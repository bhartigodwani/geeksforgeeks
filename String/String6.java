/*
A Program to check if strings are rotations of each other or not
Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1 using only one call to strstr 
routine?
(eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)
*/

import java.util.Stack;
class Solution{
    public static void main(String []args){
        String s1[] = {"ABCD","ABCD","AACD"};
        String s2[] = {"CDAB", "ACBD","ACDA"};
        for(int i=0; i<s1.length; i++){
            boolean result = areRotations(s1[i], s2[i]);
            System.out.println("String 1 = "+s1[i]+" String 2 = "+s2[i]);
            System.out.println((result == true) ? "both are rotated" : "not rotated");
        }
    }
    
    static boolean areRotations(String s1, String s2){
        Stack<Character> stack = new Stack<Character>();
        
        char temp = s2.charAt(s2.length()-1);
        int i = 0;
        while(s1.charAt(i) != temp){
            stack.push(s1.charAt(i));
            i++;
        }
        stack.push(s1.charAt(i));
        i++;
        int flag = 0;
        int j = s2.length()-1;
        while(!stack.empty()){
            if(!stack.pop().equals(s2.charAt(j))){
                flag = 1;
                break;
            }
            j--;
        }
        int k;
        if(flag == 1)
                return false;
        else{
            for(k=i; k<s1.length(); k++)
                stack.push(s1.charAt(k));
            while(!stack.empty()){
                if(!stack.pop().equals(s2.charAt(j))){
                    flag = 1;
                    break;
                }
                j--;
            }
            if(flag == 1)
                return false;
            else
                return true;
        }
        
    }

}
