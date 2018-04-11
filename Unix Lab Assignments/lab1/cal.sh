echo "enter a choice"
echo "1 multiply"
echo "2. substaract"
echo "3.add"
echo "4.divide"
echo "enter your choice"
read choice
echo "enter two numbers"
read a
read b
if [ $choice = "1" ]
then 
echo $((a+b))
fi

