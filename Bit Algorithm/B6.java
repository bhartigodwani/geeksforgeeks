/*
@author Bharti Godwani
Smallest of three integers without comparison operators
Write a C program to find the smallest of three integers, without using any of the comparison operators.
Let 3 input numbers be x, y and z.
Method 1 (Repeated Subtraction)
Take a counter variable c and initialize it with 0. In a loop, repeatedly subtract x, y and z by 1 and increment c. The number 
which becomes 0 first is the smallest. After the loop terminates, c will hold the minimum of 3.
*/
class Bits{
    public static void main(String []args){
        int x = 10, y = 15, z = 5;
        int result = minMethod1(x, minMethod1(x,y));        
        System.out.println("sum = "+result);
        
    }
    
    static int minMethod1(int x, int y){
        return ((float)(x + y) / 2.0) - (Math.abs((float)(x - y) / 2));
    }
    
    static int minMethod2(int a, int b, int c){
        int count = 0;
        while((a & b & c) != 0){
            a--;
            b--;
            c--;
            count++;
        }
        return count;
    }
}
