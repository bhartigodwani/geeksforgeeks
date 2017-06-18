/*
@author Bharti Godwani

Add 1 to a number represented as linked list

Number is represented in linked list such that each digit corresponds to a node in linked list. Add 1 to it. For example 
1999 is represented as (1-> 9-> 9 -> 9) and adding 1 to it should change it to (2->0->0->0) 
Solution:
Method 1:
reverse the list, then traverse from left to right, add one to it then keep on propogating carry. Then reverse the list again.
Method 2:
recursive implementation as follows
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
        h1 = addOne(h1);
        System.out.println("Zig Zag positioned Linked List");
        printList(h1);
        System.out.println();
        
        System.out.println("case 2"); 
        System.out.println("h2 Linked List");
        printList(h2);
        h2 = addOne(h2);
        System.out.println("Zig Zag positioned Linked List");
        printList(h2);
        System.out.println();
        
        System.out.println("case 3"); 
        System.out.println("h3 Linked List");
        printList(h3);
        h3 = addOne(h3);
        System.out.println("Zig Zag positioned Linked List");
        printList(h3);
    }
 
   
    static Node addOne(Node head){
        int carry = recursiveAddCarry(head);
        if(carry > 0){//add a 1 at front if carry is 1
            Node temp = new Node(carry);
            temp.link = head;
            head = temp;
        }
        return head;
    }
    
    //recursive method
    static int recursiveAddCarry(Node head){
        if(head == null)
            return 1;//last digit need to be added 1 so return carry as 1
        int carry = recursiveAddCarry(head.link);
        int returnCarry = (head.data + carry) / 10;
        head.data = (head.data + carry) % 10;
        return returnCarry;
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
        Node head = new Node(9);
        Node two = new Node(9);
        Node three = new Node(9);
        Node four = new Node(9);
        Node five = new Node(9);
        
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        return head;
    }
    
    static void printList(Node head){
        Node traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data);
            traversePtr = traversePtr.link;
        }
        System.out.println(); 
    }
}
