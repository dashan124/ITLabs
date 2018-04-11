#!/bin/sh
m=$1
n=$2
if [ $m -le 0 ]
then
echo "enter a positive valid number"
read a
m=$a
elif [ $n -le 0 ]
then
echo "Enter a positive valid number"
read b
n=$b
fi
if [ $m -gt $n ]
then
div=$(echo "scale=2;$n / $m" | bc)
echo "the result is $div"
else
di=$(echo "scale=2;$m / $n" |bc)
echo "the result is $di"
fi
