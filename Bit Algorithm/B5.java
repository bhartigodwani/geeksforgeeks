/*
Detect if two integers have opposite signs
Given two signed integers, write a function that returns true if the signs of given integers 
are different, otherwise false. For example, the function should return true -1 and +100, 
and should return false for -100 and -200. 
The function should not use any of the arithmetic operators.
*/
class Solution{
    public static void main (String[] args) {
        int x=-100;
        int y=1;
        boolean result1 = ((x^y)<0);//Xor is negative if their signs are opposite 
        boolean result2 = (x < 0)? (y >= 0): (y < 0);
        int result3 = ((x ^ y) >> 31);
        //System.out.println(result3);
        
        if (result1 == true && result2 == true && result3 == -1) 
            System.out.println("signs are opposite");
        else
            System.out.println("signs are same");
    }
}
