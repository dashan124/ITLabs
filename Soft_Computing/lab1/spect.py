import csv , numpy

def training(train):
    w = list()
    for i in range(1,len(train[0])):
        w.append(1/(1+i))
    loop = 90000
    rate = 0.1
    error = 0
    flag , count = 1 , 0
    while(loop > 0 ):
        loop = loop -1
        for i in range(0,len(train)):
            x = train[i]
            cost = 0
            for j in range(len(w)):
                cost = cost + w[j] * x[j]
            if cost > 0 :
                cost = 1
            else:
                cost = 0
            error = x[0] - cost
            if error != 0 :
                flag = 0
                count = 0
                for j in range(len(w)):
                    w[j] = w[j] + rate * error * x[j]
            else:
                flag = 1
                count = count + 1
            if count == len(train):
                return w
    return w

def test(testing , w ):
    n = len(testing)
    c = 0
    for i in range(n):
        cost = 0
        x = testing[i]
        for j in range(len(w)):
            cost = cost + w[j] * x[j]
        if cost > 0 :
            cost = 1
        else:
            cost = 0
        error = x[0] - cost
        if error == 0:
            c = c + 1
    return float(c/n)



def main():
    with open('SPECT.csv' , 'r') as f:
        reader = csv.reader(f , delimiter=',')
        x = list(reader)
        data = numpy.array(x)
        train = list()
        testing = list()
        n = len(data)
        c = 0
        for i in range(1,n):
            if data[i][0] == 'Yes':
                p = 1
            else:
                p = 0
            x = data[i]
            l = list()
            for j in range(1,len(x)):
                l.append(int(x[j]))
            if i%5==0:
                testing.append([p]+l)
            else:
                train.append([p]+l)
        # print(train)
        w = training(train)
        print("Acurracy : " , test(testing,w))
        print('Weights : ' , w )
        return 0


if __name__ == '__main__':
    main()
