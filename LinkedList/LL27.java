/*
Intersection of two Sorted Linked Lists
Given two lists sorted in increasing order, create and return a new list representing the intersection of the two lists. 
The new list should be made with its own memory — the original lists should not be changed.

For example, let the first linked list be 1->2->3->4->6 and second linked list be 2->4->6->8, then your function should 
create and return a third list as 2->4->6.
*/

import java.util.HashMap;
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
        
        Node head2 = new Node(1);
        for (int i=3; i<=10; i=i+2)
            head2 = insertNode(head2,i);
            
        System.out.println("\nLinkedList 1 : ");
        printLinkedList(head1);

        System.out.println("\nLinkedList 2 : ");
        printLinkedList(head2);
        System.out.println("\nnew LinkedList");
        head2 = intersectionOfLinkedList(head1, head2);
        printLinkedList(head2);
    }

    static Node intersectionOfLinkedList(Node head1, Node head2){
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        Node ptr = head1;
        while(ptr != null){
            map.put(ptr.data, "yes");
        }
        Node newHead = null;
        ptr = head2;
        int headCount = 0;
        Node newPtr = null;
        while(ptr != null){
            if (map.containsKey(ptr.data)){
                Node newNode = new Node(ptr.data);
                if (headCount == 0){
                    newHead = newNode;
                    newPtr = newHead;
                }
                else{
                    newPtr.link = newNode;
                    newPtr = newPtr.link;
                }
            }
                
        }
        return newHead;
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
