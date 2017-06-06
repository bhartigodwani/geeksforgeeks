/*
Reverse a Linked List in groups of given size
Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
Example:
Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
Output:  3->2->1->6->5->4->8->7->NULL. 

Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
Output:  5->4->3->2->1->8->7->6->NULL. 
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
        int size = 7;
        Node head = new Node(1);
        for (int value=2; value <= 8; value++){
            head = insertNode(head,value);
        }
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        System.out.println("reversed linked list");
        head = reverseListByK(head, 3);
        printLinkedList(head);
            
        
        /*------------------------case 2---------------------*/
        System.out.println("\ncase 2");
        head = createLinkedList();
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        System.out.println("reversed linked list");
        head = reverseListByK(head, 3);
        printLinkedList(head);
            
        
        /*------------------------case 3---------------------*/
        System.out.println("\ncase 3");
        head = createLinkedList2();
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        System.out.println("reversed linked list");
        head = reverseListByK(head, 3);
        printLinkedList(head);
            
        /*------------------------case 4---------------------*/
        System.out.println("\ncase 4");
        head = createLinkedList3();//contains only one element
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        System.out.println("reversed linked list");
        head = reverseListByK(head, 3);
        printLinkedList(head);
        
        /*------------------------case 5---------------------*/
        System.out.println("\ncase 5");
        head = null;
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        System.out.println("reversed linked list");
        head = reverseListByK(head, 3);
        printLinkedList(head);
        
    }
    
    static Node reverseListByK(Node head, int k){
        if(head != null){
            int flagForHead = 0;
            int count = 0;
            Node prev = null;
            Node current = head;
            Node next = null;
            Node first, second;
            first = head;
            while(count < k && current != null){
                next = current.link;
                current.link = prev;
                prev = current;
                current = next;
                count++;
            }
            head = prev;
            while(current != null){
                second = current;
                prev = null;
                next = null;
                count = 0;
                while(count < k && current != null){
                    next = current.link;
                    current.link = prev;
                    prev = current;
                    current = next;
                    count++;
                }
                first.link = prev;
                first = second;
            }
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
