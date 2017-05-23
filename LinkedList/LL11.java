class LinkedList{
    static Node head;
    
    static class Node{
        int data;
        Node link;
        Node(int d){
            data = d;
            link = null;
        }
    }
    public static void main (String[] args) {
        int a[] = {1,2,3,4,5,6,7,8};
        LinkedList ll = new LinkedList();
        ll.head = new Node(a[0]);
        
        /*linked list creation*/
        createLinkedList(a,head);
        System.out.println("original LinkedList :");
        Node traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null");
        
        /*find frequency of the given element in a LinkedList*/
        traversePtr = head;
        Node ptr1 = head, ptr2 = head, ptr3 = head, ptr4 = head;
        int el1 = 3, el2 = 6;
        int flag1 = 0, flag2 = 0;
        while(traversePtr.link != null){
            if (traversePtr.link.data == el1){
                ptr1 = traversePtr;
                ptr2 = traversePtr.link.link;
                flag1 = 1;
            }
            
            if (traversePtr.link.data == el2){
                ptr3 = traversePtr;
                ptr4 = traversePtr.link.link;
                flag2 = 1;
            }
            if (flag1 == 1 && flag2 == 1)
                break;
            
            traversePtr = traversePtr.link;
        }
        
        System.out.println("ptr1 = "+ptr1.data);
        System.out.println("ptr2 = "+ptr2.data);
        System.out.println("ptr3 = "+ptr3.data);
        System.out.println("ptr4 = "+ptr4.data);
        
        Node temp1 = ptr3;
        Node temp2 = ptr4;
        ptr3.link = ptr1.link;
        ptr1.link = ptr4;
        ptr1.link = temp1.link;
        temp1.link.link = temp2;
        
        traversePtr = head;
        while(traversePtr != null){
            System.out.print(traversePtr.data+" --> ");
            traversePtr = traversePtr.link;
        }
        System.out.println("null");
    }
    
    static void createLinkedList(int []a, Node head){
        Node ptr = head;
        for (int i=1; i<a.length; i++){
            Node node = new Node(a[i]);
            ptr.link = node;
            ptr = ptr.link;
        }
    }
}
