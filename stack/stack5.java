/*
Next Greater Element
Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.

Examples:
a) For any array, rightmost element always has next greater element as -1.
b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.

Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.

  Element        NGE
   13      -->    -1
   7       -->     12
   6       -->     12
   12     -->     -1
 */

import java.util.Scanner;
import java.util.HashMap;
class Stack{
    static int stack[], size ;
    static int top = -1;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter array size");
        size = sc.nextInt();
        stack = new int[size];
        
        //HashMap for storing the grater numbers, initially they all are -1
        //The values change if there exist the greater number
        HashMap<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
        System.out.print("enter elements:");
        
        int arr[] = new int[size];
        for (int i=0; i<size; i++){
            arr[i] = sc.nextInt();
            valueMap.put(arr[i], -1);
        } 
        
        pushStack(arr[0]);
        for (int i=1; i<size; i++){
            while(top >= 0 && arr[i] > stack[top]){
                valueMap.put(stack[top] , arr[i]);
                popStack();
            }
            
            pushStack(arr[i]);
        } 
        
        System.out.println("\n(element : greater number) pair : ");
        for (int i=0; i<size; i++){
            System.out.println(arr[i] + "  :  " +valueMap.get(arr[i]));
        }
    }
    
    
    public static void pushStack(int value){
        top++;
        if (top < size) 
            stack[top] = value;
        else
            System.out.println("stack is full");
    }
    
    public static void popStack(){
        if(top >= 0)
            top--;
        else
            System.out.println("stack is empty");
    }
}
