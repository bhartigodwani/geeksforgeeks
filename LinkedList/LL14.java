/*
Merge two sorted linked lists
Write a SortedMerge() function that takes two lists, each of which is sorted in increasing order, 
and merges the two together into one list which is in increasing order. SortedMerge() should return
the new list. The new list should be made by splicing
together the nodes of the first two lists.

For example if the first linked list a is 5->10->15 and the other linked list b is 2->3->20, 
then SortedMerge() should return a pointer to the head node of the merged list 2->3->5->10->15->20.
*/
class LinkedList{
    static class Node{
        int data;
        Node link;
        String visited;
        Node(int d){
            data = d;
            visited = "no";
            link = null;
        }
    }
    public static void main (String[] args) {
        System.out.println("case 1");
        int size = 14;
        Node head1 = new Node(1);
        for (int i=3; i<=size; i = i+2)
            head1 = createNode(i,head1);
            
        Node head2 = new Node(2);
        for (int i=4; i<=size; i = i+2)
            head2 = createNode(i,head2);
        
        System.out.println("first LinkedList");
        printLinkedList(head1);
        System.out.println("second LinkedList");
        printLinkedList(head2);
        head1 = mergeList(head1, head2);
        System.out.println("mergedlist :");
        printLinkedList(head1);
        
        /*-----------------------------------------case 2--------------------------------------*/
        System.out.println("\ncase 2");
        head1 = new Node(1);
        for (int i=3; i<=7; i = i+2)
            head1 = createNode(i,head1);
            
        head2 = null;
        
        System.out.println("first LinkedList");
        printLinkedList(head1);
        System.out.println("second LinkedList");
        printLinkedList(head2);
        head1 = mergeList(head1, head2);
        System.out.println("mergedlist :");
        printLinkedList(head1);
        
        /*-----------------------------------------case 3--------------------------------------*/
        System.out.println("\ncase 3");
        head1 = null;
        head2 = new Node(1);
        for (int i=3; i<=7; i = i+2)
            head2 = createNode(i,head2);
        
        System.out.println("first LinkedList");
        printLinkedList(head1);
        System.out.println("second LinkedList");
        printLinkedList(head2);
        head1 = mergeList(head1, head2);
        System.out.println("mergedlist :");
        printLinkedList(head1);
        
        /*-----------------------------------------case 4--------------------------------------*/
        System.out.println("\ncase 4");
        head1 = new Node(1);
        for (int i=3; i<=size; i = i+2)
            head1 = createNode(i,head1);
            
        head2 = new Node(2);
        for (int i=4; i<=7; i = i+2)
            head2 = createNode(i,head2);
            
        System.out.println("first LinkedList");
        printLinkedList(head1);
        System.out.println("second LinkedList");
        printLinkedList(head2);
        head1 = mergeList(head1, head2);
        System.out.println("mergedlist :");
        printLinkedList(head1);
        
    }
    
    static Node mergeList(Node head1, Node head2){
        if (head1 == null)
            return head2;
        else if(head2 == null)
            return head1;
        
        Node curr1, curr2, prev;
        Node newHead;
        if(head1.data < head2.data){
            newHead = head1;
            curr1 = head1.link;
            prev = head1;
            curr2 = head2;
        }
        
        else{
            newHead = head2;
            curr1 = head2.link;
            prev = head2;
            curr2 = head1;
        }
        
        while(curr1 != null && curr2 != null){
            if(curr1.data < curr2.data){
                curr1 = curr1.link;
                prev = prev.link;
            }
            else{
                Node temp = curr2.link;
                prev.link = curr2;
                curr2.link = curr1;
                prev = curr2;
                curr2 = temp;
            }
        }
        if(curr2 != null)
            prev.link = curr2;
        
        return newHead;
    }
    
    static void insertNode(Node ptr1, Node ptr2){
        Node temp = ptr2.link;
        ptr2.link = ptr1.link;
        ptr1.link = ptr2;
        ptr2 = temp;
        ptr1 = ptr1.link.link;
    }
    static Node createNode(int value, Node head){
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
            System.out.println("null");
 
        else{
            Node temp = head;
            while(temp.link != null){
                System.out.print(temp.data+" --> ");
                temp = temp.link;
            }
            System.out.println(temp.data+" --> null");
        }
    }
    
}
