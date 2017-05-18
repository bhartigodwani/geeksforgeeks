/*
Given a stack, sort it using recursion. Use of any loop constructs like while, for..etc is not allowed. We can only use the following ADT functions on Stack S:
is_empty(S)  : Tests whether stack is empty or not.
push(S)	     : Adds new element to the stack.
pop(S)	     : Removes top element from the stack.
top(S)	     : Returns value of the top element. Note that this
               function does not remove element from the stack.
Example:
Input:  -3  <--- Top
        14 
        18 
        -5 
        30 
Output: 30  <--- Top
        18 
        14 
        -3 
        -5 
*/

/*
Algorithm
We can use below algorithm to sort stack elements:
sortStack(stack S)
	if stack is not empty:
		temp = pop(S);  
		sortStack(S); 
		sortedInsert(S, temp);
Below algorithm is to insert element is sorted order:
sortedInsert(Stack S, element)
	if stack is empty OR element > top element
		push(S, elem)
	else
		temp = pop(S)
		sortedInsert(S, element)
		push(S, temp)
*/
import java.io.*;

class Stack {
    public static int top = -1;
	public static void main (String[] args) {
		int stack[] = {30, -5, 18, 14, -3};//input stack
		top = stack.length-1;
		sortedStack(stack);
		System.out.println("sorted stack:");
		for (int i=top; i>=0; i--)
		    System.out.println(stack[i]);
	}
	
	static void sortedStack(int stack[]){
	    int temp;
	    if(top == -1)
	        return;
	    else{
	        //stack is empty
    	    temp = popS(stack);
    	    sortedStack(stack);//take every element in the recursion stack so as to decide later which element to insert in sorted order
    	    insertSortedStack(temp, stack);//it will make sure that the order of insertion of elements in the stack should be sorted 
	    }
	}
	
	static void insertSortedStack(int tempElement, int stack[]){
	    if(top == -1 || tempElement > stack[top]){//whether stack is empty or TOS contains a smaller value than the current value
	        pushS(tempElement, stack);
	    }
	        
	    else{
	        int temp2 = popS(stack);//will call recursion untill the current stack is not sorted
	        insertSortedStack(tempElement,stack);
	        pushS(temp2, stack);
	    }
	}
	
	static void pushS(int element, int []stack){
	    top++;
	    stack[top] = element;
	}
	
	static int popS(int []stack){//pops and delete the top element of the stack
	    int temp = stack[top];
	    top--;
	    return temp;
	}
}
