#include<stdio.h>
#include<stdlib.h>

int head_of_queue=0;
int tail_of_queue=0;
int process_queue[100];

int main(){
	int arrival_time[100];
	int Burst_time[100];
	int TurnAround_time[100]={0};
	int completion_time[100];
	int waiting_time[100];
	int dummy_list[100];
	int no_of_process;
	int minimum;
	int pointer;
	int size;
	int current_time; //curren time
	int time_quantum;
	float total_turn_around,total_waiting_time;
	printf("Enter time Quantum \n");
	scanf("%d",&time_quantum);
	printf("Enter no of Processess\n");
	scanf("%d",&no_of_process);
	int count=0;
	printf("Enter Process Arrival time and Burst time\n");
	for(int i=0;i<no_of_process;i++){
		printf("Process - %d  :",i+1);
		scanf("%d%d",&arrival_time[i],&Burst_time[i]);
		dummy_list[i]=Burst_time[i]; //creates a copy of the Burst time list
	}
	size=1; //intilize the size first to one
	current_time=arrival_time[0]; //intilize the current_time to first arrival time
	head_of_queue=0; //intilize the head of the queue to be the first element
	tail_of_queue=0; //queue tail is also the fisrt element when only one element in the queue
	process_queue[0]=0; //initally only first process is in the process queue
	while(count<no_of_process)//while count is not equal to the total process
	{
		pointer=head_of_queue; //initally the pointer is on the head of the process queue
		while(1){ //move pointer to the next element everytime we found a new uncomplete process
			if(dummy_list[pointer]>0){ //some process is still requre time to complete
				break; //we found
			}
			//if dumm[pointer]==0 means the process is completed
			pointer=(pointer+1)%no_of_process;//if we donot find a process move to next
		}
		if(dummy_list[pointer]<=time_quantum){//if remaining time of a process to complete is less than time quantum
			//then this is last itertaion on that process
			current_time+=dummy_list[pointer]; //update the current time by the remaing burst time of the process
			dummy_list[pointer]=0;//the process is completed
			completion_time[pointer]=current_time; //update the completion_time of the process
			TurnAround_time[pointer]=completion_time[pointer]-arrival_time[pointer];
			//calculate the turn around time
			waiting_time[pointer]=TurnAround_time[pointer]-Burst_time[pointer];
			total_turn_around+=TurnAround_time[pointer];
			total_waiting_time+=waiting_time[pointer];
			count+=1; //update the count as the process completed
		}
		else{
			current_time+=time_quantum;
			dummy_list[pointer]-=time_quantum; //decrese the remaing_time of a process by the time quantum
		}
		// add next process which come by currnt time  to the process queue
		for(int j=0;j<no_of_process && arrival_time[j]<=current_time;j++){
			process_queue[size]=j;
			size+=1; //update the size  of the process as the new process is added
		}
		if(count==size){ //means the all processess is in the queue
			current_time=arrival_time[size];
			size+=1;
			process_queue[size]=size;
		}
		head_of_queue=(head_of_queue+1)%size;
		tail_of_queue=(tail_of_queue+1)%size;
	}
	printf("******************************************\n");
	printf("ROUND-ROBIN SCHEDULING(NON-PREEMPTIVE)\n");
	printf("ProcessNo.\tArrival\t\tBurstTime\tCompletion\tTurnAround\tWaiting\n");
	for (int i1=0;i1<no_of_process;i1++){
	printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n",i1+1,arrival_time[i1],Burst_time[i1],completion_time[i1],TurnAround_time[i1],waiting_time[i1]);
	}
	printf("Average Waiting Time: %f\n",total_waiting_time/no_of_process);
	printf("Average TurnAround Time: %f\n",total_turn_around/no_of_process);
	return 0;
}
