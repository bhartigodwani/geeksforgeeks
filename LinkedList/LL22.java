/*
Remove duplicates from a sorted linked list
Write a removeDuplicates() function which takes a list sorted in non-decreasing order and deletes any duplicate nodes from
the list. The list should only be traversed once.

For example if the linked list is 11->11->11->21->43->43->60 then removeDuplicates() should convert the list 
to 11->21->43->60.

Algorithm:
Traverse the list from the head (or start) node. While traversing, compare each node with its next node. If data of next 
node is same as current node then delete the next node. Before we delete a node, we need to store next pointer of the node
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
        /*---------------list of length = size------------------*/
        int size = 7;
        Node head = new Node(1);
        for (int value=1; value <= 5; value++){
            head = insertNode(head,value);
        }
        
        for (int value=5; value <= size; value++){
            head = insertNode(head,value);
        }
        head = insertNode(head,size);
        
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        System.out.println("\ndeleted LinkedList : ");
        head = removeDuplicates(head);
        printLinkedList(head);
        
        /*---------------list is empty---------------*/
        head = null;
        System.out.println("\n\noriginal LinkedList : ");
        printLinkedList(head);
        head = removeDuplicates(head);
        System.out.println("deleted LinkedList : ");
        printLinkedList(head);
         
        
    }
    
    static Node removeDuplicates(Node head){
        if (head == null){
            System.out.println("\nLinkedList is empty");
            return null;
        } 
        Node ptr = head;
        while(ptr.link != null){
            if(ptr.data == ptr.link.data)
                ptr = deleteNode(ptr, ptr.link);
            else    
                ptr = ptr.link;
        }
        return head;
    }
    
    static Node deleteNode(Node ptr, Node ptrLink){
        ptr.link = ptrLink.link;
        return ptr;
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
            System.out.print("null");
 
        else{
            Node temp = head;
            while(temp.link != null){
                System.out.print(temp.data+" --> ");
                temp = temp.link;
            }
            System.out.print(temp.data+" --> null");
        }
    }
}
