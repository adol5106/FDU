#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv){
   int n = atoi(argv[1]);
   int i;

   int *ptr = malloc(n*4);
   int *tmp = ptr;

   for (i=0;i<n;i++){
    *ptr = i;
    ptr++;
   }

   for (i=0;i<n;i++){
     printf("%d\n", *tmp);
     tmp++;
   }

   return 0;


}