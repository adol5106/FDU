#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv){
  int n=atoi(argv[1]);
  int *ptr = malloc(100000000000000);


  if (ptr == NULL){
    printf("Memory malloc failed");
    return 0;

  }
printf("Hello: %d\n",n);
return 0;



  
}