/*
BST inorder predecessor and successor
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
        int size = 7;//number of nodes in complete tree
        Node rootNode = createBTree(size);
        BFSTraversalLineByLine(rootNode);
        int x;
        boolean result;
        x = 5;
        System.out.println("x = "+x);
        result = searchInBST(rootNode, x);
        System.out.println((result == true) ? "true" : "false");
        
        x = 8;
        System.out.println("x = "+x);
        result = searchInBST(rootNode, x);
        System.out.println((result == true) ? "true" : "false");
        
        System.out.println("\nnode to be inserted is "+x);
        System.out.println("new tree");
        insertNodeBST(rootNode, x);
        BFSTraversalLineByLine(rootNode);
        
        /*second tree*/
        rootNode = createBTree2();
        System.out.println("\n\nsecond tree");
        BFSTraversalLineByLine(rootNode);
        x = 14;
        System.out.println("x = "+x);
        result = searchInBST(rootNode, x);
        System.out.println((result == true) ? "true" : "false");
        
        x = 15;
        System.out.println("x = "+x);
        result = searchInBST(rootNode, x);
        System.out.println((result == true) ? "true" : "false");
        
        System.out.println("\nnode to be inserted is "+x);
        System.out.println("new tree");
        insertNodeBST(rootNode, 9);
        BFSTraversalLineByLine(rootNode);
    }
    
    static void findKeys(Node root, int x){
        if(root == null){
            System.out.println("tree is empty");
            return;
        }
            
        Node left = inorderPredecessor(root);
        Node right = inorderSuccessor(root);
    } 
        
    static int inorderPredecessor(Node root, int x){
        Node temp = root;
        if(root.data == x){
            temp = root.left;
            if(temp == null)
                return root.data;
            while(temp != null)
                temp = temp.right;
            return temp.data;
        }
        if(x < root.data)
            return inorderPredecessor(root.left, x);
        else
            return inorderPredecessor(root.right, x);
    }
        
    static int inorderSuccessor(Node root, int x)
    
    static boolean searchInBST(Node root, int x){
        if(root == null)
            return false;
        if(root.data == x)
            return true;
        if(x < root.data)
            return searchInBST(root.left, x);
        else
            return searchInBST(root.right, x);
    }
    
    static void insertNodeBST(Node root, int x){
        if(x < root.data){
            if(root.left == null){
                root.left = new Node(x);
                return;
            }
            else
                insertNodeBST(root.left, x);
        }
        
        else{
            if(root.right == null){
                root.right = new Node(x);
                return;
            }
            else
                insertNodeBST(root.right, x);
        }
    }
    
    static Node createBTree(int size){
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
