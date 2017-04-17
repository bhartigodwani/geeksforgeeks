/*Implementing Stack using Arrays*/ 
import java.util.*;
import java.lang.*;
import java.io.*;
 
class Stack
{
	static final int Max = 1000;//max size of stack
	static int stack[] = new int[Max];//stack declaration
	static int top = -1;
 
	public static void main (String[] args) throws java.lang.Exception
	{
	    System.out.println(isEmpty()?"stack is empty":"stack is not empty"); // check whether stack is empty
		if(!popS()) // if stack is empty
			System.out.println("stack empty");
		pushS(10);
		pushS(20);
		pushS(30);
    		
		System.out.println("stack after operations");
		System.out.println(isEmpty()?"stack is empty":"stack is not empty");
	
		for(int i=top; i>=0; i--) 
			System.out.println(stack[i]); // stack after all operation
		
		System.out.println("stack top element : "+peekOrTop());
 	}
 
	public static void pushS(int value){
		if(top >= Max){
			return;
		}
		else{
			top++;
			stack[top] = value;
		}
	}
 
	public static boolean popS(){
		if(top >= 0){
			top--;
			return true; //if pop is possible
		  }
		return false;// if stack is empty
	}
	
	public static int peekOrTop(){
		return stack[top];
	}
	
	public static boolean isEmpty(){
	    if(top < 0)
	        return true;
	   return false;
	}
} 
