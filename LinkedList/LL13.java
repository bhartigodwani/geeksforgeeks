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
        size = 1;
        head = new Node(1);
        for (int i=2; i<=size; i++)
            head = createNode(i,head);
        ifLoop = findLoopVisited(head);
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
            if(temp.visited.equals("yes"))
                return true;
            else
                return false;
        }
    }
}
