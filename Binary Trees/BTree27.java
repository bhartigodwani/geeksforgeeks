/*
Foldable Binary Trees
Given a binary tree, find out if the tree can be folded or not.
A tree can be folded if left and right subtrees of the tree are structure wise mirror image of each other. An empty tree is
considered as foldable.

Consider the below trees:
(a) and (b) can be folded.
(c) and (d) cannot be folded.
(a)
       10
     /    \
    7      15
     \    /
      9  11
(b)
        10
       /  \
      7    15
     /      \
    9       11
(c)
        10
       /  \
      7   15
     /    /
    5   11
(d)
         10
       /   \
      7     15
    /  \    /
   9   10  12
   
Method 1 (Change Left subtree to its Mirror and compare it with Right subtree)
Algorithm: isFoldable(root)
  
1) If tree is empty, then return true.
2) Convert the left subtree to its mirror image
    mirror(root->left); 
3) Check if the structure of left subtree and right subtree is same
   and store the result.
    res = isStructSame(root->left, root->right); //isStructSame()
        recursively compares structures of two subtrees and returns
        true if structures are same 
4) Revert the changes made in step (2) to get the original tree.
    mirror(root->left);
5) Return result res stored in step 2.
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
        if(isFoldable(rootNode.leftChild, rootNode.rightChild))
            System.out.println("isFoldable");
        else
            System.out.println("not foldable");
        
        /*--------------------case 2------------------------------*/
        System.out.println("\n");
        rootNode = createBTree2();
        System.out.println("Second tree");
        BFSTraversalLineByLine(rootNode);
        if(isFoldable(rootNode.leftChild, rootNode.rightChild))
            System.out.println("isFoldable");
        else
            System.out.println("not foldable");
            
        /*--------------------case 3------------------------------*/
        System.out.println("\n");
        rootNode = createBTree3();
        System.out.println("Third tree");
        BFSTraversalLineByLine(rootNode);
        if(isFoldable(rootNode.leftChild, rootNode.rightChild))
            System.out.println("isFoldable");
        else
            System.out.println("not foldable");
            
        /*--------------------case 4------------------------------*/
        System.out.println("\n");
        rootNode = new Node(1);
        System.out.println("Fourth tree");
        BFSTraversalLineByLine(rootNode);
        if(isFoldable(rootNode.leftChild, rootNode.rightChild))
            System.out.println("isFoldable");
        else
            System.out.println("not foldable");
            
        /*--------------------case 5------------------------------*/
        System.out.println("\n");
        rootNode = createBTree4();
        System.out.println("Fifth tree");
        BFSTraversalLineByLine(rootNode);
        if(isFoldable(rootNode.leftChild, rootNode.rightChild))
            System.out.println("isFoldable");
        else
            System.out.println("not foldable");
    }
    
    static boolean isFoldable(Node leftChild, Node rightChild){
        if (leftChild != null && rightChild != null){ 
            leftChild = convertMirror(leftChild);
            Queue<Node> leftQue = new LinkedList<Node>();
            Queue<Node> rightQue = new LinkedList<Node>();
            leftQue.add(leftChild);
            rightQue.add(rightChild);
            while(!leftQue.isEmpty() && !rightQue.isEmpty()){
                Node left = leftQue.poll();
                Node right = rightQue.poll();
                if (left.leftChild != null && right.leftChild != null){
                    leftQue.add(left.leftChild);
                    rightQue.add(right.leftChild);
                }
                else if((left.leftChild == null && right.leftChild != null) || (left.leftChild != null && right.leftChild == null) ){
                    return false;
                }
                        
                if(left.rightChild != null && right.rightChild != null){
                    leftQue.add(left.rightChild);
                    rightQue.add(right.rightChild);
                }
                else if((left.rightChild == null && right.rightChild != null) || (left.rightChild != null && right.rightChild == null) ){
                    return false;
                }    
            }
            
            if ((leftQue.isEmpty() && !rightQue.isEmpty()) || (!leftQue.isEmpty() && rightQue.isEmpty())) 
                return false;
            return true;
        }
        else if (leftChild == null && rightChild == null){
            return true;
        }
        else
            return false;
    }
    
    static Node convertMirror(Node rootNode){
        if(rootNode == null)
            return rootNode;
            
        if (rootNode.leftChild == null && rootNode.rightChild == null)
            return rootNode;
        
        Node leftChild = convertMirror(rootNode.leftChild);
        Node rightChild = convertMirror(rootNode.rightChild);
        Node temp = leftChild;
        rootNode.leftChild = rightChild;
        rootNode.rightChild = temp;
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
