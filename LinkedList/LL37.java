/*
Add two numbers represented by linked lists | Set 1
Given two numbers represented by two lists, write a function that returns sum list. The sum list is list representation of 
addition of two input numbers.

Example 1

Input:
  First List: 5->6->3  // represents number 365
  Second List: 8->4->2 //  represents number 248
Output
  Resultant list: 3->1->6  // represents number 613

Example 2

Input:
  First List: 7->5->9->4->6  // represents number 64957
  Second List: 8->4 //  represents number 48
Output
  Resultant list: 5->0->0->5->6  // represents number 65005
*/

class LinkedList{
    static class Node{
        int data;
        Node link;
        Node(int d){
            data = d;
            link = null;
        }
    }

    public static void main (String[] args) {
        /*------------------------case 1---------------------*/
        System.out.println("case 1");
        int size = 6;
        Node head1 = new Node(1);
        for (int value=2; value <= size; value++){
            head1 = insertNode(head1, 9);
        }
        System.out.println("original LinkedList : ");
        printLinkedList(head1);
        
        Node head2 = createLinkedList2();
        printLinkedList(head2);
        
        System.out.println();
        System.out.println("new linked list");
        Node head = addTwoList(head2, head1);
        printLinkedList(head);
            
        
        
    }
    
    static Node addTwoList(Node h1, Node h2){
        Node newHead = null;
        int f = 0, c = 0;
        int value;
        Node temp = null;
        while(h1 != null && h2 != null){
            value = h1.data + h2.data + c;
            if(value > 9){
                value = value % 10;
                c = 1;
            }
            else
                c = 0;
            if(f == 0){//new LL is empty
                f = 1;
                newHead = new Node(value);
                temp = newHead;
                
            }    
            else{
                temp.link = new Node(value);
                temp = temp.link;
                
            }
            h1 = h1.link;
            h2 = h2.link;
        }
        while(h1 != null){
            value = h1.data + c;
            if(value > 9){
                value = value % 10;
                c = 1;
            }
            else
                c = 0;
            temp.link = new Node(value);
            temp = temp.link;
            
            h1 = h1.link;
        }
        while(h2 != null){
            value = h2.data + c;
            if(value > 9){
                value = value % 10;
                c = 1;
            }
            else
                c = 0;
            temp.link = new Node(value);
            temp = temp.link;
            
            h2 = h2.link;
        }
        if(c == 1){
            temp.link = new Node(1);
            temp = temp.link;
        }
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
    
    static Node insertNode(Node head, int value){
        Node newNode = new Node(value);
        Node temp = head;
        while(temp.link != null){
            temp = temp.link;
        }
        temp.link = newNode;
        return head;
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
    
    static Node createLinkedList(){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        
        one.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        five.link = six;
        six.link = three;
        
        return one;
    }
    
    static Node createLinkedList2(){
        Node one1 = new Node(9);
        Node two1 = new Node(9);
        Node two2 = new Node(9);
        Node three1 = new Node(9);
        Node three2 = new Node(9);
        Node one2 = new Node(9);
        
        one1.link = two1;
        two1.link = three1;
        three1.link = two2;
        two2.link = one2;
        return one1;
    }
    
    static Node createLinkedList3(){
        Node one1 = new Node(1);
        Node two1 = new Node(2);
        Node two2 = new Node(2);
        Node three1 = new Node(3);
        Node three2 = new Node(3);
        Node one2 = new Node(1);
        
        /*one1.link = two1;
        two1.link = three1;
        three1.link = two2;
        two2.link = one2;*/
        return one1;
    }
}
