#include <stdio.h>
#include <omp.h>
#include <stdlib.h>

int main(){
	int n;
	int tid;
	int sum;
	printf("Enter value of n : \n");
	scanf("%d",&n);
	printf("Enter Elements in the matrix :\n");
	int a[n][n];
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			scanf("%d",&a[i][j]);
		}
	}
	omp_set_num_threads(2);
	int sum_of_rows[n];
	#pragma omp parallel
	#pragma omp for  
	for(int i=0;i<n;i++){
		sum_of_rows[i]=0;
	}
	for(int i=0;i<n;i++){
		#pragma omp parallel for
			for(int j=0;j<n;j++){
				tid=omp_get_thread_num();
				sum_of_rows[i]+=a[i][j];
				printf("Thread %d \n",tid);
			}
	}
	int sum_of_cols[n];
	//#pragma omp parallel
	#pragma omp for 
	for(int i=0;i<n;i++){
		sum_of_cols[i]=0;
	}
	//#pragma omp parallel
	for(int i=0;i<n;i++){
		#pragma omp parallel for
			for(int j=0;j<n;j++){
				sum_of_cols[i]+=a[j][i];
			}
		
	}
	for(int i=0;i<n;i++){
		printf("%d ",sum_of_rows[i]);
	}
	printf("\n");
	for(int i=0;i<n;i++){
		printf("%d ",sum_of_cols[i]);
	}
	printf("\n");
	return 0;
}