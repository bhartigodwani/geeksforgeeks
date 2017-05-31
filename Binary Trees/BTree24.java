/*
How to determine if a binary tree is height-balanced?
A tree where no leaf is much farther away from the root than any other leaf. Different balancing schemes allow different 
definitions of “much farther” and different amounts of work to keep them balanced.

Consider a height-balancing scheme where following conditions should be checked to determine if a binary tree is balanced.
An empty tree is height-balanced. A non-empty binary tree T is balanced if:
1) Left subtree of T is balanced
2) Right subtree of T is balanced
3) The difference between heights of left subtree and right subtree is not more than 1.

The above height-balancing scheme is used in AVL trees. The diagram below shows two trees, one of them is height-balanced 
and other is not. The second tree is not height-balanced because height of left subtree is 2 more than height of right 
subtree.
*/
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
        int hLeft, hRight;
        hLeft = findHeight(rootNode.leftChild);
        hRight = findHeight(rootNode.rightChild);
        
        if(Math.abs(hRight - hLeft) == 1 || Math.abs(hRight - hLeft) == 0)
            System.out.println("tree is balanced");
        else
            System.out.println("tree is imbalanced");
        
        /*second tree*/
        System.out.println("\nsecond tree");
        rootNode = createBTree2();
        BFSTraversalLineByLine(rootNode);
        hLeft = findHeight(rootNode.leftChild);
        hRight = findHeight(rootNode.rightChild);
        
        if(Math.abs(hRight - hLeft) == 1 || Math.abs(hRight - hLeft) == 0)
            System.out.println("tree is balanced");
        else
            System.out.println("tree is imbalanced");
            
        /*third tree*/
        System.out.println("\nthird tree");
        rootNode = createBTree3();
        BFSTraversalLineByLine(rootNode);
        hLeft = findHeight(rootNode.leftChild);
        hRight = findHeight(rootNode.rightChild);
        
        if(Math.abs(hRight - hLeft) == 1 || Math.abs(hRight - hLeft) == 0)
            System.out.println("tree is balanced");
        else
            System.out.println("tree is imbalanced");            
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
    
    static Node createBTree3(){
        Node rootNode = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        
        rootNode.rightChild = three;
        rootNode.leftChild = two;
        two.leftChild = four;
        two.rightChild = five;
        
        return rootNode;
    }
    
    static void BFSTraversalLineByLine(Node rootNode){
        int height = findHeight(rootNode);
        /*print node level wise*/
        for(int level=1; level<=height; level++){
            printLevelOrderLineByLine(rootNode, level);
            System.out.println();
        }
    }
    
    static void printLevelOrderLineByLine(Node rootNode, int level){
        if(rootNode == null)
            return;
        if(level == 1)
            System.out.print(rootNode.data+"\t");
        else if(level > 1){
            printLevelOrderLineByLine(rootNode.leftChild,level-1);
            printLevelOrderLineByLine(rootNode.rightChild, level-1);
        }
    }
    
    static int findHeight(Node node){
        if (node == null)
            return 0;
        if(node.leftChild == null && node.rightChild == null)
            return 1;
        int height = Math.max(findHeight(node.leftChild), findHeight(node.rightChild)) + 1;
        return height;
    }
}
