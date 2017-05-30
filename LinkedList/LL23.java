/*
Remove duplicates from an unsorted linked list
Write a removeDuplicates() function which takes a list and deletes any duplicate nodes from the list. The list is not sorted.
For example if the linked list is 12->11->12->21->41->43->21 then removeDuplicates() should convert the list to 
12->11->21->41->43.
*/
import java.util.HashMap;
class LinkedList{
    static class Node{
        int data;
        Node link;
        String visited = "no";
        Node(int d){
            data = d;
            link = null;
        }
    }
    public static void main (String[] args) {
        /*---------------list of length = size------------------*/
        int size = 7;
        Node head = createLinkedList();
        
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        System.out.println("\nunique LinkedList : ");
        head = removeDuplicates(head);
        printLinkedList(head);
        
        /*---------------list is empty---------------*/
        head = null;
        System.out.println("\n\noriginal LinkedList : ");
        printLinkedList(head);
        head = removeDuplicates(head);
        System.out.println("unique LinkedList : ");
        printLinkedList(head);
         
        
    }
    
    static Node removeDuplicates(Node head){
        if (head == null){
            System.out.println("\nLinkedList is empty");
            return null;
        } 
        
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        Node ptr = head;
        Node current = null;
        while(ptr != null){
            if(map.containsKey(ptr.data)){
                ptr = deleteNode(current, ptr);
            }
            else{    
                map.put(ptr.data, "yes");
                current = ptr;
                ptr = ptr.link;
            }
        }
        return head;
    }
    
    static Node deleteNode(Node current, Node ptr){
        current.link = ptr.link;
        ptr = ptr.link;
        return ptr;
    }
    
    static Node createLinkedList(){
        Node head = new Node(2);
        Node two = new Node(2);
        Node one1 = new Node(1);
        Node one2 = new Node(1);
        Node three1 = new Node(3);
        
        head.link = one1;
        one1.link = three1;
        three1.link = two;
        two.link = one2;
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
