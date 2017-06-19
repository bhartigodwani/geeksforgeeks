/*
@author Bharti Godwani

Find the minimum distance between two numbers

Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[]. The array might 
also contain duplicates. You may assume that both x and y are different and present in arr[].

Examples:
Input: arr[] = {1, 2}, x = 1, y = 2
Output: Minimum distance between 1 and 2 is 1.

Input: arr[] = {3, 4, 5}, x = 3, y = 5
Output: Minimum distance between 3 and 5 is 2.

Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6
Output: Minimum distance between 3 and 6 is 4.

Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2
Output: Minimum distance between 3 and 2 is 1.

Method 2 
1) Traverse array from left side and stop if either x or y is found. Store index of this first occurrence in a variable say 
prev
2) Now traverse arr[] after the index prev. If the element at current index i matches with either x or y then check if it is 
different from arr[prev]. If it is different then update the minimum distance if needed. If it is same then update prev 
i.e., make prev = i.
*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Array{
    public static void main(String []args){
        /*int a[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};*/
        //int a[] = {1, 2};
        //int a[]= {3, 4, 5};
        int a[] = {2, 5, 3, 5, 4, 4, 2, 3};
        
        int in[] = new int[a.length];
        for(int i=0; i<a.length; i++)
            in[i] = i;
        //int x=1, y=2;
        int x=3, y=2;
        System.out.println("array = "+Arrays.toString(a));
        System.out.println("index = "+Arrays.toString(in));
        System.out.println("x = "+x+" y = "+y);
        int result = minDistance(a, x, y);
        System.out.println("min distance = "+result);
    }
    
    static int minDistance(int[]a, int x, int y){
        int xIndex=-1, yIndex=-1;
        int minD = -1;
        int currMinD = -1;
        for(int i=0; i<a.length; i++){
            if(a[i] == x){
                xIndex = i;
            }
            if(a[i] == y){
                yIndex = i;
            }
            if(xIndex != -1 && yIndex != -1){
                currMinD = Math.abs(xIndex - yIndex);
            }
            if(minD == -1){
                minD = currMinD;
            }
            else{
                minD = Math.min(minD, currMinD);
            }
        }
        return minD;
    }
}
