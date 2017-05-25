import java.util.Queue;
import java.util.LinkedList;
class BTree{
    static class Node{
        int data;
        Node leftChild;
        Node rightChild;
        Node(int d){
            data = d;
            leftChild = rightChild =null;
        }
    }
    
    public static void main (String[] args) {
        /*first tree*/
        
        System.out.println("first case");
        int size = 7;//number of nodes in complete tree
        Node rootNode1 = createBTree(size);
        Node rootNode2 = createBTree(size);
        System.out.println("first tree");
        displayBTree(rootNode1);
        System.out.println("second tree");        
        displayBTree(rootNode2);
        int flag = sameTree(rootNode1, rootNode2);
        if (flag == 1) 
            System.out.println("both the trees are same");
            
        else
            System.out.println("both are different");
        
        /*second case*/
        System.out.println("\nsecond case");
        rootNode1 = null;
        rootNode2 = null;
        flag = sameTree(rootNode1, rootNode2);
        if (flag == 1) 
            System.out.println("both the trees are same");
            
        else
            System.out.println("both are different");
        
        /*third case*/
        System.out.println("\nthird case");
        rootNode1 = createBTree(size);
        rootNode2 = createBTree2();
        flag = sameTree(rootNode1, rootNode2);
        if (flag == 1) 
            System.out.println("both the trees are same");
            
        else
            System.out.println("both are different");
            
        /*fourth case*/
        System.out.println("\nfourth case");
        rootNode1 = createBTree(size);
        rootNode2 = null;
        flag = sameTree(rootNode1, rootNode2);
        if (flag == 1) 
            System.out.println("both the trees are same");
            
        else
            System.out.println("both are different");
    }
    
    static Node createBTree(int size){
        Queue<Node> que = new LinkedList<Node>();
        int value = 1;
        Node rootNode = new Node(value);
        que.add(rootNode);
        while(value < size){
            Node node = que.poll();
            Node leftChild = new Node(++value);
            Node rightChild = new Node(++value);
            node.leftChild = leftChild;
            node.rightChild = rightChild;
            que.add(leftChild);
            que.add(rightChild);
        }
        return rootNode;
    }
    
    static void displayBTree(Node rootNode){
        System.out.println(rootNode.data);
        System.out.println(rootNode.leftChild.data+"\t"+rootNode.rightChild.data);
        System.out.print(rootNode.leftChild.leftChild.data+"\t"+rootNode.leftChild.rightChild.data+"\t");
        System.out.println(rootNode.rightChild.leftChild.data+"\t"+rootNode.rightChild.rightChild.data);
    }
    
    static Node createBTree2(){
        Node rootNode = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        rootNode.rightChild = two;
        rootNode.rightChild.rightChild = three;
        return rootNode;
    }
    
    static int sameTree(Node rootNode1, Node rootNode2){
        if (rootNode1 == null && rootNode2 == null) 
            return 1;
        
        if ((rootNode1 == null && rootNode2 != null) || (rootNode2 == null && rootNode1 != null))
            return 0;
            
        Queue<Node> que1 = new LinkedList<Node>();
        Queue<Node> que2 = new LinkedList<Node>();
        que1.add(rootNode1);
        que2.add(rootNode2);
        
        int flag = 1;
        while(!que1.isEmpty() && !que2.isEmpty()){
            Node n1 = que1.poll();
            Node n2 = que2.poll();
            if (n1.data != n2.data){
                flag = 0;
                break;
            } 
            
            if (n1.leftChild != null && n2.leftChild != null){ 
                if(n1.leftChild.data == n2.leftChild.data){
                    que1.add(n1.leftChild);
                    que2.add(n2.leftChild);
                }
                else{
                    flag = 0;
                    break;
                }
            }

            if (n1.rightChild != null && n2.rightChild != null){ 
                if(n1.rightChild.data == n2.rightChild.data){
                    que1.add(n1.rightChild);
                    que2.add(n2.rightChild);
                }
                else{
                    flag = 0;
                    break;
                }
            }            
        }
       
        return flag;
    }

}
