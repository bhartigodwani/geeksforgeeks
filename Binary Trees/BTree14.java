/*
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
        int [] inorder = {7,3,6,1,5,2,4};
        int [] preorder = {1,3,7,6,2,5,4};
        int [] postorder = {7,6,3,5,4,2,1};
        
        int size = 7;
        Node rootNode = createBTree(size);
        System.out.println("First tree");
        displayBTree(rootNode);
        System.out.println("\nTree made by Inorder and Preorder");
        rootNode = preInorderGiven(inorder, preorder);
        BFSTraversalLineByLine(rootNode);
        
        /*System.out.println("\nTree made by Inorder and Postorder");
        rootNode = postInOrderGiven(inorder, postorder);
        BFSTraversalLineByLine(rootNode);*/
        
        System.out.println("\n");
        rootNode = createBTree(size);
        System.out.println("Second tree");
        displayBTree(rootNode);
        System.out.println("\nTree made by Inorder and Preorder");
        rootNode = preInorderGiven(inorder, preorder);
        BFSTraversalLineByLine(rootNode);
        
        /*System.out.println("\nTree made by Inorder and Postorder");
        rootNode = postInOrderGiven(inorder, postorder);
        BFSTraversalLineByLine(rootNode);*/
    }
    
    static Node preInorderGiven(int []inorder, int []preorder){
        Integer []in = new Integer[inorder.length];
        Integer []pre = new Integer[preorder.length];
        for (int i=0; i<inorder.length; i++){
            in[i] = inorder[i];
            pre[i] = preorder[i];
        } 
        Node rootNode = new Node(preorder[0]);
        List inList = Arrays.asList(in);
        List preList = Arrays.asList(pre);
        int i=1;
    
        List list = Arrays.asList(new Character[] { 'm', 'e', 'y' });
        System.out.println(list.indexOf('e'));
        
        while(i < pre.length){
            Node newNode = new Node(pre[i]);
            Node temp = rootNode;
            while(true){
                if(temp.leftChild != null && inList.indexOf(pre[i]) < inList.indexOf(temp.data)){
                    temp = temp.leftChild;
                }
            }
            while(temp.leftChild != null && temp.rightChild != null)
        }
        
        return rootNode;
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
        
    static void displayBTree(Node rootNode){
        System.out.println(rootNode.data);
        System.out.println(rootNode.leftChild.data+"\t"+rootNode.rightChild.data);
        System.out.print(rootNode.leftChild.leftChild.data+"\t"+rootNode.leftChild.rightChild.data+"\t");
        System.out.println(rootNode.rightChild.leftChild.data+"\t"+rootNode.rightChild.rightChild.data);
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
