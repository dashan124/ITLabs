#include <stdio.h>
#include <omp.h>

void main(){
	int i,n,sum=0;
	scanf("%d",&n);
	int arr[n];
	for(i=0;i<n;i++){
		scanf("%d",&arr[i]);
	}
	float t1=omp_get_wtime();
	#pragma omp parallel num_threads(4)
	{
		#pragma omp for reduction(+:sum)
		for (i = 0; i < n; ++i)
		{
			/* code */
			sum+=arr[i];
		}
	}
	float t2=omp_get_wtime();
	printf("time is %f\n",t2-t1);
	
	printf("Sum is = %d\n",sum);
}