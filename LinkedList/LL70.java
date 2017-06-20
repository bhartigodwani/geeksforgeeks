/*
@author Bharti Godwani

Delete last occurrence of an item from linked list

Given a liked list and a key to be deleted. Delete last occurrence of key from linked. The list may have duplicates.

Examples:

Input:   1->2->3->5->2->10, key = 2
Output:  1->2->3->5->10 
*/

import java.util.Stack;
class LL70{
    static class Node{
        int data;
        Node link;
        Node(int d){
            data = d;
            link = null;
        }
    }
    public static void main(String []args){
        System.out.println("case 1");
        Node h1 = createList();
        System.out.println("linked list");
        printLinkedList(h1);
        int key = -2;
        System.out.println("key = "+key);
        System.out.println("new sorted list");
        h1 = deleteLastOccurredElement(h1, key);
        printLinkedList(h1);
        
        System.out.println("\ncase 2");
        h1 = createList2();
        System.out.println("linked list");
        printLinkedList(h1);
        key = -11;
        System.out.println("key = "+key);
        System.out.println("new sorted list");
        h1 = deleteLastOccurredElement(h1, key);
        printLinkedList(h1);
        
        System.out.println("\ncase 3");
        h1 = createList3();
        System.out.println("linked list");
        printLinkedList(h1);
        key = 13;
        System.out.println("key = "+key);
        System.out.println("new sorted list");
        h1 = deleteLastOccurredElement(h1, key);
        printLinkedList(h1);
        
        System.out.println("\ncase 4");
        h1 = createList4();
        System.out.println("linked list");
        printLinkedList(h1);
        key = 2;
        System.out.println("key = "+key);
        System.out.println("new sorted list");
        h1 = deleteLastOccurredElement(h1, key);
        printLinkedList(h1);
   }
       
   static Node deleteLastOccurredElement(Node head, int key){
       if(head == null)
           return head;
       Node temp = head;
       Node prev = null;
       Node deleteNext = null;//its next node need to be deleted
       while(temp != null){
           if(temp.data == key){
               deleteNext = prev;
           }
           prev = temp;
           temp = temp.link;
       }
       if(deleteNext == null)
           return head.link;
       else
           deleteNext.link = deleteNext.link.link;
       return head;
   }
    
    static Node createList(){
        Node head = new Node(1);
        Node two = new Node(-2);
        Node three = new Node(-3);
        Node four = new Node(4);
        Node five = new Node(-5);
        Node six = new Node(-2);
        
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        five.link = six;
        
        return head;
    }
    
    static Node createList2(){
        Node head = new Node(-5);
        Node two = new Node(-10);
        Node three = new Node(-11);
        Node four = new Node(3);
        
        head.link = two;
        two.link = three;
        three.link = four;
        return head;
    }
    
    static Node createList3(){
        Node head = new Node(-5);
        Node two = new Node(10);
        Node three = new Node(-12);
        Node four = new Node(13);
        Node five = new Node(13);
        Node six = new Node(14);
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        five.link = six;
        
        return head;
    }
    
    static Node createList4(){
        Node head = new Node(2);
        Node two = new Node(3);
        Node three = new Node(1);
        //Node four = new Node(1);
        
        //head.link = two;
        two.link = three;
        //three.link = four;
        
        return null;
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
