/*
Alternating split of a given Singly Linked List
Write a function AlternatingSplit() that takes one list and divides up its nodes to make two smaller lists ‘a’ and ‘b’. The 
sublists should be made from alternating elements in the original list. So if the original list is 0->1->0->1->0->1 then one 
sublist should be 0->0->0 and the other should be 1->1->1. 
*/
class LinkedList{
    static class Node{
        int data;
        Node link;
        String visited;
        Node(int d){
            data = d;
            link = null;
        }
    }
    
    public static void main (String[] args) {
        int size = 6;
        Node head = createList();
        System.out.println("original linked list : ");
        printList(head);
        Node nodes[] = splitList(head);
        /*display both the split lists*/
        for(int i=0; i<nodes.length; i++){
            System.out.println((i+1)+" linked list");
            printList(nodes[i]);        
        }
        
    }

    static Node[] splitList(Node head){
        Node head1 = head;
        Node head2 = head.link;
        Node t1 = head1;
        Node t2 = head2;
        while(t2 != null && t2.link != null){
            t1.link = t1.link.link;
            t1 = t1.link;
            t2.link = t2.link.link;
            t2 = t2.link;
            if(t2.link == null)
                t1.link = t1.link.link;
        }
        
        Node nodes[] = {head1, head2};
        return nodes;
    }
    static Node createList(){
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
        return head;
    }
    
    
    static void printList(Node head){
        Node traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null\n"); 
    }
}
