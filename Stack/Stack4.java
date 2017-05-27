/*
Check for balanced parentheses in an expression
Given an expression string exp , write a program to examine whether the pairs and the orders of 
“{“,”}”,”(“,”)”,”[“,”]” are correct in exp. For example, the program should print true for exp = “[()]{}{[()()]()}” 
and false for exp = “[(])”
*/

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
