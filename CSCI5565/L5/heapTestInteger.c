#include <stdio.h>
#include <stdlib.h>

int main(int argc,char **argv){
  int n=atoi(argv[1]);
  int i;

  int *ptr=malloc(n*4);
  /*printf("%d\n",ptr);*/
  int *ptr2 = ptr;
  int *tmp = ptr;
  for (i=0;i<n;i++){
    *ptr=i;
    ptr++;
  }
  
  for (i=0;i<n;i++){
    printf("%d\n",*tmp);
    tmp++;
  }
  
  free(ptr2);
  return 0;


}