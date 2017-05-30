/*
Function to check if a singly linked list is palindrome(using stack)
Given a singly linked list of characters, write a function that returns true if the given list 
is palindrome, else false.
*/
import java.util.Stack;
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
        /*------------------------case 1---------------------*/
        System.out.println("case 1");
        int size = 7;
        Node head = new Node(1);
        for (int value=2; value <= size; value++){
            head = insertNode(head,value);
        }
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        boolean isPallindrome = isPallindromeFunction(head);
        if(isPallindrome == true)
            System.out.println("is Pallindrome");
        else
            System.out.println("not a Pallindrome");
            
        /*------------------------case 2---------------------*/
        System.out.println("\ncase 2");
        head = createLinkedList();
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        isPallindrome = isPallindromeFunction(head);
        if(isPallindrome == true)
            System.out.println("is Pallindrome");
        else
            System.out.println("not a Pallindrome");
            
        
        /*------------------------case 3---------------------*/
        System.out.println("\ncase 3");
        head = createLinkedList2();
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        isPallindrome = isPallindromeFunction(head);
        if(isPallindrome == true)
            System.out.println("is Pallindrome");
        else
            System.out.println("not a Pallindrome");
            
        /*------------------------case 4---------------------*/
        System.out.println("\ncase 4");
        head = createLinkedList3();//contains only one element
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        isPallindrome = isPallindromeFunction(head);
        if(isPallindrome == true)
            System.out.println("is Pallindrome");
        else
            System.out.println("not a Pallindrome");
            
        /*------------------------case 5---------------------*/
        System.out.println("\ncase 5");
        head = null;
        System.out.println("original LinkedList : ");
        printLinkedList(head);
        
        isPallindrome = isPallindromeFunction(head);
        if(isPallindrome == true)
            System.out.println("is Pallindrome");
        else
            System.out.println("not a Pallindrome");
        
    }
    
    static boolean isPallindromeFunction(Node head){
        if(head == null)
            return true;
        Node ptr1 = head;//it will be middle of the LinkedList
        Node ptr2 = head;
        while(true){
            if (ptr2 == null || ptr2.link == null)
                break;
            ptr1 = ptr1.link;
            ptr2 = ptr2.link.link;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        Node temp = head;
        int count = 0;
        while(temp != ptr1.link){
            stack.push(temp.data);
            count++;
            temp = temp.link;
        }
        temp = ptr1.link;
        System.out.println("middle element = "+temp.data);
        if ((2*count) % 2 == 1)
            stack.pop();
            
        while(temp != null){
                if (!stack.isEmpty() && stack.pop() != temp.data)
                    return false;
                temp = temp.link;
        }
        return true;
    }
    
   
    static Node insertNode(Node head, int value){
        Node newNode = new Node(value);
        Node temp = head;
        while(temp.link != null){
            temp = temp.link;
        }
        temp.link = newNode;
        return head;
    }
    
    static void printLinkedList(Node head){
        if (head == null)
            System.out.println("null");
 
        else{
            Node temp = head;
            while(temp.link != null){
                System.out.print(temp.data+" --> ");
                temp = temp.link;
            }
            System.out.println(temp.data+" --> null");
        }
    }
    
    static Node createLinkedList(){
        Node one1 = new Node(1);
        Node two1 = new Node(2);
        Node two2 = new Node(2);
        Node three1 = new Node(3);
        Node three2 = new Node(3);
        Node one2 = new Node(1);
        
        one1.link = two1;
        two1.link = three1;
        three1.link = three2;
        three2.link = two2;
        two2.link = one2;
        return one1;
    }
    
    static Node createLinkedList2(){
        Node one1 = new Node(1);
        Node two1 = new Node(2);
        Node two2 = new Node(2);
        Node three1 = new Node(3);
        Node three2 = new Node(3);
        Node one2 = new Node(1);
        
        one1.link = two1;
        two1.link = three1;
        three1.link = two2;
        two2.link = one2;
        return one1;
    }
    
    static Node createLinkedList3(){
        Node one1 = new Node(1);
        Node two1 = new Node(2);
        Node two2 = new Node(2);
        Node three1 = new Node(3);
        Node three2 = new Node(3);
        Node one2 = new Node(1);
        
        /*one1.link = two1;
        two1.link = three1;
        three1.link = two2;
        two2.link = one2;*/
        return one1;
    }
}
