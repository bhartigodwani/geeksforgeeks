/*

Level order traversal in spiral form

Write a function to print spiral order traversal of a tree. For below tree, function should print 1, 2, 3, 4, 5, 6, 7. 
*/

import java.util.Queue;
import java.util.LinkedList;
class BTree{
    static class Node{
        int data;
        Node leftChild;
        Node rightChild;
        Node(int d){
            data = d;
            leftChild = rightChild =null;
        }
    }
    
    public static void main (String[] args) {
        /*first tree*/
        System.out.println("first tree");
        int size = 7;//number of nodes in complete tree
        Node rootNode = createBTree(size);
        displayBTree(rootNode);
        System.out.println("BFSTraversal:");
        BFSTraversal(rootNode);
        System.out.println("\n\nBFS in spiral, line by line for first tree");
        spiralBFSPrint(rootNode);
        
        /*second tree*/
        rootNode = createBTree2();
        System.out.println("\n\nsecond tree");
        System.out.println("BFSTraversal:");
        BFSTraversal(rootNode);
        System.out.println("\n\nBFS in spiral, line by line for second tree");
        spiralBFSPrint(rootNode);
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
    
    static void displayBTree(Node rootNode){
        System.out.println(rootNode.data);
        System.out.println(rootNode.leftChild.data+"\t"+rootNode.rightChild.data);
        System.out.print(rootNode.leftChild.leftChild.data+"\t"+rootNode.leftChild.rightChild.data+"\t");
        System.out.println(rootNode.rightChild.leftChild.data+"\t"+rootNode.rightChild.rightChild.data);
    }
    
    static Node createBTree2(){
        Node rootNode = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        rootNode.rightChild = two;
        rootNode.rightChild.rightChild = three;
        return rootNode;
    }
    
    static void BFSTraversal(Node rootNode){
        Queue<Node> que = new LinkedList<Node>();
        que.add(rootNode);
        while(!que.isEmpty()){
            Node node = que.poll();
            System.out.print(node.data+"\t");
            Node leftChild = node.leftChild;
            Node rightChild = node.rightChild;
            
            if (leftChild != null)
                que.add(leftChild);
                
            if(rightChild != null)
                que.add(rightChild);
        }
    }
    
    static void spiralBFSPrint(Node rootNode){
        int height = findHeight(rootNode);
        /*print node level wise*/
        boolean flag = false;
        for(int level=1; level<=height; level++){
            printSpiralOrderLineByLine(rootNode, level, flag);
            flag = !flag;
            System.out.println();
        }
    }
    
    static void printSpiralOrderLineByLine(Node rootNode, int level, boolean flag){
        if(rootNode == null)
            return;
        if(level == 1)
                System.out.print(rootNode.data+"\t");
        
        else if(level > 1){
            if(flag != false){
                    printSpiralOrderLineByLine(rootNode.leftChild,level-1, flag);
                    printSpiralOrderLineByLine(rootNode.rightChild, level-1,flag);
                }
                
            else{
                printSpiralOrderLineByLine(rootNode.rightChild, level-1,flag);
                printSpiralOrderLineByLine(rootNode.leftChild,level-1,flag);
            }
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
