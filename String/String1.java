/*
Program to find Smallest and Largest Word in a String
Given a string, find the minimum and the maximum length words in it.
Examples:
Input : "This is a test string"
Output : Minimum length word: is
         Maximum length word: string
Input : "GeeksforGeeks A computer Science portal for Geeks"
Output : Minimum length word: A
         Maximum length word: GeeksforGeeks
         
Solution :
break the string into array of string separated by space(" ") and then calculate their length.
find string with max and min length.
*/

import java.util.Arrays;
class String1{
    public static void main (String[] args) {
        String st = "GeeksforGeeks A computer Science portal for Geeks";
        String ch[] = st.split(" ");
        int length[] = new int[ch.length];
        for (int i=0; i<ch.length; i++)
            length[i] = ch[i].length();
        
        int max = length[0];
        int min = length[0];
        
        String maxStr=ch[0] , minStr=ch[0];
        for (int i=1; i<length.length; i++){
            if (max < length[i]){
                max = length[i];
                maxStr = ch[i];
            }
            
            if(min > length[i]){
                min = length[i];
                minStr = ch[i];
            }
        }
            
        System.out.println("maxStr = "+maxStr);
        System.out.println("minStr = "+minStr);
            
    }
}
