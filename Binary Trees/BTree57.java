/*

Iterative Method to find Height of Binary Tree

There are two conventions to define height of Binary Tree
1) Number of nodes on longest path from root to the deepest node.
2) Number of edges on longest path from root to the deepest node.
*/

import java.util.Stack;
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
        Node rootNode = createBTree(size);
        System.out.println("First tree");
        BFSTraversalLineByLine(rootNode);
        
        System.out.println("\n");
        rootNode = createBTree2();
        System.out.println("Second tree");
        BFSTraversalLineByLine(rootNode);
            
        System.out.println("\n");
        rootNode = createBTree3();
        System.out.println("Third tree");
        BFSTraversalLineByLine(rootNode);
        
        System.out.println("\n");
        rootNode = null;
        System.out.println("Fourth tree");
        BFSTraversalLineByLine(rootNode);
        
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
    
    static Node createBTree2(){
        Node rootNode = new Node(10);
        Node eight = new Node(8);
        Node two1 = new Node(2);
        Node three = new Node(3);
        Node five = new Node(5);
        Node two2 = new Node(2);
        
        rootNode.leftChild = eight;
        rootNode.rightChild = two1;
        eight.leftChild = three;
        eight.rightChild = five;
        two1.leftChild = two2;
        
        return rootNode;
    }
    
    static Node createBTree3(){
        Node rootNode = new Node(1);
        Node o1 = new Node(1);
        Node o2 = new Node(1);
        Node o3 = new Node(1);
        Node o4 = new Node(1);
        
        rootNode.rightChild = o1;
        o1.leftChild = o2;
        o2.rightChild = o3;
        o3.leftChild = o4;
        return rootNode;
    }
        
    static void displayBTree(Node rootNode){
        System.out.println(rootNode.data);
        System.out.println(rootNode.leftChild.data+"\t"+rootNode.rightChild.data);
        System.out.print(rootNode.leftChild.leftChild.data+"\t"+rootNode.leftChild.rightChild.data+"\t");
        System.out.println(rootNode.rightChild.leftChild.data+"\t"+rootNode.rightChild.rightChild.data);
    }
    
    static void BFSTraversalLineByLine(Node rootNode){
        int height = findHeight(rootNode);
        System.out.println("height = "+height);
        if(rootNode == null){
            System.out.println("empty tree");
            return;
        }

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
    
     static int findHeight(Node root){
        int height = 0;
        if(root == null)
            return height;
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        que.add(null);
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node == null){
                height++;
                if(!que.isEmpty())
                    que.add(null);
            }
            else{
                Node leftChild = node.leftChild;
                Node rightChild = node.rightChild;

                if (leftChild != null)
                    que.add(leftChild);

                if(rightChild != null)
                    que.add(rightChild);
            }
        }
         return height;
    }
    
}
