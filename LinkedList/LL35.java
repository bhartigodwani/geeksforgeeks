/*

Segregate even and odd nodes in a Linked List

Given a Linked List of integers, write a function to modify the linked list such that all even numbers appear before all the
odd numbers in the modified linked list. Also, keep the order of even and odd numbers same.

Examples:

Input: 17->15->8->12->10->5->4->1->7->6->NULL
Output: 8->12->10->4->6->17->15->5->1->7->NULL

Input: 8->12->10->5->4->1->6->NULL
Output: 8->12->10->4->6->5->1->NULL

// If all numbers are even then do not change the list
Input: 8->12->10->NULL
Output: 8->12->10->NULL

// If all numbers are odd then do not change the list
Input: 1->3->5->7->NULL
Output: 1->3->5->7->NULL
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
        Node head = new Node(1);
        for (int value=2; value <= size; value++){
            head = insertNode(head,value);
        }
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        System.out.println("new linked list");
        Node nodes[] = splitListEvenOdd(head);
        Node temp = nodes[0];
        head = temp;
        Node t2 = head; 
        while(temp.link != null){
            t2.link = temp.link;
            t2 = t2.link;
            temp = temp.link;
        }
        
        t2.link = nodes[1];
        printLinkedList(head);
            
        
        /*------------------------case 2---------------------*/
        System.out.println("\ncase 2");
        head = createLinkedList();
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        System.out.println("new linked list");
        nodes = splitListEvenOdd(head);
        temp = nodes[0];
        head = temp;
        t2 = head; 
        while(temp.link != null){
            t2.link = temp.link;
            t2 = t2.link;
            temp = temp.link;
        }
        
        t2.link = nodes[1];
        printLinkedList(head);
            
        
        /*------------------------case 3---------------------*/
        System.out.println("\ncase 3");
        head = createLinkedList2();
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        System.out.println("new linked list");
        nodes = splitListEvenOdd(head);
        temp = nodes[0];
        head = temp;
        t2 = head; 
        while(temp.link != null){
            t2.link = temp.link;
            t2 = t2.link;
            temp = temp.link;
        }
        
        t2.link = nodes[1];
        printLinkedList(head);
            
        /*------------------------case 4---------------------*/
        System.out.println("\ncase 4");
        head = createLinkedList3();//contains only one element
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        System.out.println("new linked list");
        nodes = splitListEvenOdd(head);
        temp = nodes[0];
        head = temp;
        t2 = head; 
        while(temp != null && temp.link != null){
            t2.link = temp.link;
            t2 = t2.link;
            temp = temp.link;
        }
        
        if(t2 != null){
            t2.link = nodes[1];
            printLinkedList(head);
        }
        else
            printLinkedList(head);
        
        /*------------------------case 5---------------------*/
        System.out.println("\ncase 5");
        head = null;
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        System.out.println("new linked list");
        nodes = splitListEvenOdd(head);
        temp = nodes[0];
        head = temp;
        t2 = head; 
        while(temp.link != null){
            t2.link = temp.link;
            t2 = t2.link;
            temp = temp.link;
        }
        
        t2.link = nodes[1];
        printLinkedList(head);
        
    }
    
    static Node[] splitListEvenOdd(Node head){
        Node head1 = null;
        Node head2 = null;
        Node even = head1;
        Node odd = head2;
        Node temp = head;
        int f1 = 0, f2 = 0;
        while(temp != null){
            if(temp.data % 2 == 0){
                if(f1 == 0){
                    head1 = temp;
                    even = head1;
                    f1 = 1;
                }
                else{
                    even.link = temp;
                    even = even.link;
                }
            }
            else{
                if(f2 == 0){
                    head2 = temp;
                    odd = head2;
                    f2 = 1;
                }
                else{
                    odd.link = temp;
                    odd = odd.link;
                }
            }
            temp = temp.link;
        }
        if(even != null && even.link != null)
             even.link = null;
        if(odd != null && odd.link != null)
            odd.link = null;
        
        Node nodes[] = {head1, head2};
        return nodes;
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
        Node one1 = new Node(1);
        Node two1 = new Node(2);
        Node two2 = new Node(2);
        Node three1 = new Node(3);
        Node three2 = new Node(3);
        Node one2 = new Node(1);
        
        one1.link = two1;
        two1.link = three1;
        three1.link = three2;
        three2.link = two2;
        two2.link = one2;
        return one1;
    }
    
    static Node createLinkedList2(){
        Node one1 = new Node(1);
        Node two1 = new Node(2);
        Node two2 = new Node(2);
        Node three1 = new Node(3);
        Node three2 = new Node(3);
        Node one2 = new Node(1);
        
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
