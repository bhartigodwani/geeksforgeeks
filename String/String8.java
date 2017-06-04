/*
Print all the duplicates in the input string
Write an efficient program to print all the duplicates and their counts in the input string

Algorithm: Let input string be “geeksforgeeks”
1: Construct character count array from the input string.
count[‘e’] = 4
count[‘g’] = 2
count[‘k’] = 2
……
2: Print all the indexes from the constructed array which have value greater than 0.
*/
import java.util.HashSet;

class String8{
    public static void main(String []args){
        String s[] = {"geeksforgeeks", "bhartiii", "yeeeee"};
        for(int i=0; i<s.length; i++){
            int chCount[] = new int[26];
            String str = s[i];
            System.out.println("String = "+str);
            for(int j=0; j<str.length(); j++){
                int k = (int)str.charAt(j) - 97;
                chCount[k]++;                                        
            }
            for(int k=0; k<26; k++){
                if(chCount[k] > 1){
                    char e = (char)(k+97);
                    System.out.println((char)(k+97)+" = "+chCount[k]);
                }
            }
                
         }
        
    }
 }
