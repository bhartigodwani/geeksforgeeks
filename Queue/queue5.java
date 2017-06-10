/*
Implement queue with the help of 2 stacks
*/
import java.util.Stack;
import java.util.Iterator;
class Queue{
    static Stack<Integer> s1 = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();
    
    public static void main (String[] args) {
        deque();
        enque(1);
        enque(2);
        enque(3);
        deque();
        enque(4);
        enque(5);
        deque();
        enque(6);
        enque(7);
        deque();
        deque();
        enque(8);
        enque(9);
        deque();
        enque(10);
        enque(11);
        
        System.out.println("queue is :");
        printQueue();
    }
    
    static void enque(int value){
        System.out.println("enque front "+value);
        if(s1.empty() && s2.empty())
            s1.push(value);
        else if(!s1.empty())
            s1.push(value);
        else
            s2.push(value);
    }
    
    static void deque(){
        if(s1.isEmpty() && s2.isEmpty())
            System.out.println("queue is empty");
        else if(!s1.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            System.out.println("dequeue element "+s2.pop());
            while(!s2.isEmpty())
                s1.push(s2.pop());
        }
        else{
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            System.out.println("dequeue element "+s1.pop());
            while(!s1.isEmpty())
                s2.push(s1.pop());
        }
    }
    
    static boolean isEmpty(){
        if(s1.isEmpty() && s2.isEmpty())
            return true;
        return false;
    }
    
    static void printQueue(){
        Iterator<Integer> it;
        if(!s1.isEmpty()){
            it = s1.iterator();
        }
        else{
            it = s2.iterator();
        }
        
        while(it.hasNext()){
            System.out.print(it.next()+"  ");
        }
    }
}
