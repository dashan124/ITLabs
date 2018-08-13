#include <stdio.h>
#include <omp.h>

int main(){
	int i=10;
	printf("value before pragma i= %d\n", i);
	#pragma omp parallel num_threads(4) private(i)
	{
		printf("value after entering pragma i=%d  tid=%d\n",i,omp_get_thread_num());
		i+=omp_get_thread_num();
		printf("Value after changing value i=%d tid=%d \n",i,omp_get_thread_num());
	}
	printf("Value after having pragma i=%d tid=%d\n",i, omp_get_thread_num());
	return 0;
}