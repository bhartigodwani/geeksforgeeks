/*
Iterative Tower of Hanoi
Tower of Hanoi is a mathematical puzzle. It consists of three poles and a number of disks of different sizes which can slide 
onto any poles. The puzzle starts with the disk in a neat stack in ascending order of size in one pole, the smallest at the 
top thus making a conical shape. The objective of the puzzle is to move all the disks from one pole (say ‘source pole’) to 
another pole (say ‘destination pole’) with the help of third pole (say auxiliary pole).

Steps:
Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective of the puzzle is to move the 
entire stack to another rod, obeying the following simple rules:
1) Only one disk can be moved at a time.
2) Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk 
can only be moved if it is the uppermost disk on a stack.
3) No disk may be placed on top of a smaller disk.

The puzzle has the following two rules:

      1. You can’t place a larger disk onto smaller disk
      2. Only one disk can be moved at a time

We’ve already discussed recursive solution for Tower of Hanoi. We have also seen that, for n disks, total 2n – 1 moves are 
required.

Iterative Algorithm:

1. Calculate the total number of moves required i.e. "pow(2, n)
   - 1" here n is number of disks.
2. If number of disks (i.e. n) is even then interchange destination 
   pole and auxiliary pole.
3. for i = 1 to total number of moves:
     if i%3 == 1:
	legal movement of top disk between source pole and 
        destination pole
     if i%3 == 2:
	legal movement top disk between source pole and 
        auxiliary pole	
     if i%3 == 0:
        legal movement top disk between auxiliary pole 
        and destination pole  
*/
class Stack14{
    public static void main (String[] args) {
        int n = 4;//number of disks;
        char fromrod = 'A';
        char auxrod = 'B';
        char torod = 'C';
        
        System.out.println("recursive approach")
        towerOfHanoi(n, fromrod, torod, auxrod);
        
    }    
    
    static void towerOfHanoi(int n, char fromrod, char torod, char auxrod){
        if(n == 1){
            System.out.println("\nMove disk 1 from "+fromrod+" to "+torod);
            return;
        }
        towerOfHanoi(n-1, fromrod, auxrod, torod);
        System.out.println("\nMove disk 1 from "+fromrod+" to "+torod);
        towerOfHanoi(n-1, auxrod, torod, fromrod);
    }
}
