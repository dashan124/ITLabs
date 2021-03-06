#include <stdlib.h>
#include <stdio.h>
#include <omp.h>

int main(){
		double pi,x;
		int i,N;
		pi=0.0;
		N=1000;
		#pragma omp parallel for private(x) 
			for(i=0;i<=N;i++){
				x=(double)i/N;
				#pragma omp atomic
				pi+=4/(1+x*x);
			}
		pi=pi/N;
		printf("Pi is %f\n",pi);
	return 0;
}