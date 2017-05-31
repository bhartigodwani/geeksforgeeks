/*
Check for Children Sum Property in a Binary Tree
Given a binary tree, write a function that returns true if the tree satisfies below property.
For every node, data value must be equal to sum of data values in left and right children. Consider data value as 0 for NULL 
children.
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
        displayBTree(rootNode);
        if(rootNode.data == countSum(rootNode))
            System.out.println("condition true");
        else
            System.out.println("condition false");
        
        
        System.out.println("\n");
        rootNode = createBTree2();
        System.out.println("Second tree");
        BFSTraversalLineByLine(rootNode);
        if(rootNode.data == countSum(rootNode))
            System.out.println("condition true");
        else
            System.out.println("condition false");
            
        System.out.println("\n");
        rootNode = createBTree3();
        System.out.println("Third tree");
        BFSTraversalLineByLine(rootNode);
        if(rootNode.data == countSum(rootNode))
            System.out.println("condition true");
        else
            System.out.println("condition false");
            
        System.out.println("\n");
        rootNode = null;
        System.out.println("Fourth tree");
        BFSTraversalLineByLine(rootNode);
        if (rootNode != null){
            if(rootNode.data == countSum(rootNode))
                System.out.println("condition true");
            else
                System.out.println("condition false");
        }
        else
        System.out.println("LinkedList is empty");
    }
    
    static int countSum(Node rootNode){
        if(rootNode == null)
            return 0;
            
        if (rootNode.leftChild == null && rootNode.rightChild == null)
            return rootNode.data;
        
        if(rootNode.data == (countSum(rootNode.leftChild) + countSum(rootNode.rightChild)))
            return rootNode.data;
        else
            return Integer.MIN_VALUE;
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
