#include <stdio.h>

int main(){
  unsigned long long x=5;
  x = ((unsigned long long) &x)+1;
  char* ptr;

  ptr=x;

  printf("%x\n",ptr);
  ptr++;

  printf("%c\n",*ptr);

  return 0;


}