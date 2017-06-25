/*
Print list items containing all characters of a given word
There is a list of items. Given a specific word, e.g., “sun”, print out all the items in list which contain all the characters 
of “sun”.
For example if the given word is “sun” and the items are “sunday”, “geeksforgeeks”, “utensils”, “”just” and “sss”, then the 
program should print “sunday” and “utensils”.
*/

import java.util.*;
class String13{
    public static void main(String []args){
        String substr = "ssun";
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> map;
        int i, numberOfStrings=6;
        for(int num=0; num<numberOfStrings; num++){
            String st = sc.next();
            map = new HashMap<Character, Integer>();
            for(i=0; i<st.length(); i++)
                map.put(st.charAt(i), (map.containsKey(st.charAt(i)) ? map.get(st.charAt(i))+1 : 1));
            for(i=0; i<substr.length(); i++){
                if(!map.containsKey(substr.charAt(i))){
                    break;
                }
                else if(map.get(substr.charAt(i)) > 0){
                    map.put(substr.charAt(i), (map.get(substr.charAt(i))-1));   
                }
                else{
                    break;
                }
            }
            if(i == substr.length())
                System.out.println(st);
        }
    }
}
