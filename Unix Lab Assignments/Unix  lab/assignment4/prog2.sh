d=`date +"%H"`
q=`date +"%M"`
x=`expr $d \* 100`
y=`expr $q + $x`
if [ $y -ge 0 ]&&[ $y -le 1159 ]
then
  echo "Good Morning"
elif [ $y -ge 1200 ]&&[ $y -le 1759 ]
then
  echo "Good afternoon"

elif [ $y -ge 1800 ]&&[ $y -le 1959 ]
then
  echo "Good evening"

else
  echo "Good Night"
fi
 
