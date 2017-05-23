/*

Write a function that counts the number of times a given int occurs in a Linked List

Given a singly linked list and a key, count number of occurrences of given key in linked list. 
For example,if given linked list is 1->2->1->2->1->3->1 and given key is 1, then output should be 4.
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
        int a[] = {1,2,4,4,3,4,7,8,4};
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
        
        /*find frequency of the given element in a LinkedList*/
        Node ptr1=head;
        int count = 0;
        int element = 4;
        while(ptr1 != null){
            if (ptr1.data == element)
                count++;
            ptr1 = ptr1.link;
        }
        System.out.println(element+" occurs "+count+" times");
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
