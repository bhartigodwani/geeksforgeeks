/*
@author Bharti Godwani

Merge two sorted linked lists such that merged list is in reverse order
Given two linked lists sorted in increasing order. Merge them such a way that the result list is in decreasing order 
(reverse order).

Examples:

Input:  a: 5->10->15->40
        b: 2->3->20 
Output: res: 40->20->15->10->5->3->2

Input:  a: NULL
        b: 2->3->20 
Output: res: 20->3->2

*/

import java.util.Stack;
class LL67{
    static class Node{
        int data;
        Node link;
        Node(int d){
            data= d;
            link = null;
        }
    }
    public static void main(String []args){
        System.out.println("case 1");
        Node h1 = createList();
        System.out.println("h1 linked list");
        printLinkedList(h1);
        Node h2 = createList2();
        System.out.println("h2 linked list");
        printLinkedList(h2);
        h1 = mergeInReverseOrder(h1, h2);
        System.out.println("merge linked list");
        printLinkedList(h1);
        
        System.out.println("\ncase 2");
        h1 = createList2();
        System.out.println("h1 linked list");
        printLinkedList(h1);
        h2 = createList3();
        System.out.println("h2 linked list");
        printLinkedList(h2);
        h1 = mergeInReverseOrder(h1, h2);
        System.out.println("merge linked list");
        printLinkedList(h1);
    }
    
        static Node mergeInReverseOrder(Node head1, Node head2){
            head1 = reverseLinkedList(head1);
            head2 = reverseLinkedList(head2);
            if (head1 == null)
                return head2;
            else if(head2 == null)
                return head1;

            Node curr1, curr2, prev;
            Node newHead;
            if(head1.data > head2.data){
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
                if(curr1.data > curr2.data){
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
    
    static Node createList(){
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        five.link = six;
        six.link = seven;
        
        return head;
    }
    
    static Node createList2(){
        Node head = new Node(5);
        Node two = new Node(10);
        Node three = new Node(15);
        Node four = new Node(40);
/*      Node five = new Node(11);
        Node six = new Node(12);
        Node seven = new Node(7);*/
        
        head.link = two;
        two.link = three;
        three.link = four;
        
        return head;
    }
    
    static Node createList3(){
        Node head = new Node(2);
        Node two = new Node(3);
        Node three = new Node(20);
        
        head.link = two;
        two.link = three;
        return head;
    }
    
    static void printLinkedList(Node head){
        if (head == null)
            System.out.print("null");
 
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
