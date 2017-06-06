/*
Count number of occurrences (or frequency) in a sorted array
Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[]. Expected time 
complexity is O(Logn)

Examples:
  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 2
  Output: 4 // x (or 2) occurs 4 times in arr[]

  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 3
  Output: 1 

  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 1
  Output: 2 

  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 4
  Output: -1 // 4 doesn't occur in arr[] 
  
  Solution:
  find first occurrence of the number with leftOccurence function and last Occurence by rightOccurence function
  if(l == -1) that means the element does not exist
  else
  result = r - l + 1;
*/

import java.io.*;
import java.util.*;

public class Array33 {

    public static void main(String[] args) {
        int arr[] =  {1, 2, 2, 2, 2, 2, 3};
        int x = 2;
        
        int l = leftOccurence(arr, 0 , arr.length-1, x);
        int r = -1;
        if(l != -1)
            r = rightOccurence(arr, 0 , arr.length-1, x);
        if(l != -1 & r != -1){
            int result = r-l+1;
            System.out.println(x+" occurs "+result+" times in array "+Arrays.toString(arr));
        }
        else
            System.out.println(x+" does not exist in array "+Arrays.toString(arr));
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
