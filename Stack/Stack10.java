/*
Implement Stack using Queues
The problem is opposite of this post. We are given a Queue data structure that supports standard operations like enqueue() 
and dequeue(). We need to implement a Stack data structure using only instances of Queue and queue operations allowed on the
instances.

Method 1 (By making push operation costly)
This method makes sure that newly entered element is always at the front of ‘q1’, so that pop operation just dequeues from
‘q1’. ‘q2’ is used to put every new element at front of ‘q1’.

Method 2 (By making pop operation costly)
In push operation, the new element is always enqueued to q1. In pop() operation, if q2 is empty then all the elements except
the last, are moved to q2. Finally the last element is dequeued from q1 and returned.
*/

import java.util.LinkedList;
import java.util.Queue;
class Stack10{
    static Queue<Integer> que1 = new LinkedList<Integer>();
    static Queue<Integer> que2 = new LinkedList<Integer>();
    public static void main (String[] args) {
        Stack10 st = new Stack10();
        st.popStack();
        st.pushStack(1);
        st.pushStack(2);    
        st.pushStack(3);
        st.popStack();
        
        /*st.que1.add(4);
        st.que1.add(5);*/
        System.out.println("\ncurrent stack :");
        if(!que1.isEmpty()){
            for(Integer item : que1){
                System.out.println(item.toString());
            }
        }
        
        if(!que2.isEmpty()){
            for(Integer item : que2){
                System.out.println(item.toString());
            }
        }
    }
    
    Queue pushStack(Integer element){
        if (que1.isEmpty()){
            que1.add(element);
            System.out.println("pushed element = "+que1.peek());
            while(!que2.isEmpty()){
                que1.add(que2.poll());
            }
            return que1;
        }
        else if (que2.isEmpty()){
            que2.add(element);
            System.out.println("pushed element = "+que2.peek());
            while(!que1.isEmpty()){
                que2.add(que1.poll());
            }
            return que2;
        }
        return null;
    }
    
    void popStack(){
        if(!que1.isEmpty()){
            System.out.println("popped element = "+que1.poll());
        }
        else if(!que2.isEmpty()){
            System.out.println("popped element = "+que2.poll());
        }
        else{
            System.out.println("stack is empty");
        }
    }
}
