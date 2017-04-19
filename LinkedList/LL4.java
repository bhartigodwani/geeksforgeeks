/*
  Delete Node at a given position in a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    // This is a "method-only" submission. 

Node Delete(Node head, int position) {
  if(position == 0){
      head = head.next;
  }
  else{
      int pos = 1;
      Node ptr = new Node();
      ptr = head;
      while(pos < position){
        ptr = ptr.next;
        pos++;
      } 
      
      ptr.next = ptr.next.next;
  }

    return head;
}
