#include <stdlib.h>
#include <stdio.h>
#include <omp.h>
#define ll unsigned long long int
int  main(){
	ll n;
	int tid;
	//printf("Enter the value of n\n");
	scanf("%lld",&n);
	ll a[n][n];
	printf("Enter the first matrix\n");
	for(ll i=0;i<n;i++){
		for(ll j=0;j<n;j++){
			scanf("%lld",&a[i][j]);
			//a[i][j]=i+1;
		}
	}
	ll b[n][n];
	printf("Enter the second matrix\n");
	for(ll i=0;i<n;i++){
		for(ll j=0;j<n;j++){
			scanf("%lld",&b[i][j]);
			//b[i][j]=j+1;
		}
	}
	ll c[n][n];
	ll i,j,m;
	ll c1[n][n];
	float t1=omp_get_wtime();
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			for(m=0;m<n;m++){
				c1[i][j]+=(a[i][m]*b[m][j]);
			}
		}
	}
	float t2=omp_get_wtime();
	float t3=omp_get_wtime();
	#pragma omp parallel
	{
	#pragma omp for private(m,j)
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			c[i][j]=0;
			for(m=0;m<n;m++){
				tid=omp_get_thread_num();
				c[i][j]+=a[i][m]*b[m][j];
				printf(" thread %d\n",tid);
			}
		}
	}
	}
	float t4=omp_get_wtime();
	for(i=0;i<n;i++){
		for( j=0;j<n;j++){
			printf("%lld ",c[i][j]);
		}
		printf("\n");
	}
	printf("parallel time is %f\n",t4-t3);
	printf("Serial time is %f\n",t2-t1);
}
