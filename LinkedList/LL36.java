/*
Detect and Remove Loop in a Linked List
Write a function detectAndRemoveLoop() that checks whether a given Linked List contains loop and if loop is present then
removes the loop and returns true. And if the list doesn’t contain loop then returns false. Below diagram shows a linked 
list with a loop. detectAndRemoveLoop() must change the below list to 1->2->3->4->5->NULL.
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
        
        System.out.println();
        System.out.println("new linked list");
        head = detectAndRemove(head);
        printLinkedList(head);
            
        
        /*------------------------case 2---------------------*/
        System.out.println("\ncase 2");
        head = createLinkedList();
        //System.out.println("original LinkedList : ");
        //printLinkedList(head);
        
        System.out.println("new linked list");
        head = detectAndRemove(head);
        printLinkedList(head);
            
        
        /*------------------------case 3---------------------*/
        System.out.println("\ncase 3");
        head = createLinkedList2();
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        System.out.println("new linked list");
        head = detectAndRemove(head);
        printLinkedList(head);
            
        /*------------------------case 4---------------------*/
        System.out.println("\ncase 4");
        head = createLinkedList3();//contains only one element
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        System.out.println("new linked list");
        head = detectAndRemove(head);
        printLinkedList(head);
        
        /*------------------------case 5---------------------*/
        System.out.println("\ncase 5");
        head = null;
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        System.out.println("new linked list");
        head = detectAndRemove(head);
        printLinkedList(head);
    }
    
    static Node detectAndRemove(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.link != null && slow != fast){
            slow = slow.link;
            fast = fast.link.link;
        }
        if(fast == null || fast.link == null){
            System.out.println("no loop exist");
            return head;
        }
        else{
            System.out.println("loop exist");
            slow = head;
            while(slow.link != fast.link){
                slow = slow.link;
                fast = fast.link;
            }
            fast.link = null;
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
