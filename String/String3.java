/*
Determine if a string has all Unique Characters
Given a string, Determine if the string has all unique characters.
Examples:
Input : abcd10jk
Output : true
Input : hutg9mnd!nk9
Output : false
*/
import java.util.HashMap;
class String2{
    public static void main (String[] args) {
        String str = "Geeks for Geeks";
        str = "Hello Geeks";
        str = "Geeks Quiz";
        str = "abcd10jk";
        str = "hutg9mnd!nk9";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i) != ' '){
                int value = (map.get(str.charAt(i)) == null)? 1 : (map.get(str.charAt(i)) + 1);
                map.put(str.charAt(i), value);
            } 
        } 
        
        int flag = 0;
        for (int i=0; i<str.length(); i++){
            if(!map.get(str.charAt(i)).equals(1)){
                flag = 1;
                break;
            }
        } 
        
        System.out.println((flag == 0)? "true" : "false");//true if string is unique else false
       
    }
}
