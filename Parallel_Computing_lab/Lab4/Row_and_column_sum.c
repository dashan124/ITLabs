#include <stdio.h>
#include <omp.h>
#include <stdlib.h>

int main(){
	int n;
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
	#pragma omp parallel shared(a,n)
	{
		#pragma omp sections
		{
			#pragma omp section
			{
				#pragma omp parallel
				{
					for(int i=0;i<n;i++){
						sum=0;
						#pragma omp for reduction(+:sum)
						{
							for(int j=0;j<n;j++){
								sum+=a[i][j];
							}
							printf(" sum of %d Row is = %d\n",i,sum);
						}
					}
				}
			}
			#pragma omp section
			{
				#pragma omp parallel
				{
					for(int i=0;i<n;i++){
						sum=0;
						#pragma omp for reduction(+:sum)
						{
							
							for(int j=0;j<n;j++){
								sum+=a[j][i];
							}
							printf(" sum of %d column is = %d\n",i,sum);
						}
					}
				}
			}
		}
	}
	return 0;
}