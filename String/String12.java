/*
Given a string, find its first non-repeating character
Given a string, find the first non-repeating character in it. For example, if the input string is “GeeksforGeeks”, then 
output should be ‘f’ and if input string is “GeeksQuiz”, then output should be ‘G’.
*/

import java.util.Arrays;
class String12{
    public static void main(String []args){
        //String str = "zAAa";
        String str = "GeeksforGeeks";
        //String str =  "GeeksQuiz";
        int countArray[] = new int[52];//0-25 (a-z) & 26-51 (A-Z)
        int indexArray[] = new int[52];
        int i = 'A'+0;
        for(i=0; i<52; i++)
            indexArray[i] = -1;
        System.out.println("string = "+str);
        /*-----------------calculating count and index array------------*/
        for(i=0; i<str.length(); i++){
            if(str.charAt(i)>='a' && str.charAt(i)<='z'){
                countArray[((str.charAt(i)+0)-97)]++;
                if(indexArray[((str.charAt(i)+0)-97)] == -1)
                    indexArray[((str.charAt(i)+0)-97)] = i; 
            }
            else if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
                countArray[((str.charAt(i)+0)-39)]++;
                if(indexArray[((str.charAt(i)+0)-39)] == -1)
                    indexArray[((str.charAt(i)+0)-39)] = i; 
            }
        }
        
        /*-------------finding index of first non repeating character-----------*/
        int firstIndex = Integer.MAX_VALUE;
        for(i=0; i<52; i++){
            if(countArray[i] == 1 && firstIndex > indexArray[i]){
                firstIndex = indexArray[i];
            }
        }
        if(firstIndex == Integer.MAX_VALUE)
            System.out.println("no non repeating char exist");
        else
            System.out.println("first non repeating = "+(str.charAt(firstIndex)));
    }
}
