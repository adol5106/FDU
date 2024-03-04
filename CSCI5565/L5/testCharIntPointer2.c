#include <stdio.h>

int main(){
    int x=1;
    char* ptr;

    ptr = &x;
    printf("%x\n",ptr);
    ptr++;
  

    printf("%d\n",*ptr);




    return 0;
}