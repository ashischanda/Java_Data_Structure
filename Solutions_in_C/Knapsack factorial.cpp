/*
****************************************
Problem: Knapsack factorial (Greedy)
****************************************
Ashis Kumar Chanda
id:   1624
CSE,  DU
Email:ashisdu@yahoo.com
06-06-13
****************************************
****************************************
*/

/*	
  Think that one person want to buy 50 litre milk. 
	But there is several milk bottle with different price. 
	He want to take max price
*/

#include<stdio.h>			//  greedy 
#include<algorithm>
#include<iostream>
using namespace std;
#define M 50

typedef struct k{
	double wei;
	double be;		
	double value;			//  unit            value per  weight

	bool operator< (const k &a) const {
		return value > a.value ;
	}

}Data;

double min(double a, double b)
{
	if( a> b)
		return b;
	else
		return a;
}

int main()
{ 
	int i,j,N , Knap ;
	Data d[M];

	puts("Give Knap size");
	scanf("%d",&Knap);
	puts("Give item num");
	scanf("%d",&N);


	printf(" now give weight & benefit");
	for(i=0; i<N; i++){
		scanf("%lf%lf",&d[i].wei, &d[i].be) ;
		d[i].value = d[i].wei / d[i].be;
	}
	sort( d, d+N);

	j=0;
	i=0;
	int w;
	while( j<Knap){
		w= d[i].wei ;
		printf(" value of item is %lf  and weight taken %lf\n", d[i].be, min( w, Knap-w ) );
		j= j+ min ( w, Knap-w );
		i++;
	}


	return 0;
}

/*
10
5
4 12
8 32
2 40
6 30
1 50
*/
