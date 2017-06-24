/*
@author Bharti Godwani

Connect nodes at same level

Write a function to connect all the adjacent nodes at the same level in a binary tree. Structure of the given Binary Tree 
node is like following.
struct node{
  int data;
  struct node* left;
  struct node* right;
  struct node* nextRight;  
}

Initially, all the nextRight pointers point to garbage values. Your function should set these pointers to point next right 
for each node.

Example

Input Tree
       A
      / \
     B   C
    / \   \
   D   E   F


Output Tree
       A--->NULL
      / \
     B-->C-->NULL
    / \   \
   D-->E-->F-->NULL
*/

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
class BTree{
    static class Node{
        int data;
        Node left, right, nextRight;
        Node(int d){
            data = d;
            left = right = nextRight = null;
        }
    }
    public static void main(String []args){
        int size = 7;
        Node root = createBTree(size);
        System.out.println("original tree");
        BFSTraversalLineByLine(root);
        System.out.println("updated tree through preorder");
        connectSameLevelPreorder(root);
        BFSTraversalLineByLine(root);
        System.out.println();
        
        root = createBTree2();
        System.out.println("original tree");
        BFSTraversalLineByLine(root);
        System.out.println("updated tree through preorder");
        connectSameLevelPreorder(root);
        BFSTraversalLineByLine(root);
        System.out.println();
        
        root = new Node(1);
        root.left = new Node(2);
        System.out.println("original tree");
        BFSTraversalLineByLine(root);
        System.out.println("updated tree through preorder");
        connectSameLevelPreorder(root);
        BFSTraversalLineByLine(root);
        System.out.println();
    }
    
    /*-----------------------------using Preorder-----------------------------*/
    /*-----------------------------only for complete tree---------------------*/
    static Node connectSameLevelPreorder(Node root){
        root.nextRight = null;
        connectSameLevelPreorderRec(root);
        return root;
    }
    
    static void connectSameLevelPreorderRec(Node root){
        if(root == null || (root.left == null && root.right == null))
            return;
        if(root.left != null){//find nextright for root.left child
            Node leftNextRight = null;
            if(root.right != null){
                root.left.nextRight = root.right;
            }
            else{
                Node temp = root.nextRight;
                while(temp != null){
                    if(temp.left != null){
                        leftNextRight = temp.left;
                        break;
                    }
                    else if(temp.right != null){
                        leftNextRight = temp.right;
                        break;
                    }
                    temp = temp.nextRight;
                }
                root.left.nextRight = leftNextRight;
            }
        }

        if(root.right != null){//find nextright for root.right child
            Node rightNextRight = null;
            Node temp = root.nextRight;
            while(temp != null){
                if(temp.left != null){
                    rightNextRight = temp.left;
                    break;
                }
                else if(temp.right != null){
                    rightNextRight = temp.right;
                    break;
                }
                temp = temp.nextRight;
            }
            root.right.nextRight = rightNextRight;
        }
        
        connectSameLevelPreorderRec(root.left);
        connectSameLevelPreorderRec(root.right);
    }
    
    static Node createBTree2(){
        Node root = new Node(1);
        Node o2 = new Node(2);
        Node o3 = new Node(3);
        Node o4 = new Node(4);
        Node o5 = new Node(5);
        Node o6 = new Node(6);
        Node o7 = new Node(7);
        Node o8 = new Node(8);
        Node o9 = new Node(9);
        Node o10 = new Node(10);
        Node o11 = new Node(11);
        Node o12 = new Node(12);
        
        root.left = o2;
        root.right = o3;
        o2.left = o4;
        o3.left = o5;
        o3.right = o6;
        o4.left = o7;
        o5.right = o8;
        o6.right = o9;
        o7.left = o10;
        o8.left = o11;
        o9.left = o12;
        
        return root;
    }
    
    static Node createBTree(int size){
        Queue<Node> que = new LinkedList<Node>();
        int value = 1;
        Node rootNode = new Node(value);
        que.add(rootNode);
        while(value < size){
            Node node = que.poll();
            Node left = new Node(++value);
            Node right = new Node(++value);
            node.left = left;
            node.right = right;
            que.add(left);
            que.add(right);
        }
        return rootNode;
    }
    
    static void BFSTraversalLineByLine(Node root){
        if(root == null)
            System.out.println("null");
        
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        que.add(null);
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node == null){
                System.out.println();
                if(!que.isEmpty())
                    que.add(null);
            }
            else{
                System.out.print("("+node.data+" - "+((node.nextRight != null) ? node.nextRight.data : "null")+" )  ");
                Node left = node.left;
                Node right = node.right;
                if (left != null)
                    que.add(left);

                if(right != null)
                    que.add(right);
            }
        }
    }
}
