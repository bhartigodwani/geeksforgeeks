class Graph{
    static class Node{
        int data;
        int link;
        Node(){
            link = null;
        }
    }
    
    public static void main (String[] args) {
        int numberOfVertices = 5;
        Node []list = new Node[numberOfVertices];
        for (int i=0; i<numberOfVertices; i++){
            for (int j=0; j<numberOfVertices; j++){
                if(i != j){
                    Node temp = new Node(j);
                    
                }

            } 
        } 
        
        
        int edges[][] = new int[7][2];
        edges[0][0] = 0;
        edges[0][1] = 1;
        edges[1][0] = 0;
        edges[1][1] = 4;
        edges[2][0] = 1;
        edges[2][1] = 4;
        edges[3][0] = 3;
        edges[3][1] = 4;
        edges[4][0] = 1;
        edges[4][1] = 2;
        edges[5][0] = 2;
        edges[5][1] = 3;
        
        List<int> []ajdList = new List<int>[5];
        ajdList[0].add(1);
        ajdList[0].add(4);
        ajdList[1].add(2);
        ajdList[1].add(3);
        ajdList[1].add(4);
        
        
    }
}
