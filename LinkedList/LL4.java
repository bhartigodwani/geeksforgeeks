/*
Write a function to get Nth node in a Linked List
Write a GetNth() function that takes a linked list and an integer index and returns the data value stored in the node at 
that index position.
Example:
Input:  1->10->30->14,  index = 2
Output: 30  
The node at index 2 is 30
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
        int a[] = {1,2,3,4,5,6};
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
        
        /*find Nth node with iteration*/
        traversePtr = head;
        int length = 0;
        int N = 4;
        boolean flag = false;
        while(traversePtr != null){
            if (length == N){
                System.out.println("index = "+N+"\nNth node is = "+traversePtr.data);
                break;
            }
            length++;
            traversePtr = traversePtr.link;
        }
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
