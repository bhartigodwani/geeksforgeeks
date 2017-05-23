/*

Write a function to delete a Linked List

Algorithm For C/C++: Iterate through the linked list and delete all the nodes one by one. 
Main point here is not to access next of the current pointer if current pointer is deleted.

In Java, automatic garbage collection happens, so deleting a linked list is easy. 
We just need to change head to null.
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
        int a[] = {1,2,3,4};
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
        
        traversePtr = head;
        while(traversePtr != null){
            head = traversePtr.link;
            traversePtr = traversePtr.link;
        }
        
        System.out.println("LinkedList after deletion:");
        traversePtr = head;
        int flag = 0;
        while(traversePtr != null){
            flag = 1;
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null");
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
