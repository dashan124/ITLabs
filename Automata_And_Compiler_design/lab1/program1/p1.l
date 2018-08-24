%{
	#include <stdio.h>
	int v=0;
	int c=0;
%}
%%
[aeiouAEIOU] v++;
[A-Za-z] c++;
%%
main(){
	printf("enter the string And press ctrl+d\n");
	yylex();
	printf("the no of vowels %d\n",v);
	printf("the no of constans are %d\n",c);
	return 0;
}