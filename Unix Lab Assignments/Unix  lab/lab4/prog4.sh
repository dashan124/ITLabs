n=0
p=0
z=0
echo ""|cat>a.txt
for ((i=0;i<10;i++))
do
  read a
  echo "$a"|cat>>a.txt
  if [ $a -gt 0 ]
  then
    p=$[$p+1]
  elif [ $a -lt 0 ]
  then
    n=$[$n+1]
  else
    z=$[$z+1]
  fi
done
echo "no of positive numbers "$p
echo "no of negative numbers " $n
echo "no of zeros "$z
sort -n a.txt
