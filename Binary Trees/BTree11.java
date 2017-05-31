/*
Inorder Tree Traversal without recursion and without stack!
Using Morris Traversal, we can traverse the tree without using stack and recursion. The idea of 
Morris Traversal is based on Threaded Binary Tree. In this traversal, we first create links to 
Inorder successor and print the data using these links, and finally revert the changes to restore
original tree.

1. Initialize current as root 
2. While current is not NULL
   If current does not have left child
      a) Print current's data
      b) Go to the right, i.e., current = current->right
   Else
      a) Make current as right child of the rightmost 
         node in current's left subtree
      b) Go to this left child, i.e., current = current->left
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
        System.out.println("\ninOrderTraversal");
        inOrderTraversal(rootNode);
        System.out.println("\npreOrderTraversal");
        preOrderTraversal(rootNode);
        
    }
    
    static void inOrderTraversal(Node rootNode){
        Node current = rootNode;
        while(current != null){
            if (current.leftChild == null){//if leftChild is null then print the node and go right
                System.out.print(current.data+"  ");
                current = current.rightChild;
            }
            else{
                Node predecessor = current.leftChild;//find the predecessor
                while(predecessor.rightChild != null && predecessor.rightChild != current)
                    predecessor = predecessor.rightChild;
                if (predecessor.rightChild == null){
                    predecessor.rightChild = current;
                    current = current.leftChild;
                }
                else{
                    predecessor.rightChild = null;
                    System.out.print(current.data+"  ");
                    current = current.rightChild;
                }
            }
        }
    }
    
    static void preOrderTraversal(Node rootNode){
        Node current = rootNode;
        while(current != null){
            if (current.leftChild == null){//if leftChild is null then print the node and go right
                System.out.print(current.data+"  ");
                current = current.rightChild;
            }
            else{
                Node predecessor = current.leftChild;//find the predecessor
                while(predecessor.rightChild != null && predecessor.rightChild != current)
                    predecessor = predecessor.rightChild;
                if (predecessor.rightChild == null){
                    predecessor.rightChild = current;
                    System.out.print(current.data+"  ");
                    current = current.leftChild;
                }
                else{
                    predecessor.rightChild = null;
                    current = current.rightChild;
                }
            }
        }
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
    
}
