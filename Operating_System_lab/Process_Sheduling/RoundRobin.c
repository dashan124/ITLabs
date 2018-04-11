 #include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main(){
  int n;
  printf("Enter the no of processess\n");
  scanf("%d",&n);
  int process[n];
  for(int i=0;i<n;i++){
    process[i]=i+1;
  }
  int Burst_time[n];
  int Arrival_time[n];
  int Completion_time[n];
  int u=0;
  while(u<n){
    int x,y;
    printf("Enter arrival and Burst_time \n");
    scanf("%d%d",&x,&y);
    if(x<0||y<=0){
      printf("Invalid Input\n");
      u-=1;
    }
    else{
      Arrival_time[u]=x;
      Burst_time[u]=y;
      u+=1;
    }
  }
  printf("Enter Value of the time Quantum\n");
  int Quantum;
  while(1){
    scanf("%d",&Quantum);
  if(Quantum<=0){
    printf("Invalid Time Quantum value\n");
  }
  else{
    break;
  }
}
int waiting_time[n],turnAround_time[n],total_wait=0,total_turn=0;
int remaining_time[n];
for(int x=0;x<n;x++){
  remaining_time[x]=Burst_time[x];
}
int t=0;//current time value
//keep travesing until all the process are not done
while(1){
  int done_flag=1;
  for(int i=0;i<n;i++){
    //if remaining_time of a process is greater than zero then not done_flag
    //need to be travese
    if(remaining_time[i]>0){
      done_flag=0;//there is pending process
      if(remaining_time[i]>Quantum){
        t+=Quantum;
        // Increase the value of t i.e. shows
      // how much time a process has been processed
      remaining_time[i]-=Quantum;
      //decrease the remaining_time by the time Quantum
      }
      //if the Burst time is Smaller then or Equal to the time Qunatum
      //that means this is the last cycle of the process
      else{
        //Increase the value of current time by the remaining_time of a process
        t=t+remaining_time[i];
        // Waiting time is current time minus time
        // used by this process
        Completion_time[i]=t;
      //  waiting_time[i]=t-Burst_time[i];
        remaining_time[i]=0;
      }
    }
  }
  if(done_flag==1){
    break;
  }
}
for(int i=0;i<n;i++){
//  turnAround_time[i]=Burst_time[i]+waiting_time[i];
turnAround_time[i]=Completion_time[i]-Arrival_time[i];
}
for(int i=0;i<n;i++){
  waiting_time[i]=turnAround_time[i]-Burst_time[i];
}
printf("Processess \t Arrival_time\t Burst time \tCompletion Time \t Waiting time \t turn Around Time\t\n");
for(int i=0;i<n;i++){
  total_turn+=turnAround_time[i];
  total_wait+=waiting_time[i];
  printf("%d\t\t%d  \t\t%d  \t\t\t%d\t\t\t  %d\t\t\t    %d\t\n",process[i],Arrival_time[i],Burst_time[i],Completion_time[i],waiting_time[i],turnAround_time[i]);
}
printf("avergae waiting_time  = %lf\n",(float)total_wait/(float)n);
printf("Average Turn Around time =%lf\n",(float)total_turn/(float)n);
  return 0;
}
