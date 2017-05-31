/*
Given a binary tree, print out all of its root-to-leaf paths one per line.
*/

import java.util.Stack;
import java.util.Queue;
import java.util.Arrays;
import java.util.List;
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
        int [] inorder = {7,3,6,1,5,2,4};
        int [] preorder = {1,3,7,6,2,5,4};
        int [] postorder = {7,6,3,5,4,2,1};
        
        /*--------------------case 1------------------------------*/
        int size = 7;
        Node rootNode = createBTree(size);
        System.out.println("First tree");
        BFSTraversalLineByLine(rootNode);
        System.out.println("possible paths in tree--");
        int path[] = new int[10];//maximum posiblity of the number of paths be 10
        printNumberPaths(rootNode, path, 0);
        
        /*--------------------case 2------------------------------*/
        System.out.println("\n");
        rootNode = createBTree2();
        System.out.println("Second tree");
        BFSTraversalLineByLine(rootNode);
        System.out.println("\npossible paths in tree--");
        printNumberPaths(rootNode, path, 0);
    }
    
    static void printNumberPaths(Node rootNode, int[] path, int pathLength){
        if(rootNode == null)
            return;
        
        path[pathLength] = rootNode.data;
        pathLength++;
        
        if(rootNode.leftChild == null && rootNode.rightChild == null)
            printPathArray(path, pathLength);
        
        else{
            printNumberPaths(rootNode.leftChild, path, pathLength);
            printNumberPaths(rootNode.rightChild, path, pathLength);
        }
    }

    static void printPathArray(int []path, int pathLength){
        for (int i=0; i<pathLength; i++) 
            System.out.print(path[i]+"  ");
        System.out.println();
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
        Node rootNode = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        
        rootNode.leftChild = two;
        rootNode.rightChild = three;
        two.leftChild = four;
        three.leftChild = six;
        six.rightChild = seven;
        
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
