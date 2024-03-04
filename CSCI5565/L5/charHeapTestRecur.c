#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void printC(char *cptr){
  if(*cptr == '\0'){
    
    return;
  }  else{
    printC(cptr+1);
    printf("%c",*cptr);
  }


}

int main (int argc, char **argv){
  char *c = malloc(6);
  c = "hello";
  printf("%s\n",c);

  printC(c);
  printf("\n");
  return 0;


}