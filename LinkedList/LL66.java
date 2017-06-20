/*
@author Bharti Godwani

Point arbit pointer to greatest value right side node in a linked list
Given singly linked list with every node having an additional “arbitrary” pointer that currently points to NULL. We need to 
make the “arbitrary” pointer to greatest value node in a linked list on its right side.
*/

import java.util.Stack;
class LL66{
    static class Node{
        int data;
        Node link;
        Node arbit;
        Node(int d){
            data= d;
            link = arbit = null;
        }
    }
    public static void main(String []args){
        System.out.println("case 1");
        Node head = createList();
        System.out.println("original linked list");
        printLinkedList(head);
        head = setArbitNode(head);
        System.out.println("\narbit linked list");
        printLinkedList(head);
        
        System.out.println("\n\ncase 2");
        head = createList2();
        System.out.println("original linked list");
        printLinkedList(head);
        head = setArbitNode(head);
        System.out.println("\narbit linked list");
        printLinkedList(head);
    }
    
    static Node setArbitNode(Node head){
        head = reverseLinkedList(head);
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        Node temp = head.link;
        while(!stack.isEmpty() && temp != null){
            if(stack.peek().data < temp.data){
                temp.arbit = stack.peek();
                stack.pop();
                stack.push(temp);
            }
            else if(stack.peek().data >= temp.data)
                temp.arbit = stack.peek();
            temp = temp.link;
        }
        return reverseLinkedList(head);
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
        Node three = new Node(20);
        Node four = new Node(3);
        Node five = new Node(11);
        Node six = new Node(12);
        Node seven = new Node(7);
        
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        five.link = six;
        six.link = seven;
        
        return head;
    }
    
    static void printLinkedList(Node head){
        if (head == null)
            System.out.print("null");
 
        else{
            Node temp = head;
            while(temp.link != null){
                System.out.print("("+temp.data+" - "+((temp.arbit == null) ? "null" : temp.arbit.data)+") --> ");
                temp = temp.link;
            }
            System.out.print("("+temp.data+" - null) --> null");
        }
    }
}
