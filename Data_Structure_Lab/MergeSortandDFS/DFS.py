class Graph:
    def __init__(self):
        self.color="white"
        self.distance=None
        self.pred=None
        self.time=[]
def dfs(graph,s,t):
    a[s].dis = 0
    a[s].color = "grey"
    t += 1
    a[s].time.append(t)
    for v in graph[s]:
        if a[v].color == "white":
            t = dfs(graph, v, t)
            a[v].pre = s
    a[s].color = "black"
    t += 1
    a[s].time.append(t)
    print("vertix", s, "    timeslap", a[s].time)
    return t

n=int(input("Enter the no of vertices:  "))
a=[None]*n
graph=[None]*n
for i in range(n):
    a[i]=Graph()
    graph[i]=[]
e=int(input("Enter the no of edges :  "))
print("Enter edges ")
i=0
while i<e:
    x,y=map(int,input().split())
    if x<n and y<n:
        graph[x].append(y)
    else:
        print("Invalid edge input again")
        i-=1
    i+=1
print("Enter a source vertex : ")
s=int(input())
t=dfs(graph,s,0)
print("tree edges:")
for i in range(n):
    for j in range(len(graph[i])):
        print(i,graph[i][j])
