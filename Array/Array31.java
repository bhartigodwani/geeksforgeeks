/*
Check if array elements are consecutive | Added Method 3
Given an unsorted array of numbers, write a function that returns true if array consists of consecutive numbers.
Examples:
a) If array is {5, 2, 3, 1, 4}, then the function should return true because the array has consecutive numbers from 1 to 5.
b) If array is {83, 78, 80, 81, 79, 82}, then the function should return true because the array has consecutive numbers from 
78 to 83.
c) If the array is {34, 23, 52, 12, 3 }, then the function should return false because the elements are not consecutive.
d) If the array is {7, 6, 5, 5, 3, 4}, then the function should return false because 5 and 5 are not consecutive.
*/

import java.io.*;
import java.util.*;

public class Array31{

    public static void main(String[] args) {
        int a[] = {83, 78, 80, 81, 79, 82};
        int xor1 = 0;
        int min = a[0], max = a[0];
        xor1 = xor1^a[0];
        for(int i=1; i<a.length; i++){
            if(min > a[i])
                min = a[i];
            
            if(max < a[i])
                max = a[i];
            xor1 ^= a[i];
        }
        
        int xor2 = 0;
        for(int i=min; i<=max; i++)
            xor2 ^= i;
        
        if((xor1 ^ xor2) != 0)
            System.out.println("false");
        else
            System.out.println("true");
    }
}
