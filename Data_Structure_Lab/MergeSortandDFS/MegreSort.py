def MergeSort(arr,low,high):
    if low<high:
        mid=(low+high)//2
        MergeSort(arr,low,mid)
        MergeSort(arr,mid+1,high)
        Merge(arr,low,mid,high)
    else:
        return
def Merge(arr,low,mid,high):
    L=arr[low:mid+1]
    R=arr[mid+1:high+1]
    l=0
    r=0
    k=low
    while l<=mid-low and r<high-mid:
        if L[l]<R[r]:
            arr[k]=L[l]
            l+=1
        else:
            arr[k]=R[r]
            r+=1
        k+=1
    while l<=mid-low:
        arr[k]=L[l]
        k+=1
        l+=1
    while r<(high-mid):
        arr[k]=R[r]
        r+=1
        k+=1


n=int(input("Enter the no of elements in array :  "))
arr=[]
for j in range(n):
    arr.append(int(input()))
MergeSort(arr,0,len(arr)-1)
print(arr)