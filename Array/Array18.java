/*
Segregate 0s and 1s in an array
You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array. Traverse array only once.

Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0] 
Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1] 
*/
import java.util.Arrays;
class Array18{
    public static void main (String[] args) {
        //int []a = {0, 1, 1, 1, 1, 1};//already sorted Array
        //int []a = {1,1,1,0,0,0};//worst case
        //int []a = {1,0,1,0,1,0};
        //int []a = {1,0,1,1,1,1};
        int []a = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        int l=0, r=a.length-1;
        int temp;
        while(l < r){
            if(a[l] == 0)
                l++;
                
            else if(a[l] == 1 && a[r] == 0)//swap them
                swap(a, l, r);
            
            else{
                while(a[r] == 1 && l<r){
                    r--;
                }
                swap(a, l, r);
                l++;
                r--;
            }
        }
        
        System.out.println("segegated array : "+Arrays.toString(a));
    }
    
    static void swap(int []a, int l, int r){
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
