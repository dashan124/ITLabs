class Graph:
    def __init__(self):
        self.color="white"
        self.dis=None
        self.pre=None
        self.time=[]
def dfs(av,s,t):
    a[s].dis=0
    a[s].color="grey"
    t+=1
    a[s].time.append(t)
    for v in av[s]:
        if a[v].color=="white":
            t=dfs(av,v,t)
            a[v].pre=s
    a[s].color="black"
    t+=1
    a[s].time.append(t)
    print("vertix",s,"    timeslap",a[s].time)
    return t
n=int(input("enter No. of vertices :"))
g=[0]*n
a=[None]*n
av=[None]*n
for i in range(n):
    a[i]=Graph()
    av[i]=[]
e=int(input("enter No. of edges: "))
print("enter edges")
i=0
while(i<e):
    x,y=map(int,input().split())
    if x<n and y<n:
        av[x].append(y)
        av[y].append(x)
    else:
        print("INVALID EDGE, input again ")
        i-=1
    i+=1
print("Enter a source vertex")
s=int(input())
t=dfs(av,s,0)
