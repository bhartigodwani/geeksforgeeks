/*
@author Bharti Godwani
Rearrange a linked list such that all even and odd positioned nodes are together

Rearrange a linked list in such a way that all odd position nodes are together and all even positions node are together,

Examples:

Input:   1->2->3->4
Output:  1->3->2->4

Input:   10->22->30->43->56->70
Output:  10->30->56->22->43->70

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
        
        System.out.println("case 1"); 
        System.out.println("h1 Linked List");
        printList(h1);
        evenOddList(h1);
        System.out.println("even odd positioned Linked List");
        printList(h1);
        System.out.println();
        
        System.out.println("case 2"); 
        System.out.println("h2 Linked List");
        printList(h2);
        evenOddList(h2);
        System.out.println("even odd positioned Linked List");
        printList(h2);
        System.out.println();
        
        System.out.println("case 3"); 
        System.out.println("h3 Linked List");
        printList(h3);
        evenOddList(h3);
        System.out.println("even odd positioned Linked List");
        printList(h3);
    }
 
    static Node evenOddList(Node head){
        if(head == null || head.link == null)
            return head;
        else{
            Node h1 = head;
            Node h2 = head.link;
            Node mergePtr = h2;
            while(h2 != null && h2.link != null){
                h1.link = h1.link.link;
                h2.link = h2.link.link;
                h1 = h1.link;
                h2 = h2.link;
            }
            h1.link = mergePtr;
            return head;
        }

    }
    
    static Node createList1(){
        Node head = new Node('1');
        Node two = new Node('2');
        Node three = new Node('3');
        Node four = new Node('4');
        Node five = new Node('5');
        Node six = new Node('6');
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        five.link = six;
        return head;
    }

    static Node createList2(){
        Node head = new Node('1');
        Node two = new Node('2');
        Node three = new Node('3');
        Node four = new Node('4');
        Node five = new Node('5');
        Node six = new Node('6');
        Node seven = new Node('7');
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        five.link = six;
        six.link = seven;
        
        return head;
    }
    
    static Node createList3(){
        Node head = new Node('1');
        Node two = new Node('2');
        Node three = new Node('3');
        Node four = new Node('4');
        Node five = new Node('5');
        Node six = new Node('6');
        
        head.link = two;
        /*two.link = three;
        three.link = four;
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
