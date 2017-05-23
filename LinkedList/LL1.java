/*
Linked List operations implemented:

Creation

Deletion at:
1. front
2. end
3. given position
4. give key

Insertion at:
1. front
2. end
3. given position
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
        
        /*deletion at front*/
        deleteAtFront();
        System.out.println("\nLinkedList after deletion at front:");
        traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null\n");
        
        /*deletion at end*/
        deleteAtEnd();
        System.out.println("LinkedList after deletion at end:");
        traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null\n");
        
        
        /*deletion at given position*/
        int position = 2;
        deleteAtGivenPosition(position);
        System.out.println("position to be deleted = "+position);
        System.out.println("LinkedList after deletion at given position:");
        traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null\n");
        

        /*insertion at front*/
        int valueToBeInsertedAtFront = 5;
        insertAtFront(valueToBeInsertedAtFront);
        System.out.println("valueToBeInsertedAtFront is = "+valueToBeInsertedAtFront);
        System.out.println("LinkedList after insertion at front:");
        traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null\n");
        
        /*insertion at end*/
        int valueToBeInsertedAtEnd = 6;
        System.out.println("valueToBeInsertedAtEnd is = "+valueToBeInsertedAtEnd);
        insertAtEnd(valueToBeInsertedAtEnd);
        System.out.println("LinkedList after insertion at end:");
        traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null\n");
        
        /*insertion at given position*/
        position = 4;
        int valueToBeInsertedAtPosition = 7;
        System.out.println("position = "+position+"  valueToBeInsertedAtPosition is = "+valueToBeInsertedAtPosition);
        insertAtPosition(position , valueToBeInsertedAtPosition);
        System.out.println("LinkedList after insertion at given position:");
        traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null\n");
       
        
        /*deletion of a node given a key*/
        int key = 6;
        deleteGivenKey(key);
        System.out.println("key to be deleted = "+key);
        System.out.println("LinkedList after deletion of node of given key:");
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
    
    static void deleteAtFront(){
        head = head.link;
    }
    
    static void deleteAtEnd(){
        Node ptr = head;
        while(ptr.link.link != null)
            ptr = ptr.link;
        
        ptr.link = null;
    }
    
    static void deleteAtGivenPosition(int position){
        Node ptr = head;
        int pos = 1;
        while(pos < position-1)
            ptr = ptr.link;
        ptr.link = ptr.link.link;
    }
    
    static void deleteGivenKey(int key){
        Node current = head;
        if(current.data == key){
            head = head.link;
        }
        else{
            Node next = current.link;
            while(next.data != key){
                current = current.link;
                next = next.link;
            }            
            
            current.link = next.link;
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
        while(tempPos < position-1){
            ptr = ptr.link;
            tempPos++;
        }
        newNode.link = ptr.link;
        ptr.link = newNode;
    }
}
