#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
#include <sys/time.h>
#define ll long long int  
#define chunk 10000
int main(){
	struct timeval TimeValue_Start;
	struct timezone TimeZone_Start;
	struct timeval TimeValue_Final;
	struct timezone TimeZone_Final;
	long time_start,time_end;
	double time_overhead;
	ll n;
	omp_set_num_threads(10);
	 scanf("%lld",&n);
	ll arr[n];
	ll i,min;
	for(i=0;i<n;i+=1){
		//scanf("%lld",&arr[i]);
		arr[i]=(n-i)*((n-i)+1);
		//printf("%lld  ",arr[i]);
	}
	printf("\n");
	gettimeofday(&TimeValue_Start,&TimeZone_Start);
	min=arr[0];
	#pragma omp parallel for reduction(min:min) schedule(guided,chunk)
	for(i=1;i<n;i+=1){
		// if(arr[i]<min){
		// 	min=arr[i];
		// }
		min=min>arr[i] ? arr[i]:min;
	}
	gettimeofday(&TimeValue_Final,&TimeZone_Final);
	time_start=TimeValue_Start.tv_sec*1000000+TimeValue_Start.tv_usec;
	time_end=TimeValue_Final.tv_sec*1000000+TimeValue_Final.tv_usec;
	time_overhead=(time_end-time_start)/1000000.0;
	printf("\n\n\tTime in Seconds (T) : %lf\n",time_overhead);
	printf("Min in given array is %lld\n",min);
	return 0;
}