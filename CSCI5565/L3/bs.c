#include <stdio.h>

int binarySearch(int arr[], int l, int r, int x){
   if (r >=1){
      int mid = l+(r-l)/2;
      if(arr[mid]==x)
        return mid;

   if (arr[mid]>x)
        return binarySearch(arr,l,mid-1,x);

   
   return binarySearch(arr,mid+1,r,x);
}
return -1;
}

int main(){
   int arr[]={1,2,3,4,5,6};

   int res = binarySearch(arr,0,sizeof(arr)/sizeof(arr[0])-1,6);
   if(res == -1)
     printf("The result has failed\n");
   else printf("Your target is at index %d\n",res);

   return 0;


}