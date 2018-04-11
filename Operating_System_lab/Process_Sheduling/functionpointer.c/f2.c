#include<stdio.h>
#include<stdlib.h>
#include<math.h>

//unlike normal pointers function pointer points to code npt data
//function pointer store the start address of the executabel code

void function(int a){
  printf("the sqroot of the %d is %lf",a,sqrt(a));
}
int main(){
  void (*fun_ptr)(int)=function;
  fun_ptr(100);
  return 0;
}
