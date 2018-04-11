#!/bin/bash
echo "please enter a number"
read n1

echo "please choose an operation"
echo "1. add"
echo "2. subtract"
echo "3. divide"
echo "4. multiply"
read opr

echo "please enter a number again"
read n2

if [ $opr = "1" ]
   then
      echo $((n1+n2))
elif [ $opr = "2" ]
   then  
      echo $((n1-n2))
elif [ $opr = "3" ]
   then
      echo $((n1/n2))
elif [ $opr = "4" ]
   then
       echo $((n1*n2))

fi
exit 0