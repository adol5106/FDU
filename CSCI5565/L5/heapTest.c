#include <stdio.h>
#include <stdlib.h>

int *makeArr(int n){
   int *ptr = malloc(n*sizeof(int));
   return ptr;

}

void initArr(int *ptr, int n){
   for (int i=0;i<n;i++){
    *ptr = i;
    ptr++;
   }


}

void modArr(int *ptr,int n){
   for(int i=0;i<n;i++){
      if(i%2==0){
        *ptr=0;
      }
     ptr++;
   }


}

int main(int argc,char **argv){
  int n = atoi(argv[1]);
  int *ptr = makeArr(n);
  initArr(ptr, n);
  modArr(ptr,n);
  for (int i=0;i<n;i++){
    printf("%d\n",*(ptr+i));
  }
  free(ptr);
  return 0;



}