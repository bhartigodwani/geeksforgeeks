/*
@author Bharti Godwani

Find a Fixed Point in a given array

Given an array of n distinct integers sorted in ascending order, write a function that returns a Fixed Point in the array, 
if there is any Fixed Point present in array, else returns -1. Fixed Point in an array is an index i such that arr[i] is 
equal to i. Note that integers in array can be negative.

Examples:

  Input: arr[] = {-10, -5, 0, 3, 7}
  Output: 3  // arr[3] == 3 

  Input: arr[] = {0, 2, 5, 8, 17}
  Output: 0  // arr[0] == 0 


  Input: arr[] = {-10, -5, 3, 4, 7, 9}
  Output: -1  // No Fixed Point

*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Array{
    public static void main(String []args){
        int a[] = {-10, -5, 0, 3, 7};
        //int a[] = {-10, -5, 0, 5, 7};
        System.out.println("array = "+Arrays.toString(a));
        int fixPoint = findFixedPoint(a, 0, a.length-1);
        System.out.println((fixPoint == -1) ? "no fixed point" : ("fixed point = "+fixPoint));
    }
    
    static int findFixedPoint(int a[], int l, int r){
        int mid = (l+r)/2;
            if(l < r){
            if(a[mid] == mid)
                return mid;
            if(a[mid] > mid)
                return findFixedPoint(a, l, mid-1);
            else
                return findFixedPoint(a, mid+1, r);
        }
        return -1;
    }
}
