//uva 11462

// Look age range is 1 to 120
// We just count the values of that range. No matter how many people is there?
// Then just print this array
// if N= 10^7  , Max Run time = 120*120

#include<stdio.h>
#include<stdlib.h>

int arr[120];   // to count age, Not people

int main()
{
	int i,j,k,t,elem;

	while(scanf("%d",&t)!=EOF){
        for(i=0; i<120; i++)        // set all 0
            arr[i]=0;

		if(t==0)			break;
		for(i=0;i<t; i++){
            scanf("%d",&j);
            arr[j]++;           // count age
		}

		for(j=1;j<120;j++){
            while(arr[j]>=1){
                printf("%d ",j);
                arr[j]--;
            }
		}
		printf("\n",arr[2], arr[5],arr[7]);
	}

	return 0;
}
