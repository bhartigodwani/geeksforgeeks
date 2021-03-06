/*deletion of tree can be best done by postorder traversal 
because we dont need to take any intermediate memory to save any node's data*/

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
        System.out.println("first tree");
        int size = 7;//number of nodes in complete tree
        Node rootNode = createBTree(size);
        displayBTree(rootNode);
        deleteTree(rootNode);
        rootNode = null;
        System.out.println("Tree is deleted");
        
        /*second tree*/
        System.out.println("\nsecond tree");
        rootNode = createBTree2();
        deleteTree(rootNode);
        rootNode = null;
        System.out.println("Tree is deleted");
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
        Node four = new Node(4);
        Node five = new Node(5);
        rootNode.rightChild = two;
        rootNode.rightChild.rightChild = three;
        rootNode.rightChild.rightChild.rightChild = four;
        rootNode.rightChild.rightChild.rightChild.rightChild = five;
        return rootNode;
    }
    
    static void deleteTree(Node node){
        if(node == null)
            return ;
        if(node.leftChild == null && node.rightChild == null){
            System.out.println("deleted node = "+node.data);
            node = null;
            return;
        }
        deleteTree(node.leftChild);
        deleteTree(node.rightChild);
        System.out.println("deleted node = "+node.data);
        node = null;
    }
}
