/*

Print ancestors of a given binary tree node without recursion

Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree.

For example, consider the following Binary Tree

            1
        /       \
       2         3
     /   \     /   \
    4     5    6    7 
   /       \       /
  8         9     10  

Following are different input keys and their ancestors in the above tree

Input Key    List of Ancestors 
-------------------------
 1            
 2            1
 3            1
 4            2 1
 5            2 1
 6            3 1
 7            3 1
 8            4 2 1
 9            5 2 1
10            7 3 1

*/

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
class BTree{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    
    public static void main (String[] args) {
        int size = 7;
        Node rootNode = createBTree(size);
        System.out.println("First tree");
        BFSTraversalLineByLine(rootNode);
        int x = 7;
        printAncesstors(rootNode, x);
        
        System.out.println("\n");
        rootNode = createBTree2();
        System.out.println("Second tree");
        BFSTraversalLineByLine(rootNode);
        x = 5;
        printAncesstors(rootNode, x);
            
        System.out.println("\n");
        rootNode = createBTree3();
        System.out.println("Third tree");
        BFSTraversalLineByLine(rootNode);
        x = 1;
        printAncesstors(rootNode, x);
        
        System.out.println("\n");
        rootNode = null;
        System.out.println("Fourth tree");
        BFSTraversalLineByLine(rootNode);
        
    }
    
    static void printAncesstors(Node root, int x){
        Stack<Node> stack = new Stack<Node>();
        System.out.println();
        //stack.push(root);
        Node curr = root;
        while(!stack.isEmpty()){
            if(curr.data == x){
                while(!stack.isEmpty()){
                    System.out.print(stack.pop().data+"  ");
                }
                break;
            }
            if(curr == null){
                if(!stack.isEmpty()){
                    stack.pop();
                    curr = stack.peek().right;
                    //stack.push(curr);
                }
            }
            if(curr.left != null && curr.data != x){
                stack.push(curr);
                curr = curr.left;
            }
            else if(curr.left == null){
                stack.push(curr);
                if(curr.right == null){
                    stack.pop();
                    curr = stack.peek().right;
                }
                else{
                    //stack.push(curr.right);
                    curr = curr.right;
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
            Node left = new Node(++value);
            Node right = new Node(++value);
            node.left = left;
            node.right = right;
            que.add(left);
            que.add(right);
        }
        return rootNode;
    }
    
    static Node createBTree2(){
        Node rootNode = new Node(1);
        Node o2 = new Node();
        Node o3 = new Node();
        Node o4 = new Node();
        Node o5 = new Node();
        Node o6 = new Node();
        Node o7 = new Node();
        Node o8 = new Node();
        Node o9 = new Node();
        Node o10 = new Node();
        Node o11 = new Node();
        Node o12 = new Node();
        Node o13 = new Node();
        Node o15 = new Node();
        /*Node o = new Node();
        Node o = new Node();*/
        
        rootNode.left = o2;
        rootNode.right = o3;
        o2.left = o4;
        o2.right = o5;
        o3.left = o6;
        o3.right = o7;
        o4.left = o8;
        o5.right = o9;
        o7.left = o10;
        
        return rootNode;
    }
    
    static Node createBTree3(){
        Node rootNode = new Node(1);
        Node o1 = new Node(1);
        Node o2 = new Node(1);
        Node o3 = new Node(1);
        Node o4 = new Node(1);
        
        rootNode.right = o1;
        o1.left  = o2;
        o2.right = o3;
        o3.left = o4;
        return rootNode;
    }
        
    static void BFSTraversalLineByLine(Node rootNode){
        int height = findHeight(rootNode);
        System.out.println("height = "+height);
        if(rootNode == null){
            System.out.println("empty tree");
            return;
        }

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
    
     static int findHeight(Node root){
        int height = 0;
        if(root == null)
            return height;
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        que.add(null);
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node == null){
                height++;
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
            }
        }
         return height;
    }
    
}
