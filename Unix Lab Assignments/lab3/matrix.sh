echo "enter the rows and columns "
read r1
read c1
echo " enter the elements"
for((i=0;i<$r1;i++));
do
for((j=0;j<$c1;j++));
do
read ele
mat[$i,$j]=$ele
done
done
echo "enter the second"
read r2
read c2
echo " enter the elements"
for((t=0;t<$r2;t++));
do
for((v=0;v<$c2;v++));
do
read el
matr[$t,$v]=$ele
done
done
for((b=0;b<$r1;b++));
do
for((u=0;u<$c1;u++));
do
s=0
s=`expr ${mat[$b,$u]} + ${matr[$b,$u]} ` 
sum[$b,$u]=$s
done
done
for ((f=0;f<$r1;f++)) do
   # printf "$f1" $j
    for ((g=0;g<$c1;g++)) do
        echo ${sum[$f,$g]}
    done
    echo
done
