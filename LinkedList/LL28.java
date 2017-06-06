/*
Delete alternate nodes of a Linked List
Given a Singly Linked List, starting from the second node delete all alternate nodes of it. For example, if the given 
linked list is 1->2->3->4->5 then your function should convert it to 1->3->5, and if the given linked list is 1->2->3->4 
then convert it to 1->3.
*/
class LinkedList{
    static class Node{
        int data;
        Node link;
        String visited;
        Node(int d){
            data = d;
            link = null;
        }
    }
    
    public static void main (String[] args) {
        int size = 6;
        Node head = createList();
        System.out.println("original linked list : ");
        printList(head);
        head = deleteAlternateNode(head);
        System.out.println("deleted linked list with iteration : ");
        printList(head);
        
        head = createList();
        head = deleteAlternateNodeRecursion(head);
        System.out.println("deleted linked list with recursion : ");
        printList(head);        
    }

    static Node createList(){
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        five.link = six;
        return head;
    }
    
    static Node deleteAlternateNode(Node head){
        Node temp = head;
        while(temp != null && temp.link != null){
            temp.link = temp.link.link;
            temp = temp.link;
        }
        return head;
    }
    
    static Node deleteAlternateNodeRecursion(Node head){
        if(head == null || head.link == null)
            return head;
        
        head.link = head.link.link;
        
        deleteAlternateNodeRecursion(head.link);
        return head;
    }
    
    static void printList(Node head){
        Node traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null\n"); 
    }
}
