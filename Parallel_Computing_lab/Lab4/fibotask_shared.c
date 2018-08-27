#include <stdio.h>
#include <omp.h>
#include <stdlib.h>
#define ll long long int
ll fibo(ll n);
void main(){
	ll n,fib;
	double t1,t2;
	printf("Enter the value of n\n");
	scanf("%lld",&n);
	t1=omp_get_wtime();
	#pragma omp parallel shared(n)
	{
		#pragma omp single
		{
			fib=fibo(n);
		}
	}
	t2=omp_get_wtime();
	printf("Fibonacci value is %lld\n",fib);
	printf("Time taken is %lf\n", t2-t1);
}
ll fibo(ll n){
	ll a,b;
	if(n<2){
		return n;
	}
	else{
		#pragma omp task shared(a)
		{
			printf("Task created by Thread %d\n",omp_get_thread_num());
			a=fibo(n-1);
			printf("Task Executed by Thread %d\n",omp_get_thread_num());
		} 
		#pragma omp task shared(b)
		{
			printf("Task created by thread %d\n",omp_get_thread_num());
			b=fibo(n-2);
			printf("Task Executed by thread %d\n",omp_get_thread_num());
		}

	}
	#pragma omp taskwait
		{
			return a+b;
		}
}