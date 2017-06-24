/*
Print Left View of a Binary Tree

Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from 
left side. Left view of following tree is 12, 10, 25.

          12
       /     \
     10       30
            /    \
          25      40 
*/

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
class BTree{
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    public static void main(String []args){
        int size = 7;
        System.out.println("tree1");
        Node root = createBTree(size);
        BFSTraversalLineByLine(root);
        System.out.println("left viewed nodes");
        printLeftView(root);
        
        
        System.out.println("tree2");
        root = createBTree2();
        BFSTraversalLineByLine(root);
        System.out.println("left viewed nodes");
        printLeftView(root);
        
        System.out.println("tree3");
        root = new Node(1);
        root.left = new Node(2);
        BFSTraversalLineByLine(root);
        System.out.println("left viewed nodes");
        printLeftView(root);
    }
    
    static void printLeftView(Node root){
        if(root == null){
            System.out.println(root);
            return;
        }
        
        if(root.left == null && root.right == null){
            System.out.println(root.data);
            return; 
        }
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        que.add(null);
        System.out.print(root.data+"  ");
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node == null){
                if(que.isEmpty())
                    break;
                else
                    System.out.print(que.peek().data+"  ");
                que.add(null);
            }
            else{
                if(node.left != null)
                    que.add(node.left);
                
                if(node.right != null)
                    que.add(node.right);
             }
        }
        System.out.println("\n");
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
            printLevelOrderLineByLine(rootNode.left,level-1);
            printLevelOrderLineByLine(rootNode.right, level-1);
        }
    }
    
    static int findHeight(Node node){
        if (node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 1;
        int height = Math.max(findHeight(node.left), findHeight(node.right)) + 1;
        return height;
    }
}
