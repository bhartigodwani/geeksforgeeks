/*
Detect if two integers have opposite signs
Given two signed integers, write a function that returns true if the signs of given integers are different, otherwise false. 
For example, the function should return true -1 and +100, and should return false for -100 and -200. The function should not 
use any of the arithmetic operators.
*/
import java.util.Arrays;
class Array{
    public static void main(String []args){
        int n1 = -3;
        int n2 = -33;
        n1 = ((n1^n2) >> 31 & 1);
        System.out.println((n1==0) ? "same signs" : "different signs");
    }
}
