/*
Check if all leaves are at same level

Given a Binary Tree, check if all leaves are at same level or not.

          12
        /    \
      5       7       
    /          \ 
   3            1
  Leaves are at same level

          12
        /    \
      5       7       
    /          
   3          
   Leaves are Not at same level


          12
        /    
      5             
    /   \        
   3     9
  /      /
 1      2
 Leaves are at same level
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
        Node root = createBTree(size);
        BFSTraversalLineByLine(root);
        boolean result = isSameLevel(root);
        System.out.println((result == true) ? "at same level" : "not on same level");
        
        
        size = 15;
        root = createBTree2();
        BFSTraversalLineByLine(root);
        result = isSameLevel(root);
        System.out.println((result == true) ? "at same level" : "not on same level");
        
        
        root = new Node(1);
        root.left = new Node(2);
        BFSTraversalLineByLine(root);
        result = isSameLevel(root);
        System.out.println((result == true) ? "at same level" : "not on same level");
    }
    
    static boolean isSameLevel(Node root){
        if(root == null || (root.left == null && root.right == null))
            return true;
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        que.add(null);
        int leafLevel = 0;
        int level = 0;
        while(!que.isEmpty()){
          //  System.out.println("while");
            Node node = que.poll();
            if(node == null){
                level++;
                //System.out.println("node is null l = "+level);
                if(que.isEmpty()){
                    //System.out.println("que is empty");
                    break;
                }
                que.add(null);
            }
            else{
                if(node.left != null){
                    //System.out.println("left not null");
                    que.add(node.left);
                }
                if(node.right != null){
                    //System.out.println("right not null");
                    que.add(node.right);
                }
                if(node.left == null && node.right == null){
                    //System.out.println("both are null");
                    if(leafLevel == 0){
                      //  System.out.println("leaflevel is 0");
                        leafLevel = level + 1;
                    }
                    else if((level+1) != leafLevel){
                        //System.out.println("false case");
                        return false;
                    }
                }
            }
        }
        return true;
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
