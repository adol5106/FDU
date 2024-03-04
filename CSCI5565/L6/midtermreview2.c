#include <stdio.h>
#include <stdlib.h>

int sumOfDigits(int n){
   if (n<10)
     return n;
   else 
     return sumOfDigits(n/10)+n%10;




}

int main(int argc,char **argv){
   int n=atoi(argv[1]);
   int res=sumOfDigits(n);
   printf("%d\n",res);


}