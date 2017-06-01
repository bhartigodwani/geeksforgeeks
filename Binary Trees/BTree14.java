/*
Construct Tree from given Inorder and Preorder traversals
Algorithm: buildTree()
1) Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick next element in 
next recursive call.
2) Create a new tree node tNode with the data as picked element.
3) Find the picked element’s index in Inorder. Let the index be inIndex.
4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
6) return tNode.
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
        Integer [] inorder1 = {4,2,5,1,6,3,7};
        Integer [] preorder1 = {1,2,4,5,3,6,7};
        Integer [] postorder1 = {4,5,2,6,7,3,1};
        int size = 7;
        Node rootNode = createBTree(size);
        System.out.println("First original tree");
        BFSTraversalLineByLine(rootNode);
        System.out.println("tree made by inorder and preorder");
        rootNode = in_Pre_Order(inorder1, preorder1);
        BFSTraversalLineByLine(rootNode);
        System.out.println("tree made by inorder and postorder");
        rootNode = in_Post_Order(inorder1,postorder1);
        BFSTraversalLineByLine(rootNode);
        
        
        /*--------------------case 2------------------------------*/
        Integer []inorder2 = {4,2,1,6,7,3};
        Integer []preorder2 = {1,2,4,3,6,7};
        Integer []postorder2 = {4,2,7,6,3,1};
        System.out.println("\n");
        rootNode = createBTree2();
        System.out.println("Second tree");
        BFSTraversalLineByLine(rootNode);
        System.out.println("tree made by inorder and preorder");
        rootNode = in_Pre_Order(inorder2, preorder2);
        BFSTraversalLineByLine(rootNode);
        System.out.println("tree made by inorder and postorder");
        rootNode = in_Post_Order(inorder2,postorder2);
        BFSTraversalLineByLine(rootNode);
            
        /*--------------------case 3------------------------------*/
        Integer []inorder3 = {5,4,3,2,1};
        Integer []preorder3 = {1,2,3,4,5};
        Integer []postorder3 = {5,4,3,2,1};
        System.out.println("\n");
        rootNode = createBTree3();
        System.out.println("Third tree");
        BFSTraversalLineByLine(rootNode);
        System.out.println("tree made by inorder and preorder");
        rootNode = in_Pre_Order(inorder3, preorder3);
        BFSTraversalLineByLine(rootNode);
        System.out.println("tree made by inorder and postorder");
        rootNode = in_Post_Order(inorder3,postorder3);
        BFSTraversalLineByLine(rootNode);
        
    }
    
    static Node in_Pre_Order(Integer [] inorder, Integer[] preorder){
        Node rootNode = new Node(preorder[0]);
        for (int i=1; i<preorder.length; i++){
            rootNode = buildTree(rootNode, preorder[i], inorder);
        } 
        return rootNode;
    }
    
    static Node in_Post_Order(Integer [] inorder, Integer[] postorder){
        Node rootNode = new Node(postorder[postorder.length-1]);
        for (int i=postorder.length-2; i >= 0; i--){
            rootNode = buildTree(rootNode, postorder[i], inorder);
        } 
        return rootNode;
    }
    
    static Node buildTree(Node rootNode, int element, Integer []inorder){
        List inorderList = Arrays.asList(inorder);
        Node newNode = new Node(element);
        Node temp = rootNode;
        while(true){
            if(inorderList.indexOf(element) < inorderList.indexOf(temp.data)){
                if(temp.leftChild != null)
                    temp = temp.leftChild;
                else{
                    temp.leftChild = newNode;
                    break;
                }
            }
            else{
                if(temp.rightChild != null)
                    temp = temp.rightChild;
                else{
                    temp.rightChild = newNode;
                    break;
                }
            }
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
