#include<stdio.h>
#include<stdlib.h>
#define MAX 1000
typedef struct deque{
  int data[MAX];
  int rear,front;
}deque;
void init(deque *p);
int Isempty(deque *p);
int IsFull(deque *p);
void EnqueueFront(deque *p,int x);
void EnqueueRear(deque *p,int x);
int DequeueFront(deque *p);
int DequeueRear(deque *p);
void print(deque *p);
void init(deque *p){
  p->rear=-1;
  p->front=-1;
}
int Isempty(deque *p){
  if(p->rear==-1){
    return 1;
  }
  return 0;
}
int IsFull(deque *p){
  if((p->rear+1)%MAX==p->front){
    return 1;
  }
  return 0;
}
void EnqueueRear(deque *p,int x){
  if(Isempty(p)){
    p->rear=0;
    p->front=0;
    p->data[0]=x;
  }
  else if(IsFull(p)){
    printf("Deque is Full\n");
    exit(0);
  }
  else{
int be=p->rear;
    p->rear=(p->rear+1)%MAX;
//printf("before %d after rear is %d\n",be,p->rear);
    p->data[p->rear]=x;
  }
}
void EnqueueFront(deque *p,int x){
  if(Isempty(p)){
    p->front=0;
    p->rear=0;
    p->data[0]=x;
  }
  else if(IsFull(p)){
    printf("Deuque is full\n");
    exit(0);
  }
  else{
int fr=p->front;
    p->front=(p->front-1+MAX)%MAX;
//printf("before front %d after front %d\n",fr,p->front);
    p->data[p->front]=x;
  }
}
int DequeueRear(deque *p){
  int x;
  x=p->data[p->rear];
  if(p->rear==p->front){
    init(p);
  }
  else{
    p->rear=(p->rear-1+MAX)%MAX;
  }
  return x;
}
int DequeueFront(deque *p){
  int x;
  x=p->data[p->front];
  if(p->rear==p->front){
    init(p);
  }
  else{
    p->front=(p->front+1)%MAX;
    return x;
  }
}
void print(deque *p){
  if(Isempty(p)){
    printf("Deque is Empty!!!\n");
    exit(0);
  }
  int i=p->front;
  while(i!=p->rear){
    printf("%d \t",p->data[i]);
    i=(i+1)%MAX;
  }
  printf("%d\n",p->data[p->rear]);
}
int main(){
  int i,x,op,n;
 deque q;
 init(&q);
 do
 {
     printf("\n1.Create\n2.Insert(rear)\n3.Insert(front)\n4.Delete(rear)\n5.Delete(front)");
     printf("\n6.Print\n7.Exit\n\nEnter your choice:");
     scanf("%d",&op);

     switch(op)
     {
         case 1: printf("\nEnter number of elements:");
                 scanf("%d",&n);
                 init(&q);
                 printf("\nEnter the data:");
                for(i=0;i<n;i++)
                 {
                     scanf("%d",&x);
                     if(IsFull(&q))
                     {
                         printf("\nQueue is full!!");
                         exit(0);
                     }
                     EnqueueRear(&q,x);
                 }
                 break;

         case 2: printf("\nEnter element to be inserted:");
                 scanf("%d",&x);

                 if(IsFull(&q))
                 {
                     printf("\nQueue is full!!");
                     exit(0);
                 }

                 EnqueueRear(&q,x);
                 break;

         case 3: printf("\nEnter the element to be inserted:");
                 scanf("%d",&x);

                 if(IsFull(&q))
                 {
                     printf("\nQueue is full!!");
                     exit(0);
                 }

                 EnqueueFront(&q,x);
                 break;

         case 4: if(Isempty(&q))
                 {
                     printf("\nQueue is empty!!");
                     exit(0);
                 }

                 x=DequeueRear(&q);
                 printf("\nElement deleted is %d\n",x);
                 break;

         case 5: if(Isempty(&q))
                 {
                     printf("\nQueue is empty!!");
                     exit(0);
                 }

                 x=DequeueFront(&q);
                 printf("\nElement deleted is %d\n",x);
                 break;

         case 6: print(&q);
                 break;

         default: break;
     }
 }while(op!=7);
  return 0;
}
