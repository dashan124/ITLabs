#!/bin/bash
echo "Enter the width of rectangle:"
read width
echo "Enter the length of rectangle:"
read length
area=$(echo "scale=2;( length * width)" | bc)
echo "area of rectangle is $area"
 