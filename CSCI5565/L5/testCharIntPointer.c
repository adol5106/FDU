#include <stdio.h>

int main(){
    int x=1;
    char* ptr;
    
    ptr = &x;
    
    printf("%x\n",ptr);
    ptr++;
    
    *ptr = '\t';
    printf("%d\n",*ptr);
    printf("%d\n",x);


    return 0;
}