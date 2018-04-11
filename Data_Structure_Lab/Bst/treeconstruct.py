class treenode:
    def __init__(self):
        self.data=None
        self.left=None
        self.right=None
        self.parent=None

class tree:
    def __init__(self):
        self.root=None

    def insert(self,p):
        a=[]
        b=[]
        c=[]
        count=0
        for i in range(0,len(p)):
            key=p[i]

            if key=="*" or key=="/" or key=="+" or key=="-" or key=="^":
                b.append(key)
            elif key=="(":
                c.append(")")
                count+=1
            elif count>3 and key==')' and len(a)!=0 and len(b)!=0:
                temp = treenode()
                temp.data = b.pop()
                temp1 = treenode()
                temp2 = treenode()
                temp1.data = a.pop()
                temp2.data = a.pop()
                temp.left = temp1
                temp.right = temp2
                temp1.parent = temp
                temp2.parent = temp

                if self.root==None:

                    self.root=temp
                    count-=1
                elif self.root.right==None:
                    self.root.right=temp
                else:
                    newnode=treenode()
                    newnode.data=b.pop()
                    newnode.left=self.root
                    self.root.parent=newnode
                    newnode.right=temp
                    temp.parent=newnode
                    self.root=newnode
                    count-=2
            elif key==")" and len(a)!=0 and len(b)!=0:
                if c.pop()==key:
                    temp=treenode()
                    w=b.pop()
                    temp.data=w
                    if count>=1:
                        count-=1

                    if self.root==None:
                        temp1 = treenode()
                        temp2 = treenode()
                        self.root=temp
                        temp.left=temp1
                        temp.right=temp2
                        temp2.data=a.pop()
                        temp1.data=a.pop()
                        a.append(w)
                    elif self.root!=None:
                        temp.left=self.root
                        self.root.parent=temp
                        temp1=treenode()
                        temp1.data=a.pop()
                        temp.right=temp1
                        self.root=temp

            else:
                    a.append(key)

    def printtreeinorder(self,root):

        if root.right != None:
            self.printtreeinorder(root.right)
        print(root.data, end=" ")
        if root.left != None:
            self.printtreeinorder(root.left)

    def printtreepostorder(self, root):

        if root.right != None:
            self.printtreepostorder(root.right)
        if root.left != None:
            self.printtreepostorder(root.left)
        print(root.data,end= " ")

    def printtreepreorder(self,root):
        print(root.data,end=" ")
        if root.right!=None:
            self.printtreepreorder(root.right)
        if root.right!=None:
            self.printtreepreorder(root.left)



T=tree()
p='( 1 + ( ( ( 2 + 6 ) * ( 5 + 4 ) ) ) ) ) '
a=p.split()
print(a)
T.insert(a)
T.printtreeinorder(T.root)
print()
T.printtreepostorder(T.root)
print()
T.printtreepreorder(T.root)