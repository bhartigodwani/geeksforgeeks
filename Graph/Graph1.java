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
    }
    
    public static void main (String[] args) {
        int numberOfVertices = 5;
        System.out.println("complete graph of 5 vertices(0-4)");
        Node [] list = createAdjacencyList(numberOfVertices);//create adjacency list for complete graph
        displayGraphEdges(list);
        
        System.out.println("\na non cmplete graph of 5 vertices(0-4)");
        list = createAdjacencyList2(numberOfVertices);
        displayGraphEdges(list);
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
   
   
   static Node[] createAdjacencyList2(int numberOfVertices){
        Node []list = new Node[numberOfVertices];
        for (int i=0; i<numberOfVertices; i++){
            list[i] = new Node();
            Node temp = list[i];
            int value = 0;
            if(i < numberOfVertices-2){
                    temp.link = new Node(i+1);
                    temp = temp.link;
                    temp.link = new Node(i+2);
                }
            
            else{
                    temp.link = new Node(i-1);
                    temp = temp.link;
                    temp.link = new Node(i-2);
            }
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
}
