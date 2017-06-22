/*
Print a Binary Tree in Vertical Order | Set 2 (Hashmap based Method)

Given a binary tree, print it vertically. The following example illustrates vertical order traversal.

           1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9 
               
			  
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9
*/

import java.util.*;
class Hash1{
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    
    public static void main(String []args){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Node root = createBTree();
        createHashTable(root, map, 0);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
    
    static void createHashTable(Node root, HashMap<Integer, Integer> map, int HD){
        if(root == null)
            return;
        map.put(root.data, HD);
        createHashTable(root.left, map, HD-1);
        createHashTable(root.right, map, HD+1);
    }
    
    /*---------------------------using bfs-----------------------------*/
    /*--------------------order is not correct-------------------------*/
    /*static void createHashTable(Node root, HashMap<Integer, Integer> map){
        if(root == null)
            return;
        
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        que.add(null);
        map.put(root.data, 0);
        
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node == null){
                System.out.println();
                if(!que.isEmpty())
                    que.add(null);
            }
            else{
                System.out.print(node.data+"  ");
                Node left = node.left;
                Node right = node.right;
                if (left != null){
                    que.add(left);
                    map.put(node.left.data, map.get(node.data)-1);
                }

                if(right != null){
                    que.add(right);
                    map.put(node.right.data, map.get(node.data)+1);
                }
            }
        }
    }*/
    
    static Node createBTree(){
        Node root = new Node(4);
        Node o1 = new Node(2);
        Node o2 = new Node(5);
        Node o3 = new Node(1);
        Node o4 = new Node(3);
        Node o5 = new Node(6);
        Node o6 = new Node(7);
        
        root.left = o1;
        root.right = o2;
        o1.left = o3;
        o1.left = o3;
        o1.right = o4;
        o2.right = o5;
        o5.right = o6;
        
        return root;
    }
    
    static Node createBTree2(){
        Node root = new Node(10);
        Node o1 = new Node(8);
        Node o2 = new Node(12);
        Node o3 = new Node(7);
        Node o4 = new Node(9);
        Node o5 = new Node(14);
        Node o6 = new Node(18);
        
        root.left = o1;
        root.right = o2;
        o1.left = o3;
        o1.right = o4;
        o2.right = o5;
        o5.right = o6;
        
        return root;
    }
    
    static void BFSTraversalLineByLine(Node root){
        if(root == null)
            System.out.println("null");
        
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        que.add(null);
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node == null){
                System.out.println();
                if(!que.isEmpty())
                    que.add(null);
            }
            else{
                System.out.print(node.data+"  ");
                Node left = node.left;
                Node right = node.right;
                if (left != null)
                    que.add(left);

                if(right != null)
                    que.add(right);
            }
        }
    }
}
