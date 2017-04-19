/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
Node Insert(Node head,int data) {
    Node newNode = new Node();
    newNode.data = data;
    newNode.next = null;
    
    if(head == null){
        head = newNode;
    }
    else{
        Node ptr = new Node();
        ptr = head;
        while(ptr.next != null){
            ptr = ptr.next;
        }
        
        ptr.next = newNode;
    }
    return head;
}
 
