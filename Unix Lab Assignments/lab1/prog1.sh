echo "enter the radius "
read r
area=$(echo "scale=2;3.14*$r*$r" | bc)
echo "the area is $area"
echo "enter amount"
read p
echo "entre rate of interest"
read re
echo "enter the time "
read t
i=`expr $p \* $re \* $t `
i=`expr $i / 100 `
echo "the rate of interest is $i"
