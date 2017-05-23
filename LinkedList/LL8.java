/*
Find n’th node from the end of a Linked List.
Given a Linked List and a number n, write a function that returns the value at the n’th node
from end of the Linked List.
*/

class LinkedList{
    static Node head;
    
    static class Node{
        int data;
        Node link;
        Node(int d){
            data = d;
            link = null;
        }
    }
    public static void main (String[] args) {
        int a[] = {1,2,3,4,5,6,7};
        LinkedList ll = new LinkedList();
        ll.head = new Node(a[0]);
        
        /*linked list creation*/
        createLinkedList(a,head);
        System.out.println("original LinkedList :");
        Node traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null");
        
        /*find element with iteration*/
        Node ptr1 = head;
        Node ptr2 = head;
        int n = 3;
        int temp = 1;
        while(temp <= n){
            ptr1 = ptr1.link;
            temp++;
        }
        
        while(ptr1 != null){
            ptr1 = ptr1.link;
            ptr2 = ptr2.link;
        }
        System.out.println("N = "+n+"\nnth element from end of LinkedList is = "+ptr2.data);
    }
    
    static void createLinkedList(int []a, Node head){
        Node ptr = head;
        for (int i=1; i<a.length; i++){
            Node node = new Node(a[i]);
            ptr.link = node;
            ptr = ptr.link;
        }
    }
}
