/* package whatever; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static final int Max = 1000;//max size of stack
	static int stack[] = new int[Max];//stack declaration
	static int top = -1;
 
	public static void main (String[] args) throws java.lang.Exception
	{
		if(!popS()) // if stack is empty
			System.out.println("stack empty");
		pushS(10);
		pushS(20);
		pushS(30);
    
		for(int i=top; i>=0; i--) 
			System.out.println(stack[i]); // stack after all operation
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
}
