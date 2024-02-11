#include <stdio.h>

// 1 0 3
// 0 5 0
// 7 0 9

int main(int argc, char **argv){
    int x[3][3]={{1,2,3},{4,5,6},{7,8,9}};

    for (int i=0;i<3;i++){
      for (int j=0;j<3;j++){
        if ((i%2==0) && (j%2==1))
         {printf("0 ");}
        else if ((i%2==1) && (j%2==0))
         {printf("0 ");}
        else
         {printf("%d ",x[i][j]);}
      }
      printf("\n");



    }
  return 0;




}