/*

Root to leaf path sum equal to a given number

Given a binary tree and a number, return true if the tree has a root-to-leaf path such that adding up all the values along 
the path equals the given number. Return false if no such path can be found. 
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
        int element = 7;//true case
        System.out.println("element = "+element);
        int path[] = new int[10];//maximum posiblity of the number of paths be 10
        System.out.println("following are the paths from the tree");
        printNumberPaths(rootNode, path, 0);
        if(isPathSumEqualMain(rootNode, path, 0,element))
            System.out.println("true");
        else
            System.out.println("false");
        
        /*--------------------case 2------------------------------*/
        System.out.println("\n");
        rootNode = createBTree2();
        System.out.println("Second tree");
        BFSTraversalLineByLine(rootNode);
        element = 8;//false case
        System.out.println("element = "+element);
        int path2[] = new int[10];//maximum posiblity of the number of paths be 10
        System.out.println("following are the paths from the tree");
        printNumberPaths(rootNode, path2, 0);
        if(isPathSumEqualMain(rootNode, path2, 0,element))
            System.out.println("true");
        else
            System.out.println("false");
            
        /*--------------------case 3------------------------------*/
        System.out.println("\n");
        rootNode = createBTree3();
        System.out.println("Third tree");
        BFSTraversalLineByLine(rootNode);
        element = 15;//true case
        System.out.println("element = "+element);
        int path3[] = new int[10];//maximum posiblity of the number of paths be 10
        System.out.println("following are the paths from the tree");
        printNumberPaths(rootNode, path3, 0);
        if(isPathSumEqualMain(rootNode, path3, 0,element))
            System.out.println("true");
        else
            System.out.println("false");
    }
    
    static boolean isPathSumEqualMain(Node rootNode, int[] path, int pathLength, int element){
        if(rootNode == null)
            return false;
        
        path[pathLength] = rootNode.data;
        pathLength++;
        
        if(rootNode.leftChild == null && rootNode.rightChild == null){
            boolean result = isPathSumEqual(path, pathLength, element);
            if (result == true)
                return result;
        }
        
        else{
            if(isPathSumEqualMain(rootNode.leftChild, path, pathLength,element))
                return true;
            if(isPathSumEqualMain(rootNode.rightChild, path, pathLength,element))
                return true;
        }
        return false;
    }
    
    static boolean isPathSumEqual(int []path, int pathLength, int element){
        int sum = 0;
        for (int i=0; i<pathLength; i++){ 
            sum += path[i];
        }
        if(sum == element)
            return true;
        else
            return false;
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
    
    static Node createBTree3(){
        Node rootNode = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        
        rootNode.leftChild = two;
        two.leftChild = three;
        three.leftChild = four;
        four.leftChild = five;
        
        
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
