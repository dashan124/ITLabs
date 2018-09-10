import pandas as pan
import numpy as num
import math

file = pan.read_csv("SPECT.csv")
file.sample(frac=1)
file = file.sample(frac=1).reset_index(drop=True)
size = file.shape[1] - 1
w1 = [[(1.0 / (file.shape[0] * 5.0))] * (size) for i in range(5)]
w2 = [(1.0 / 5.0)] * (5)
i1 = [1] * 5
o1 = [1] * 5
e1 = [0] * 5

y = []
lr = 0.2
fw1 = [[(1.0 / (file.shape[0] * 5.0))] * (size) for _ in range(5)]
fw2 = [(1.0 / 5.0)] * (5)
k = file.shape[0]
pddtrain = []
pddtest = []
file1 = []


def activate(wx):
    ww = 1 / (1 + pow(math.e, -wx))
    if ww > 0:
        return 1
    return 0


def wxxx(wx):
    if wx > 2:
        return 1
    else:
        return 0


def oneiteration():
    global y, w1, w2, pddtrain, file1, lr, k, i1, o1, e1
    serror = 0
    for i in range(pddtrain.shape[0] - 1):
        error = 0
        for ii in range(5):
            for j in range(len(file1)):
                i1[ii] += pddtrain[file1[j]][i] * w1[ii][j]
            o1[ii] = activate(i1[ii])
            wx = 1
        for ii in range(5):
            wx += o1[ii] * w2[ii]
            output = activate(wx)
        error = output * (1 - output) * (y[i] - output)
        for ii in range(5):
            e1[ii] = o1[ii] * (1 - o1[ii]) * (error * w2[ii])
        for ii in range(5):
            w2[ii] += (lr * o1[ii])
        for ii in range(5):
            for j in range(len(file1)):
                w1[ii][j] += (lr * e1[ii] * pddtrain[file1[j]][i])
        serror += error
    return serror


def accuracy():
    global y, w1, w2, pddtest, file1, lr, k
    tp = tn = fn = fp = 0
    for i in range(pddtest.shape[0]):
        wpre1 = [1] * 5
        for ii in range(5):
            for j in range(len(file1)):
                wpre1[ii] += pddtest[file1[j]][i] * w1[ii][j]
            wpre1[ii] = activate(wpre1[ii])
        wx = 1
        for ii in range(5):
            wx += w2[ii] * wpre1[ii]
        result = activate(wx)
        if y[i] == 1 and result == 1:
            tp += 1
        elif y[i] == 1:
            fn += 1
        elif y[i] == 0 and result == 0:
            tn += 1
        else:
            fp += 1
    # print("hi")
    return [tp, fn, fp, tn]


def kfoldcv(iteration_val, nfolds):
    global y, w1, w2, file, pddtrain, pddtest, file1, lr, k, finalw
    acc = 0
    l = 0
    avgacc = 0.0
    setsize = (file.shape[0] // nfolds)
    for i in range(1, nfolds):
        err = 0
        k = (file.shape[0] // nfolds) * i
        # print("     ",k)
        i = 1
        j = k
        while j < file.shape[0]:
            pddtrain = file[:i]
            pddtrain = pddtrain.append(file[j:])
            pddtrain = pddtrain.reset_index()
            pddtest = file[i:j]
            pddtest = pddtest.reset_index()
            i = j
            j = j + k
            for ii in range(iteration_val):
                err = oneiteration()
                if err == 0:
                    break
            racc = accuracy()
            acc1 = (1.0 * racc[0] + racc[3]) / (racc[0] + racc[1] + racc[2] + racc[3])
            if acc <= acc1:
                acc = acc1
                fw1 = w1
                fw2 = w2
            w1 = [[(1.0 / (file.shape[0] * 5.0))] * (size) for i in range(5)]
            w2 = [(1.0 / 5.0)] * (5)
            avgacc += acc1
            l += 1
            print('accuracy is :', acc1, acc)
            print(j, k)
    print(avgacc, iteration_val)
    return [(avgacc * 1.0) / l, acc]


file1 = []
lr = 0.1  # 70.7=0.92, 0.9=0.88
for i in file.keys():
    file1.append(i)
file1 = file1[1:]
for i in range(file.shape[0]):
    if file[file.keys()[0]][i] == "No":
        y.append(0)
    else:
        y.append(1)
file = file[file.keys()[1:]]
print("average accuracy is =", kfoldcv(1000, 10))
