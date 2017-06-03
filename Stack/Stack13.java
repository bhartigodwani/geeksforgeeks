/*
How to efficiently implement k stacks in a single array?

We have discussed space efficient implementation of 2 stacks in a single array. In this post, a general solution for k stacks
is discussed. Following is the detailed problem statement.

Create a data structure kStacks that represents k stacks. Implementation of kStacks should use only one array, i.e., k stacks
should use the same array for storing elements. Following functions must be supported by kStacks.

push(int x, int sn) –> pushes x to stack number ‘sn’ where sn is from 0 to k-1
pop(int sn) –> pops an element from stack number ‘sn’ where sn is from 0 to k-1

Method 1 (Divide the array in slots of size n/k)
A simple way to implement k stacks is to divide the array in k slots of size n/k each, and fix the slots for different stacks,
i.e., use arr[0] to arr[n/k-1] for first stack, and arr[n/k] to arr[2n/k-1] for stack2 where arr[] is the array to be used to
implement two stacks and size of array be n.

The problem with this method is inefficient use of array space. A stack push operation may result in stack overflow even if
there is space available in arr[]. For example, say the k is 2 and array size (n) is 6 and we push 3 elements to first and 
do not push anything to second second stack. When we push 4th element to first, there will be overflow even if we have space
for 3 more elements in array.
*/
import java.util.Arrays;
class Solution{
    public static void main (String[] args) {
        int size = 30;
        int k = 5;
        int arr[] = new int[size];
        for(int i=0; i<arr.length; i++)
            arr[i] = -1;
        
        pushStack(arr, 1, 3, k);
        pushStack(arr, 2, 3, k); // pushStack(arr, element to be pushed, stack number in which to be pushed, k)        
        pushStack(arr, 3, 3, k);
        pushStack(arr, 4, 3, k);
        pushStack(arr, 5, 3, k);
        pushStack(arr, 6, 3, k);
        pushStack(arr, 7, 3, k);
        pushStack(arr, 8, 3, k);
        popStack(arr, 3, k);//popStack(arr, stackno to be popped, k=number of stacks);
        popStack(arr, 2, k);
        pushStack(arr, 8, 1, k);
        pushStack(arr, 8, 6, k);
        pushStack(arr, 2, 6, k);
        popStack(arr, 6, k);
        System.out.println("stack is "+Arrays.toString(arr));
    }
    
    static void pushStack(int arr[], int element, int stackNo, int k){
        int rangeLeft = k * (stackNo - 1);
        int rangeRight = rangeLeft + k;
        while(arr[rangeLeft] != -1 && rangeLeft <= rangeRight)
               rangeLeft++;
        if(rangeLeft <= rangeRight)
            arr[rangeLeft] = element;
        else
            System.out.println("stack "+ stackNo +" is full");
        
    }
    
    static void popStack(int arr[], int stackNo, int k){
        int rangeLeft = k * (stackNo - 1);
        int rangeRight = rangeLeft + k;
        int tempLeft = rangeLeft;
        while(arr[tempLeft] != -1 && tempLeft <= rangeRight)
               tempLeft++;
        
        if(tempLeft == rangeLeft)
                System.out.println("stack "+stackNo+" is empty");
        else{
            tempLeft--;
            arr[tempLeft] = -1;
         }
      }   
}
