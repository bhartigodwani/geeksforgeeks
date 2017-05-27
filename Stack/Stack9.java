/*
Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and 
an additional operation getMin() which should return minimum element from the SpecialStack. All these operations of 
SpecialStack must be O(1). To implement SpecialStack, you should only use standard Stack data structure and no other data 
structure like arrays, list, .. etc.

Example:
Consider the following SpecialStack
16  --> TOP
15
29
19
18
When getMin() is called it should return 15, which is the minimum element in the current stack. 

If we do pop two times on stack, the stack becomes
29  --> TOP
19
18

When getMin() is called, it should return 18 which is the minimum in the current stack.
*/
import java.util.Stack;
class Stack9{
    public static void main (String[] args) {
        Stack<Integer> mainStack = new Stack<Integer>();
        Stack<Integer> minStack = new Stack<Integer>();
        
        int elements[] = {18,19,29,15,16};
        for (int i=0; i<elements.length; i++)  {
            mainStack.push(elements[i]);
            if(minStack.isEmpty() || (int)minStack.peek() > elements[i])
                minStack.push(elements[i]);
        } 
        
        System.out.println("given stack is : ="+mainStack);
        System.out.println("min element so far = "+getMin(minStack));
        System.out.println("popped element is : "+pop(mainStack, minStack));
        System.out.println("popped element is : "+pop(mainStack, minStack));
        System.out.println("current stack : "+mainStack);
        System.out.println("min element so far : "+getMin(minStack));

    }
    
    static int pop(Stack mainStack, Stack minStack){
        if (mainStack.peek() == minStack.peek())
            minStack.pop();
        return (int)mainStack.pop();
    }
    static int getMin(Stack minStack){
        return (int)(minStack.peek());
    }
    
}
