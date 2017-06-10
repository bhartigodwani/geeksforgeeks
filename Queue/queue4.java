/*
Implementation of Deque using array
*/
class Queue{
    static int front=-1, rear=-1;
    static int MAX_SIZE = 10;
    static int queue[] = new int[MAX_SIZE];
    
    public static void main (String[] args) {
        isEmpty();
        enqueFront(1);
        enqueRear(2);
        enqueFront(3);
        enqueRear(4);
        enqueRear(5);
        enqueRear(6);
        enqueFront(1);
        dequeFront();
        dequeRear();
        
        getFront();
        getRear();
        isEmpty();
        System.out.println("queue is :");
        printQueue();
        
    }
    
    static void enqueFront(int value){
        System.out.println("enque front "+value);
        if(!isFull()){
            if(isEmpty()){
                front++;
                rear++;
                queue[front] = value;
                
            } 
            else if(front == 0){
                front = MAX_SIZE - 1;
                queue[front] = value;
            }    
            else{
                front--;
                queue[front] = value;
            }
        }
        else
            System.out.println("queue is full");
    }
    
    static void enqueRear(int value){
        System.out.println("enque Rear "+value);
        if(!isFull()){
            rear++;
            queue[rear] = value;
        }
        else
            System.out.println("queue is full");
    }
    
    static void dequeFront(){
        System.out.println("dequeue front");
        if(!isEmpty()){
            if(front == MAX_SIZE-1){
                queue[front] = -1;
                front = 0;
            }
            
            else if(front != rear){
                queue[front] = -1;
                front++;
            }
            else{
                queue[front] = -1;
                queue[rear] = -1;
                front = -1;
                rear = -1;
            }
        }
        else
            System.out.println("queue is empty");
    }
    
    static void dequeRear(){
        System.out.println("dequeue rear");
        if(!isEmpty()){
            if(rear == 0){
                if(front == 0){
                    queue[front] = -1;
                    queue[rear] = -1;
                    front--;
                    rear--;
                }
                else{
                    queue[rear] = -1;
                    rear = MAX_SIZE-1;   
                } 
            }
            else{
                queue[rear] = -1;
                rear--;   
            }
        }
        else
            System.out.println("queue is empty");
    }
    
    static int getFront(){
        return front;
    }
    
    static int getRear(){
        return rear;
    } 
    
    static boolean isEmpty(){
        if(front == -1)
            return true;
        return false;
    }
    
    static boolean isFull(){
        if((front == 0 && rear == MAX_SIZE-1) || (rear == front-1))
            return true;
        return false;
    }
    
    static void printQueue(){
        for(int i=0; i<=MAX_SIZE-1; i++)
            System.out.print(queue[i]+"  ");
    }
}
