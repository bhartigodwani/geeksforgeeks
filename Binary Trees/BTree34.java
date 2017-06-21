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
        root = connectSameLevel(root);
        System.out.println("updated tree");
        BFSTraversalLineByLine(root);
        System.out.println();
        
        root = createBTree2();
        System.out.println("original tree");
        BFSTraversalLineByLine(root);
        root = connectSameLevel(root);
        System.out.println("updated tree");
        BFSTraversalLineByLine(root);
        System.out.println();
        
        root = new Node(1);
        root.left = new Node(2);
        System.out.println("original tree");
        BFSTraversalLineByLine(root);
        root = connectSameLevel(root);
        System.out.println("updated tree");
        BFSTraversalLineByLine(root);
    }
    
    static Node connectSameLevel(Node root){
        if(root == null)
            return root;
        
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        que.add(null);
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node == null){
                if(!que.isEmpty())
                    que.add(null);
            }
            else{
                Node left = node.left;
                Node right = node.right;
                if (left != null)
                    que.add(left);

                if(right != null)
                    que.add(right);
                node.nextRight = que.peek();
            }
        }
        return root;
    }
    
    static Node createBTree2(){
        Node root = new Node(12);
        root.left = new Node(5);
        root.right = new Node(7);
        root.left.left = new Node(3);
        
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
