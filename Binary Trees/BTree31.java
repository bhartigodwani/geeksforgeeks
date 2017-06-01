/*
Print Ancestors of a given node in Binary Tree
Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree.
For example, if the given tree is following Binary Tree and key is 7, then your function should print 4, 2 and 1.
              1
            /   \
          2      3
        /  \
      4     5
     /
    7
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
        int key = 5;
        System.out.println("key = "+key);
        System.out.println("Ancesstors are :");
        getAncesstors(rootNode, key);
        
        
        /*--------------------case 2------------------------------*/
        System.out.println("\n");
        rootNode = createBTree2();
        System.out.println("Second tree");
        BFSTraversalLineByLine(rootNode);
        key = 7;
        System.out.println("key = "+key);
        System.out.println("Ancesstors are :");
        getAncesstors(rootNode, key);
            
        /*--------------------case 3------------------------------*/
        System.out.println("\n");
        rootNode = createBTree3();
        System.out.println("Third tree");
        BFSTraversalLineByLine(rootNode);
        key = 3;
        System.out.println("key = "+key);
        System.out.println("Ancesstors are :");
        getAncesstors(rootNode, key);
            
        /*--------------------case 4------------------------------*/
        System.out.println("\n");
        rootNode = new Node(1);
        System.out.println("Fourth tree");
        BFSTraversalLineByLine(rootNode);
        key = 1;
        System.out.println("key = "+key);
        if(rootNode.data == key)
            System.out.println("no Ancesstors exist");
        else{
            System.out.println("Ancesstors are :");
            getAncesstors(rootNode, key);
        }
            
        /*--------------------case 5------------------------------*/
        System.out.println("\n");
        rootNode = createBTree4();
        System.out.println("Fifth tree");
        BFSTraversalLineByLine(rootNode);
        key = 5;
        System.out.println("key = "+key);
        if(rootNode.data == key)
            System.out.println("no Ancesstors exist");
        else{
            System.out.println("Ancesstors are :");
            getAncesstors(rootNode, key);
        }
        
    }
    
    static int getAncesstors(Node rootNode, int element){
        int flag = 0;
         
        if (rootNode == null)
            return 0;
            
        if (rootNode.data == element){
            return 1;
        }
        
        if(rootNode.leftChild != null)  
            flag = getAncesstors(rootNode.leftChild,element);
        
        if (rootNode.rightChild != null && flag == 0)
            flag = getAncesstors(rootNode.rightChild,element);
        
        if(flag == 1)
            System.out.print(rootNode.data+"  ");
        
        return flag;
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
