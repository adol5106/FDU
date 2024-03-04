#include <stdio.h>

int main(){
  int x = 5;
  int* ptr;

  ptr=&x;

  printf("%x\n",ptr);
  ptr++;

  printf("%x\n",ptr);

  return 0;



}