/*
Design a stack with operations on middle element
How to implement a stack which will support following operations in O(1) time complexity?
1) push() which adds an element to the top of stack.
2) pop() which removes an element from top of stack.
3) findMiddle() which will return middle element of the stack.
4) deleteMiddle() which will delete the middle element.
Push and pop are standard stack operations.

The important question is, whether to use a linked list or array for implementation of stack?

Please note that, we need to find and delete middle element. Deleting an element from middle is not O(1) for array. Also, 
we may need to move the middle pointer up when we push an element and move down when we pop(). In singly linked list, moving
middle pointer in both directions is not possible.

The idea is to use Doubly Linked List (DLL). We can delete middle element in O(1) time by maintaining mid pointer. We can 
move mid pointer in both directions using previous and next pointers. 
*/

class Stack12{
    static Node middleElement;
    static int count = 0;

    static class Node{
        int data;
        Node prev;
        Node next;
        Node(int d){
            data = d;
            prev = next = null;
        }
    }
    
    public static void main (String[] args) {
        Node top = null;
        top = pushStack(1, top);
        System.out.println("pushed element = "+top.data);
        
        System.out.println("\nstack left = ");
        Node temp = top;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.prev;
        }
        System.out.println("\nmid element = "+middleElement.data);
        
        top = pushStack(2, top);
        System.out.println("\npushed element = "+top.data);
        top = pushStack(3, top);
        System.out.println("\npushed element = "+top.data);
        top = popStack(top);
        top = pushStack(4, top);
        System.out.println("\npushed element = "+top.data);
        
        System.out.println("\nstack left = ");
        temp = top;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.prev;
        }
        System.out.println("\nmid element = "+middleElement.data);
        
        top = popStack(top);
        top = pushStack(5, top);
        System.out.println("\npushed element = "+top.data);
        top = pushStack(6, top);
        System.out.println("\npushed element = "+top.data);
        
        
        System.out.println("\nstack left = ");
        temp = top;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.prev;
        }
        System.out.println("\nmid element = "+middleElement.data);
    }
    
    static Node pushStack(int value, Node top){
        count++;
        Node newNode = new Node(value);
        if(top == null){
            middleElement = newNode;
        }
        else{
            if(count % 2 == 1){
                middleElement = middleElement.next;
            }
            newNode.prev = top;
            top.next = newNode;
        }

        top = newNode;
        return top;
    }
    
    static Node popStack(Node top){
        if(top == null){
            System.out.println("\nstack is empty");
            return null;
        }
        if(count % 2 == 1)
            middleElement = middleElement.prev;
        System.out.println("\npopped element = "+top.data);
        top = top.prev;
        count--;
        return top;
    }
    
}
