class Graph:
    def __init__(self):
        self.color="white"
        self.dis=None
        self.pre=None
        self.time=[]
def dfs(av,s):
    stack=[]
    stack.append(s)
    t=0
    while len(stack)!=0:
        x=stack.pop()
        a[x].color="black"
        for v in av[x]:
            if a[v].color=="white":
                stack.append(v)
                a[v].color="grey"
                a[v].pre=v
                t+=1
                a[s].time.append(t)

        print("vertix",x,"    timeslap",a[s].time)
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
for i in range(n):
    if a[i].color=="white":
        dfs(av,i)