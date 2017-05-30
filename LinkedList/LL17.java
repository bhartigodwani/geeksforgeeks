/*
Given only a pointer/reference to a node to be deleted in a singly linked list, how do you delete it?
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
        /*---------------when node is first or in between------------------*/
        Node head = new Node(5);//just to check we have a record of head ptr
        Node nodePointer = createLinkedList(head);//return node to be deleted
        System.out.println("original LinkedList");
        printLinkedList(head);
        System.out.println("\nnode to be delete is : "+nodePointer.data);
        deleteNode(nodePointer);

        System.out.println("LinkedList after deletion is :");
        printLinkedList(head);
    }
    
    static Node createLinkedList(Node head){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        head.link = one;
        one.link = two;
        two.link = three;
        three.link = four;
        return two;
    }
    
    static void deleteNode(Node nodePointer){
        if (nodePointer.link == null)
            nodePointer = null;
        else{
            nodePointer.data = nodePointer.link.data;
            nodePointer.link = nodePointer.link.link;
        }
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
