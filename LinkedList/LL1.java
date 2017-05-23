/*
  Insert Node at the beginning of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

// This is a "method-only" submission. 

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
        
        /*insertion at front*/
        int valueToBeInsertedAtFront = 5;
        insertAtFront(valueToBeInsertedAtFront);
        System.out.println("\nvalueToBeInsertedAtFront is = "+valueToBeInsertedAtFront);
        System.out.println("LinkedList after insertion at front:");
        traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null\n");
        
        /*insertion at end*/
        int valueToBeInsertedAtEnd = 6;
        System.out.println("\nvalueToBeInsertedAtEnd is = "+valueToBeInsertedAtEnd);
        insertAtEnd(valueToBeInsertedAtEnd);
        System.out.println("LinkedList after insertion at end:");
        traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null\n");
        
        /*insertion at given position*/
        int position = 4;
        int valueToBeInsertedAtPosition = 7;
        System.out.println("\nposition = "+position+"  valueToBeInsertedAtPosition is = "+valueToBeInsertedAtPosition);
        insertAtPosition(position , valueToBeInsertedAtPosition);
        System.out.println("LinkedList after insertion at given position:");
        traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null\n");
        
    }
    
    static void createLinkedList(int []a, Node head){
        Node ptr = head;
        for (int i=1; i<a.length; i++){
            Node node = new Node(a[i]);
            ptr.link = node;
            ptr = ptr.link;
        }
    }
    
    static void insertAtFront(int valueToBeInserted){
        Node newNode = new Node(valueToBeInserted);
        newNode.link = head;
        head = newNode;
    }
    
    static void insertAtEnd(int valueToBeInsertedAtEnd){
        Node newNode = new Node(valueToBeInsertedAtEnd);
        Node ptr = head;
        while(ptr.link != null){
            ptr = ptr.link;
        }
        
        ptr.link = newNode;
    }
    
    static void insertAtPosition(int position , int insertAtPosition){
        Node ptr = head;
        Node newNode = new Node(insertAtPosition);
        int tempPos=1;
        while(tempPos < position){
            ptr = ptr.link;
            tempPos++;
        }
        newNode.link = ptr.link;
        ptr.link = newNode;
    }
}
