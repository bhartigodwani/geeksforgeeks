class Tree{
    static class Node{
        int data;
        Node leftChild;
        Node rightChild;
        Node(int d){
            data = d;
            leftChild = null;
            rightChild = null;
        }
    }
    public static void main (String[] args) {
        Node rootNode = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        
        rootNode.leftChild = two;
        rootNode.rightChild = three;
        two.leftChild = four;
        
        System.out.println("\t\t\t"+rootNode.data);
        System.out.println("\t\t"+rootNode.leftChild.data+"\t\t"+rootNode.rightChild.data);
        System.out.println("\t"+rootNode.leftChild.leftChild.data);
    }
}
 
