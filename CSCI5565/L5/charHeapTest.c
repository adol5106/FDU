#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(int argc, char **argv){
    char *c=malloc(6);
    c = "hello";

    printf("%s\n",c);

    for (int i=5;i>=0;i--){
      printf("%c",*(c+i));

    }
    printf("\n");
    return 0;

}
