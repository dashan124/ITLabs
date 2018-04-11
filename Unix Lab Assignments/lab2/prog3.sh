echo "how many elements you want to enter"
read gc
echo "entre $gc elements"
#echo $gc
for(( c=0 ; c < $gc ; c++))
do
read ele
array_name[$c]="$ele"
done
count=0
count1=0
count2=0
for(( v=0 ; v < $gc ; v++));
do
if [ ${array_name[$v]} -lt 0 ]
then 
count=` expr $count + 1 `
elif [ ${array_name[$v]} -eq 0 ]
then
count1=` expr $count1 + 1 `
else
count2=` expr $count2 + 1 `
fi
done 
echo "no of negative elements $count"
echo "no of zeros $count1"
echo "no of positives $count2"
sorted=($(for i in "${array_name[@]}";do
echo $i;
done | sort))
echo "the sorted array"
for i in ${sorted[*]};
do
echo $i
done
echo "the min :${sorted[0]}"
echo "the max :${sorted[$gc-1]}"
count=0
for(( c=0 ; c < $gc ;c++))
do
for(( g=0 ; g < $gc ; g++))
do
if [ $c -ne $g ]
then
if [ ${array_name[$c]} -eq ${array_name[$g]} ]
then
count=`expr $count + 1 ` 
fi
fi
done
done
if [ $count -gt 0 ]
then
echo "the values are repeated"
fi

