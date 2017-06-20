/*
@author Bharti Godwani

Sort linked list which is already sorted on absolute values
Given a linked list which is sorted based on absolute values. Sort the list based on actual values.

Examples:
Input :  1 -> -10 
output: -10 -> 1

Input : 1 -> -2 -> -3 -> 4 -> -5 
output: -5 -> -3 -> -2 -> 1 -> 4 

Input : -5 -> -10 
Output: -10 -> -5

Input : 5 -> 10 
output: 5 -> 10

Solution:
A simple solution is to traverse the linked list from beginning to end. For every visited node, check if it is out of order. 
If it is, remove it from its current position and insert at correct position. This is implementation of insertion sort for 
linked list and time complexity of this solution is O(n*n).

A better solution is to sort the linked list using merge sort. Time complexity of this solution is O(n Log n).

An efficient solution can work in O(n) time. An important observation is, all negative elements are present in reverse order. 
So we traverse the list, whenever we find an element that is out of order, we move it to the front of linked list. 
*/

import java.util.Stack;
class LL69{
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
        System.out.println("absolute sorted linked list");
        printLinkedList(h1);
        System.out.println("actual sorted list");
        h1 = sortAbsoluteToActual(h1);
        printLinkedList(h1);
        
        System.out.println("\ncase 2");
        h1 = createList2();
        System.out.println("absolute sorted linked list");
        printLinkedList(h1);
        System.out.println("actual sorted list");
        h1 = sortAbsoluteToActual(h1);
        printLinkedList(h1);
        
        System.out.println("\ncase 3");
        h1 = createList3();
        System.out.println("absolute sorted linked list");
        printLinkedList(h1);
        System.out.println("actual sorted list");
        h1 = sortAbsoluteToActual(h1);
        printLinkedList(h1);
        
        System.out.println("\ncase 4");
        h1 = createList4();
        System.out.println("absolute sorted linked list");
        printLinkedList(h1);
        System.out.println("actual sorted list");
        h1 = sortAbsoluteToActual(h1);
        printLinkedList(h1);
   }
       
   static Node sortAbsoluteToActual(Node head){
       if(head == null || head.link == null)
           return head;
       
       Node temp = head.link;
       Node prev = head;
       while(temp != null){
           if(temp.data < 0){//add node at front as it is negative
               prev.link = temp.link;
               temp.link = head;
               head = temp;
               temp = prev.link;
           }
           else{
               prev = temp;
               temp = temp.link;
           }
       }
       return head;
   }
    
    static Node createList(){
        Node head = new Node(1);
        Node two = new Node(-2);
        Node three = new Node(-3);
        Node four = new Node(4);
        Node five = new Node(-5);
        
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        
        return head;
    }
    
    static Node createList2(){
        Node head = new Node(-5);
        Node two = new Node(-10);
        Node three = new Node(-11);
        
        head.link = two;
        two.link = three;
        
        return head;
    }
    
    static Node createList3(){
        Node head = new Node(-5);
        Node two = new Node(10);
        Node three = new Node(-12);
        Node four = new Node(13);
        Node five = new Node(14);
        
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        
        return head;
    }
    
    static Node createList4(){
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

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
