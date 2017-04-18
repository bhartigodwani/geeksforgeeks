/*
Implement two stacks in an array
Create a data structure twoStacks that represents two stacks. Implementation of twoStacks should use only one array, i.e., both stacks should use the same array for storing elements. Following functions must be supported by twoStacks.

push1(int x) –> pushes x to first stack
push2(int x) –> pushes x to second stack

pop1() –> pops an element from first stack and return the popped element
pop2() –> pops an element from second stack and return the popped element

Implementation of twoStack should be space efficient.
*/

import java.util.Scanner;
class Stack{
    static int top1 = -1, top2;
    static int twoStackArray[] ;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter 2stack array size:");
        int size = sc.nextInt();
        twoStackArray = new int[size]; 
        top2 = size;
        pushInStack1(1); // push in stack 1
        pushInStack1(2);
        pushInStack1(3);
        pushInStack1(4);
        
        pushInStack2(1); // push in stack 2
        pushInStack2(2);
        pushInStack2(3);
        pushInStack2(4);
        
        popStack1(); // pop in stack1
        popStack2(); // pop in stack2
        
        System.out.println("stack 1 after all the operation :");
        for(int i=top1; i>=0; i--){
            System.out.println(twoStackArray[i]+ "  ");
        }
        
        
        System.out.println("\nstack 2 after all the operation :");
        for(int i=top2; i<size; i++){
            System.out.println(twoStackArray[i]+ "  ");
        }
        
    }
    
    public static void pushInStack1(int value){
        top1++;
        twoStackArray[top1] = value;
    }
    
    public static void pushInStack2(int value){
        top2--;
        twoStackArray[top2] = value;
    }
    
    public static void popStack1(){
        top1--;
    }
    
    public static void popStack2(){
        top2++;
    }
}
