#!/bin/bash
echo "Enter amount:"
read p
echo "Enter time:"
read t
echo "Enter Rate of interst:"
read r
i=` expr $p \* $t \* $r `
i=` expr $i / 100 `
echo "Simple interst is : $i"
