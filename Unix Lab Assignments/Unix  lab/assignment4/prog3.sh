echo "Enter your choice "
echo "1.adding a record"
echo "2.deleting a record"
echo "3.finding a record"
read choice
echo " "|cat>>student.lst
if [ $choice -eq 1 ]
then
  echo "enter the name of the student"
  read name
  echo "enter the roll no of the student"
  read roll
  echo "enter the semester of the student"
  read sem
  echo "enter marks in sub1"
  read m1
  echo "enter marks in sub2"
  read m2
  echo "enter marks in sub3"
  read m3
  echo -n " Name : $name"|cat>>student.lst
  echo -n " roll no : $roll"|cat>>student.lst
  echo -n " semester : $sem"|cat>>student.lst
  echo -n " sub1 marks : $m1"|cat>>student.lst
  echo -n " sub2 marks : $m2"|cat>>student.lst
  echo -n " sub3 marks : $m3"|cat>>student.lst
elif [ $choice -eq 2 ]
then
  echo "Enter a roll no to delete record"
  read roll
  n=`grep -n "$roll" student.lst|cut -c 1`
  x=$n"d"
  sed "$x" student.lst|cat > student.lst 
elif [ $choice -eq 3 ]
then
  echo "enter anything to search"
  read any
  grep $any student.lst
else
  echo "Enter a valid choice"
fi
