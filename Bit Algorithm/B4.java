/*
Swap bits in a given number
Given a number x and two positions (from right side) in binary representation of x, write a function that swaps n bits at
given two positions and returns the result. It is also given that the two sets of bits do not overlap.
*/
class Bits{
    public static void main(String []args){
        int num = 28;
        System.out.println("original number = "+num);
        int p1=0, p2=3, n=2;
        int r, l;
        for(int i=0; i<n; i++){
            r = (num >> (p1+i))&1;    
            l = (num >> (p2+i))&1;

            /* XOR the two bits */
             int x = (l ^ r);

            /* Put the xor bit back to their original positions */
            x = (x << (p1+i)) | (x << (p2+i));

            /* XOR 'x' with the original number so that the
               two sets are swapped */
            num = num ^ x;
        }
        
        System.out.println("number after swapping of bits = "+num);
    }
}
