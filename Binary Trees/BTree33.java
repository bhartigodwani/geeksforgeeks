/*


Check if a binary tree is subtree of another binary tree 

Given two binary trees, check if the first tree is subtree of the second one. A subtree of a tree T is a tree S consisting of a node in T and all of its descendants in T. The subtree corresponding to the root node is the entire tree; the subtree corresponding to any other node is called a proper subtree.

For example, in the following case, tree S is a subtree of tree T.

        Tree 2
          10  
        /    \ 
      4       6
       \
        30


        Tree 1
              26
            /   \
          10     3
        /    \     \
      4       6      3
       \
        30
*/

import java.util.Stack;
import java.util.Queue;
import java.util.Arrays;
import java.util.List;
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
        
        /*--------------------case 1------------------------------*/
        int size = 7;
        System.out.println("case 1");
        Node rootNode1 = createBTree(size);
        System.out.println("tree A");
        BFSTraversalLineByLine(rootNode1);
        System.out.println("tree B");
        Node rootNode2 = createBTree1b();
        BFSTraversalLineByLine(rootNode2);
        if(isSubtree(rootNode1,rootNode2))
            System.out.println("tree A is subtree of tree B");
        else 
            System.out.println("tree A is not subtree of tree B");
        
        /*--------------------case 2------------------------------*/
        System.out.println("\ncase 2");
        Node rootNode1 = createBTree2();
        System.out.println("tree A");
        BFSTraversalLineByLine(rootNode1);
        System.out.println("tree B");
        Node rootNode2 = createBTree2a();
        BFSTraversalLineByLine(rootNode2);
        if(isSubtree(rootNode1,rootNode2))
            System.out.println("tree A is subtree of tree B");
        else 
            System.out.println("tree A is not subtree of tree B");
            
        /*--------------------case 3------------------------------*/
        System.out.println("\ncase 3");
        Node rootNode1 = createBTree2();
        System.out.println("tree A");
        BFSTraversalLineByLine(rootNode1);
        System.out.println("tree B");
        Node rootNode2 = createBTree2b();
        BFSTraversalLineByLine(rootNode2);
        if(isSubtree(rootNode1,rootNode2))
            System.out.println("tree A is subtree of tree B");
        else 
            System.out.println("tree A is not subtree of tree B");            
            
        /*--------------------case 4------------------------------*/
        System.out.println("\ncase 4");
        rootNode1 = createBTree5();
        System.out.println("tree A");
        BFSTraversalLineByLine(rootNode1);
        System.out.println("tree B");
        rootNode2 = createBTree6a();
        BFSTraversalLineByLine(rootNode2);
        if(isSubtree(rootNode1,rootNode2))
            System.out.println("tree A is subtree of tree B");
        else 
            System.out.println("tree A is not subtree of tree B");

        /*--------------------case 5------------------------------*/
        System.out.println("\ncase 5");
        rootNode1 = createBTree5();
        System.out.println("tree A");
        BFSTraversalLineByLine(rootNode1);
        System.out.println("tree B");
        rootNode2 = createBTree6b();
        BFSTraversalLineByLine(rootNode2);
        if(isSubtree(rootNode1,rootNode2))
            System.out.println("tree A is subtree of tree B");
        else 
            System.out.println("tree A is not subtree of tree B");
            
        /*--------------------case 6------------------------------*/
        System.out.println("\n");
        rootNode1 = createBTree6();
        System.out.println("tree A");
        BFSTraversalLineByLine(rootNode1);
        System.out.println("tree B");
        rootNode2 = createBTree7();
        BFSTraversalLineByLine(rootNode2);
        if(isSubtree(rootNode1,rootNode2))
            System.out.println("tree A is subtree of tree B");
        else 
            System.out.println("tree A is not subtree of tree B");
        
    }
    
    static boolean isSubtree(Node rootNode1, Node rootNode2){
        int data = rootNode1.data;
        rootNode2 = findNodeContainingData(data, rootNode2);
        if (rootNode2 != null){
            Queue<Node> que1 = new LinkedList<Node>();
            Queue<Node> que2 = new LinkedList<Node>();
            que1.add(rootNode1);
            que2.add(rootNode2);
            
            while(!que1.isEmpty() && !que2.isEmpty()){
                Node node1 = que1.poll();
                Node node2 = que2.poll();
                
                Node l1 = node1.leftChild;
                Node r1 = node1.rightChild;
                
                Node l2 = node2.leftChild;
                Node r2 = node2.rightChild;
                
                if (l1 != null && l2 != null)
                    que1.add(leftChild);
                    
                if(rightChild != null)
                    que.add(rightChild);
            }
        } 
    }
    
    static Node findNodeContainingData(int data, Node rootNode){
        Queue<Node> que = new LinkedList<Node>();
        que.add(rootNode);
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node.data == data)
                return node;
            Node leftChild = node.leftChild;
            Node rightChild = node.rightChild;
            
            if (leftChild != null)
                que.add(leftChild);
                
            if(rightChild != null)
                que.add(rightChild);
        }
        return null;
    }
    
    static Node createBTree7(){
        Node rootNode = new Node(4);
        Node two1 = new Node(2);
        Node two2 = new Node(2);
        Node one = new Node(1);
        
        rootNode.rightChild = two1;
        two1.rightChild = two2;
        two2.rightChild = one;
        return rootNode;    
    }
    
    static Node createBTree1b(Node rootNode){
            Node rootNode = new Node(3);
            rootNode.leftChild = new Node(6);
            rootNode.rightChild = new Node(7);
    }
    
    static Node createBTree2a(){
        Node rootNode = new Node(3);
        Node six = new Node(6);
        Node seven = new Node(7);
        
        rootNode.leftChild = six;
        six.rightChild = seven;
        
        return rootNode;
    }   
    
    static Node createBTree2b(){
        Node rootNode = new Node(2);
        rootNode.leftChild = new Node(4);
        rootNode.rightChild = new Node(5);
        
        return rootNode;    
    }
    
    static Node createBTree6a(){
        Node rootNode = new Node(3);
        rootNode.leftChild = new Node(3);
        return rootNode;
    }
    
    static Node createBTree6b(){
        Node rootNode = new Node(10);
        rootNode.leftChild = new Node(4);
        rootNode.rightChild = new Node(6);
        return rootNode;
    }
        
    static int sum(Node node){
        if(node == null)
            return 0;
            
        return sum(node.leftChild) + node.data + sum(node.rightChild);
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
    
    static Node createBTree2(){
        Node rootNode = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        
        rootNode.leftChild = two;
        rootNode.rightChild = three;
        two.leftChild = four;
        three.leftChild = six;
        six.rightChild = seven;
        
        return rootNode;
    }
    
    static Node createBTree3(){
        Node rootNode = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        
        rootNode.leftChild = two;
        two.leftChild = three;
        three.leftChild = four;
        four.leftChild = five;
        return rootNode;
    }
    
    static Node createBTree4(){
        Node rootNode = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        
        rootNode.leftChild = two;
        rootNode.rightChild = four;
        two.leftChild = three;
        three.leftChild = six;
        four.leftChild = five;
        five.leftChild = seven;
        
        return rootNode;
    }
    
    static Node createBTree5(){
        Node rootNode = new Node(26);
        Node ten = new Node(10);
        Node three1 = new Node(3);
        Node six = new Node(6);
        Node four = new Node(4);
        Node three2 = new Node(3);
        
        rootNode.leftChild = ten;
        rootNode.rightChild = three1;
        ten.leftChild = six;
        ten.rightChild = four;
        three1.rightChild = three2;
        return rootNode;
    }
    
    static Node createBTree6(){
        Node rootNode = new Node(16);
        Node eight = new Node(8);
        Node four = new Node(4);
        Node two = new Node(2);
        Node one1 = new Node(1);
        Node one2 = new Node(1);
        
        rootNode.rightChild = eight;
        eight.rightChild = four;
        four.rightChild = two;
        two.rightChild = one1;
        one1.rightChild = one2;
        
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
            printLevelOrderLineByLine(rootNode.leftChild,level-1);
            printLevelOrderLineByLine(rootNode.rightChild, level-1);
        }
    }

    static int findHeight(Node node){
        if (node == null)
            return 0;
        if(node.leftChild == null && node.rightChild == null)
            return 1;
        int height = Math.max(findHeight(node.leftChild), findHeight(node.rightChild)) + 1;
        return height;
    }
    
}
