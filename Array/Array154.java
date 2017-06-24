/*
Find lost element from a duplicated array
Given two arrays which are duplicates of each other except one element, that is one element from one of the array is missing, 
we need to find that missing element.
Examples:

Input:  arr1[] = {1, 4, 5, 7, 9}
        arr2[] = {4, 5, 7, 9}
Output: 1
1 is missing from second array.

Input: arr1[] = {2, 3, 4, 5}
       arr2[] = {2, 3, 4, 5, 6}
Output: 6
6 is missing from first array.
*/
import java.util.Arrays;
class Array154{
    public static void main(String []args){
        /*int a1[] = {1, 4, 5, 7, 9};
        int a2[] = {4, 5, 7, 9};*/
        int a1[] = {2, 3, 4, 5};
        int a2[] = {2, 3, 4, 5, 6};
        System.out.println("array1 = "+Arrays.toString(a1));
        System.out.println("array2 = "+Arrays.toString(a2));
        int xor = a1[0];
        for(int i=1; i<a1.length; i++)
            xor ^= a1[i];
        for(int i=0; i<a2.length; i++)
            xor ^= a2[i];
        System.out.println("missing number = "+xor);
    }
}
