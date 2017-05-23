/*
Given a singly linked list, find middle of the linked list. 
For example, if given linked list is 1->2->3->4->5 then output should be 3.

If there are even nodes, then there would be two middle nodes, we need to print second middle element. 
For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
Method 1:
Traverse the whole linked list and count the no. of nodes. Now traverse the list again till 
count/2 and return the node at count/2.

Method 2:
Traverse linked list using two pointers. Move one pointer by one and other pointer by two. 
When the fast pointer reaches end slow pointer will reach middle of the linked list.
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
        Node ptr1=head, ptr2=head;
        traversePtr = head;
        while(true){
            if (ptr2 == null || ptr2.link == null)
                break;
            ptr1 = ptr1.link;
            ptr2 = ptr2.link.link;
        }
        System.out.println("middle element is = "+ptr1.data);

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
