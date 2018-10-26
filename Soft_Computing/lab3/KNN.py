import csv
import random
import math
import operator

def loadDataSet(filename,split,trainingSet=[],testSet=[]):
	with open(filename,'r') as csvfile:
		lines=csv.reader(csvfile)
		dataset=list(lines)
		for x in range(len(dataset)-1):
			for y in range(4):
				dataset[x][y]=float(dataset[x][y])
			if random.random()<split:
				trainingSet.append(dataset[x])
			else:
				testSet.append(dataset[x])
def distance(a,b,length):
	dist=0
	for x in range(length):
		xx=a[x]-b[x]
		dist+=(xx*xx)
	return math.sqrt(dist)
def getNeibours(trainingSet,test,k):
	distances=[]
	length=len(test)-1
	for x in range(len(trainingSet)):
		dist=distance(test,trainingSet[x],length)
		distances.append([trainingSet[x],dist])
	distances.sort(key=operator.itemgetter(1))
	neighbours=[]
	for x in range(k):
		neighbours.append(distances[x][0])
	return neighbours
def getResponse(neighbours):
	classVotes={}
	for x in range(len(neighbours)):
		response=neighbours[x][-1]
		for response in classVotes:
			classVotes[response]+=1
		else:
			classVotes[response]=1
	sortedVotes=sorted(iter(classVotes.items()),key=operator.itemgetter(1),reverse=True)
	return sortedVotes[0][0]
def getAccuracy(testSet,predictions):
	correct=0
	for x in range(len(testSet)):
		if testSet[x][-1]==predictions[x]:
			correct+=1
	return ((correct/float(len(testSet))))*100

def main():
	trainingSet=[]
	testSet=[]
	split=0.67
	loadDataSet('iris.data',split,trainingSet,testSet)
	print("trainging set"+repr(len(trainingSet)))
	print("test set: "+repr(len(testSet)))
	predictions=[]
	k=5
	for x in range(len(testSet)):
		neighbours=getNeibours(trainingSet,testSet[x],k)
		result=getResponse(neighbours)
		predictions.append(result)
		#print(">predicted = "+repr(result)+", actual="+repr(testSet[x][-1]))
	accuracy=getAccuracy(testSet,predictions)
	print("accuracy "+repr(accuracy)+"%")

if __name__ == '__main__':
	main()
