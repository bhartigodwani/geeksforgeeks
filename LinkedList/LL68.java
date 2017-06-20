/*
@author Bharti Godwani

Check if a linked list of strings forms a palindrome
Given a linked list handling string data, check to see whether data is palindrome or not?
For example,

Input  : a -> bc -> d -> dcb -> a -> NULL
Output : True
String "abcddcba" is palindrome.

Output : a -> bc -> d -> ba -> NULL
Output : False
String "abcdba" is not palindrome. 

Solution:
make a string out of Linked list and check whether its pallindrome or not
*/

import java.util.Stack;
class LL68{
    static class Node{
        String data;
        Node link;
        Node(String d){
            data = d;
            link = null;
        }
    }
    
    public static void main(String []args){
        System.out.println("case 1");
        Node h1 = createList();
        System.out.println("h1 linked list");
        printLinkedList(h1);
        boolean result = isPallindrome(h1);
        System.out.println((result == true) ? "list is pallindrome" : "list is not a pallindrome");
        
        System.out.println("\ncase 2");
        Node h2 = createList2();
        System.out.println("h2 linked list");
        printLinkedList(h2);
        result = isPallindrome(h2);
        System.out.println((result == true) ? "list is pallindrome" : "list is not a pallindrome");
        
        System.out.println("\ncase 3");
        Node h3 = createList3();
        System.out.println("h3 linked list");
        printLinkedList(h3);
        result = isPallindrome(h3);
        System.out.println((result == true) ? "list is pallindrome" : "list is not a pallindrome");
        
   }
       
    static boolean isPallindrome(Node head){
        if(head == null)
            return true;
        String str = "";
        Node t = head;
        while(t != null){
            str = str + t.data;
            t = t.link;
        }
        return isPallindromeUtil(str);
    }
    
    static boolean isPallindromeUtil(String str){
        int r=str.length()-1;
        for(int l=0; l<str.length()/2; l++){
            if(str.charAt(l) != str.charAt(r))
                return false;
            r--;
        }    
        return true;
    }
    
    static Node createList(){
        Node head = new Node("a");
        Node two = new Node("bc");
        Node three = new Node("d");
        Node four = new Node("dcb");
        Node five = new Node("a");
        
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = five;
        
        return head;
    }
    
    static Node createList2(){
        Node head = new Node("a");
        Node two = new Node("bc");
        Node three = new Node("d");
        Node four = new Node("ba");
        
        head.link = two;
        two.link = three;
        three.link = four;
        
        return head;
    }
    
    static Node createList3(){
        Node head = new Node("abcdef");
        Node two = new Node("b");
        Node three = new Node("c");
        
        head.link = two;
        two.link = three;
        return head;
    }
    
    static void printLinkedList(Node head){
        if (head == null)
            System.out.print("null");
 
        else{
            Node temp = head;
            while(temp.link != null){
                System.out.print(temp.data+" --> ");
                temp = temp.link;
            }
            System.out.println(temp.data+" --> null");
        }
    }
}
