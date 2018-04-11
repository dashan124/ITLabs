#include<stdio.h>
#include<stdlib.h>
int main(int argc,char* argv[]){
  FILE *source ,*target;
  //declaring file pointer for source file and target file
  char ch;
  /*if aguments are less than three throw an error*/
  if(argc!=3){
    printf("Command Error !! Insufficent arguments Given\n");
    return 0;
  }
  source=fopen(argv[1],"r");
  //open the source file in read mode
  target=fopen(argv[2],"w");
  //open the target file in write mode
  if(source==NULL||target==NULL){
    printf("Unable to open . Error while opening file\n");
    return 0;
  }
  while((ch=fgetc(source))!=EOF){
  fputc(ch,target);//writing to the target FILE
}
  printf("Copy is successful\n");
  fclose(source);//closing the source file
  fclose(target);//closing the target file
  return 0;
}
