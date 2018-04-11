def printmatrix(matrix):
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            print(matrix[i][j],end=" ")
        print()

def main():
    n=int(input("Enter the no of vertices "))
    matrix=[[0 for i in range(n)] for k in range(n)]
    matrix2=[[] for g in range(n)]
    print("Enter the no of edges ")
    m=int(input())
    for i in range(m):
        a,b=map(int,input().split())
        matrix[a][b]=1
        matrix[b][a]=1
        matrix2[a].append(b)
        matrix2[b].append(a)
    print("adjacency matrix")
    printmatrix(matrix)
    print("adjacency list")
    #printmatrix(matrix2)
    for k in range(n):
        print("Vertex",k,": ",end=" ")
        for j in range(len(matrix2[k])):
            if j!=len(matrix2[k])-1:
                print(matrix2[k][j],end=",")
            else:
                print(matrix2[k][j],end=" ")
        print()
if __name__ =='__main__':
    main()