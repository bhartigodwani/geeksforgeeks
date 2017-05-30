/*
Given a linked list which is sorted, how will you insert in sorted way
Algorithm: 
Let input linked list is sorted in increasing order.

1) If Linked list is empty then make the node as head and return it.
2) If value of the node to be inserted is smaller than value of head node
    then insert the node at start and make it head.
3) In a loop, find the appropriate node after which the input node (let 9) is
    to be inserted. To find the appropriate node start from head, keep moving 
    until you reach a node GN (10 in the below diagram) who's value is 
    greater than the input node. The node just before GN is the appropriate
    node (7).
4) Insert the node (9) after the appropriate node (7) found in step 3.
*/
class LinkedList{
    static class Node{
        int data;
        Node link;
        String visited;
        Node(int d){
            data = d;
            visited = "no";
            link = null;
        }
    }
    public static void main (String[] args) {
        /*-------------------case 1-------------------*/
        System.out.println("case 1");
        System.out.println("insertion at last");
        int size = 7;
        Node head = new Node(1);
        for (int value=2; value <= size; value++){
            head = insertNode(head,value);
        }
        System.out.println("original LinkedList : ");
        printLinkedList(head);

        int element = 17;
        System.out.println("node to be inserted is : "+element);

        head = insertionInSortedLL(element, head);
        printLinkedList(head);
        
        /*-------------------case 2-------------------*/
        System.out.println("\ncase 2");
        System.out.println("insertion in middle");
        size = 14;
        head = new Node(1);
        for (int value=3; value <= size; value=value+2){
            head = insertNode(head,value);
        }
        System.out.println("original LinkedList : ");
        printLinkedList(head);

        element = 12;
        System.out.println("node to be inserted is : "+element);

        head = insertionInSortedLL(element, head);
        printLinkedList(head);
        
        /*-------------------case 3-------------------*/
        System.out.println("\ncase 3");
        System.out.println("insertion at first");
        size = 14;
        head = new Node(1);
        for (int value=3; value <= size; value=value+2){
            head = insertNode(head,value);
        }
        System.out.println("original LinkedList : ");
        printLinkedList(head);

        element = 0;
        System.out.println("node to be inserted is : "+element);

        head = insertionInSortedLL(element, head);
        printLinkedList(head);
    }
    
    static Node insertionInSortedLL(int element, Node head){
        Node temp = head;
        Node ptr1,ptr2;
        if(element < temp.data){
            head = insertNodeInLL(head, element, null, head);
        }
        else{
            while(temp.link != null){
                if(temp.data <= element && temp.link.data > element){
                    head = insertNodeInLL(head, element, temp, temp.link);
                    break;
                }
                temp = temp.link;
            }
            if (temp.link == null) {
                head = insertNodeInLL(head, element, temp, null);
            }
        }
        return head;
    }

    static Node insertNodeInLL(Node head, int element, Node ptr1, Node ptr2){
        Node newNode = new Node(element);
        if (ptr1 == null) {
            newNode.link = ptr2;
            head = newNode;
        }
        else if (ptr2 == null) {
            ptr1.link = newNode;
        }
        else{
            newNode.link = ptr2;
            ptr1.link = newNode;
            
        }
        return head;
    }

    static Node insertNode(Node head, int value){//or creating the Linkedlist
        Node newNode = new Node(value);
        Node temp = head;
        while(temp.link != null){
            temp = temp.link;
        }
        temp.link = newNode;
        return head;
    }

    static boolean findLoopVisited(Node head){
        if(head == null)
            return false;
        else{
            Node temp = head;
            while(temp != null && temp.visited.equals("no")){
                temp.visited = "yes";
                temp = temp.link;
            }
            if(temp != null && temp.visited.equals("yes"))
                return true;
            else
                return false;
        }
    }
    
    static boolean findLoopFloyd(Node head){
        if(head == null)
            return false;
            
        if (head.link != null){ 
            Node ptr1 = head;
            Node ptr2 = head;
            while(ptr2.link != null){
                ptr1 = ptr1.link;
                ptr2 = ptr2.link.link;
                if(ptr1 == ptr2){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    static Node createLoopLinkedList(){
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = two;
        return head;
    }
    
     static void printLinkedList(Node head){
        if (head == null)
            System.out.print("null");
 
        else{
            Node temp = head;
            while(temp.link != null){
                System.out.print(temp.data+" --> ");
                temp = temp.link;
            }
            System.out.println(temp.data+" --> null");
        }
    }
}
