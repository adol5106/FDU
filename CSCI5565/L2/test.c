#include <stdio.h>

int main(){
    int i=0;
    int flag=0;
    while (i > -1){
      printf("%d ",i);
      if (flag==0){
        i++;
      }
      else{
        i--;
      }
      if(i==9){
        flag=1;
      }
    }
    return 0;
}