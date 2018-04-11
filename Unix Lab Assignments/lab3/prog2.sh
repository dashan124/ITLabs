echo "enter a name"
read name
if [ -f $name ]
then
echo "the content of file "
cat $name
elif [ -d $name ]
then
ls -l $name
fi

