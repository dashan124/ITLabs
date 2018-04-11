#!/bin/sh
echo "the first thing to show is "
echo $HOME
echo "b. the current user name"
_user="$(id -u -n)"
echo "the user is $_user"
echo "c. todays date"
NOW=$(date +"%m/%d/%Y")
echo "$NOW"
re=$(who --count)
echo "the number of users $re"
e=$(tty)
echo "terminal $e"
