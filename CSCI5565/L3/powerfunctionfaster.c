#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int power2(int x,int n){
   // write a recursive function
   if(n==0){
    return 1;
   } else {
    if (n % 2 ==1){
       return x*power2(x,n-1);

    } else{
        int y = power2(x,n/2);
        return y*y;
    }
   }
}

int main(int argc, char **argv){
    int x=atof(argv[1]);
    int n=atof(argv[2]);


    printf("%d\n", power2(x,n));
    return 0;

}

