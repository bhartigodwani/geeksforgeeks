/*

Replace every element with the greatest element on right side

Given an array of integers, replace every element with the next greatest element (greatest element on the right side) in the 
array. Since there is no element next to the last element, replace it with -1. For example, if the array is 
{16, 17, 4, 3, 5, 2}, then it should be modified to {17, 5, 5, 5, 2, -1}.

*/

import java.util.Arrays;
class Array{
    public static void main(String []args){
        int a[] = {16, 17, 4, 3, 5, 2};
        System.out.println("original array = "+Arrays.toString(a));
        int n = a.length;
        int max = a[n-1];
        a[n-1] = -1;
        for(int i=n-2; i>=0; i--){
            if(a[i] > max){
                int temp = a[i];
                a[i] = max;
                max = temp;
            }
            else
                a[i] = max;
        }
        System.out.println("modified array = "+Arrays.toString(a));
    }
}
