/*
Write a function to get the intersection point of two Linked Lists.
There are two singly linked lists in a system. By some programming error the end node of one of the 
linked list got linked into the second list, forming a inverted Y shaped list. Write a program to 
get the point where two linked list merge.
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
        /*---------------list of length = size------------------*/
        int size = 7;
        Node head1 = new Node(1);
        for (int value=2; value <= size; value++){
            head1 = insertNode(head1,value);
        }
        
        Node head2 = new Node(8);
        for (int i=9; i<=10; i++)
            head2 = insertNode(head2,i);
            
        for (int value=5; value <= size; value++){
            head2 = insertNode(head2,value);
        }
        
        System.out.println("\nLinkedList 1 : ");
        printLinkedList(head1);
        head1 = reverseLinkedList(head1);
        
        System.out.println("\nLinkedList 2 : ");
        printLinkedList(head2);
        head2 = reverseLinkedList(head2);
        
        Node ptr1 = head1;
        Node ptr2 = head2;
        Node current = ptr1;
        while(ptr1.data == ptr2.data){
            current = ptr1;
            ptr1 = ptr1.link;
            ptr2 = ptr2.link;
        }
        System.out.println("\nat node = "+current.data+" both the LinkedList merged");
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
    
    static Node reverseLinkedList(Node head){
        if(head != null){
            Node prev = null;
            Node current = head;
            Node next = null;
            while(current != null){
                next = current.link;
                current.link = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }
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
