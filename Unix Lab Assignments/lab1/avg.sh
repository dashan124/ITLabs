echo "enter the value of n"
read n
sum=0
for((i=1;i<=n;i++));
do
echo "enter a num"
read num
sum=` expr $sum + $num `
done
avg=` expr $sum / $n `
echo "the vag is $avg"

