echo "enter the no of names you want to add"
read n
echo " "|cat>>address.lst
for((i=0;i<n;i++));
do
  echo "enter the name"
  read name
  echo "enter the address"
  read add
  echo "Name : $name"|cat>>address.lst
  echo "Address : $add"|cat>>address.lst
  echo " "|cat>>address.lst
done
