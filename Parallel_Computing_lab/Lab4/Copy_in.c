#include <stdio.h>
#include <omp.h>
#include <stdlib.h>

void main(){
	#pragma omp parallel num_threads(4) copyin(x)
	{
		tid=omp_get_thread_num();
		#pragma omp master
		{
			printf("parallel region 1\n");
			x=x+1;
		}
		#pragma omp barrier
		if(tid==1){
			x=x+2;
		}
		printf("Thread %d value of x is %d\n",tid,x);
	}
	#pragma omp parallel num_threads(4)
	{
		#pragma omp master
		{
			printf("parallel region 2\n");
		}
		#pragma omp barrier
		printf("Thread %d value of x is %d\n",tid,n);
	}
	printf("value of x in main region is %d \n",x);
}