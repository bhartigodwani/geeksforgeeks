/*
Find the element that appears once
Given an array where every element occurs three times, except one element which occurs only once. Find the element that occurs once. Expected time complexity is O(n) and O(1) extra space.
Examples:

Input: arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3}
Output: 2

Complexity = O(nlogn)
*/
import java.util.Scanner;
import java.util.Arrays;
class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        
        int i;
        for(i=0; i<n; ){
            if(arr[i] == arr[i+1] && arr[i+1] == arr[i+2])
                i=3;
            else
                break;
        }
        
        System.out.println("element = "+arr[i]);
        
    }
}
