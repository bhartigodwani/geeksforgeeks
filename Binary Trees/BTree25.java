/*
Double Tree
Write a program that converts a given tree to its Double tree. To create Double tree of the given tree, create a new 
duplicate for each node, and insert the duplicate as the left child of the original node.
So the tree..

    2
   / \
  1   3

is changed to..

       2
      / \
     2   3
    /   /
   1   3
  /
 1

And the tree

            1
          /   \
        2      3
      /  \
    4     5

is changed to

               1
             /   \
           1      3
          /      /
        2       3
      /  \
     2    5
    /    /
   4   5
  /   
 4    
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
        System.out.println("Doubled tree");
        rootNode = convertTree2DoubleTree(rootNode);
        BFSTraversalLineByLine(rootNode);
        
        
        /*--------------------case 2------------------------------*/
        System.out.println("\n");
        rootNode = createBTree2();
        System.out.println("Second tree");
        BFSTraversalLineByLine(rootNode);
        System.out.println("Doubled tree");
        rootNode = convertTree2DoubleTree(rootNode);
        BFSTraversalLineByLine(rootNode);
            
        /*--------------------case 3------------------------------*/
        System.out.println("\n");
        rootNode = createBTree3();
        System.out.println("Third tree");
        BFSTraversalLineByLine(rootNode);
        System.out.println("Doubled tree");
        rootNode = convertTree2DoubleTree(rootNode);
        BFSTraversalLineByLine(rootNode);
    }
    
    static Node in_Pre_Order(Integer [] inorder, Integer[] preorder){
        Node rootNode = new Node(preorder[0]);
        for (int i=1; i<preorder.length; i++){
            rootNode = buildTree(rootNode, preorder[i], inorder);
        } 
        return rootNode;
    }
    
    static Node in_Post_Order(Integer [] inorder, Integer[] postorder){
        Node rootNode = new Node(postorder[postorder.length-1]);
        for (int i=postorder.length-2; i >= 0; i--){
            rootNode = buildTree(rootNode, postorder[i], inorder);
        } 
        return rootNode;
    }
    
    static Node buildTree(Node rootNode, int element, Integer []inorder){
        List inorderList = Arrays.asList(inorder);
        Node newNode = new Node(element);
        Node temp = rootNode;
        while(true){
            if(inorderList.indexOf(element) < inorderList.indexOf(temp.data)){
                if(temp.leftChild != null)
                    temp = temp.leftChild;
                else{
                    temp.leftChild = newNode;
                    break;
                }
            }
            else{
                if(temp.rightChild != null)
                    temp = temp.rightChild;
                else{
                    temp.rightChild = newNode;
                    break;
                }
            }
        }
        return rootNode;
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
        
    static Node convertTree2DoubleTree(Node rootNode){
        Queue<Node> que = new LinkedList<Node>();
        que.add(rootNode);
        while(!que.isEmpty()){
            Node node = que.poll();
            
            if (node.leftChild != null){
                que.add(node.leftChild);
            }
                
            if(node.rightChild != null){
                que.add(node.rightChild);
            }
            
            Node newNode = new Node(node.data);
            Node tempLeft = node.leftChild;
            node.leftChild = newNode;
            newNode.leftChild = tempLeft;
        }
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
