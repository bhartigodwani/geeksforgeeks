/*
Find minimum difference between any two elements
Given an unsorted array, find the minimum difference between any pair in given array.
Examples :

Input  : {1, 5, 3, 19, 18, 25};
Output : 1
Minimum difference is between 18 and 19

Input  : {30, 5, 20, 9};
Output : 4
Minimum difference is between 5 and 9

Input  : {1, 19, -4, 31, 38, 25, 100};
Output : 5
Minimum difference is between 1 and -4
*/
import java.util.Arrays;
class Array153{
    public static void main(String []args){
        //int a[] = {2, 3, 4, 5};
        //int a[] = {1, 2, 3, 4, 5, 6, 7};
        int a[] = {1, 19, -4, 31, 38, 25, 100};
        Arrays.sort(a);
        int mindiff = Integer.MAX_VALUE, curr_min;
        System.out.println("array = "+Arrays.toString(a));
        for(int i=0; i<a.length-1; i++){
            curr_min = a[i+1] - a[i];
            mindiff = Math.min(mindiff, curr_min);
        }
        System.out.println("min diference = "+mindiff);
    }
}
