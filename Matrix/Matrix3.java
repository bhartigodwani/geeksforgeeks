/*
Print unique rows in a given boolean matrix
Given a binary matrix, print all unique rows of the given matrix.

Input:
	{0, 1, 0, 0, 1}
    {1, 0, 1, 1, 0}
    {0, 1, 0, 0, 1}
    {1, 1, 1, 0, 0}
Output:
	0 1 0 0 1 
	1 0 1 1 0 
	1 1 1 0 0 
*/

import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
class Matrix3{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of rows and columns:");
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int [][]matrix = new int[rows][columns];
        
        System.out.println("\nGiven matrix is ");
        for (int row=0; row<rows; row++){
            for (int column=0; column<columns; column++){
                matrix[row][column] = sc.nextInt();
                System.out.print(matrix[row][column]+"  ");
            } 
            System.out.println();
        }
         
        System.out.println("\nUnique rows :");
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int row=0; row<rows; row++){
            
            List<Integer> list = new ArrayList<Integer>();
            for (int column=0; column<columns; column++){
                if (matrix[row][column] == 1)
                    list.add(column);
            }
           
            if (!map.containsValue(list)){
                map.put(row,list);
                for (int column=0; column<columns; column++){
                    System.out.print(matrix[row][column]+"  ");
                }
                System.out.println();
            }    
        } 
    }
}
