/*
Extract Leaves of a Binary Tree in a Doubly Linked List

Given a Binary Tree, extract all leaves of it in a Doubly Linked List (DLL). Note that the DLL need to be created in-place. Assume that the node structure of DLL and Binary Tree is same, only the meaning of left and right pointers are different. In DLL, left means previous pointer and right means next pointer.

Let the following be input binary tree
        1
     /     \
    2       3
   / \       \
  4   5       6
 / \         / \
7   8       9   10


Output:
Doubly Linked List
7<->8<->5<->9<->10

Modified Tree:
        1
     /     \
    2       3
   /         \
  4           6
  */

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
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
    
    static class RootReference{
        Node root;
        RootReference(){
            root = null;
        }
    }
    
    static class LinkReference{
        Node head;
        LinkReference(){
            head = null;
        }
    }
    
    public static void main(String []args){
        int size = 7;
        System.out.println("tree1");
        RootReference rr = new RootReference();
        rr.root = createBTree(size);
        LinkReference lr = new LinkReference();
        BFSTraversalLineByLine(rr.root);
        System.out.println("new tree");
        extractLeaves(rr.root, lr.head);
        BFSTraversalLineByLine(rr.root);
        printDoublyList(lr.head);
        
        System.out.println("tree2");
        rr.root = createBTree2();
        BFSTraversalLineByLine(rr.root);
        System.out.println("new tree");
        extractLeaves(rr.root, lr.head);
        BFSTraversalLineByLine(rr.root);
        printDoublyList(lr.head);
        
        System.out.println("tree3");
        rr.root = new Node(1);
        rr.root.left = new Node(2);
        BFSTraversalLineByLine(rr.root);
        System.out.println("new tree");
        extractLeaves(rr.root, lr.head);
        BFSTraversalLineByLine(rr.root);
        printDoublyList(lr.head);
    }
    
    static Node extractLeaves(Node root, Node head){
        if(root == null)
            return null;
            
        if (root.left == null && root.right == null){
            return root;    
        }
        
        Node left = extractLeaves(root, head);
        if(left != null){
            if(head != null){
                head = left;
            }
                
        }
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
