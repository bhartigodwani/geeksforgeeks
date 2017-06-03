/*
Length of the longest valid substring
Given a string consisting of opening and closing parenthesis, find length of the longest valid parenthesis substring.

Examples:

Input : ((()
Output : 2
Explanation : ()

Input: )()())
Output : 4
Explanation: ()() 

Input:  ()(()))))
Output: 6
Explanation:  ()(()))

*/
import java.util.Stack;
class Stack15{
    public static void main (String[] args) {
        String testStringArray[] = {"((()", ")()())", "()(()))))"};
        for(int j=0; j<testStringArray.length; j++){
            String str = testStringArray[j];
            System.out.println("String = "+str);
            Stack<Character> st = new Stack<Character>();
            int count = 0;
            
            for(int i=0; i<str.length(); i++){
                if(st.isEmpty() && str.charAt(i) == '(' ){
                    st.push(str.charAt(i));
                }
                else if(str.charAt(i) == '(')
                    st.push(str.charAt(i));
                   
                if(!st.isEmpty() && st.peek().equals('(') && str.charAt(i) == ')'){
                    st.pop();
                    count += 2;
                }
            }
            System.out.println("count = "+count+"\n");
        }
    }
}
