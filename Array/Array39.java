/*
@author Bharti Godwani

Find the repeating and the missing | Added 3 new methods

Given an unsorted array of size n. Array elements are in range from 1 to n. One number from set {1, 2, …n} is missing and 
one number occurs twice in array. Find these two numbers.

Examples:

  arr[] = {3, 1, 3}
  Output: 2, 3   // 2 is missing and 3 occurs twice 

  arr[] = {4, 3, 6, 2, 1, 1}
  Output: 1, 5  // 5 is missing and 1 occurs twice 

*/
import java.util.Arrays;
class Array39{
    public static void main(String []args){
        int a[] = {4, 3, 6, 2, 1, 5, 1};
        System.out.println("array = "+Arrays.toString(a));
        findMissingAndRepeating(a);
    }
    
    static void findMissingAndRepeating(int a[]){
        int n = a[0];
        for(int i=1; i<a.length; i++)
            n = (a[i] > n) ? a[i] : n;
        int countArr[] = new int[a.length+1];
        for(int i=0; i<a.length; i++){
            countArr[a[i]]++;
        }
            
        int miss = -1, repeat = -1; 
        for(int i=1; i<=n; i++){
            if(countArr[i] == 0)
                miss = i;
            else if(countArr[i] == 2)
                repeat = i;
        }
        if(miss == -1)
            miss = n+1;
        
        System.out.println("mising number = "+miss);
        System.out.println("repeating number = "+repeat);
    }
}
