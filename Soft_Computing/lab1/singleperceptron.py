from csv import reader
import random

# Load a CSV file
def load_csv(filename):
	dataset = list()
	with open(filename, 'r') as file:
		csv_reader = reader(file)
		for row in csv_reader:
			if not row:
				continue
			dataset.append(row)
	return dataset

def str_column_to_float(dataset, column):
	for row in dataset:
		row[column] = float(row[column].strip())

def str_column_to_int(dataset, column):
	class_values = [row[column] for row in dataset]
	unique = set(class_values)
	lookup = dict()
	for i, value in enumerate(unique):
		lookup[value] = i
	for row in dataset:
		row[column] = lookup[row[column]]
	return lookup


def calculatevalue(dataset,weight):
	ans=0
	for i in range(len(weight)):
		ans+=(weight[i]*dataset[i])

	if ans>0:
		return 1
	else:
		return 0

def goforaccuracy(weight,dataset):
	countp=0
	n = len(dataset[0])-1
	for i in range(len(dataset)):
		check = calculatevalue(dataset[i],weight)
		if check == dataset[i][n]:
			countp+=1

	return (countp*100)/(len(dataset))



def updateweight(weight,learningrate,error,dataset):
	for i in range(len(weight)):
		weight[i]+=(learningrate*error*dataset[i])

	return weight

def singleperceptron(weight,dataset):
	n=len(dataset[0])-1
	for i in range(500):
		for j in range(len(dataset)):
			check = calculatevalue(dataset[j],weight)

			if check == dataset[j][n]:
				pass
			else:
				weight=updateweight(weight,0.01,dataset[j][n]-check,dataset[j])

	return weight

print("Enter the filename")
f = input()
dataset = load_csv(f)
dataset.pop(0)
n=len(dataset[0])
val = 1/(n)
weight=[val]*(len(dataset[0])-1)
for i in range(len(dataset[0])-1):
	str_column_to_float(dataset, i)
str_column_to_int(dataset, len(dataset[0])-1)
traindataset=list()
checkdataset=list()
for i in range(len(dataset)):
	if i%5==0:
		checkdataset.append(dataset[i])
	else:
		traindataset.append(dataset[i])
finalweight=singleperceptron(weight,traindataset)
ans = goforaccuracy(finalweight,checkdataset)
print("Accuracy :",ans)
print("Final Weight :", finalweight)
