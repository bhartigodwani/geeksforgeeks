/*
@author Bharti Godwani

Check if a given array contains duplicate elements within k distance from each other

Given an unsorted array that may contain duplicates. Also given a number k which is smaller than size of array. Write a 
function that returns true if array contains duplicates within k distance.

Examples:

Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
Output: false
All duplicates are more than k distance away.

Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
Output: true
1 is repeated at distance 3.

Input: k = 3, arr[] = {1, 2, 3, 4, 5}
Output: false

Input: k = 3, arr[] = {1, 2, 3, 4, 4}
Output: true
*/

import java.util.HashMap;
import java.util.Arrays;
class Hash2{
    public static void main(String []args){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int arr[] = {1, 2, 3, 4, 1, 2, 3, 4};
        //int arr[] = {1, 2, 3, 1, 4, 5};
        //int arr[] = {1, 2, 3, 4, 5};
        //int arr[] = {1, 2, 3, 4, 4};
        int k = 3;//distance
        System.out.println("array = "+Arrays.toString(arr));
        System.out.println("k = "+k);
        boolean areDuplicate = areDuplicate(arr, k, map);
        System.out.println((areDuplicate==true) ? "duplicates are present within "+k+" numbers" : "duplicates are not present within "+k+" numbers");
        
    }
    
    static boolean areDuplicate(int a[], int k, HashMap<Integer, Integer> map){
        for(int i=0; i<a.length; i++){
            if(map.containsKey(a[i]) && (map.get(a[i]) + k) >= i){
                return true;
            }
            else
                map.put(a[i], i);
        }
        return false;
    }
}
