m=$1
n=$2
if [ $m -le 0 ]
then
echo "please enter a valid positive number"
read num
m=$num
elif [ $n -le 0 ]
then
echo "enter a valid positive no"
read mun
n=$mun
fi
if [ $m -gt $n ]
then
div=$(echo "scale=2; $n / $m " |bc)
echo "the result is $div"
else
div=$(echo "scale=2; $m / $n " |bc)
echo "the result is $div"
fi

