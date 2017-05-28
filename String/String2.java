/*
Print all distinct characters of a string in order 
Given a string, find the all distinct (or non-repeating characters) in it. For example, if the 
input string is "Geeks for Geeks", then output should be "for" and if input string is "Geeks Quiz",
then output should be "GksQuiz".
The distinct characters should be printed in same order as they appear in input string.

Examples:
Input  : Geeks for Geeks
Output : for
Input  : Hello Geeks
Output : HoGks
*/
import java.util.HashMap;
class String2{
    public static void main (String[] args) {
        String str = "Geeks for Geeks";
        str = "Hello Geeks";
        str = "Geeks Quiz";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i) != ' '){
                int value = (map.get(str.charAt(i)) == null)? 1 : (map.get(str.charAt(i)) + 1);
                map.put(str.charAt(i), value);
            } 
        } 
        
        for (int i=0; i<str.length(); i++){
            if(str.charAt(i) != ' ' && map.get(str.charAt(i)).equals(1))
                System.out.print(str.charAt(i));
        } 
        
    }
}
