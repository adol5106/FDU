#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv){
   int n=atoi(argv[1]);
   int **x = malloc(sizeof(int *)*n);
   int i,j;
   int cnt=1;

   for(i=0;i<n;i++){
     *(x+i) = malloc(sizeof(int)*n);
   }

   for(i=0;i<n;i++){
     for(j=0;j<n;j++){
        x[i][j]=cnt;
        cnt++;
     }
   }

   for(i=0;i<n;i++){
    for(j=0;j<n;j++){
        printf("%d\t",x[i][j]);
    }
    printf("\n");
   }
   return 0;

}