max=999
for ((i=1;i<=999;i++));
do
    a1=$(echo "scale=0;($i % 10)" | bc)
    b=$(echo "scale=0;($i / 10)" | bc)
    b1=$(echo "scale=0;($b % 10)" | bc)
    c=$(echo "scale=0;($b / 10)" | bc)
    c1=$(echo "scale=0;($c % 10)" | bc)
    a2=$(echo "scale=0;($a1 * $a1 * $a1)" | bc)
    a3=$(echo "scale=0;($b1 * $b1 * $b1)" | bc)
    a4=$(echo "scale=0;($c1 * $c1 * $c1)" | bc)
    a=$(echo "scale=0;($a2 + $a3 + $a4)" | bc)
    if [ $i -eq $a ]
    then
    echo "$i"
    fi
done
