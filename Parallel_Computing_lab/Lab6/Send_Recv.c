#include <mpi.h>
#include <stdlib.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{
	int size,myrank;
	int x;
	MPI_Status status;
	MPI_Init(&argc,&argv);
	MPI_Comm_size(MPI_COMM_WORLD,&size);
	MPI_Comm_rank(MPI_COMM_WORLD,&myrank);
	if(myrank==0){
		x=10;
		MPI_Send(&x,1,MPI_INT,1,1,MPI_COMM_WORLD);
	}
	else if(myrank==1){
		printf("The value of x is %d\n",x);
		MPI_Recv(&x,1,MPI_INT,0,1,MPI_COMM_WORLD,&status);
		printf("Process %d of %d\n the value of x is %d",myrank,size,x);
		printf("Source %d tag %d\n", status.MPI_SOURCE,status.MPI_TAG);
	}
	MPI_Finalize();
	return 0;
}