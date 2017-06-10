/*
Implementation of Deque using doubly linked list
*/
class Queue1{
    static Node front = null;
    static Node rare = null;
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int d){
            data = d;
            next = null;
            prev = null;
        }
    }
    public static void main (String[] args) {
        isEmpty();
        enqueFront(1);
        enqueRare(2);
        enqueFront(3);
        enqueRare(4);
        dequeFront();
        dequeRare();
        getFront();
        getRare();
        isEmpty();
        System.out.println("queue is :");
        printQueue();
        
    }
    
    static void enqueFront(int value){
        Node node = new Node(value);
        if(front == null && rare == null){
            front = node;
            rare = node;
        }     
        else{
            node.next = front;
            front.prev = node;
            front = node;
        }
        System.out.println("enque at front element is : "+front.data);
    }
    
    static void enqueRare(int value){
        Node node = new Node(value);
        if(front == null && rare == null){
            front = node;
            rare = node;
        }    
        else{
            rare.next = node;
            node.prev = rare;
            rare = node;
        }
        System.out.println("enque at rare element is : "+rare.data);
    }
    
    static void dequeFront(){
         if(front == null && rare == null){
             System.out.println("queu is empty");
         }   
        else{
            System.out.println("deque at front element is : "+front.data);
            front = front.next;
            front.prev = null;
        }
    }
    
    static void dequeRare(){
         if(front == null && rare == null){
             System.out.println("queu is empty");
         }   
        else{
            System.out.println("deque at rare element is : "+rare.data);
            rare = rare.prev;
            rare.next = null;
        }
    }
    
    static int getFront(){
        if(front != null){
            System.out.println("front : "+front.data);
            return front.data;
        }
        System.out.println("queue is empty");
        return -1;
    }
    
    static int getRare(){
        if(rare != null){
            System.out.println("rare : "+rare.data);
            return rare.data;
        }
        System.out.println("queue is empty");
        return -1;
    } 
    
    static boolean isEmpty(){
        if(front == null){
            System.out.println("queue is empty");
            return true;
        }
        return false;
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
