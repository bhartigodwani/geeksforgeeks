/*
Check for Majority Element in a sorted array
Question: Write a C function to find if a given integer x appears more than n/2 times in a sorted array of n integers.
Basically, we need to write a function say isMajority() that takes an array (arr[] ), array’s size (n) and a number to be 
searched (x) as parameters and returns true if x is a majority element (present more than n/2 times).

Examples:

Input: arr[] = {1, 2, 3, 3, 3, 3, 10}, x = 3
Output: True (x appears more than n/2 times in the given array)

Input: arr[] = {1, 1, 2, 4, 4, 4, 6, 6}, x = 4
Output: False (x doesn't appear more than n/2 times in the given array)

Input: arr[] = {1, 1, 1, 2, 2}, x = 1
Output: True (x appears more than n/2 times in the given array)
*/

import java.io.*;
import java.util.*;

public class Array16 {

    public static void main(String[] args) {
        //int arr[] =  {1, 2, 2, 2, 2, 2, 2, 3, 4, 7, 8};
        //int arr[] ={1, 2, 3, 4, 4, 4, 4};
        //int arr[] = {1, 2, 3, 3, 3, 3, 10};
        //int arr[] = {1, 1, 2, 4, 4, 4, 6, 6};
        int arr[] = {1, 1, 1, 2, 2};
        /*the majority element need to be on centre*/
        int mid = (0 + (arr.length-1))/2;
        int l = leftOccurence(arr, 0 , arr.length-1, arr[mid]);
        int r = -1;
        if(l != -1)
            r = rightOccurence(arr, 0 , arr.length-1, arr[mid]);
        if(l != -1 & r != -1){
            int result = r-l+1;
            if(result > (arr.length/2))
                System.out.println("majority element is : "+arr[mid]+" in array "+Arrays.toString(arr)+"with frequency : "+result);
            else
                System.out.println("majorit element doesnot exist in array "+Arrays.toString(arr));
        }
    }
    
    static int leftOccurence(int []arr, int l, int r, int x){
        int mid = (l+r)/2;
        if(l==r && arr[mid] == x)
            return mid;
        else if(l < r){
            if(arr[mid] == x){
                if(mid == 0 || arr[mid-1] != x)
                    return mid;
                else
                    return leftOccurence(arr, l, mid-1, x);                
            }
           else if(arr[mid] < x)
                return leftOccurence(arr, mid+1, r, x);
           else if(arr[mid] > x)
               return leftOccurence(arr, l, mid-1, x);
        }
           return -1;
    }

    static int rightOccurence(int []arr, int l, int r, int x){
        int mid = (l+r)/2;
        if(l==r && arr[mid] == x)
            return mid;
        else if(l < r){
            if(arr[mid] == x){
                if((mid+1) == arr.length || arr[mid+1] != x)
                    return mid;
                else
                    return rightOccurence(arr, mid+1, r, x);                
            }
           else if(arr[mid] < x)
                return rightOccurence(arr, mid+1, r, x);
           else if(arr[mid] > x)
               return rightOccurence(arr, l, mid-1, x);
       }
       return -1;
    }
}
