/*
Find the node with minimum value in a Binary Search Tree
This is quite simple. Just traverse the node from root to left recursively until left is NULL. The node whose left is NULL 
is the node with minimum value. 
*/

import java.util.Queue;
import java.util.LinkedList;
class BST{
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    public static void main(String []args){
        /*first tree*/
        System.out.println("first tree");
        Node rootNode = createBTree();
        BFSTraversalLineByLine(rootNode);
        System.out.println("min value = "+findMinValue(rootNode));
        
        /*second tree*/
        rootNode = createBTree2();
        System.out.println("\n\nsecond tree");
        BFSTraversalLineByLine(rootNode);
        System.out.println("min value = "+findMinValue(rootNode));
    }
    
    static int findMinValue(Node root){
        if(root.left == null && root.right == null)
            return root.data;
        Node temp = root;
        while(temp.left != null)
            temp = temp.left;
        return temp.data;
    }
    
    static Node createBTree(){
        Node root = new Node(4);
        Node o1 = new Node(2);
        Node o2 = new Node(5);
        Node o3 = new Node(1);
        Node o4 = new Node(3);
        Node o5 = new Node(6);
        Node o6 = new Node(7);
        
        root.left = o1;
        root.right = o2;
        o1.left = o3;
        o1.left = o3;
        o1.right = o4;
        o2.right = o5;
        o5.right = o6;
        
        return root;
    }
    
    static Node createBTree2(){
        Node root = new Node(10);
        Node o1 = new Node(8);
        Node o2 = new Node(12);
        Node o3 = new Node(7);
        Node o4 = new Node(9);
        Node o5 = new Node(14);
        Node o6 = new Node(18);
        
        root.left = o1;
        root.right = o2;
        o1.left = o3;
        o1.right = o4;
        o2.right = o5;
        o5.right = o6;
        
        return root;
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
                System.out.print(node.data+"  ");
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
