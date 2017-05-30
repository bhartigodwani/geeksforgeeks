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
        /*-------------------------------using marked visite-------------------------*/
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
        if (head.link != null){ 
            Node ptr1 = head;
            Node ptr2 = head;
            while(ptr2.link != null || ptr1 != ptr2){
                ptr1 = ptr1.link;
                ptr2 = ptr2.link.link;
            }
            if(ptr2 == null)
                return false;
            else if(ptr1 == ptr2)
                return true;
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
