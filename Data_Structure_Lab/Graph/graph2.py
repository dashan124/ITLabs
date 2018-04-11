class binheap:
	def __init__(self,a):
		self.heap=a
		self.l=len(a)
		for i in range(self.l//2-1,-1,-1):
			self.heapify(i)
	def heapify(self,i):
		lt=2*i+1
		rt=2*(i+1)
		if lt<self.l and rt<self.l:
			if self.heap[lt]>self.heap[rt]:
				x=lt
			else:
				x=rt
		elif lt<self.l and rt>=self.l:
			x=lt
		elif rt<self.l and lt>=self.l:
			x=rt
		else:
			return
		if self.heap[i]>self.heap[x]:
			t=self.heap[i]
			self.heap[i]=self.heap[x]
			self.heap[x]=t
			self.heapify(x)
	def mini(self):
		return self.heap[0]
	def insert(self,new):
		if self.l==0:
			print("No heap")
		else:
			i=self.l
			self.l+=1
			self.heap.append(new)
			while(i>=0):
				if self.heap[i]<self.heap[i//2]:
					t=self.heap[i]
					self.heap[i]=self.heap[i//2]
					self.heap[i//2]=t
					i=i//2
				else:
					break
    def update(self,i):
        while i>0:
            if self.heap[i]>self.heap[i//2]:
                t=self.heap[i]
                self.heap[i]=self.heap[i//2]
                self.heap[i//2]=t
            i=i//2
            self.update(i)
	def extmin(self):
		t=self.heap[0]
		self.heap[0]=self.heap[self.l-1]
		self.heap[self.l-1]=t
		self.heap[self.l-1]=None
		self.l-=1
		self.heapify(0)
class Graph:
    def __init__(self):
        self.distance=None

'''a=[5,10,15]
t=binheap(a)
print(t.heap)
t.insert(12)
print(t.heap)
t.extmin()
t.extmin()
print(t.heap)'''
def dijkstra(av,s):
    pass
n=int(input("Enter the no of vertices :  "))
a=[None]*n
gr=[None]*n
for i in range(n):
    a[i]=Graph()
    gr[i]=[]
e=int(input("Enter the no of edges : "))
i=0
while(i<e):
    x,y=map(int,input().split())
    if x<n and y<n:
        gr[x].append(y)
        gr[y].append(x)
    else:
        print("Invalid edge input again")
        i-=1
    i+=1

