/*
BFS traversal for graph
creation of graph is done with given edges
*/

import java.util.Queue;
import java.util.LinkedList;
class Graph{
    static class Node{
        int data;
        Node link;
        Node(int d){
            data = d;
            link = null;
        }
        Node(){
            link = null;
        }
        Node(int d, Node l){//for startVertex
            data = d;
            link = l;
        }
    }
    
    public static void main (String[] args) {
        /*------------------------creating a complete graph------------------*/
        int numberOfVertices = 5;
        System.out.println("complete graph of 5 vertices(0-4)");
        Node [] list = createAdjacencyList(numberOfVertices);//create adjacency list for complete graph
        displayGraphEdges(list);
        
        int [][]edges = {
            {0,1},{0,3},{1,0},{1,2},
            {1,4},{2,1},{2,3},{3,0},
            {3,2},{3,4},{4,1},{4,3}
        };
        list = createAdjacencyList2(numberOfVertices, edges);
        displayGraphEdges(list);
        
        /*----------------------------------BFS Traversal--------------------------------*/
        int startVertex = 2;
        System.out.println("BFS traversal for graph starting from "+startVertex+" vertex");
        BFSTraversal(startVertex, list);
    }
    
    static Node[] createAdjacencyList(int numberOfVertices){
       Node []list = new Node[numberOfVertices];
        for (int i=0; i<numberOfVertices; i++){
            list[i] = new Node();
            Node temp = list[i];
            for (int j=0; j<numberOfVertices; j++){
                if(i != j){
                    temp.link = new Node(j);
                    temp = temp.link;
                }
            } 
        }
        return list;
    }
   
    static Node[] createAdjacencyList2(int numberOfVertices, int [][]edges){
        Node []list = new Node[numberOfVertices];
        
        /*----------------------------------creating empty adjacency list-----------------*/
        for (int i=0; i<numberOfVertices; i++){
            list[i] = new Node(i);
        } 
        
        /*----------------------------------linking the nodes------------------------------*/
        for (int i=0; i<edges.length; i++){
                int u = edges[i][0];
                int v = edges[i][1];
                
                Node listLink = list[u].link;
                Node V = new Node(v);
                list[u].link = V;
                V.link = listLink;
        } 
        return list;
    }
    
    static void displayGraphEdges(Node list[]){
       System.out.println("adjacency list : ");
       int numberOfVertices = list.length;
       for (int i=0; i<numberOfVertices; i++){
            System.out.print(i);
            Node temp = list[i];
            while(temp.link != null){
                temp = temp.link;
                System.out.print(" --> "+temp.data);
            }
            System.out.println();
        }
    }
    
    static void BFSTraversal(int startVertex, Node []list){
        String []visited = new String[list.length];
        //System.out.print(startVertex+"\t");
        for (int i=0; i<visited.length; i++)
            visited[i] = "nonVisited";
        
        Queue<Node> que = new LinkedList<Node>();
        Node startNode = new Node(startVertex,list[startVertex].link);
        que.add(startNode);
        //System.out.println("startNode = "+startNode.data+" link = "startNode.link.data);
        visited[startVertex] = "visited";
        while(!que.isEmpty()){
            Node temp = que.poll();
            System.out.print(temp.data+"\t");
            //System.out.println(temp.link.data);
            while(temp.link != null){
                int d = temp.link.data;
                
                //System.out.println("d= "+d);
                if(visited[d].equals("nonVisited")){
                    que.add(list[temp.link.data]);
                    visited[temp.link.data] = "visited";
                }
                temp = temp.link;
            }
        }
    }
}
