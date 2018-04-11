#!/bin/bash
sum=0
echo "Enter a number:"
read n
for((i=1;i<=n;i++))
do
sum=`expr $sum + $i`
done

echo "Sum is $sum"