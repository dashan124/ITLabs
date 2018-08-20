#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

void main(){
	int arr[50],check[50];
	int serial_sum;
	int sum,partail_sum;
	int n,i;
	printf("Enter the size of the array\n");
	scanf("%d",&n);
	if(n<=0){
		printf("Array size should not be negative or zero\n");
		exit(0);
	}
	printf("Enter array elements\n");
	for(i=0;i<n;i++){
		scanf("%d",&arr[i]);
		check[i]=arr[i];
	}
	printf("Array elements are\n");
	for(i=0;i<n;i++){
		printf("Array[%d] =%d \n",i,arr[i]);
	}
	sum=0;
	partail_sum=0;
	float t1;
	t1=omp_get_wtime();
	#pragma omp parallel for shared(sum)
		for(i=0;i<n;i++){
			#pragma omp critical
				sum=sum+arr[i];
		}
	float t2;
	t2=omp_get_wtime();
	serial_sum=0;
	float t3;
	t3=omp_get_wtime();
	for(i=0;i<n;i++){
		serial_sum+=check[i];
	}
	float t4;
	t4=omp_get_wtime();
	if(serial_sum==sum){
		printf("the serail sum and parallel sums are equal\n");
	}
	else{
		printf("Sums are unequal\n");
		printf("Sum is %d\n",sum);
		exit(0);
	}
	printf("serial sum time is %f\n",t4-t3);
	printf("parallel sum time is %f\n",t2-t1);
	printf("Sum is =%d\n",sum);
}