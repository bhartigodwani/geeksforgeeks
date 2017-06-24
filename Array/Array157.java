/*
Find minimum number of merge operations to make an array palindrome

Given an array of positive integers. We need to make the given array a ‘Palindrome’. Only allowed operation on array is merge.
Merging two adjacent elements means replacing them with their sum. The task is to find minimum number of merge operations 
required to make given array a ‘Palindrome’.

To make an array a palindromic we can simply apply merging operations n-1 times where n is the size of array (Note a single 
element array is alway palindrome similar to single character string). In that case, size of array will be reduced to 1. But 
in this problem we are asked to do it in minimum number of operations.

Example:

Input : arr[] = {15, 4, 15}
Output : 0
Array is already a palindrome. So we
do not need any merge operation.

Input : arr[] = {1, 4, 5, 1}
Output : 1
We can make given array palindrome with
minimum one merging (merging 4 and 5 to
make 9)

Input : arr[] = {11, 14, 15, 99}
Output : 3
We need to merge all elements to make
a palindrome.

*/
import java.util.Arrays;
class Array{
    public static void main(String []args){
        //int a[] = {2, 3, 4, 5};
        //int a[] = {1, 2, 3, 4, 5, 6, 7};
        //int a[] = {1, 19, -4, 31, 38, 25, 100};
        //int a[] = {4,2,1};
        //int a[] = {15, 4, 15};
        //int a[]= {1, 4, 5, 1};
        int a[] = {11, 14, 15, 99};
        System.out.println("array = "+Arrays.toString(a));
        int r = a.length-1, merge=0, sum;
        for(int l=0; l<=a.length/2; ){
            if(a[l] == a[r]){
                l++;
                r--;
            }       
            else if(a[l] < a[r]){
                sum = a[l];
                l++;
                while(l<r && sum < a[r]){
                    sum += a[l];
                    l++;
                    merge++;
                }
                if(sum == a[r])
                    break;
                else if(l==r){
                    merge++;
                    break;
                }
            }
            else{
                sum = a[r];
                r--;
                while(r>l && sum < a[l]){
                    sum += a[r];
                    r--;
                    merge++;
                }
                if(sum == a[l])
                    break;
                else if(l==r){
                    merge++;
                    break;
                }
            }
        }
        System.out.println("merge = "+merge);
    }
}
