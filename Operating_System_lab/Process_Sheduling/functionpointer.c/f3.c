#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int compare(const void *a,const void *b){
  return (*(int *)a-*(int *)b);
}
int main(){
  int n;
  printf("Enter the value of n\n");
  scanf("%d",&n);
  int arr[n];
  printf("Enter the array elements \n");
  for(int i=0;i<n;i++){
    scanf("%d",&arr[i]);
  }
  qsort(arr,n,sizeof(int),compare);
  for(int i=0;i<n;i++){
    printf("%d ",arr[i]);
  }
  printf("\n");
  return 0;
}
