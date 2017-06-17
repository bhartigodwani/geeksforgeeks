//@author Bharti Godwani
/*
Add two numbers without using arithmetic operators
Write a function Add() that returns sum of two integers. The function should not use any of the arithmetic operators (+, ++, –, -, .. etc).

Sum of two bits can be obtained by performing XOR (^) of the two bits. Carry bit can be obtained by performing AND (&) of two bits.
Above is simple Half Adder logic that can be used to add 2 single bits. We can extend this logic for integers. If x and y don’t have set bits at same position(s), then bitwise XOR (^) of x and y gives the sum of x and y. To incorporate common set bits also, bitwise AND (&) is used. Bitwise AND of x and y gives all carry bits. We calculate (x & y) << 1 and add it to x ^ y to get the required result.
*/
class Bits{
    public static void main(String []args){
        int x = 10, y = 15;
        int tx, ty;
        int sum = 0;
        int carry = 0;
        for(int i=0; i<32; i++){
            tx = x >> i;//right shift so that we can add the LSBs every time
            ty = y >> i;
            tx = tx & 1;//to get the LSB
            ty = ty & 1;   
            sum = ((tx ^ ty ^ carry)<<i) | sum;//sum is obtained by xoring tx, ty and carry;
            System.out.println("tx = "+tx+" ty = "+ty+" ca = "+carry+" sum = "+sum); 
            carry = tx&y | ty&carry | carry&tx; // carry = xy + yc + cx;
        }
        System.out.println("sum = "+sum);
    }
}
