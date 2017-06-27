/*
Find a triplet that sum to a given value
Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. If there is such a 
triplet present in array, then print the triplet and return true. Else return false. For example, if the given array is 
{12, 3, 4, 1, 6, 9} and given sum is 24, then there is a triplet (12, 3 and 9) present in array whose sum is 24. 
*/

import java.util.Arrays;
class Array{
    public static void main(String []args){
        int []a = {12, 3, 4, 1, 6, 9};
        int sum = 25;
        int flag = 0;
        System.out.println("givan array = "+Arrays.toString(a)+"\nsum = "+sum);
        Arrays.sort(a);
        for(int i=0; i<a.length-2; i++){
            for(int j=i+1; j<a.length-1; j++){
                int l = j;
                int r = a.length-1;
                while(l<r){
                    if(a[i] + a[l] + a[r] == sum){
                        System.out.println("possible triplet is:\n"+a[i]+" "+a[l]+" "+a[r]);
                        flag = 1;
                        break;
                    }
                    
                    else if(a[i] + a[l] + a[r] < sum)
                        l++;
                    
                    else if(a[i] + a[l] + a[r] > sum)
                        r--;
                }
                if(flag == 1)
                    break;
            }
        }
        if(flag == 0)
                System.out.println("no triplet possible");
    }
}
