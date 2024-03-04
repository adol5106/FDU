#include <stdio.h>

int main(){
  char x='a';
  char* ptr;

  ptr=&x;

  printf("%x\n", ptr);
  ptr +=1;
  printf("%x\n",ptr);


  return 0;



}