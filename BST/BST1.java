import java.util.Arrays;
class BST{
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
        int elements[] = {4,2,5,1,6,3,7};
        System.out.println("elements to inserted in the BST : "+Arrays.toString(elements));
        Node rootNode = null;
        rootNode = insertNodeBST(rootNode,elements[0]);
        for (int i=0; i<elements.length; i++){
            addNodeBST(rootNode,elements[i]);    
        } 
        
        )
    }
    
    static Node insertNodeBST(Node rootNode, int element){
        if (rootNode == null)
            return new Node(element);
        if (rootNode.leftChild < rootNode) 
        
    }
}
