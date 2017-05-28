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
Solution :
  for every row calculate the corresponding decimal value that will be unique for every row if they are.
  then using hashmap(key=rows,value=row's decimal values)
*/

import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
class Matrix4{
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
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int row=0; row<rows; row++){
            Integer decimalValue = 0;
            int power = 0;
            for (int column=columns-1; column>=0; column--){
                decimalValue += (int)(Math.pow(2,power)*matrix[row][column]);
                power++;
            }
           
            if (!map.containsValue(decimalValue)){
                map.put(row,decimalValue);
                for (int column=0; column<columns; column++){
                    System.out.print(matrix[row][column]+"  ");
                }
                System.out.println();
            }    
        } 
    }
}
