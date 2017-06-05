/*
Find the smallest missing number
Given a sorted array of n distinct integers where each integer is in the range from 0 to m-1 and m > n. Find the smallest
number that is missing from the array.
Examples
Input: {0, 1, 2, 6, 9}, n = 5, m = 10
Output: 3

Input: {4, 5, 10, 11}, n = 4, m = 12
Output: 0

Input: {0, 1, 2, 3}, n = 4, m = 5
Output: 4

Input: {0, 1, 2, 3, 4, 5, 6, 7, 10}, n = 9, m = 11
Output: 8
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int arr[] =  {0, 1, 2, 3, 4, 5, 6, 7, 10};
        System.out.println(binarySearch(arr, 0 , arr.length-1));
    }
    
    static int binarySearch(int []arr, int l, int r){
        int mid = (l+r)/2;
        if(l == r){
            if(arr[mid] != mid)
                return mid;
            else if(arr[mid] == mid)
                return mid+1;
        }
        if(l < r){
            if(arr[mid] == mid)
                return binarySearch(arr, mid+1, r);
            else if(arr[mid] > mid)
                return binarySearch(arr, l, mid-1);
        }
        return 0;
    }
}
