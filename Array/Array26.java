/*
Sort an array of 0s, 1s and 2s
Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then 
all 1s and all 2s in last.

Example
Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
*/
import java.util.Arrays;
class Array{
    public static void main(String []args){
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        System.out.println("Array = "+Arrays.toString(arr));
        //low will tend to point zeroes, mid to ones and high to 2s
        int low=0, mid=0, high=arr.length-1;
        int temp;
        while(mid <= high){
            switch(arr[mid]){
                case 0:
                        temp = arr[mid];
                        arr[mid] = arr[low];
                        arr[low] = temp;
                        low++;
                        mid++;
                        break;
                case 1:
                        mid++;
                        break;
                case 2:
                        temp = arr[mid];
                        arr[mid] = arr[high];
                        arr[high] = temp;
                        high--;
                        break;
            }
        }
        
        
        System.out.println("\n0 1 2 array = "+Arrays.toString(arr));
    }
}
