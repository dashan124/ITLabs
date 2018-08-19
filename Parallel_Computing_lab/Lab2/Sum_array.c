#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

void main(){
	int arr[50],check[50];
	int serial_sum;
	int sum,partail_sum;
	int n,i;
	scanf("%d",&n);
	if(n<=0){
		printf("Array size should not be negative or zero\n");
		exit(0);
	}
	for(i=0;i<n;i++){
		arr[i]=i*5;
		check[i]=arr[i];
	}
	printf("Array elements are\n");
	for(i=0;i<n;i++){
		printf("Array[%d] =%d \n",i,arr[i]);
	}
	sum=0;
	partail_sum=0;
	#pragma omp parallel for shared(sum)
		for(i=0;i<n;i++){
			#pragma omp critical
				sum=sum+arr[i];
		}
	serial_sum=0;
	for(i=0;i<n;i++){
		serial_sum+=check[i];
	}
	if(serial_sum==sum){
		printf("the serail sum and parallel sums are equal\n");
	}
	else{
		printf("Sums are unequal\n");
		exit(0);
	}
	printf("Sum is =%d\n",sum);
}