/*
Main idea :
Keep on going to the extreme left of the tree if the intermediate (root)node is null that means we have reached the leaf node.
Till then we should push the node on to the stack, when ever we start getting node == null we will pop from the stack, display
the element and traverse to the right child of the node.

Algorithm:
1) Create an empty stack S.
2) Initialize current node as root
3) Push the current node to S and set current = current->left until current is NULL
4) If current is NULL and stack is not empty then 
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right 
     c) Go to step 3.
5) If current is NULL and stack is empty then we are done.
*/

import java.util.Stack;
import java.util.Queue;
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
        int size = 7;
        Node rootNode = createBTree(size);
        System.out.println("First tree");
        displayBTree(rootNode);
        System.out.println("\ninOrderTraversal");
        inOrderTraversal(rootNode);
        
    }
    
    static void inOrderTraversal(Node rootNode){
        Stack<Node> stack = new Stack<Node>();
        if(rootNode == null)
            return;
        
        while(true){
            if(rootNode != null){
                stack.push(rootNode);
                rootNode = rootNode.leftChild;
            }
            else{
                if(stack.isEmpty())
                    break;
                rootNode = stack.pop();
                System.out.print(rootNode.data+"\t");
                rootNode = rootNode.rightChild;
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
    
}
