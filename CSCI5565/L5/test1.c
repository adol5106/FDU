#include <stdio.h>

int main(){
   int x=5;
   int y;
   int* ptr;

   ptr = &x;

   printf("%x\n",ptr);
   printf("%d\n",(*ptr)*(*ptr));
   printf("%d\n",y);

   return 0;


}