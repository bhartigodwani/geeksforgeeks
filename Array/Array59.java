/*
Find the smallest positive number missing from an unsorted array | Set 1
You are given an unsorted array with both positive and negative elements. You have to find the smallest positive number 
missing from the array in O(n) time using constant extra space. You can modify the original array.

Examples
 Input:  {2, 3, 7, 6, 8, -1, -10, 15}
 Output: 1

 Input:  { 2, 3, -7, 6, 8, 1, -10, 15 }
 Output: 4

 Input: {1, 1, 0, -1, -2}
 Output: 2 

*/
import java.util.*;
class Array{
    public static void main(String []args){
        //int []a1 = {12, 3, 4, 1, 6, 9, 9, 5, 6,34};
        //int a1[] = {1, 1, 0, -1, -2};
        //int a1[] = {2, 3, 7, 6, 8, -1, -10, 15};
        int a1[] = { 2, 3, -7, 6, 8, 1, -10, 15 };
        System.out.println("givan array = "+Arrays.toString(a1));
        firstMethod(a1);
        //int []a2 = {12, 3, 4, 1, 6, 9, 9, 5, 6,34};
        //int a2[] = {1, 1, 0, -1, -2};
        //int a2[] = {2, 3, 7, 6, 8, -1, -10, 15};
        int a2[] = { 2, 3, -7, 6, 8, 1, -10, 15 };
        System.out.println("givan array = "+Arrays.toString(a2));
        secondMethod(a2);
    }
    static void firstMethod(int a[]){
      HashSet<Integer> set = new HashSet<Integer>();
        int max = a[0];
        set.add(a[0]);
        for(int i=1; i<a.length; i++){
            if(max < a[i])
                max = a[i];
            set.add(a[i]);
        }
       
        for(int i=1; i<=max+1; i++){
            if(!set.contains(i)){
                System.out.println("missing number is = "+i);
                break;
            }
        }
    }
        
        static void secondMethod(int []a){
            int n = segregate(a);//index upto which positive numbers are there after segregation
            System.out.println("missing = "+findPositiveMissing(a, n));  
        }
        static int findPositiveMissing(int []a, int n){
        for(int i=0; i<=n; i++){
            if(Math.abs(a[i]) > n)
                continue;
            else if(a[Math.abs(a[i])-1] > 0)    
                a[Math.abs(a[i])-1] *= -1;
        }   
        //System.out.println("segregate array = "+Arrays.toString(a));
        int i;
        for(i=0; i<=n; i++)
            if(a[i] > 0)
                return i+1;
        return i+1;//if no element is found yet
    }
    
    static int segregate(int []a){
        int n = a.length-1;
        int l = 0, r = a.length-1;
        while(l<=r){
            if(a[l] <= 0){
                while(l<r && a[r]<=0)
                    r--;
                int temp = a[l];
                a[l] = a[r];
                a[r] = temp;
                l++;
                r--;
            }
            else
                l++;
        }
        for(int i=0; i<a.length; i++){
            if(a[i] <= 0){
                n = i-1;
                break;
            }
        }
        for(int i=n+1; i<a.length; i++)
            a[i] *= -1;
            
        return n;
    }
}
