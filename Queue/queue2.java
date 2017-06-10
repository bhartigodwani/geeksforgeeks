/*
Queue | Set 2 (Linked List Implementation)
*/
class Queue1{
    static Node front = null;
    static Node rare = null;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    public static void main (String[] args) {
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
        deque();
        enque(13);
        enque(14);
        enque(15);
        enque(3);
        enque(4);
        deque();
        System.out.println("queue is :");
        printQueue();
        
    }
    
    static void enque(int value){
        Node node = new Node(value);
        if(front == null && rare == null){
            front = node;
            rare = node;
        }    
        else{
            rare.next = node;
            rare = node;
        }
        System.out.println("enque element is : "+rare.data);
    }
    
    static void deque(){
         if(front == null && rare == null){
             System.out.println("queu is empty");
         }   
        else{
            System.out.println("deque element is : "+front.data);
            front = front.next;
        }
    }
    
    static void printQueue(){
        Node temp = front;
        while(temp != rare){
            System.out.print(temp.data+" | ");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
}
