/*
Sliding Window Maximum (Maximum of all subarrays of size k)
Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.

Examples:
Input :
arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
k = 3
Output :
3 3 4 5 5 5 6
Input :
arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
k = 4
Output :
10 10 10 15 15 90 90

Solution 1:
using left and right array
Solution 2:
using deque(refer notes)
*/

import java.util.Arrays;
class Array{
    public static void main(String[] args){
        int []a = {1, 2, 3, 1, 4, 5, 2, 3, 6, 4,1};
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        int k = 3;
        int ti = 0;
        System.out.println("array = "+Arrays.toString(a));
        for(int i=0; i<a.length; i++){
            if(i % k == 0)
                left[ti] = a[i];
            
            else
                left[ti] = Math.max(a[i], left[ti-1]);
            ti++;
        }
        System.out.println("left = "+Arrays.toString(left));
        
        ti=0;
        int temp;
        for(int i=1; i<=k; i++){
            temp = (i*k)-1;
            if(temp < a.length){
                int count = k-1;
                right[temp] = a[temp];
                temp--;
                while(count > 0){
                    right[temp] = Math.max(a[temp], right[temp+1]);
                    temp--;
                    count--;
                }
            }
        }
        System.out.println("right = "+Arrays.toString(right));
        int result[] = new int[a.length-k];
        ti=0;
        for(int i=0; i<a.length-k; i++){
            result[ti] = Math.max(right[i], left[i+k-1]);
            ti++;
        }
        System.out.println("result = "+Arrays.toString(result));
    }
}
