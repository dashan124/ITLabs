#include<stdio.h>
int main(){
	int arr[100],burst[100],ta[100]={0},compl[100],wt[100],seq[100];
	int i,j,count,n,min,p;
	float awt,ata;
	printf("Enter no. of process: ");
	scanf("%d",&n);
	printf("Enter their Arrival Time and Burst Time\n");
	for (i=0;i<n;i++){
		printf("process-%d :",i+1);
		scanf("%d%d",&arr[i],&burst[i]);
	}
	p=arr[0];
	min=0;
	for (i=0;i<n && arr[i]==p;i++){
		if (burst[min]>burst[i])
				min=i;
	}
	seq[min]=1;
	compl[min]=arr[min]+burst[min];
	ta[min]=compl[min]-arr[min];
	wt[min]=0;
	awt=0;
	ata=ta[min];
	count=n-1;
	j=min;
	while(count>0){
		for (i=0;i<n;i++){
			if (ta[i]==0){
				min=i;
				while(arr[i]==arr[min]){
					if (burst[min]>burst[i] && ta[i]==0)
						min=i;
					i++;
				}
			break;}
		}
		for (i=0;i<n && compl[j]>= arr[i];i++){
			if (burst[min]>burst[i] && ta[i]==0)
				min=i;
		}
		seq[min]=n-count+1;
		compl[min]=burst[min]+compl[j];
		if (arr[min]>compl[j])
			compl[min]=burst[min]+arr[min];
		j=min;
		ta[min]=compl[min]-arr[min];
		ata+=ta[min];
		wt[min]=ta[min]-burst[min];
		awt+=wt[min];
		count-=1;
	}
	printf("******************************************\n");
	printf("SORTEST JOB FIRST SCHEDULING(NON-PREEMPTIVE)\n");
	printf("******************************************\n");
	printf("ProcessNo.\tArrival\t\tBurstTime\tCompletion\tTurnAround\tWaiting\t\tSequence\n");
	for (i=0;i<n;i++){
	printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n",i+1,arr[i],burst[i],compl[i],ta[i],wt[i],seq[i]);
	}
	printf("Average Waiting Time: %f\n",awt/n);
	printf("Average TurnAround Time: %f\n",ata/n);
}
