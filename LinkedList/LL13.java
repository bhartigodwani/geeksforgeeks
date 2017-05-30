/*
Write a program function to detect loop in a linked list
Solution:
1. Use Hashing:
Traverse the list one by one and keep putting the node addresses in a Hash Table. At any point, 
if NULL is reached then return false and if next of current node points to any of the previously 
stored nodes in Hash then return true.

2. Mark Visited Nodes:
This solution requires modifications to basic linked list data structure.  Have a visited flag 
with each node.  Traverse the linked list and keep marking visited nodes.  If you see a visited
node again then there is a loop. This solution works in O(n) but requires additional information
with each node.
A variation of this solution that doesn't require modification to basic data structure can be
implemented using hash.  Just store the addresses of visited nodes in a hash and if you see an 
address that already exists in hash then there is a loop.

3. Floyd's Cycle-Finding Algorithm:
This is the fastest method. Traverse linked list using two pointers.  Move one pointer by one and 
other pointer by two.  If these pointers meet at some node then there is a loop.  If pointers do 
not meet then linked list doesn't have loop.
*/
class LinkedList{
    static class Node{
        int data;
        Node link;
        String visited;
        Node(int d){
            data = d;
            visited = "no";
            link = null;
        }
    }
    public static void main (String[] args) {
        /*-------------------------------using marked visit-------------------------*/
        System.out.println("Using marked visit : \n");
        /*-------------------------------case 1---------------------------------------*/
        System.out.println("case 1");
        int size = 7;
        Node head = new Node(1);
        for (int i=2; i<=size; i++)
            head = createNode(i,head);
        boolean ifLoop = findLoopVisited(head);
        if(ifLoop == true)
            System.out.println("loop exist");
        else
            System.out.println("loop doesnot exist");
            
        /*-------------------------------case 2---------------------------------------*/
        /*------------------------------------only one node exist----------------------*/
        System.out.println("case 2");
        size = 1;
        head = new Node(1);
        for (int i=2; i<=size; i++)
            head = createNode(i,head);
        ifLoop = findLoopVisited(head);
        if(ifLoop == true)
            System.out.println("loop exist");
        else
            System.out.println("loop doesnot exist");
            
        /*-------------------------------case 3---------------------------------------*/
        /*-------------------------------loop exist------------------------------------*/
        System.out.println("case 3");
        head = createLoopLinkedList();
        ifLoop = findLoopVisited(head);
        if(ifLoop == true)
            System.out.println("loop exist");
        else
            System.out.println("loop doesnot exist");
        
        
        /*-------------------------------case 4---------------------------------------*/
        /*-------------------------------empty LinkedList-----------------------------*/
        System.out.println("case 4");
        head = null;
        ifLoop = findLoopVisited(head);
        if(ifLoop == true)
            System.out.println("loop exist");
        else
            System.out.println("loop doesnot exist");
            
            
    
        /*-------------------------------using floyd cycle's algorithm-------------------------*/
        System.out.println("\nUsing floyd cycle's algorithm : \n");
        /*-------------------------------case 1---------------------------------------*/
        System.out.println("case 1");
        size = 7;
        head = new Node(1);
        for (int i=2; i<=size; i++)
            head = createNode(i,head);
        ifLoop = findLoopFloyd(head);
        if(ifLoop == true)
            System.out.println("loop exist");
        else
            System.out.println("loop doesnot exist");
            
        /*-------------------------------case 2---------------------------------------*/
        /*------------------------------------only one node exist----------------------*/
        System.out.println("case 2");
        size = 1;
        head = new Node(1);
        for (int i=2; i<=size; i++)
            head = createNode(i,head);
        ifLoop = findLoopFloyd(head);
        if(ifLoop == true)
            System.out.println("loop exist");
        else
            System.out.println("loop doesnot exist");
            
        /*-------------------------------case 3---------------------------------------*/
        /*-------------------------------loop exist------------------------------------*/
        System.out.println("case 3");
        head = createLoopLinkedList();
        ifLoop = findLoopFloyd(head);
        if(ifLoop == true)
            System.out.println("loop exist");
        else
            System.out.println("loop doesnot exist");
        
        
        /*-------------------------------case 4---------------------------------------*/
        /*-------------------------------empty LinkedList-----------------------------*/
        System.out.println("case 4");
        head = null;
        ifLoop = findLoopFloyd(head);
        if(ifLoop == true)
            System.out.println("loop exist");
        else
            System.out.println("loop doesnot exist");        
    }
    
    static Node createNode(int value, Node head){
        Node newNode = new Node(value);
        Node temp = head;
        while(temp.link != null){
            temp = temp.link;
        }
        temp.link = newNode;
        return head;
    }
    
    static boolean findLoopVisited(Node head){
        if(head == null)
            return false;
        else{
            Node temp = head;
            while(temp != null && temp.visited.equals("no")){
                temp.visited = "yes";
                temp = temp.link;
            }
            if(temp != null && temp.visited.equals("yes"))
                return true;
            else
                return false;
        }
    }
    
    static boolean findLoopFloyd(Node head){
        if(head == null)
            return false;
            
        if (head.link != null){ 
            Node ptr1 = head;
            Node ptr2 = head;
            while(ptr2.link != null){
                ptr1 = ptr1.link;
                ptr2 = ptr2.link.link;
                if(ptr1 == ptr2){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    static Node createLoopLinkedList(){
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        head.link = two;
        two.link = three;
        three.link = four;
        four.link = two;
        return head;
    }
}
