location=$1
filecount=0
dir=0
if [ $# -lt 1 ]
then
echo "please enter a valid"
fi
for item in $location/.*
do
if [ -f "$item" ]
then 
filecount=`expr $filecount + 1 `
elif [ -d "$item" ]
then
dir=`expr $dir + 1 `
fi
done
echo "filecount : "$filecount
echo "dircount  :" $dir
