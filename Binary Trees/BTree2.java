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
        int size = 7;//number of nodes in complete tree
        
        /*first tree*/
        Node rootNode = createBTree(size);
        System.out.println("First tree");
        displayBTree(rootNode);
        System.out.println("\ninOrderTraversal");
        inOrderTraversal(rootNode);
        System.out.println("\npreOrderTraversal");
        preOrderTraversal(rootNode);
        System.out.println("\npostOrderTraversal");
        postOrderTraversal(rootNode);
        
        /*Second tree*/
        rootNode = createBTree2();
        System.out.println("\n\nSecond tree");
        displayBTree2(rootNode);
        System.out.println("\ninOrderTraversal");
        inOrderTraversal(rootNode);
        System.out.println("\npreOrderTraversal");
        preOrderTraversal(rootNode);
        System.out.println("\npostOrderTraversal");
        postOrderTraversal(rootNode);
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
        rootNode.rightChild.leftChild = three;
        return rootNode;
    }
    
    static void displayBTree2(Node rootNode){
        System.out.println(rootNode.data);
        System.out.print(rootNode.rightChild.data+"\n");
        System.out.println(rootNode.rightChild.leftChild.data);
    }
    
    static void inOrderTraversal(Node node){
        if(node == null)
            return ;
        
        if(node.leftChild == null && node.rightChild == null){
            System.out.print(node.data+"\t");
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.print(node.data+"\t");
        inOrderTraversal(node.rightChild);
    }
    
    static void preOrderTraversal(Node node){
        if(node == null)
            return ;
        if(node.leftChild == null && node.rightChild == null){
            System.out.print(node.data+"\t");
            return;
        }
        System.out.print(node.data+"\t");
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }
    
    static void postOrderTraversal(Node node){
        if(node == null)
            return ;
        if(node.leftChild == null && node.rightChild == null){
            System.out.print(node.data+"\t");
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.print(node.data+"\t");
    }
}
