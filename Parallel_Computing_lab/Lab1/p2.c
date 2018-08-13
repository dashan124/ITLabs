#include <stdio.h>
#include <omp.h>

int main(){
	int value;
	printf("Enter 0: for serial 1: for parallel\n");
	scanf("%d",&value);
	#pragma omp parallel if(value)
	{
		if(omp_in_parallel()){
			printf("parallel value =%d id=%d\n",value,omp_get_thread_num());
		}
		else
		{
			printf("serial value =%d id=%d\n",value,omp_get_thread_num());
		}
	}
}