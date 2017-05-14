/*
Find the element that appears once
Given an array where every element occurs three times, except one element which occurs only once. Find the element that occurs once. Expected time complexity is O(n) and O(1) extra space.
Examples:

Input: arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3}
Output: 2 
*/

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++){
            if(map.containsKey(arr[i]))//containsKey return true if key is present else false
                map.put(arr[i], map.get(arr[i]) + 1);//get() return the value wrt key
            else
                map.put(arr[i], 1);
        }
        
        System.out.println(map);
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue().equals(1)){ //getValue() returns the value of the entry
                System.out.println(entry.getKey()); //returns the key of the entry
            }
        }
    }
}
