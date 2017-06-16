/*
Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
Given an unsorted array arr[0..n-1] of size n, find the minimum length subarray arr[s..e] such that sorting this subarray 
makes the whole array sorted.
Examples:
1) If the input array is [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60], your program should be able to find that the subarray
lies between the indexes 3 and 8.
2) If the input array is [0, 1, 15, 25, 6, 7, 30, 40, 50], your program should be able to find that the subarray lies 
between the indexes 2 and 5.
*/
import java.util.Arrays;
class Array{
    public static void main(String []args){
        //int[] arr = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        int[] arr = {0, 1, 15, 25, 6, 7, 30, 40, 50};
        System.out.println("Array = "+Arrays.toString(arr));
        int left=0;
        while(left<arr.length-1 && arr[left] < arr[left+1])
            left++;
        
        int right = arr.length-1;
        while(right >= 1 && arr[right] > arr[right-1])
            right--;
        int min=arr[left], max = arr[left];
        for(int i=left+1; i <= right; i++){
            if(arr[i] > max)
                max = arr[i];
            if(arr[i] < min)
                min = arr[i];
        }
        
        int f1=0, f2=0;
        for(int i=0; i<left; i++){
            if(arr[i] > min && f1 == 0){
                left = i;
                break;    
            }
        }
        
        for(int i=arr.length-1; i>right; i--){
            if(arr[i] < max && f2 == 0){
                right = i;            
                break;
            }
        }

        System.out.println("left = "+left+" right = "+right);
    }
}
