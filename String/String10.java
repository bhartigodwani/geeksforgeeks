/*
An in-place algorithm for String Transformation
Given a string, move all even positioned elements to end of string. While moving elements, keep the relative order of all even
positioned and odd positioned elements same. For example, if the given string is “a1b2c3d4e5f6g7h8i9j1k2l3m4”, convert it to 
“abcdefghijklm1234567891234” in-place and in O(n) time complexity.
*/

import java.util.HashSet;

class Strin10{
    public static void main(String []args){
        String s[] = {"a1b2c3d4e5f6g7h8i9j1k2l3m4", "geeksforgeeks", "bharti4", "yeeeeee"};
        for(int i=0; i<s.length; i++){
            int chCount[] = new int[26];
            String str = s[i];
            System.out.println("String = "+str);
            String s1 = "";
            String s2 = "";
            /*make 2 strings, one for even placed characters and other for odd placed characters*/
            for(int j=0; j<str.length(); j++){
                if(j % 2 == 1)
                    s1 += str.charAt(j);
                else
                    s2 += str.charAt(j);
            }
            String newString = s2 + s1;
            System.out.println("newString = "+newString+"\n");
         }
    }
}
