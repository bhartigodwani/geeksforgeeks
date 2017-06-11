/*
Maximum and minimum of an array using minimum number of comparisons
*/
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] a = {2, 5, 2, 8, 5, 6, 8, 8};
        System.out.println("array : "+Arrays.toString(a));
        int count = numberOfComparisions(a);
        System.out.println("count  = "+count);
    }
    
    static int numberOfComparisions(int []a){
        int min, max, cur_min, cur_max;
        int count = 0;
        int i = 0;
        if(a.length % 2 == 0){
            min = (a[0] > a[1]) ? a[1]: a[0];
            max = (a[0] < a[1]) ? a[1]: a[0];
            i = i+2;
            count+=1;
        }
        else{
            min = a[0];
            max = a[0];
            i++;
        }
        
        for(; i<a.length; i+=2){
            if(a[i] > a[i+1]){
                cur_min = a[i+1];
                cur_max = a[i];
            }
            else{
                cur_max = a[i+1];
                cur_min = a[i];
            }
            count++;
            if(max < cur_max)
                max = cur_max;
            if(min > cur_min)
                min = cur_min;
            count += 2;
        }
        System.out.println("max = "+max+"  min = "+min);
        return count;
    }
}
