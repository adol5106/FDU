#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int power(int n, int x){
   if (x==0)
     return 1;
   else
     return n * power(n,x-1);
   

}

int main(int argc, char **argv){
    printf("%d\n", power(6,4));


}