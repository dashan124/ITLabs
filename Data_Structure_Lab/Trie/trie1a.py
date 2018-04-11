class Trienode:
	def __init__(self):
		self.ch=[None]*26
class Tries:
	def __init__(self):
		self.head=None
	def findkey(self,x):
		if ord(x)>=97 and ord(x)<=122:
			return ord(x)-97
		if ord(x)>=65 and ord(x)<=90:
			return ord(x)-65
	def add(self,s):
		if self.head==None:
			tmp=Trienode()
			self.head=tmp
		tmp=self.head.ch
		for i in range(len(s)):
			key=self.findkey(s[i])
			if tmp[key]==None:
				tmp[key]=Trienode()
			tmp=tmp[key].ch
	def search(self,s):
		if self.head==None:
			print("Not Found")
		else:
			tmp=self.head.ch
			for i in range(len(s)):
				key=self.findkey(s[i])
				if tmp[key]==None:
					print("Not found")
					return
				else:
					tmp=tmp[key].ch
			print("FOUND IT")

t=Tries()
t.add("apple")
t.add("ball")
t.search("ballet")
