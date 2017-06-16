/*
Segregate Even and Odd numbers
Given an array A[], write a function that segregates even and odd numbers. The functions should put all even numbers first, 
and then odd numbers.
Example

Input  = {12, 34, 45, 9, 8, 90, 3}
Output = {12, 34, 8, 90, 45, 9, 3} 

In the output, order of numbers can be changed, i.e., in the above example 34 can come before 12 and 3 can come before 9.
*/
import java.util.Arrays;
class Array{
    public static void main(String []args){
        int[] arr = {12, 34, 45, 9, 8, 90, 3};
        int left=0;
        int right = arr.length-1;
        
        while(left < right){
            if(arr[left] % 2 == 0)
                left++;
            if(arr[right] % 2 == 1)
                right--;
            if(arr[left] % 2 == 1 && left < right){
                while(left < right && arr[right] % 2 == 1)
                    right--;
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
                right--;
            }
        }
        System.out.println("even odd array = "+Arrays.toString(arr));
    }
}
