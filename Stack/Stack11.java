class Stack11{
    static Stack<Node> stack = new Stack<Node>();
    static Node middleElement;
    static count = 0;

    static Node{
        int data;
        Node prev;
        Node next;
        Node(int d){
            data = d;
            prev = next = null;
        }
    }
    
    public static void main (String[] args) {
        Node tail = null;
        tail = pushStack(1, tail);
        tail = popStack();
    }
    
    static Node pushStack(int value, Node tail){
        count++;
        Node newNode = new Node(value);
        if(tail == null){
            middleElement = newNode;
            tail = newNode;
            return tail;
        }
        if(count % 2 == 1)
            middleElement = middleElement.next;
        
        tail.next = newNode;
        tail = newNode;
        return tail;
    }
    
    static void popStack(){
            
    }
    
}
