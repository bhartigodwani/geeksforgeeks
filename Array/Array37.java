/*
@author Bharti Godwani

Find whether an array is subset of another array | Added Method 3
Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a subset of arr1[] or not. Both the arrays are not
in sorted order. It may be assumed that elements in both array are distinct.

Examples:
Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1}
Output: arr2[] is a subset of arr1[]

Input: arr1[] = {1, 2, 3, 4, 5, 6}, arr2[] = {1, 2, 4}
Output: arr2[] is a subset of arr1[]

Input: arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3}
Output: arr2[] is not a subset of arr1[]
*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Array37{
    public static void main(String []args){
        /*int arr1[] = {11, 1, 13, 21, 3, 7};
        int arr2[] = {11, 3, 7, 1, 9};*/
        
        /*int arr1[] = {1, 4, 2} ;
        int arr2[] = {1, 4, 4, 2} ;*/
        
        /*int arr1[] = {1, 2, 3, 4, 5, 6};
        int arr2[] = {1, 2, 4};*/
        
        int arr1[] = {10, 5, 2, 23, 19};
        int arr2[] = {19, 5, 3};
        /*-----------------------using sorting and merging---------------------*/
        System.out.println("case1");
        System.out.println("a1 = "+Arrays.toString(arr1));
        System.out.println("a2 = "+Arrays.toString(arr2));
        boolean result = sortAndMerge(arr1, arr2);//true if a2 is subset of a1 else false
        if(result)
            System.out.println("a2 is subset of a1");
        else
            System.out.println("a2 is not subset of a1");

        /*---------------------------using hashing-----------------------------*/
        System.out.println("case2");
        System.out.println("a1 = "+Arrays.toString(arr1));
        System.out.println("a2 = "+Arrays.toString(arr2));
        result = throughHashing(arr1, arr2);//true if a2 is subset of a1 else false
        if(result)
            System.out.println("a2 is subset of a1");
        else
            System.out.println("a2 is not subset of a1");
        
    }
    
    static boolean sortAndMerge(int[] a1, int[] a2){
        Arrays.sort(a1);
        Arrays.sort(a2);
        int i1=0, i2=0;
        while(i1<a1.length && i2<a2.length){
            if(a1[i1] == a2[i2]){
                i1++;
                i2++;
            }
            else if(a1[i1] < a2[i2])
                i1++;
            else
                return false;
        }
        if(i2 < a2.length)
            return false;
        return true;
    }
    
    static boolean throughHashing(int []a1, int[] a2){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<a1.length; i++){
            map.put(a1[i], (map.containsKey(a1[i])) ? (map.get(a1[i])+1) : 1 );
        }
        
        for(int i=0; i<a2.length; i++){
            if(!map.containsKey(a2[i]))
                return false;
            else if(map.containsKey(a2[i]) && map.get(a2[i]) > 0){
                map.put(a2[i], (map.get(a2[i])-1));
            }
            else
                return false;
        }
        /*for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+"   "+entry.getValue());
        }*/
       return true;
    }
}
