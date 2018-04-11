sum=0
a=$1
for((i=1;i<=$a;i++));
do
sum=` expr $sum + $i `
done
echo "the sum is $sum"

