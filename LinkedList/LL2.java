/*
Find Length of a Linked List (Iterative and Recursive)

Write a function to count number of nodes in a given singly linked list.
For example, the function should return 5 for linked list 1->3->1->2->1
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
        
        /*find length with iteration*/
        traversePtr = head;
        int length = 0;
        while(traversePtr != null){
            length++;
            traversePtr = traversePtr.link;
        }
        System.out.println("\nlength of the LinkedList with iteration is = "+length);
        
        /*find length with recursion*/
        int count = findLength(head);
        System.out.println("\nlength of the LinkedList with iteration is = "+count);
    }
    
    static void createLinkedList(int []a, Node head){
        Node ptr = head;
        for (int i=1; i<a.length; i++){
            Node node = new Node(a[i]);
            ptr.link = node;
            ptr = ptr.link;
        }
    }
    
    static int findLength(Node ptr){
        int count = 0;
        if(ptr.link == null)
            return 1;
        else{
            count = 1 + findLength(ptr.link);
        }
    return count;
    }
}
