/*
@author Bharti Godwani

Compare two strings represented as linked lists

Given two linked lists, represented as linked lists (every character is a node in linked list). Write a function compare() 
that works similar to strcmp(), i.e., it returns 0 if both strings are same, 1 if first linked list is lexicographically 
greater, and -1 if second string is lexicographically greater.

Examples:

Input: list1 = g->e->e->k->s->a
       list2 = g->e->e->k->s->b
Output: -1

Input: list1 = g->e->e->k->s->a
       list2 = g->e->e->k->s
Output: 1

Input: list1 = g->e->e->k->s
       list2 = g->e->e->k->s
Output: 0
*/

class LL{
    static class Node{
        char data;
        Node link;
        Node(char d){
            data = d;
            link = null;
        }
    }
    public static void main(String []args){
        Node h1 = createList1();
        Node h2 = createList2();
        Node h3 = createList3();
        
        int result ;
        System.out.println("case 1"); 
        System.out.println("h1 Linked List");
        printList(h1);
        System.out.println("h2 Linked List");
        printList(h2);
        result = strcmp(h1, h2);
        System.out.println("result"+result);
        System.out.println(); 
        
        System.out.println("case 2"); 
        System.out.println("h1 Linked List");
        printList(h1);
        System.out.println("h3 Linked List");
        printList(h3);
        result = strcmp(h1, h3);
        System.out.println("result"+result);
        System.out.println(); 
        
        System.out.println("case 3"); 
        System.out.println("h3 Linked List");
        printList(h3);
        System.out.println("h3 Linked List");
        printList(h3);
        result = strcmp(h3, h3);
        System.out.println("result"+result);
        System.out.println(); 
    }
 
    static int strcmp(Node h1, Node h2){
        if(h1 == null && h2 == null)
            return 0;//both are same
        if((h1 == null && h1!= null) || (h2 == null && h1!= null))
            return 1;//one of them is lexicographically greater
        else{
            Node t1 = h1;
            Node t2 = h2;
            while(t1!=null && t2!=null){
                if(t1.data != t2.data)
                    return -1;//when they are not same
                else{
                    t1 = t1.link;
                    t2 = t2.link;
                }
            }
            if(t1 != null || t2 != null)//when one of them is lexicographically greater
                return 1;
            else
                return 0;
        }
    }
    
    static Node createList1(){
        Node head = new Node('g');
        Node two = new Node('e');
        Node three = new Node('e');
        Node four = new Node('k');
        Node five = new Node('s');
        Node six = new Node('a');
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        five.link = six;
        return head;
    }

    static Node createList2(){
        Node head = new Node('g');
        Node two = new Node('e');
        Node three = new Node('e');
        Node four = new Node('k');
        Node five = new Node('s');
        Node six = new Node('b');
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        five.link = six;
        return head;
    }
    
    static Node createList3(){
        Node head = new Node('g');
        Node two = new Node('e');
        Node three = new Node('e');
        Node four = new Node('k');
        Node five = new Node('s');
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        return head;
    }
    
    static void printList(Node head){
        Node traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null"); 
    }
}
