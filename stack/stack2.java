/*reverse string using stack*/
import java.util.Scanner;
class ReverseStack{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string to reversed");
        String str = sc.next();
        char []ch = str.toCharArray();
        Stack stack = new Stack();

        System.out.println("original String:");
        for (int i = 0; i<ch.length; i++){
            System.out.print(ch[i]+"  ");
        }

        //pushing each character in stack
        for (int i = 0; i<ch.length; i++){
            stack.pushS(ch[i]);
        } 
        
        //pop each element from the Stack and print
        System.out.println("\nreversed Stack:");
        for (int i=0; i<ch.length; i++){
            System.out.print(stack.peekOrTop()+"  ");
            stack.popS();
        } 
    }
    
}

class Stack
{
    static final int Max = 1000;//max size of stack
    static char stack[] = new char[Max];//stack declaration
    static int top = -1;
    
    Stack(){
        
    }
 
	public static void pushS(char value){
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
	
	public static char peekOrTop(){
		return stack[top];
	}
	
	public static boolean isEmpty(){
	    if(top < 0)
	        return true;
	   return false;
	}
} 
