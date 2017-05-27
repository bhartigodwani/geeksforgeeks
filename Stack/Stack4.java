/*
Check for balanced parentheses in an expression
Given an expression string exp , write a program to examine whether the pairs and the orders of 
“{“,”}”,”(“,”)”,”[“,”]” are correct in exp. For example, the program should print true for exp = “[()]{}{[()()]()}” 
and false for exp = “[(])”
*/

/*two approaches*/

/*----------------------------------------first approach---------------------------------*/
import java.util.Scanner;
class Stack{
    static int top = -1, maxSize;
    static char stack[];
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the expression :");
        String str = sc.next();
        char ch[] = str.toCharArray();
        stack = new char[ch.length];
        boolean flag = true;
        for (int i=0; i<ch.length; i++){
        
            if (ch[i] == '{' || ch[i] == '(' || ch[i] == '[')
                pushInStack(ch[i]);
        
            if (ch[i] == '}' || ch[i] == ')' || ch[i] == ']'){
                flag = checkBalance(ch[i]);
            }
                
            if(flag == false){
                System.out.println("unbalanced");
                break;
            }
        } 
        
        if(flag == true)
            System.out.println("balanced");
    }
    
    public static void pushInStack(char symbol){
        top++;
        stack[top] = symbol;
    }
    
    public static boolean checkBalance(char symbol){
        
        if (top >= 0){ 
            if((symbol == ')' && stack[top] == '(') || (symbol == '}' && stack[top] == '{') || (symbol == ']' && stack[top] == '[')){
                popStack();
                return true;
            }
        }
        
        else{
            return false;
        }
    return false;
    }
    
    public static boolean popStack(){
        if(top < 0){
            return false;
        }
        else{
            top--;    
            return true;
        }
    }
}

/*----------------------------------------second approach---------------------------------*/
import java.util.Stack;
class Stack4{
    public static void main (String[] args) {
        Stack<Character> stack = new Stack<Character>();
        String expression = "({[]})";
        int flag = 0;//expression is considered to balanced initially as no check is applied till now
        for (int i=0; i<expression.length(); i++){
            if (expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '[')
                stack.push(expression.charAt(i));
            
            else if(!stack.isEmpty() && expression.charAt(i) == ')' && stack.peek().equals('('))
                stack.pop();
            
            else if(!stack.isEmpty() && expression.charAt(i) == '}' && stack.peek().equals('{'))
                stack.pop();
            
            else if(!stack.isEmpty() && expression.charAt(i) == ']' && stack.peek().equals('['))
                stack.pop();
                
            else if(stack.isEmpty() && (expression.charAt(i) == ')' || expression.charAt(i) == '}' || expression.charAt(i) == ']')){
                System.out.println("unbalanced expression");
                flag = 1;
                break;
            }
        }
        if(flag == 0 && !stack.isEmpty())
            System.out.println("unbalanced expression");
        if(flag == 0 && stack.isEmpty())
            System.out.println("balanced expression");
    }
}
