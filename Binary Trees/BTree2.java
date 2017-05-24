import java.util.Queue;
import java.util.LinkedList;

public class CreateTree{

    class Node{
        int data;
        Node leftChild;
        Node rightChild;
        Node(int d){
            int data = d;
            leftChild = rightChild = null;
        }
    }
	public static Node createTree(int count){
		Queue<Node> queue=new LinkedList<>();
		int label = 1;
		Node root = null;
		Node node = new Node(label);
		root = node;
		label++;
		queue.add(root);
		Node left,right;
		while(label <= count){
			node = queue.poll();
			left = new Node(label++);
			right = new Node(label++);
			node.left = left;
			node.right = right;
			queue.add(left);
			queue.add(right);
		}
		return root;
	}

	public static void main(String[] args){
		Node rootNode = createTree(7);
		BinaryTree bt = new BinaryTree();
		bt.printTree(rootNode);
	}
	
	static void createTree(Node rootNode){
	    
	}
}
