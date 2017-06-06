/*

Two elements whose sum is closest to zero

Question: An Array of integers is given, both +ve and -ve. You need to find the two elements such that their sum is closest 
to zero.
Examples:
Input: -8 -66 -60  
Output: -60 -8

Input: -21 -67 -37 -18 4 -65  
Output: -18 4

Input: -24 -73  
Output: -73 -24
*/

import java.util.Arrays;

public class Array34{

    public static void main(String[] args) {
        //int arr[] =  {-21, -67, -37, -18, 4, -65};
        //int arr[] = {-8, -66, -60};
        int arr[] = {-24, -73};
        System.out.println("array : "+Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("\nsorted array : "+Arrays.toString(arr));
        int l=0, r=arr.length-1;
        int sum = 0, absSum = Integer.MAX_VALUE;
        int one=0, two=arr.length;
        while(l<r){
            sum = arr[l] + arr[r];
            if(absSum > Math.abs(sum)){
                absSum = Math.abs(sum);
                one = l;
                two = r;
            }
            if(sum == 0)
                break;
            if(sum < 0)
                l++;
            else
                r--;
        }
        System.out.println("\nsum = "+absSum+"  l = "+arr[one]+" r = "+arr[two]);
    }
       
}
