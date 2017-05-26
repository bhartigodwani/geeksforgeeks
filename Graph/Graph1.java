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
        Node [] list = createGraph(numberOfVertices);//create complete graph of numberOfVertices size
        displayGraphEdges(list);
   }
   
   static Node[] createGraph(int numberOfVertices){
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
