/*
Maximum difference between two elements such that larger element appears after the smaller number
Given an array arr[] of integers, find out the difference between any two elements such that larger element appears after the
smaller number in arr[].

Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). If array is [ 7, 9, 5,
6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)
Solution:
Method 1)
In this method, instead of taking difference of the picked element with every other element, we take the difference with the 
minimum element found so far. So we need to keep track of 2 things:
1) Maximum difference found so far (max_diff).
2) Minimum number visited so far (min_element).

Method 2)
First find the difference between the adjacent elements of the array and store all differences in an auxiliary array diff[] of 
size n-1. Now this problems turns into finding the maximum sum subarray of this difference array.
*/

class Array{
    public static void main(String []args){
        int []a = { 7, 9, 5, 6, 3, 2};
        int temp[] = new int[a.length-1];
        for(int i=0; i<a.length-1; i++)
            temp[i] = a[i+1] - a[i];
        int curr_max = temp[0];
        int max_so_far = temp[0];
        for (int i=1; i<temp.length; i++){
            curr_max = Math.max(curr_max+temp[i] , temp[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        } 
        System.out.println("max difference = "+max_so_far+"\n");
    }
}
