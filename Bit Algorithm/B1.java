/*
Find the element that appears once
Given an array where every element occurs three times, except one element which occurs only once. Find the element that occurs 
once. Expected time complexity is O(n) and O(1) extra space.
Examples:

Input: arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3}
Output: 2
*/
import java.util.Arrays;
class Bit{
    public static void main(String []args){
        //int[] arr = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        int[] arr = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3};
        //int []arr = {5,5,8,5};
        System.out.println("Array = "+Arrays.toString(arr));
        int result = 0;
        int lastBit, sum;
        for(int j=0; j<32; j++){
            sum = 0;
            for(int i=0; i<arr.length; i++){
                sum += arr[i] & 1;
                arr[i] >>= 1;
            }
            result = (sum%3)<<j | result;
        }
        System.out.println("result = "+result);
    }
}
