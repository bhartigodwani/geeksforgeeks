/*
@author Bharti Godwani

Implement a stack using single queue

We are given queue data structure, the task is to implement stack using only given queue data structure.
We have discussed a solution that uses two queues. In this article, a new solution is discussed that uses only one queue. 
This solution assumes that we can find size of queue at any point. The idea is to keep newly inserted element always at 
front, keeping order of previous elements same. Below are complete steps.

// x is the element to be pushed and s is stack
push(s, x) 
  1) Let size of q be s. 
  1) Enqueue x to q
  2) One by one Dequeue s items from queue and enqueue them.
  
// Removes an item from stack
pop(s)
  1) Dequeue an item from q
*/
import java.util.Queue;
import java.util.LinkedList;
class Stack27{
    static Queue<Integer> que = new LinkedList<Integer>();
    public static void main(String []args){
        int num = 12;
        popStack();
        for(int i=1; i<=num; i+=2){
            pushStack(i);
            pushStack(i+1);
            if(i%3 == 0)
                popStack();
        }    
        System.out.println("Stack = ");
        for(Object item : que){
            System.out.println(item.toString());
        }
    }
    
    static void pushStack(int value){
        que.add(value);
        System.out.println("enque = "+value);
        while(que.peek() != value)
            que.add(que.poll());
    }
    
    static void popStack(){
        if(que.isEmpty()){
            System.out.println("stack is empty");
            return;
        }
        System.out.println("deque = "+que.poll());
    }
}
