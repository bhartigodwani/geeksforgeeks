/*
mergesort on linkedlist
*/
class LinkedList{
    static class Node{
        int data;
        Node next;
        String visited;
        Node(int d){
            data = d;
            next = null;
        }
        Node(){
            next = null;
        }
    }
    
    public static void main (String[] args) {
        int size = 6;
        Node head1 = createList();
        System.out.println("1st linked list : ");
        printList(head1);
        mergeSort(head1);
        System.out.println("sorted linked list : ");
        printList(head1);
    }

    static Node mergeSort(Node head){
    if ((head == null)||(head.next == null)){
        return head;
    }
    Node left = head;
    Node right = head.next;
    while((right != null) && right.next != null){
        head = head.next;
        right = right.next.next;
    }
    right = head.next;
    head.next = null;
    return merge(mergeSort(left), mergeSort(right));
    }

    static Node merge(Node left, Node right){
        Node head = new Node ();
        Node temp = head;
        while((left != null) && (right !=null)){
            if(left.data <= right.data ){
                temp.next = left;
                temp = left;
                left = left.next;
            }
            else{
                temp.next = right;
                temp = right; 
                right = right.next;
            }
        }
        if(right == null)
            temp.next = left;
        else
            temp.next = right;
        return head.next;
    }  
    
    static Node createList(){
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        
        head.next = seven;
        seven.next = six;
        six.next = four;
        four.next = three;
        three.next = two;
        /*two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;*/
        return head;
    }
    
    static Node createList2(){
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        /*head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        five.link = six;
        */
        return head;
    }
    
    static void printList(Node head){
        Node traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.next;
        }
        System.out.println("null\n"); 
    }
}
