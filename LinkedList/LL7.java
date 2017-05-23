/*creation of LinkedList using node class*/
class LinkedList{
    static Node head;
    
    static class Node{
        int data;
        Node link;
        Node(int data){
            this.data = data;
            this.link = null;
        }
    }
    
    public static void main (String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        
        ll.head.link = second;
        second.link = third;
        
        System.out.println("first element = "+head.data);
        System.out.println("second element = "+head.link.data);
        System.out.println("third element = "+head.link.link.data);
    }
}
