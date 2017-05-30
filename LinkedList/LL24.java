/*
Pairwise swap elements of a given linked list
Given a singly linked list, write a function to swap elements pairwise. For example, if the linked list is 1->2->3->4->5 
then the function should change it to 2->1->4->3->5, and if the linked list is 1->2->3->4->5->6 then the function should 
change it to 2->1->4->3->6->5.
Through iteration and recursion
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
        /*----------------------------------non recursive way-------------------------*/
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
        head = pairWiseSwap(head);
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
        head = pairWiseSwap(head);
        printLinkedList(head);
        
        /*---------------list is empty---------------*/
        System.out.println();
        head = null;
        System.out.println("\noriginal LinkedList : ");
        printLinkedList(head);
        System.out.println("\nSwapped LinkedList : ");
        head = pairWiseSwap(head);
        printLinkedList(head);
        
        /*----------------------------------recursive way-------------------------*/
        /*---------------list of odd length size------------------*/
        System.out.println("\n\nthrough recursion");
        size = 7;
        head = new Node(1);
        for (int value=2; value <= size; value++){
            head = insertNode(head,value);
        }
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        System.out.println("\nSwapped LinkedList : ");
        head = pairWiseSwapRecursion(head);
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
        head = pairWiseSwapRecursion(head);
        printLinkedList(head);
        
        /*---------------list is empty---------------*/
        System.out.println();
        head = null;
        System.out.println("\noriginal LinkedList : ");
        printLinkedList(head);
        System.out.println("\nSwapped LinkedList : ");
        head = pairWiseSwapRecursion(head);
        printLinkedList(head);
         
        
    }
    
    static Node pairWiseSwap(Node head){
        Node p1 = head;
        while(p1 != null && p1.link != null){
            int temp = p1.data;
            p1.data = p1.link.data;
            p1.link.data = temp;
            p1 = p1.link.link;
        }
        return head;
    }
    
    static Node pairWiseSwapRecursion(Node head){
        Node p1 = head;
        if(p1 != null && p1.link != null){
            swap(p1, p1.link);
            pairWiseSwapRecursion(p1.link.link);
        }
        return head;
    }
    
    static void swap(Node p1, Node p1Link){
        int temp = p1.data;
        p1.data = p1Link.data;
        p1Link.data = temp;
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
