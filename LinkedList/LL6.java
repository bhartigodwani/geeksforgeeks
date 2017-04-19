/*
  Compare two linked lists A and B
  Return 1 if they are identical and 0 if they are not. 
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

int CompareLists(Node headA, Node headB) {
    if(headA == null && headB == null)
        return 1;
    if((headA == null && headB != null) || (headA != null && headB == null))
        return 0;
    else{
        Node ptr1 = new Node();
        Node ptr2 = new Node();
        ptr1 = headA;
        ptr2 = headB;
        int flag = 0;
        while(ptr1!=null && ptr2!=null){
            if(ptr1.data != ptr2.data){
                flag = 1;
                break;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        if(flag == 1 || ptr1!=null || ptr2!=null)
            return 0;
        else
            return 1;
        
     
    }
    
}
