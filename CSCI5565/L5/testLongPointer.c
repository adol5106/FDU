#include <stdio.h>

int main(){
  long long x = 5;
  long long* ptr;

  ptr=&x;

  printf("%x\n",ptr);
  ptr++; 

  printf("%x\n",ptr);

  return 0;



}