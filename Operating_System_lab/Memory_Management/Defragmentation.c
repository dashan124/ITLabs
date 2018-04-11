#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
//defragmentation is basically removing the fragment in variable size //partitioning


//sim
struct Node{//create a linked list node
  int size;
  bool allocated;
  int processId;
  struct Node *next;
};
void FirstFit(struct Node** head,int prosize,int pid){
printf("FirstFit\n");
struct Node* temp=*head;
struct Node* newnode=NULL;
//while(temp->next!=NULL){
while(temp!=NULL){
  if((temp->size>=prosize)&&(temp->allocated!=true)){
    newnode=(struct Node*)malloc(sizeof(struct Node));
    newnode->next=temp->next;
    int siz=(temp->size)-prosize;
    newnode->size=siz;
    temp->size=prosize;
    temp->allocated=true;
    temp->next=newnode;
    temp->processId=pid;
    break;
    return;
  }
  temp=temp->next;
}

//printf("!!!!!!Error available space is not sufficient\n");

}
void BestFit(struct Node** head,int prosize,int pid){
printf("BestFit\n");
struct Node* temp=*head;
struct Node* prev=NULL;
int min=temp->size;
int flag=0;
while(temp!=NULL){
  if((min>temp->size)&&(min>=prosize)&&temp->allocated!=true){
  min=temp->size;
  }
  prev=temp;
  temp=temp->next;
}
temp=prev;
struct Node* newnode=NULL;
if(temp!=NULL){
  newnode=(struct Node*)malloc(sizeof(struct Node));
  newnode->next=temp->next;
  int siz=(temp->size)-prosize;
  newnode->size=siz;
  temp->size=prosize;
  temp->allocated=true;
  temp->next=newnode;
  temp->processId=pid;
  flag=1;


}
if(flag==0){
  printf("!!!!!!Error available space is not sufficient\n");
}
}
void WorstFit(struct Node** head ,int prosize,int pid){
struct Node* temp=*head;
printf("WorstFit\n");
int max=temp->size;
int flag=0;
struct Node* prev=NULL;
while(temp!=NULL){
  if((max<temp->size)&&(max>=prosize)&&(temp->allocated!=true)){
    max=temp->size;
  }
  prev=temp;
  temp=temp->next;
}
temp=prev;
struct Node* newnode=NULL;
if(temp!=NULL){
  newnode=(struct Node*)malloc(sizeof(struct Node));
  newnode->next=temp->next;
  int siz=(temp->size)-prosize;
  newnode->size=siz;
  temp->size=prosize;
  temp->allocated=true;
  temp->next=newnode;
  temp->processId=pid;
  flag=1;

}
if(flag==0){
  printf("!!!!!!Error available space is not sufficient\n");
}
}
void printList(struct Node** root)
{
  struct Node* node=*root;
  while (node != NULL)
  {
     printf(" Process ID =%d \t Process Size=%d\t\n\n", node->processId,node->size);
     node = node->next;
  }
}
void delete(struct Node** head,int pid){
//while deleting the process we move that node of memory to the last and merge with the free memory
struct Node* temp=*head;
struct Node* tmp=*head;
int blankspace=0;//blankspace is space of that block which is going to free 
int flag=0;
if (temp->processId==pid){//if that block is head then make head to the next block
  blankspace+=tmp->size;
  *head=tmp->next;
  flag=1;
}
while(temp->next!=NULL){
//otherwise find the process in linked list 
  if(temp->next->processId==pid){
    blankspace=temp->next->size;
    temp->next=temp->next->next;
    temp->next->allocated=false;
    flag=1;
  }
  temp=temp->next;
}
if(flag==1){//check if flag=1 that means process is found and deleted successfully
  temp->size+=blankspace;

}
else{
  printf("Error process not found\n");
}
}
int main(){
  struct Node* head_ref=NULL;
  struct Node* head_ref1=NULL;
  struct Node* head_ref2=NULL;
  printf("enter the total available space memory\n");
  int memory_size;
  scanf("%d",&memory_size);
  head_ref=(struct Node*)malloc(sizeof(struct Node));//first linked list for first fit
  head_ref->size=memory_size;
  head_ref->allocated=false;
  head_ref->next=NULL;
  head_ref1=(struct Node*)malloc(sizeof(struct Node));//second linked list for best fit
  head_ref1->size=memory_size;
  head_ref1->allocated=false;
  head_ref1->next=NULL;
  head_ref2=(struct Node*)malloc(sizeof(struct Node));//third linked list for worst fit
  head_ref2->size=memory_size;
  head_ref2->allocated=false;
  head_ref2->next=NULL;
  int choice=0;

  while(choice!=3){
    printf("Enter your choice \n1.Add process\n2.Delete process\n3.exit\n4.printList\n");
    scanf("%d",&choice);
    printf("####################################################\n");
    switch (choice) {
      case 1:{
        int process;
        int pid;
        printf("enter process size \n");
        scanf("%d",&process);
        printf("Enter process ID\n");
        scanf("%d",&pid);
        printf("##################################################################################\n");
        FirstFit(&head_ref,process,pid);
        BestFit(&head_ref1,process,pid);
        WorstFit(&head_ref2,process,pid);
        break;
      }
      case 2:{
        printf("Enter process Id to delete process\n");
        int pid;
        scanf("%d",&pid);
        delete(&head_ref,pid);
        delete(&head_ref1,pid);
        delete(&head_ref2,pid);
        break;
      }
      case 3:{
        printf("exiting.........\n");
        exit(0);
        break;
      }
      case 4:{
        struct Node* temp=head_ref;
        printf("*******************FIRST FIT ALGORITHM\n");
        printList(&head_ref);
        printf("##################################################\n");
        printf("************************BEST FIT ***************************\n");
        printList(&head_ref1);
        printf("################################################################\n");
        printf("******************** WORST FIT******************\n");
        printList(&head_ref2);
      }
      default:{
        printf("ERROR\n");
        exit(0);
        break;
      }
    }
  }
  return 0;
}
