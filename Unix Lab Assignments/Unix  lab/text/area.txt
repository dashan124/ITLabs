#!/bin/bash
echo -n "Enter the radius of a circle : "
read r
 
area=$(echo "scale=2;3.14 * ($r * $r)" | bc)
 
d=$(echo "scale=2;2 * $r"|bc)
circumference=$(echo "scale=2;3.14 * $d"| bc)
 
echo "Area of circle is $area"
echo "Circumference of circle is $circumference"