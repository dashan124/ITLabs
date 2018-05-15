#include<stdio.h>
int main(){
	int arr[100],burst[100],ta[100],compl[100],wt[100];
	int i,j,d,n;
	float awt,ata;
	printf("Enter no. of process: ");
	scanf("%d",&n);
	printf("Enter their Arrival Time and Burst Time\n");
	for (i=0;i<n;i++){
	printf("process-%d :",i+1);
	scanf("%d%d",&arr[i],&burst[i]);}
	compl[0]=arr[0]+burst[0];
	ta[0]=burst[0];
	wt[0]=0;
	awt=0;
	ata=ta[0];
	for (i=1;i<n;i++){
	if (arr[i]>compl[i-1]){
	compl[i]=burst[i]+arr[i];
	}
	else{
	compl[i]=burst[i]+compl[i-1];
	}
	ta[i]=compl[i]-arr[i];
	ata+=ta[i];
	wt[i]=ta[i]-burst[i];
	awt+=wt[i];
	}
	printf("*************************************\n");
	printf("FIRST COME FIRST SERVE SCHEDULING\n");
	printf("*************************************\n");
	printf("ProcessNo.\tArrival\t\tBurstTime\tCompletion\tTurnAround\tWaiting\n");
	for (i=0;i<n;i++){
	printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n",i+1,arr[i],burst[i],compl[i],ta[i],wt[i]);
	}
	printf("Average Waiting Time: %f\n",awt/n);
	printf("Average TurnAround Time: %f\n",ata/n);

}
