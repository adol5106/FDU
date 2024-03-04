#include <stdio.h>

int main(int argc, char **argv){
   int n=5;
   int arr[1000000000000]={1,2,3,4,5};
   int *ptr = &arr[0];
   for (int i=0;i<n;i++){
     printf("%d\n",*ptr);
     ptr++;

   }

   return 0;


}