import java.util.Queue;
import java.util.LinkedList;
class BTree{
    static class Node{
        int data;
        Node leftChild;
        Node rightChild;
        Node(int d){
            data = d;
            leftChild = rightChild = null;
        }
    }
    
    public static void main (String[] args) {
        int size = 7;
        Node rootNode = createTree(size);
        displayTree(rootNode);
    }
    
    static Node createTree(int size){
        Queue<Node> que = new LinkedList();
        int value = 1;
        Node rootNode = new Node(value);
        que.add(rootNode);
        while(value <= size){
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
    
    static void displayTree(Node rootNode){
        System.out.println(rootNode.data);
        System.out.println(rootNode.leftChild.data+"\t"+rootNode.rightChild.data);
        System.out.println(rootNode.leftChild.leftChild.data+"\t"+rootNode.leftChild.rightChild.data+"\t"+rootNode.rightChild.leftChild.data+"\t"+rootNode.rightChild.rightChild.data);
    }
}
