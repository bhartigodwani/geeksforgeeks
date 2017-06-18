/*
@author Bharti Godwani

Rearrange a Linked List in Zig-Zag fashion
Given a linked list, rearrange it such that converted list should be of the form a < b > c < d > e < f .. where a, b, c.. 
are consecutive data node of linked list. Examples :

Input:  1->2->3->4
Output: 1->3->2->4 

Input:  11->15->20->5->10
Output: 11->20->5->15->10

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
        Node h1 = createList1();
        Node h2 = createList2();
        Node h3 = createList3();
        
        System.out.println("case 1"); 
        System.out.println("h1 Linked List");
        printList(h1);
        zigZagList(h1);
        System.out.println("Zig Zag positioned Linked List");
        printList(h1);
        System.out.println();
        
        System.out.println("case 2"); 
        System.out.println("h2 Linked List");
        printList(h2);
        zigZagList(h2);
        System.out.println("Zig Zag positioned Linked List");
        printList(h2);
        System.out.println();
        
        System.out.println("case 3"); 
        System.out.println("h3 Linked List");
        printList(h3);
        zigZagList(h3);
        System.out.println("Zig Zag positioned Linked List");
        printList(h3);
    }
 
    static Node zigZagList(Node head){
        Node temp = head;
        boolean flag = true;
        while(temp.link != null){
            if(flag){//case a>b>c then swap a and b
                if(temp.data > temp.link.data){
                    int t = temp.data;
                    temp.data = temp.link.data;
                    temp.link.data = t;
                }
            }
            else{//case a<b<c then swap b and c
                if(temp.data < temp.link.data){
                    int t = temp.data;
                    temp.data = temp.link.data;
                    temp.link.data = t;
                }
            }
            temp = temp.link;
            flag = !flag;//to check alternatively
        }
        return head;
    }
    
    static Node createList1(){
        Node head = new Node(4);
        Node two = new Node(3);
        Node three = new Node(7);
        Node four = new Node(8);
        Node five = new Node(6);
        Node six = new Node(2);
        Node seven = new Node(1);
                 
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        five.link = six;
        six.link = seven;
        return head;
    }

    static Node createList2(){
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
    
    static Node createList3(){
        Node head = new Node(4);
        Node two = new Node(1);
        Node three = new Node(5);
        Node four = new Node(6);
        Node five = new Node(7);
        Node six = new Node(9);
        
        head.link = two;
        two.link = three;
/*        three.link = four;
        four.link = five;*/
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
