#include <stdio.h>
#include <stdlib.h>


int main (int argc, char **argv){
    int arr[5]={1,2,3,4,5};
    int *ptr=malloc(5*sizeof(int));


    printf("%lu %lu\n",sizeof(arr),sizeof(ptr));





    return 0;
}