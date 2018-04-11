#include<stdio.h>
int head=0;
int tail=0;
int queue[100];
int main(){
	int arr[100],burst[100],ta[100]={0},compl[100],wt[100],seq[100],dummy[100];
	int i,j,count,n,min,p,size,curt,tq;
	float awt,ata;
	printf("Enter time quantum");
	scanf("%d",&tq);
	printf("Enter no. of process: ");
	scanf("%d",&n);
	count=0;
	printf("Enter their Arrival Time and Burst Time\n");
	for (i=0;i<n;i++){
		printf("process-%d :",i+1);
		scanf("%d%d",&arr[i],&burst[i]);
		dummy[i]=burst[i];
	}
	size=1;curt=arr[0];
	head=0;tail=0;
	queue[0]=0;
	while(count<n){
		p=head;
		while(1){
			if (dummy[p]>0){
				break;
			}
			p=(p+1)%n;
		}
		if (dummy[p]<=tq){
			curt+=dummy[p];
			dummy[p]=0;
			compl[p]=curt;
			ta[p]=compl[p]-arr[p];
			wt[p]=ta[p]-burst[p];
			ata+=ta[p];
			wt+=wt[p];
			count+=1;
		}
		else{
			curt+=tq;
			dummy[p]-=tq;
		}
		for(i=size;i<n && arr[i]<=curt;i++){
			queue[size]=i;
			size+=1	;		
		}
		if (count==size){
			curt=arr[size];
			size+=1;
			queue[size]=size;
		}
		head=(head+1)%size;
		tail=(tail+1)%size;

	}
	printf("******************************************\n");
	printf("ROUND-ROBIN SCHEDULING(NON-PREEMPTIVE)\n");
	printf("******************************************\n");
	printf("ProcessNo.\tArrival\t\tBurstTime\tCompletion\tTurnAround\tWaiting\n");
	for (i=0;i<n;i++){
	printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n",i+1,arr[i],burst[i],compl[i],ta[i],wt[i]);
	}
	printf("Average Waiting Time: %f\n",awt/n);
	printf("Average TurnAround Time: %f\n",ata/n);
	
}