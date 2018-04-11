a=$(echo "scale=2; $1 + $2 " | bc)
echo "the sum is "$a
