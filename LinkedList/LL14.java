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
        
        Node ptr1 = head1, ptr2 = head2; 
        while(ptr1.link != null && ptr2 != null){
            if (ptr1.data < ptr2.data){
                //insertNode(ptr1,ptr2);
                Node temp = ptr2.link;
                ptr2.link = ptr1.link;
                ptr1.link = ptr2;
                ptr2 = temp;
                ptr1 = ptr1.link.link;
            }
            else{
                int tempData = ptr1.data;
                ptr1.data = ptr2.data;
                ptr2.data = tempData;
                //insertNode(ptr1,ptr2);
                Node temp = ptr2.link;
                ptr2.link = ptr1.link;
                ptr1.link = ptr2;
                ptr2 = temp;
                ptr1 = ptr1.link.link;
            }
        }
        if (ptr1.link == null){
            ptr1.link = ptr2;
        }
        
        return head1;
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
