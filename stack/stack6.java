/*Reverse a stack using recursion:
You are not allowed to use loop constructs like while, for..etc, and you can only use the following ADT functions on Stack S:
isEmpty(S)
push(S)
pop(S)

Solution:
The idea of the solution is to hold all values in Function Call Stack until the stack becomes empty. 
When the stack becomes empty, insert all held items one by one at the bottom of the stack.*/

import java.util.Scanner;

class Stack{
    static int stack[] ;
    static int top = -1;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter stack size:");
        int size = sc.nextInt();
        int i ;
        stack = new int[size];
        System.out.println("enter the stack:");
        for (i=0; i<size; i++)
            stack[i] = sc.nextInt();
        
        top = i-1;
        revereseStack(stack);
        
        System.out.println("revereseStack is:");
        for (i=top; i>= 0; i--){
            System.out.println(stack[i]);
        } 
    }
    
    static public void revereseStack(int []stack){
       if (top >= 0){
           int temp = popStack();//stores popped element in function call stack
           revereseStack(stack);
           insertReverseStack(temp);//insert into stack after every element is popped
        }
    }
    
    static public int popStack(){
        
        if(top >= 0){
            int topElement = stack[top];
            top--;
            return topElement;
        }
        
        else{
            System.out.println("stack is empty");
            return '#';
        }
        
    }
    
    static public void insertReverseStack(int value){
        top++;
        stack[top] = value;
    }
}
