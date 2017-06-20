/*
@author Bharti Godwani

Split a Circular Linked List into two halves
1) Store the mid and last pointers of the circular linked list using tortoise and hare algorithm.
2) Make the second half circular.
3) Make the first half circular.
4) Set head (or start) pointers of the two linked lists.

In the below implementation, if there are odd nodes in the given circular linked list then the first result list has 1 more node than the second result list.
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
        for(int i=8; i>0; i--){
            last = insertNode(last, i);
        }
        System.out.println("Linked list");
        printLinkedList(last);
        Node split[] = splitCircularList(last);
        System.out.println("First Linked list");
        printLinkedList(split[0]);
        System.out.println("Second Linked list");
        printLinkedList(split[1]);
   }
   
   static Node[] splitCircularList(Node last){
       Node split[] = new Node[2];
       System.out.println("1");
       if((last == null) || (last != null && last.link == null)){
           System.out.println("base case");
           split[0] = last;
           split[1] = null;
           return split;
       }
       
       /*  h1 will contain pointer of last node of first list
           h1.link will contain first node of second list */
       
       Node h1 = last; //slow pointer
       Node h2 = last.link; //fast pointer
       System.out.println("before");
       while(h2.link != last && h2 != last){
           h1 = h1.link;
           h2 = h2.link.link;
       }   
          
       split[1] = h1.link;//split[1] will point to last of second list
       h2 = h1.link;
       while(h2.link != last)
          h2 = h2.link;
       h2.link = split[1];//second list is set
       
       h1.link = last;//making first list circular
       split[0] = last;
       System.out.println("1 = "+split[0].data);
       System.out.println("2 = "+split[1].data);
       return split;
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
