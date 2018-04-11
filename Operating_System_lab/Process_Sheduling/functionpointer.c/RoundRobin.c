#include<stdio.h>
#include<stdlib.h>

struct Process{
  int processId;
  int Arrival_time;
  int Burst_time;
};
int comarision(struct Process a,struct Process b){
  if(a.Burst_time>b.Burst_time){
    return 1;
  }
  else{
    return 2;
  }
}
/*
void FindWaitingTime(struct Process proc[],int n,int waiting[]){
  //waiting time of the first process is Zero
  waiting[0]=0;
  for(int i=1;i<n;i++){
    waiting[i]=proc[i-1].Burst_time+waiting[i-1];
  }
}
void FindturnAround(struct Process proc[],int n,int waiting[],int turnAr[]){
  for(int i=0;i<n;i++){
    turnAr[i]=proc[i].Burst_time+waiting[i];
  }
}
void findavgTime(struct Process proc[], int n)
{
    int wt[n], tat[n], total_wt = 0, total_tat = 0;
    findWaitingTime(proc, n, wt);
    findTurnAroundTime(proc, n, wt, tat);
    printf("\nProcesses\t Burst time \t Waiting time \t Turn around time\n");
    for (int i = 0; i < n; i++)
    {
        total_wt = total_wt + wt[i];
        total_tat = total_tat + tat[i];
        printf(" %d \t %d \t %d \t %d \t\n",proc[i].processId,proc[i].Burst_time,wt[i],tat[i]);
    }
    printf("Average Waiting time =  %lf\n",(float)total_wt / (float)n );
    printf("Average Waiting time =  %lf\n",(float)total_tat / (float)n);
}
*/
int main(){
  int n;
  printf("Enter the no of Procssess\n");
  scanf("%d",&n);
  struct Process   proc[n];
  for(int i=0;i<n;i++){
  //  printf("Enter process Id\n");
  //  scanf("%d",&proc[i].processId);
  proc[i].processId=i+1;
    printf("Enter Arrival Time\n");
    scanf("%d",&proc[i].Arrival_time);
    printf("Enter burst Time\n");
    scanf("%d",&proc[i].Burst_time);
  }
  for(int x=0;x<n;x++){
    for(int y=0;y<n-x;y++){
      if(proc[y].Burst_time<proc[y].Burst_time){
        struct Process temp;
        temp=proc[y];
        proc[y]=proc[y+1];
        proc[y+1]=temp;
      }
    }
  }
  for(int i=0;i<n;i++){
    printf("%d \n",proc[i].Burst_time);
  }
  int waiting[n],tat[n],total_wt = 0, total_tat = 0;
  waiting[0]=0;
  for(int i=1;i<n;i++){
    waiting[i]=proc[i-1].Burst_time+waiting[i-1];
  }
  for(int i=0;i<n;i++){
    tat[i]=proc[i].Burst_time+waiting[i];
  }
  printf("Sorted order\n");
  for(int r=0;r<n;r++){
    printf("%d ",proc[r].processId);
  }
  printf("\n");
  printf("\nProcesses\t Burst time \t Waiting time \t Turn around time\n");
  for (int i = 0; i < n; i++)
  {
      total_wt = total_wt + waiting[i];
      total_tat = total_tat + tat[i];
      printf(" %d \t\t %d \t\t %d \t\t%d \t\n",proc[i].processId,proc[i].Burst_time,waiting[i],tat[i]);
  }
  printf("Average Waiting time =  %lf\n",(float)total_wt / (float)n );
  printf("Average Waiting time =  %lf\n",(float)total_tat / (float)n);

return 0;
}
