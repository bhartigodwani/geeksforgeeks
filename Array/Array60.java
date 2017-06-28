/*
Find the two numbers with odd occurrences in an unsorted array
Given an unsorted array that contains even number of occurrences for all numbers except two numbers. Find the two numbers 
which have odd occurrences in O(n) time complexity and O(1) extra space.

Examples:
Input: {12, 23, 34, 12, 12, 23, 12, 45}
Output: 34 and 45

Input: {4, 4, 100, 5000, 4, 4, 4, 4, 100, 100}
Output: 100 and 5000

Input: {10, 20}
Output: 10 and 20

*/
import java.util.Arrays;
class Array{
    public static void main(String []args){
        //int a[] = {4, 4, 100, 5000, 4, 4, 4, 4, 100, 100};
        //int a[] = {12, 23, 34, 12, 12, 23, 12, 45};
        int a[] = {10, 20};
        System.out.println("array = "+Arrays.toString(a));
        int i, xor = 0;
        for(i=0; i<a.length; i++)
            xor ^= a[i];
        //int r = a.length-1;
        i = 0;
        int shift = 0;
        int firstSetBit = (xor >> i++) & 1;
        while(firstSetBit != 1){
            firstSetBit = (xor >> i++) & 1;
            shift++;
        }
        int xor1 = 0, xor2 = 0;
        for(i=0; i < a.length; i++){
            if(((a[i] >> shift) & 1) == 0)
                xor1 ^= a[i];
            if(((a[i] >> shift) & 1) == 1)
                xor2 ^= a[i];
        }
        System.out.println("first = "+xor2+" second = "+xor1);
    }
}
