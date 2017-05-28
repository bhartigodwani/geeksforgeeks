/*
A Boolean Matrix Question
Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1
(or true) then make all the cells of ith row and jth column as 1.

Example 1
The matrix
1 0
0 0
should be changed to following
1 1
1 0

Example 2
The matrix
0 0 0
0 0 1
should be changed to following
0 0 1
1 1 1

Example 3
The matrix
1 0 0 1
0 0 1 0
0 0 0 0
should be changed to following
1 1 1 1
1 1 1 1
1 0 1 1
*/

import java.util.Scanner;
class Matrix2{
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
        
        int rowMatrix[] = new int[rows];
        int columnMatrix[] = new int[columns];
        
        for (int row=0; row<rows; row++){
            for (int column=0; column<columns; column++){
                if(matrix[row][column] == 1){
                    rowMatrix[row] = 1;
                    columnMatrix[column] = 1;
                }
            } 
        }
        
        for (int row=0; row<rows; row++){
            if (rowMatrix[row] == 1){
                for (int column=0; column<columns; column++){
                    matrix[row][column] = 1;
                } 
            } 
        }
        
        for (int column=0; column<columns; column++){
            if (columnMatrix[column] == 1){
                for (int row=0; row<rows; row++){
                    matrix[row][column] = 1;
                } 
            } 
        }
        
        System.out.println("Output matrix");
        for (int row=0; row<rows; row++){
            for (int column =0; column<columns; column++){
                System.out.print(matrix[row][column]+"  ");
            } 
            System.out.println();
        } 
    }
}
