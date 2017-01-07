/*
****************************************
Problem: Coin Change
****************************************
Ashis Kumar Chanda
ID:   1624
CSE,  DU
Email:ashisdu@yahoo.com
16-06-13
****************************************
****************************************
*/

/// Greedy

//		It shows the shortest way of getting n Taka ( Example 15)
//		5*3, 10+5*2, 2*5+5
//		10+5*2  is our answer. Because, only 3 coins need

#include <stdio.h>
#define N 4
int main()
{
	int i,j, n;
	int coin[N]={20,10,5,2};		// take max first

	

	while(scanf("%d",&n) != EOF){
		printf("coins are :");
		j=0;
		while( n>0){
			for( i=0; i< N ;i++)		//   take max coin
				if( coin[i] <= n)
					break;

		printf(" %d", coin[i]);
		j+= n/ coin[i];
		n = n% coin[i];
	}

	printf("\n Coin need %d\n\n", j);
	}
	return 0;
}
