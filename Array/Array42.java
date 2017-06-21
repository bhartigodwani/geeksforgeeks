/*
@author Bharti Godwani

Find the maximum element in an array which is first increasing and then decreasing

Given an array of integers which is initially increasing and then decreasing, find the maximum value in the array.

Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}
Output: 500

Input: arr[] = {1, 3, 50, 10, 9, 7, 6}
Output: 50

Corner case (No decreasing part)
Input: arr[] = {10, 20, 30, 40, 50}
Output: 50

Corner case (No increasing part)
Input: arr[] = {120, 100, 80, 20, 0}
Output: 120

Solution:
Using binary search
*/

import java.util.Arrays;
class Array42{
    public static void main(String []args){
        //int a[] =  {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        //int a[] = {1, 3, 50, 10, 9, 7, 6};
        //int a[] = {10, 20, 30, 40, 50};
        int a[] = {120, 100, 80, 20, 0};
        
        int index[] = new int[a.length];
        for(int i=0; i<a.length; i++){
            index[i] = i;    
        } 
        System.out.println("array = "+Arrays.toString(a));
        System.out.println("index = "+Arrays.toString(index));
        
        int max = searchMaxElement(a, 0, a.length-1);
        System.out.println("max = "+max);
    }
    
    static int searchMaxElement(int []a, int l, int r){
          if(l == r)
             return a[l];
          if(l < r){
              int mid = (l+r)/2;
              if(a[mid] > a[mid+1]){
                  if(mid == 0)
                      return a[mid];
                  else if(a[mid-1] < a[mid])
                      return a[mid];
              }
              if(a[mid] < a[mid+1])
                  return searchMaxElement(a, mid+1, r);
          
              if(a[mid] > a[mid+1])
                  return searchMaxElement(a, l, mid-1);
          }    
        return 0;
    }
}
