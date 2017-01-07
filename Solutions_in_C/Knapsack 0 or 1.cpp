//  dynamic problem DP
//  Modified: Ashis chanda
//  Date: 26/05/2013

/*
	Think that there is one thief, who want to take the most valueable items
	but he can carry maximum 10 kg.
	He can't take fraction of one item
	Thus, he may take a item (1) or not (0)
*/

/*
Input:	N items, each with various Vi (Value) and Wi (Weight) and max Knapsack size Knap.
Output: Maximum value of items that one can carry, if he can either take or not-take a
		particular item.
Let C[i][w] be the maximum value if the available items are {X1,X2,...,Xi} and the
knapsack size is w.
i)		if i == 0 or w == 0 (if no item or knapsack full), we can't take anything C[i][w] = 0
ii)		if Wi > w (this item too heavy for our knapsack),skip this item C[i][w] = C[i-1][w];
iii)	if Wi <= w, take the maximum of "not-take" or "take" C[i][w] = max(C[i-1][w] ,
		C[i-1][w-Wi]+Vi);
The solution can be found in C[N][W];
*/


#include<stdio.h>
#define N 4				// Item num 4

int main()
{
	int i,w, Knap=0;
	int value[N+1]= {0,12,10,20,15};    // As algo, table start from 0 but first is not item
	int weight[N+1]={0,2, 1, 3, 2};

	int c[50][50];						// for making table


	puts("Give your bag or knapsack size");

	while(scanf("%d",&Knap) != EOF){

		for(i=0; i<= Knap ;i++)		//  +1 because as table start from 0
			c[0][i]=0;
		for(i=0; i<= N ;i++)				// items in column
			c[i][0]=0;


		for (i=1;i<=N;i++)				//  start from 1
			for (w=1;w<= Knap ;w++) {
				if (weight[i] > w){
						c[i][w] = c[i-1][w];
				}
				else{
					int x=c[i-1][w] ;
					int y=c[i-1][w- weight[i]]+ value[i] ;
					if( x > y)
						c[i][w] = x ;
					else
						c[i][w] = y ;

				}

			}


	/*	Debug
	  for (i=0;i<N;i++){				//  start from 1
			for (w=0;w<= Knap ;w++)
				printf(" %2d", c[i][w]);
			printf("\n");
			}
	*/

	printf(" %d \n",c[N][Knap]);
	}

	return 0;
}
