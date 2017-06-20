/*
@author Bharti Godwani
Sorted insert for circular linked list
*/

import java.util.Stack;
class LL74{
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
        last = insertNode(last, 2);
        last = insertNode(last, 10);
        last = insertNode(last, 8);
        last = insertNode(last, 5);
        
        System.out.println("Linked list");
        printLinkedList(last);
        System.out.println("Sorted Linked list");
        key = 7;//insertion in intermediate position
        System.out.println("key = "+key);
        last = insertSorted(last, key);
        printLinkedList(last);
        
        System.out.println("Sorted Linked list");
        key = 1;//insertion at front
        System.out.println("key = "+key);
        last = insertSorted(last, key);
        printLinkedList(last);
        
        System.out.println("Sorted Linked list");
        key = 12;//insertion at last
        System.out.println("key = "+key);
        last = insertSorted(last, key);
        printLinkedList(last);
        
        System.out.println("Sorted Linked list");
        key = 8;//insert repeat
        System.out.println("key = "+key);
        last = insertSorted(last, key);
        printLinkedList(last);
   }
   
   static Node insertSorted(Node last, int key){
       Node temp = last;
       Node newNode = new Node(key);
       if(key <= last.data){//insertion at first node
           while(temp.link != last)
               temp = temp.link;
           
           newNode.link = temp.link;
           temp.link = newNode;
           return newNode;
       }
       else{
           while(temp.link != last){//insertion at some intermediate position
               if(temp.data < key && key <= temp.link.data){
                   newNode.link = temp.link;
                   temp.link = newNode;
                   break;
               }
               temp = temp.link;
           }
           if(temp.link == last && temp.data < key){//insertion at end
               newNode.link = temp.link;
               temp.link = newNode;
           }
       }
       return last;
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
