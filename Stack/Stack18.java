/*
@author Bharti Godwani

Minimum number of bracket reversals needed to make an expression balanced
Given an expression with only ‘}’ and ‘{‘. The expression may not be balanced. Find minimum number of bracket reversals to 
make the expression balanced.

Examples:

Input:  exp = "}{"
Output: 2
We need to change '}' to '{' and '{' to
'}' so that the expression becomes balanced, 
the balanced expression is '{}'

Input:  exp = "{{{"
Output: Can't be made balanced using reversals

Input:  exp = "{{{{"
Output: 2 

Input:  exp = "{{{{}}"
Output: 1 

Input:  exp = "}{{}}{{{"
Output: 3
*/

import java.util.Stack;
class Stack18{
    public static void main(String []args){
        String str = "{{{";
        System.out.println("String = "+str);
        int rev = (int)numberOfReversal(str);
        if(rev == -1)
            System.out.println("Can't be made balanced using reversals");    
        else    
            System.out.println("number of reversal required = "+rev);
    }
    
    static double numberOfReversal(String str){
        int c1=0, c2=0;
        if(str == null)
            return c1;
        
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '{'){
                stack.push('{');
            }
            else if(str.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{')
                stack.pop();
            else if(str.charAt(i) == '}'){
                stack.push('}');
                c2++;
            }
        }
        while(!stack.isEmpty()){
            if(stack.pop() == '{')
                c1++;
        }
        if((c1+c2) % 2 == 1){
            return -1;
        }
        double c = Math.ceil(c1/2.0) + Math.ceil(c2/2.0);
        return c;
    }
}
