/*
Identical Linked Lists
Two Linked Lists are identical when they have same data and arrangement of data is also same. For example Linked lists a 
(1->2->3) and b(1->2->3) are identical. . Write a function to check if the given two linked lists are identical.
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
        Node head1 = createList();
        System.out.println("1st linked list : ");
        printList(head1);
        
        Node head2 = createList2();
        System.out.println("2nd linked list : ");
        printList(head2);
        
        boolean result = areEqual(head1, head2);
        if(result == true)
            System.out.println("identical");
        else
            System.out.println("not identical");
        
    }

    static boolean areEqual(Node h1, Node h2){
        Node t1 = h1;
        Node t2 = h2;
        int flag = 0;
        while(t1 != null && t2 != null){
            if(t1.data != t2.data){
                flag = 1;
                break;
            }
            t1 = t1.link;
            t2 = t2.link;
        }
        if(flag == 1)
            return false;
        else if(t1 == null && t2 == null)
            return true;
        else
            return false;
        
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
