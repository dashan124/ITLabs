class Heap:
    def __init__(self):
        self.distv=[]
        self.vertic=[]
        self.length=0
    def parent(self,i):
        if i==0:
            return 0
        elif i%2==0:
            return (i//2)-1
        else:
            return i//2
    def heapify(self,i):
        print(self.distv)
        left=2*i+1
        right=2*(i+1)
        if left<self.length and right<self.length:
            if self.distv[left]>self.distv[right]:
                x=right
            else:
                x=left
        elif left<self.length and right>=self.length:
            x=left
        elif right<self.length and left>=self.length:
            x=right
        else:
            return
        if self.distv[i]>self.distv[x]:
            t=self.distv[i]
            self.distv[i]=self.distv[x]
            self.distv[x]=t
            temp=self.vertic[i]
            self.vertic[i]=self.vertic[x]
            self.vertic[x]=temp
            self.heapify(x)
    def Min(self):
        return self.distv[0]
    def Insert(self,index,val):
        self.vertic.append(index)
        self.distv.append(val)
        self.length+=1
        i=self.length-1
        while i>0:
            p=self.parent(i)
            if self.distv[i]<self.distv[p]:
                t=self.distv[i]
                self.distv[i]=self.distv[p]
                self.distv[p]=t
                temp=self.vertic[i]
                self.vertic[i]=self.vertic[p]
                self.vertic[p]=temp
            i=p
    def Extractmin(self):
        t=self.vertic[0]
        r=self.distv[0]
        self.distv[0]=self.distv[self.length-1]
        self.distv[self.length-1]=r
        self.distv.pop()
        self.length=self.length-1
        d=self.vertic[0]
        self.vertic[0]=self.vertic[self.length-1]
        self.vertic[self.length-1]=d
        self.heapify(0)
        return t
    def update(self,x,y):
        i=0
        for j in range(self.length):
            if self.vertic[j]==x:
                self.distv[j]=y
                i=j
                break
        #print(self.distv)
       # print(self.vertic)
        self.heapify(0)
class Graph:
    def __init__(self):
        self.sd=100000
        self.pred=None
def Dijsktras(s,graph,weight,n):
    h=Heap()
    a[s].sd=0
    for j in range(n):
        h.Insert(j,a[j].sd)
    while len(h.distv)!=0:
        q=h.Extractmin()
        for r in range(len(graph[q])):
            if a[graph[q][r]].sd>weight[q][r]+a[q].sd:
                t=weight[q][r]+a[q].sd
                a[graph[q][r]].sd=t
                h.update(graph[q][r],t)
                a[r].pred=r
    for k in range(n):
        print(k,a[k].sd)
n=int(input("enter No. of vertices :"))
a=[None]*n
graph=[None]*n
weight=[None]*n
for i in range(n):
    a[i]=Graph()
    graph[i]=[]
    weight[i]=[]
e=int(input("enter No. of edges: "))
print("enter edges")
i=0
while(i<e):
    x,y,wei=map(int,input().split())
    if x<n and y<n:
        graph[x].append(y)
        graph[y].append(x)
        weight[x].append(wei)
        weight[y].append(wei)
    else:
        print("INVALID EDGE, input again ")
        i-=1
    i+=1
print("Enter a source vertex")
s=int(input())
Dijsktras(s,graph,weight,n)
