#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
#include <sys/time.h>
#define ll long long int 

int main(){
	struct timeval TimeValue_Start;
	struct timezone TimeZone_Start;
	struct timeval TimeValue_Final;
	struct timezone TimeZone_Final;
	long time_start,time_end;
	double time_overhead;
	omp_set_num_threads(100);
	ll n;
	n=1010100;
	ll arr[n];
	for(ll i=0;i<n;i++){
		arr[i]=rand()%1000000007;
	}
	ll key=arr[n-4];
	ll index=-1;
	gettimeofday(&TimeValue_Start,&TimeZone_Start);
	#pragma omp parallel for
	for(ll i=0;i<n;i+=1){
		if(arr[i]==key){
			index=i;
		}
	}
	gettimeofday(&TimeValue_Final,&TimeZone_Final);
	time_start=TimeValue_Start.tv_sec*1000000+TimeValue_Start.tv_usec;
	time_end=TimeValue_Final.tv_sec*1000000+TimeValue_Start.tv_usec;
	time_overhead=(time_end-time_start)/1000000.0;
	printf("\n\n\n time in seconds : = %lf\n",time_overhead);
	printf("%lld\n",index);
}
