/*
@author Bharti Godwani
Sort a linked list that is sorted alternating ascending and descending orders?

Given a Linked List. The Linked List is in alternating ascending and descending orders. Sort the list efficiently.

Example:

Input List:   10->40->53->30->67->12->89->NULL
Output List:  10->12->30->43->53->67->89->NULL

An Efficient Solution works in O(n) time. Below are all steps.
1. Separate two lists.
2. Reverse the one with descending order
3. Merge both lists. 
*/
class LL{
    static class Node{
        int data;
        Node link;
        Node(int d){
            data = d;
            link = null;
        }
    }
    public static void main(String []args){
        Node head = createList();
        System.out.println("Linked List");
        printList(head);
        
        Node heads[] = splitList(head);        
        Node h1 = heads[0];
        Node h2 = heads[1];
        System.out.println("ascending list");
        printList(h1);
        System.out.println("descending list");
        h2 = reverseLinkedList(h2);
        printList(h2);
        h1 = mergeList(h1, h2);
        System.out.println("sorted list");
        printList(h1);
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
    
    static Node reverseLinkedList(Node head){
        if(head != null){
            Node prev = null;
            Node current = head;
            Node next = null;
            while(current != null){
                next = current.link;
                current.link = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }
        return head;
    }
    
    static Node[] splitList(Node head){
        Node head1 = head;
        Node head2 = head.link;
        Node t1 = head1;
        Node t2 = head2;
        while(t2 != null && t2.link != null){
            t1.link = t1.link.link;
            t1 = t1.link;
            t2.link = t2.link.link;
            t2 = t2.link;
            if(t2 == null)
                break;
            else if(t2.link == null)
                t1.link = t1.link.link;
        }
        
        Node nodes[] = {head1, head2};
        return nodes;
    }
    
    static Node createList(){
        Node head = new Node(10);
        Node two = new Node(40);
        Node three = new Node(53);
        Node four = new Node(30);
        Node five = new Node(67);
        Node six = new Node(12);
        Node seven = new Node(89);
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        five.link = six;
        six.link = seven;
        return head;
    }
    
    static void printList(Node head){
        Node traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null\n"); 
    }
}
