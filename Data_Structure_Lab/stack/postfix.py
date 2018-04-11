
def isoperator(x):
    if x=='+' or x=='-' or x=='*' or x=='/':
        return 1
    else:
        return 0
def res(o,m,n):
    if o=='+':
        return m+n
    elif o=='-':
        return m-n
    elif o=='*':
        return m*n
    elif o=='/':
        return m/n
    else:
        return 0
str1=input()
l=str1.split()
stack=list()
for i in range(len(l)):
    if isoperator(l[i]):
        d=int(stack.pop())
        c=int(stack.pop())
        h=res(l[i],c,d)
        stack.append(h)
    else:
        stack.append(l[i])
print(stack.pop())
