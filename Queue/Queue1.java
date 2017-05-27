import java.util.Arrays;
class Queue1{
    static int front = -1, rare = -1;
    static int queue[];
    public static void main (String[] args) {
        int size = 10;
        queue = new int[size];
        enque(1);
        enque(2);
        deque();
        enque(3);
        deque();
        enque(4);
        enque(5);
        enque(6);
        enque(7);
        enque(8);
        enque(9);
        enque(10);
        enque(11);
        enque(12);
        enque(13);
        enque(14);
        enque(15);
        
        System.out.print("queue : ");
        for (int i=front; i<=rare; i++)
            System.out.print(queue[i]+"  ");
        
    }
    
    static void enque(int value){
        
        if(front == -1)//i.e queue is empty
            front++;
            
        if (rare < queue.length-1){
            rare++;
            queue[rare] = value;
            System.out.println("enque = "+value);
        }
        else{
            System.out.println("queue is full = "+value);
            return;
        }
    }
    
    static void deque(){
        if(front > -1 && front < queue.length){
            System.out.println("deque = "+queue[front]);
            front++;
        }
        else
            System.out.println("queue is empty");
    }
}
