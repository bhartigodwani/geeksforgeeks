/*
Remove characters from the first string which are present in the second string
Write an efficient C function that takes two strings as arguments and removes the characters from first string which are 
present in second string (mask string).
*/
import java.util.HashSet;

class String7{
    public static void main(String []args){
        String s1[] = {"ABCD","ABCD","AACD","cbhdchbhbdcjd","1234"};
        String s2[] = {"Ad", "Bd","Dd","dcj","12345"};
        for(int i=0; i<s1.length; i++){
            System.out.println("String 1 = "+s1[i]+" String 2 = "+s2[i]);
            String newString = convertString(s1[i], s2[i]);
            System.out.println("new String is = "+newString);
        }
    }
    
    static String convertString(String s1, String s2){
        HashSet<Character> set = new HashSet<Character>();
        int i = 0;
        String newString = "";
        while(i < s2.length()){
            set.add(s2.charAt(i));
            i++;
        }
        i = 0;
        while(i < s1.length()){
            if(!set.contains(s1.charAt(i))){
                newString += s1.charAt(i);
            }
            i++;
        }
        return newString;
    }

}
