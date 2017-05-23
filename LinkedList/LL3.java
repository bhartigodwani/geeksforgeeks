/*
Search an element in a Linked List (Iterative and Recursive)
Write a function that searches a given key ‘element’ in a given singly linked list. 
The function should return true if element is present in linked list and false otherwise.
For example, if the key to be searched is 15 and linked list is 14->21->11->30->10, then function should return false. 
If key to be searched is 14, then the function should return true.
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
        
        /*find element with iteration*/
        int element = 2;//present in the linked list
        traversePtr = head;
        int length = 0;
        boolean flag = false;
        while(traversePtr != null){
            if(traversePtr.data == element){
                //System.out.println("true");
                flag = true;
                break;
            }
            traversePtr = traversePtr.link;
        }
        System.out.println("\nwith iteration");
        if(flag == true)
            System.out.println("element is present in the list");
        else
            System.out.println("element is \"not\" present in the list");
        
        /*find element with recursion*/
        System.out.println("\nwith recursion");
        element = 5;
        boolean present = findElement(head,element);
        
        if(present == true)
            System.out.println("element is present in the list");
        else
            System.out.println("element is \"not\" present in the list");
            
    }
    
    static void createLinkedList(int []a, Node head){
        Node ptr = head;
        for (int i=1; i<a.length; i++){
            Node node = new Node(a[i]);
            ptr.link = node;
            ptr = ptr.link;
        }
    }
    
    static boolean findElement(Node ptr, int element){
        if(ptr == null)
            return false;
            
        else if(ptr.data == element){
            return true;
        }
            
        else{
            return findElement(ptr.link, element);
        }
        
    }
}
