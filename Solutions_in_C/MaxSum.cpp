/*
****************************************
Problem: Max Sum
****************************************
Ashis Kumar Chanda
id:   1624
CSE,  DU
Email:ashisdu@yahoo.com
06-06-13
****************************************
****************************************
*/
#include<stdio.h>		//  dynamic problem DP
int main()
{
	int i, start, end , sum, sidx, eidx;
	int array[13] = { 3, 2, 8, 9, -25, 5, 8, 4, 4 ,-3, 5, 3, -10};

	int length =13;
	int max = 0;

	start = 0;

	while(start < length) 
	{
        sum = array[start];

        for(end = (start + 1) ; end < length; end++) {
                sum += array[end];
                if(sum > max) {
                        sidx = start;
                        eidx =end;
                        max = sum;
                }
        }
        start++;
	}

	for( i=sidx ;i<=eidx ;i++)
		printf(" %d ", array[i] );

	printf("\n Sum : %d\n",max);
return 0;
}
