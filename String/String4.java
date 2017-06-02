/*
Toggle case of a string using Bitwise operators

Given a string, write a function that returns toggle case of a string using the bitwise operators in place.
In ASCII codes character ‘A’ is integer 65 = (0100 0001)2, while character ‘a’ is integer 97 = (0110 0001)2.
The difference between the ASCII values of ‘a’ and ‘A’ is 32.
So we can easily change the case of the letters either from Upper to lower or lower to upper by adding or subtracting the 
difference from the letters.

Examples:

Input : "GeekSfOrgEEKs"
Output : "gEEKsFoRGeekS"                  

Input : "StRinG"
Output : "sTrINg"
*/
class String4{
    public static void main(String[] args){
        String str = "geeKsforGeekS";
        System.out.println("string = "+str);
        
        /*--------------------------case 1---------------------------------*/
        System.out.println("case 1");
        String strMain = "";
        for (int i=0; i<str.length(); i++){
            int temp; 
            if((int)str.charAt(i) >= 97 && (int)str.charAt(i) <= 123){
                strMain = strMain + (char)(str.charAt(i)-32);
            }
            else{
                strMain = strMain + (char)(str.charAt(i)+32);
            }
        }
        System.out.println("toggled string = "+strMain);
        
        
    }
} 
