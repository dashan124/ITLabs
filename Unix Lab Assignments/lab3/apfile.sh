echo "enter the first filename"
read first
echo "enter the second filename"
read second
if [ -e $first ]
then
if [ -e $second ]
then
cat $first >> $second
else
cat $first > $second
fi
fi

