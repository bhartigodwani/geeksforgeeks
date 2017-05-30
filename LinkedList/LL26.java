/*
Move last element to front of a given Linked List
Write a C function that moves last element to front in a given Singly Linked List. For example, if the given Linked List is 
1->2->3->4->5, then the function should change the list to 5->1->2->3->4.
*/
class LinkedList{
    static class Node{
        int data;
        Node link;
        Node(int d){
            data = d;
            link = null;
        }
    }
    public static void main (String[] args) {
        /*---------------list of odd length size------------------*/
        System.out.println("through iteration");
        int size = 7;
        Node head = new Node(1);
        for (int value=2; value <= size; value++){
            head = insertNode(head,value);
        }
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        System.out.println("\nSwapped LinkedList : ");
        head = changeLinkedList(head);
        printLinkedList(head);
        
        /*---------------list of even length size------------------*/
        System.out.println();
        size = 6;
        head = new Node(1);
        for (int value=2; value <= size; value++){
            head = insertNode(head,value);
        }
        System.out.println("\noriginal LinkedList : ");
        printLinkedList(head);
        System.out.println("\nSwapped LinkedList : ");
        head = changeLinkedList(head);
        printLinkedList(head);
        
        /*---------------list is empty---------------*/
        System.out.println();
        head = null;
        System.out.println("\noriginal LinkedList : ");
        printLinkedList(head);
        System.out.println("\nSwapped LinkedList : ");
        head = changeLinkedList(head);
        printLinkedList(head);
    }
    
    static Node changeLinkedList(Node head){
        if(head == null || head.link == null)
            return head;
            
        Node ptr = head;
        while(ptr.link.link != null){
            ptr = ptr.link;
        }
        ptr.link.link = head;
        head = ptr.link;
        ptr.link = null;
        return head;
    }
    
    static Node insertNode(Node head, int value){
        Node newNode = new Node(value);
        Node temp = head;
        while(temp.link != null){
            temp = temp.link;
        }
        temp.link = newNode;
        return head;
    }
    
    static void printLinkedList(Node head){
        if (head == null)
            System.out.print("null");
 
        else{
            Node temp = head;
            while(temp.link != null){
                System.out.print(temp.data+" --> ");
                temp = temp.link;
            }
            System.out.print(temp.data+" --> null");
        }
    }
}
