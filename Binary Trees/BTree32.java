/*
Check if a given Binary Tree is SumTree
Write a function that returns true if the given Binary Tree is SumTree else false. A SumTree is a Binary Tree where the 
value of a node is equal to sum of the nodes present in its left subtree and right subtree. An empty tree is SumTree and 
sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
Following is an example of SumTree.

          26
        /   \
      10     3
    /    \     \
  4      6      3
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
        
        /*--------------------case 1------------------------------*/
        int size = 7;
        Node rootNode = createBTree(size);
        System.out.println("First original tree");
        BFSTraversalLineByLine(rootNode);
        if(isSumTree(rootNode) == 1)
            System.out.println("is sum tree");
        else
            System.out.println("not a sum tree");
        
        
        /*--------------------case 2------------------------------*/
        System.out.println("\n");
        rootNode = createBTree2();
        System.out.println("Second tree");
        BFSTraversalLineByLine(rootNode);
        if(isSumTree(rootNode) == 1)
            System.out.println("is sum tree");
        else
            System.out.println("not a sum tree");
            
        /*--------------------case 3------------------------------*/
        System.out.println("\n");
        rootNode = createBTree3();
        System.out.println("Third tree");
        BFSTraversalLineByLine(rootNode);
        if(isSumTree(rootNode) == 1)
            System.out.println("is sum tree");
        else
            System.out.println("not a sum tree");
            
        /*--------------------case 4------------------------------*/
        System.out.println("\n");
        rootNode = new Node(1);
        System.out.println("Fourth tree");
        BFSTraversalLineByLine(rootNode);
        if(isSumTree(rootNode) == 1)
            System.out.println("is sum tree");
        else
            System.out.println("not a sum tree");
        
            
        /*--------------------case 5------------------------------*/
        System.out.println("\n");
        rootNode = createBTree4();
        System.out.println("Fifth tree");
        BFSTraversalLineByLine(rootNode);
        if(isSumTree(rootNode) == 1)
            System.out.println("is sum tree");
        else
            System.out.println("not a sum tree");
            
        /*--------------------case 6------------------------------*/
        System.out.println("\n");
        rootNode = createBTree5();
        System.out.println("Sixth tree");
        BFSTraversalLineByLine(rootNode);
        if(isSumTree(rootNode) == 1)
            System.out.println("is sum tree");
        else
            System.out.println("not a sum tree");            
            
        /*--------------------case 7------------------------------*/
        System.out.println("\n");
        rootNode = createBTree6();
        System.out.println("Seventh tree");
        BFSTraversalLineByLine(rootNode);
        if(isSumTree(rootNode) == 1)
            System.out.println("is sum tree");
        else
            System.out.println("not a sum tree");            
        
    }
    
    static int isSumTree(Node rootNode){
        
        if(rootNode == null || (rootNode.leftChild == null && rootNode.rightChild == null))
            return 1;
        
        int leftCount = rootNode.leftChild == null ? 0 : sum(rootNode.leftChild);
        int rightCount = rootNode.rightChild == null ? 0 : sum(rootNode.rightChild);
        if ((rootNode.data == leftCount+rightCount) && (isSumTree(rootNode.leftChild)==1) && (isSumTree(rootNode.rightChild)==1))
            return 1;
        
        return 0;
    }
    
    
    static int sum(Node node){
        if(node == null)
            return 0;
            
        return sum(node.leftChild) + node.data + sum(node.rightChild);
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
    
    static Node createBTree4(){
        Node rootNode = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        
        rootNode.leftChild = two;
        rootNode.rightChild = four;
        two.leftChild = three;
        three.leftChild = six;
        four.leftChild = five;
        five.leftChild = seven;
        
        return rootNode;
    }
    
    static Node createBTree5(){
        Node rootNode = new Node(26);
        Node ten = new Node(10);
        Node three1 = new Node(3);
        Node six = new Node(6);
        Node four = new Node(4);
        Node three2 = new Node(3);
        
        rootNode.leftChild = ten;
        rootNode.rightChild = three1;
        ten.leftChild = six;
        ten.rightChild = four;
        three1.rightChild = three2;
        return rootNode;
    }
    
    static Node createBTree6(){
        Node rootNode = new Node(16);
        Node eight = new Node(8);
        Node four = new Node(4);
        Node two = new Node(2);
        Node one1 = new Node(1);
        Node one2 = new Node(1);
        
        rootNode.rightChild = eight;
        eight.rightChild = four;
        four.rightChild = two;
        two.rightChild = one1;
        one1.rightChild = one2;
        
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
