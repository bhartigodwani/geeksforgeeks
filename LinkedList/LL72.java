/*
@author Bharti Godwani
Circular Singly Linked List | Insertion
A node can be added in three ways:
    Insertion in an empty list
    Insertion at the beginning of the list
    Insertion at the end of the list
    Insertion in between the nodes
*/

import java.util.Stack;
class LL{
    static class Node{
        int data;
        Node link;
        Node(int d){
            data = d;
            link = null;
        }
        Node(){
            link = null;
        }
    }
    
    public static void main(String []args){
        Node last = null;
        int key, pos;
        
        key = 4;
        pos = 1;
        System.out.println("key = "+key+" pos = "+pos);
        last = insertNodeAtPosition(last, key, pos);
        System.out.println("new Linked list");
        printLinkedList(last);
        
        key = 1;
        System.out.println("key = "+key);
        last = insertNode(last, key);
        System.out.println("new Linked list");
        printLinkedList(last);
        
        key = 2;
        System.out.println("key = "+key);
        last = insertNode(last, key);
        System.out.println("new Linked list");
        printLinkedList(last);
        
        key = 3;
        System.out.println("key = "+key);
        last = insertNode(last, key);
        System.out.println("new Linked list");
        printLinkedList(last);
        
        key = 5;
        pos = 2;
        System.out.println("key = "+key+" pos = "+pos+" last = "+last.data);
        last = insertNodeAtPosition(last, key, pos);
        System.out.println("new Linked list");
        printLinkedList(last);
        
        key = 6;
        pos = 3;
        System.out.println("key = "+key+" pos = "+pos);
        last = insertNodeAtPosition(last, key, pos);
        System.out.println("new Linked list");
        printLinkedList(last);
        
        key = 7;
        pos = 12;
        System.out.println("key = "+key+" pos = "+pos);
        last = insertNodeAtPosition(last, key, pos);
        System.out.println("new Linked list");
        printLinkedList(last);
        
        key = 7;
        pos = 1;
        System.out.println("key = "+key+" pos = "+pos);
        last = insertNodeAtPosition(last, key, pos);
        System.out.println("new Linked list");
        printLinkedList(last);
       
   }
   
   /*----------------------insert after last node-----------------------*/
   static Node insertNode(Node last, int key){
       if(last == null){
           Node newNode = new Node(key);
           last = newNode;
           last.link = last;
       }
       else{
           Node newNode = new Node(key);
           newNode.link = last.link;
           last.link = newNode;
       }
       return last;
   }
   
    /*----------------------insert at perticular position after last node-----------------------*/
    static Node insertNodeAtPosition(Node last, int key, int pos){
        if(last == null){
           if(pos == 1){
               Node newNode = new Node(key);
               last = newNode;
               last.link = last;
           }
           else
               System.out.println("insertion at position = "+pos+" is not possible");
           
           return last;
        }
       else{
           Node newNode = new Node(key);
           Node temp = last;
           if(pos == 1){
               while(temp.link != last)
                   temp = temp.link;
               
               newNode.link = temp.link;
               temp.link = newNode;
               last = newNode;
               return last;
           }
           else{
               int p = 1;
               while(p < pos-1 && temp.link != last){
                   p++;
                   temp = temp.link;
               }
               if(p < pos && temp.link == last){
                    System.out.println("insertion at position = "+pos+" is not possible");
                    return last;    
               }
               newNode.link = temp.link;
               temp.link = newNode;
           }
       return last;
       }
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
    
    /*-----------------------Circular Singly Linked List Traversal----------------*/
    static void printLinkedList(Node last){
        if (last == null)
            System.out.println("null");
 
        else{
            Node temp = last;
            while(temp.link.data != last.data){
                System.out.print(temp.data+" --> ");
                temp = temp.link;
            }
            System.out.println(temp.data+((temp.data!=last.data) ? " --> "+last.data : "")+"\n");
        }
    }
}
