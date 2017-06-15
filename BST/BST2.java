/*
Binary Search Tree | Set 2 (Delete)
We have discussed BST search and insert operations. In this post, delete operation is discussed. When we delete a node, there possibilities arise.

1) Node to be deleted is leaf: Simply remove from the tree.

              50                            50
           /     \         delete(20)      /   \
          30      70       --------->    30     70 
         /  \    /  \                     \    /  \ 
       20   40  60   80                   40  60   80

2) Node to be deleted has only one child: Copy the child to the node and delete the child

              50                            50
           /     \         delete(30)      /   \
          30      70       --------->    40     70 
            \    /  \                          /  \ 
            40  60   80                       60   80

3) Node to be deleted has two children: Find inorder successor of the node. Copy contents of the inorder successor to the node and delete the inorder successor. Note that inorder predecessor can also be used.

              50                            60
           /     \         delete(50)      /   \
          40      70       --------->    40    70 
                 /  \                            \ 
                60   80                           80

The important thing to note is, inorder successor is needed only when right child is not empty. In this particular case, inorder successor can be obtained by finding the minimum value in right child of the node.
*/

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
class BST{
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
    
    public static void main(String []args){
        System.out.println("tree1");
        RootReference rr = new RootReference();
        rr.root = createBST();
        BFSTraversalLineByLine(rr.root);
        deleteNodeInBST(rr.root, 14);
        System.out.println("tree after deletion = 14");
        BFSTraversalLineByLine(rr.root);
        
        
        System.out.println("tree2");
        rr.root = createBST();
        BFSTraversalLineByLine(rr.root);
        deleteNodeInBST(rr.root, 20);
        System.out.println("tree after deletion = 20");
        BFSTraversalLineByLine(rr.root);        
        
        System.out.println("tree3");
        rr.root = createBST();
        BFSTraversalLineByLine(rr.root);
        deleteNodeInBST(rr.root, 9);
        System.out.println("tree after deletion = 9");
        BFSTraversalLineByLine(rr.root);        
        
        System.out.println("tree4");
        rr.root = createBST();
        BFSTraversalLineByLine(rr.root);
        deleteNodeInBST(rr.root, 7);
        System.out.println("tree after deletion = 7");
        BFSTraversalLineByLine(rr.root);        
        
        System.out.println("tree5");
        rr.root = createBST();
        BFSTraversalLineByLine(rr.root);
        deleteNodeInBST(rr.root, 3);
        System.out.println("tree after deletion = 3");
        BFSTraversalLineByLine(rr.root);        
        
        System.out.println("tree6");
        rr.root = createBST();
        BFSTraversalLineByLine(rr.root);
        deleteNodeInBST(rr.root, 5);
        System.out.println("tree after deletion = 5");
        BFSTraversalLineByLine(rr.root);        
        
        System.out.println("tree7");
        rr.root = createBST();
        BFSTraversalLineByLine(rr.root);
        deleteNodeInBST(rr.root, 12);
        System.out.println("tree after deletion = 12");
        BFSTraversalLineByLine(rr.root);        
    }
    
    static void deleteNodeInBST(Node root, int key){
        root = deleteRecursive(root, key);
    }
    
    static Node deleteRecursive(Node root, int key){
        if(root == null)
            return null;
        
        //when key can be at left side of the bst
        if(key < root.data)
            root.left = deleteRecursive(root.left, key);
        
        //when key can be at right side of the bst
        else if(key > root.data)
            root.right = deleteRecursive(root.right, key);
        
        //when key == root.data
        else{
            //if node have only one child
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            
            //when both children are present
            else{
                root.data = getInorderSuccessor(root.right);    //finding inorder successor 
                root.right = deleteRecursive(root.right, root.data);
            }            
        }
        return root;
    }
    
    static int getInorderSuccessor(Node root){
        int min = root.data;
        Node temp = root.left;
        while(temp != null){
            min = temp.data;
            temp = temp.left;
        }
        return min;
    }
    
    static Node createBST(){
        Node root = new Node(12);
        Node five = new Node(5);
        Node fifteen = new Node(15);
        Node three = new Node(3);
        Node seven = new Node(7);
        Node thirteen = new Node(13);
        Node seventeen = new Node(17);
        Node one = new Node(1);
        Node nine = new Node(9);
        Node fourteen = new Node(14);
        Node twenty = new Node(20);
        Node eight = new Node(8);
        Node eleven = new Node(11);
        Node eighteen = new Node(18);
        
        root.left = five;
        root.right = fifteen;
        five.left = three;
        five.right = seven;
        fifteen.left = thirteen;
        fifteen.right = seventeen;
        three.left = one;
        seven.right = nine;
        thirteen.right = fourteen;
        seventeen.right = twenty;
        nine.left = eight;
        nine.right = eleven;
        twenty.left = eighteen;
        
        return root;
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
