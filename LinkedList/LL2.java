/*
  Insert Node at a given position in a linked list 
  head can be NULL 
  First element in the linked list is at position 0
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    

Node InsertNth(Node head, int data, int position) {
  Node newNode = new Node();
    newNode.data = data;
    int pos = 1;
    Node ptr1 = new Node();
    ptr1 = head;
    while(pos < position){
        ptr1 = ptr1.next;
        pos++;
    }
    
    if(position == 0){
        newNode.next = head;
        head = newNode;
    }
    else{
        newNode.next = ptr1.next;
        ptr1.next = newNode;
    }
    return head;
}
