/*
A Product Array Puzzle
Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that prod[i] is equal to the 
product of all the elements of arr[] except arr[i]. Solve it without division operator and in O(n).

Example:
arr[] = {10, 3, 5, 6, 2}
prod[] = {180, 600, 360, 300, 900}
*/
import java.util.Arrays;
class Array{
    public static void main(String []args){
        int[] arr = {10, 3, 5, 6, 2};
        int []left = new int[arr.length];
        int []right = new int[arr.length];
        int prod[] = new int[arr.length];
        
        left[0] = 1;
        for(int i=1; i<arr.length; i++)
            left[i] = left[i-1] * arr[i-1];
        
        right[arr.length-1] = 1;
        for(int i=arr.length-2; i>=0; i--)
            right[i] = right[i+1] * arr[i+1];
        
        for(int i=0; i<arr.length; i++)
            prod[i] = left[i] * right[i];
        System.out.println("array = "+Arrays.toString(arr));
        System.out.println("product array = "+Arrays.toString(prod)+"\n");
        
        /*------------------efficient method-------------------*/
        /*----------------without left and right array---------*/
        for(int i=0; i<arr.length; i++)
            prod[i] = 1;
        prod[0] = 1;
        for(int i=1; i<arr.length; i++)
            prod[i] = prod[i-1] * arr[i-1];
        int temp = 1;
        for(int i=arr.length-2; i>=0; i--){
            temp = temp * arr[i+1];
            prod[i] = prod[i] * temp;
        }
            
        System.out.println("------------------efficient method-------------------\n----------------without left and right array---------");
        System.out.println("array = "+Arrays.toString(arr));
        System.out.println("product array = "+Arrays.toString(prod));
    }
}
