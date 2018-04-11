echo "enter a string"
read str
echo $str > temp
echo "the duplicate string  $temp"
rvs="$(rev temp)"
if [ $str = $rvs ]
then
echo "plaindrome"
else
echo "not"
fi

