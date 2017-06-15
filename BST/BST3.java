/*
Data Structure for a single resource reservations
Design a data structure to do reservations of future jobs on a single machine under following constraints.
1) Every job requires exactly k time units of the machine.
2) The machine can do only one job at a time.
3) Time is part of the system. Future Jobs keep coming at different times. Reservation of a future job is done only if there is no existing reservation within k time frame (after and before)
4) Whenever a job finishes (or its reservation time plus k becomes equal to current time), it is removed from system.

Example:

Let time taken by a job (or k) be = 4

At time 0: Reservation request for a job at time 2 in 
           future comes in, reservation is done as machine 
           will be available (no conflicting reservations)
Reservations {2}

At time 3: Reservation requests at times 15, 7, 20 and 3.
           Job at 7, 15 and 20 can be reserved, but at 3 
           cannot be reserved as it conflicts with a 
           reserved at 2.
Reservations {2, 7, 15, 20}

At time 6: Reservation requests at times 30, 17, 35 and 45
           Jobs at 30, 35 and 45 are reserved, but at 17  
           cannot be reserved as it conflicts with a reserved 
           at 15.
Reservations {7, 15, 30, 35, 45}.
Note that job at 2 is removed as it must be finished by 6.
*/

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
class BTree{
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    
    static class RootReference{
        Node root;
        RootReference(){
            root = null;
        }
    }
    
    public static void main(String []args){
        System.out.println("tree1");
        RootReference rr = new RootReference();
        //rr.root = createBST();
        BFSTraversalLineByLine(rr.root);
        System.out.println();
        /*--------------------------insertion in bst if reservation is possible--------------*/
        int atTime = 0;
        int reservationTime = 2;
        int k = 4;
        rr.root = canReserve(rr.root, reservationTime, atTime, k); 
        System.out.println("tree after reservation = "+reservationTime);
        BFSTraversalLineByLine(rr.root);
        System.out.println("possible reservation so far "+atTime);
        /*--------------possible reservation so far---------------------*/
        reservationAtTime(rr.root, atTime, k);
        System.out.println();
        System.out.println();
        
        
        atTime = 3;
        System.out.println("at time = "+atTime);
        reservationTime = 15;
        rr.root = canReserve(rr.root, reservationTime, atTime, k); 
        System.out.println("tree after reservation = "+reservationTime);
        BFSTraversalLineByLine(rr.root);
        System.out.println();
        
        reservationTime = 7;
        rr.root = canReserve(rr.root, reservationTime, atTime, k); 
        System.out.println("tree after reservation = "+reservationTime);
        BFSTraversalLineByLine(rr.root);
        System.out.println();
        
        reservationTime = 20;
        rr.root = canReserve(rr.root, reservationTime, atTime, k); 
        System.out.println("tree after reservation = "+reservationTime);
        BFSTraversalLineByLine(rr.root);
        System.out.println();
        
        reservationTime = 3;
        rr.root = canReserve(rr.root, reservationTime, atTime, k); 
        System.out.println("tree after reservation = "+reservationTime);
        BFSTraversalLineByLine(rr.root);
        System.out.println("possible reservation so far at "+atTime);
        /*--------------possible reservation so far---------------------*/
        reservationAtTime(rr.root, atTime,k);
        System.out.println();
        System.out.println();
        
        atTime = 6;
        System.out.println("at time = "+atTime);
        reservationTime = 30;
        rr.root = canReserve(rr.root, reservationTime, atTime, k); 
        System.out.println("tree after reservation = "+reservationTime);
        BFSTraversalLineByLine(rr.root);
        System.out.println();
        
        reservationTime = 17;
        rr.root = canReserve(rr.root, reservationTime, atTime, k); 
        System.out.println("tree after reservation = "+reservationTime);
        BFSTraversalLineByLine(rr.root);
        System.out.println();
        
        reservationTime = 35;
        rr.root = canReserve(rr.root, reservationTime, atTime, k); 
        System.out.println("tree after reservation = "+reservationTime);
        BFSTraversalLineByLine(rr.root);
        System.out.println();
        
        reservationTime = 45;
        rr.root = canReserve(rr.root, reservationTime, atTime, k); 
        System.out.println("tree after reservation = "+reservationTime);
        BFSTraversalLineByLine(rr.root);
        System.out.println("possible reservation so far at "+atTime);
        /*--------------possible reservation so far---------------------*/
        reservationAtTime(rr.root, atTime, k);
        System.out.println();
    }
    
    static void reservationAtTime(Node node, int atTime, int k){
        if(node == null)
            return ;
         
        if(node.left == null && node.right == null){
            if(node.data + k > atTime)
                System.out.print(node.data+"\t");
            return;
        }
        reservationAtTime(node.left, atTime, k);
        if(node.data + k > atTime)
            System.out.print(node.data+"\t");
        reservationAtTime(node.right, atTime, k);
    }
    
    static Node canReserve(Node root, int reservationTime, int atTime, int k){
        //if no reservation is done
        if(root == null){
            root = new Node(reservationTime);
            return root;
        }
        //can be scheduled because time has not already passed
        if(reservationTime >= atTime){
            if(reservationTime < root.data){
                if((root.data - reservationTime) >= k){//check for k minutes with reservation
                    if(root.left == null){
                        root.left = new Node(reservationTime);
                        return root;
                    }
                   else
                        canReserve(root.left, reservationTime, atTime, k);    //recursive calls for insertion
                }
                else
                    System.out.println("can't schedule "+reservationTime);
            }
            else if(reservationTime > root.data){
                if((reservationTime - root.data) >= k){
                    if(root.right == null){
                        root.right = new Node(reservationTime);
                        return root;
                    }
                    else
                        canReserve(root.right, reservationTime, atTime, k);    
                }
                else
                    System.out.println("can't schedule "+reservationTime);
            }
        }
        //cant be scheduled because time is already passed
        else
            System.out.println("can't be scheduled because "+reservationTime+" lacks by "+atTime);
        return root;
    }
    
    static void BFSTraversalLineByLine(Node rootNode){
        if(rootNode == null)
            System.out.println("null");
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
            printLevelOrderLineByLine(rootNode.left,level-1);
            printLevelOrderLineByLine(rootNode.right, level-1);
        }
    }
    
    static int findHeight(Node node){
        if (node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 1;
        int height = Math.max(findHeight(node.left), findHeight(node.right)) + 1;
        return height;
    }
}
