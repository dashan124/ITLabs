#include<stdio.h>
#include<stdlib.h>
void function(int a){
  printf("Square of the value is %d\n",a*a);
}
int main(){
  void (*fun_ptr)(int)=&function;
  //function pointer to the function
  (*fun_ptr)(10);
  return 0;
}
