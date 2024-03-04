#include <stdio.h>
#include <stdlib.h>


int main(int argc, char **argv){
   int n=3;
   int i;

   int *ptr = malloc(n*4);
   int *tmp = ptr;
   int *ptr2 = ptr;
   *ptr = 1;
   ptr++;
   *ptr=2;
   ptr++;
   *ptr=3;

   for(i=0;i<n;i++){
    printf("%d\n",tmp[i]);

   }

   
   free(ptr2);
   return 0;



}