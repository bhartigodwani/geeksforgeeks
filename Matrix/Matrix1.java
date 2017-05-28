/*
Search in a row wise and column wise sorted matrix
Given an n x n matrix and a number x, find position of x in the matrix if it is present in it. 
Else print “Not Found”. In the given matrix, every row and column is sorted in increasing order. 
The designed algorithm should have linear time complexity.
Example :
Input : mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 29
Output : Found at (2, 1)
Input : mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 100
Output : Element not found
*/

import java.util.Scanner;
class Matrix1{
    public static void main (String[] args) {
        int size = 4;
        int [][]matrix = new int[size][size];
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                matrix[i][j] = sc.nextInt();
            } 
        }
        
        int elementToBeFound = 29;
        int column = size-1;
        int flag = 0;
        for (int row=0; row<size; ){
            if (matrix[row][column] == elementToBeFound){
                System.out.println("element found at ["+row+"]["+column+"]");
                flag = 1;
                break;
            }
            
            if (matrix[row][column] > elementToBeFound && column >= 0){
                column--;
            }
            
            else if (matrix[row][column] < elementToBeFound){
                row++;
            }
        } 
        
        if (flag == 0)
            System.out.println("element not found");
    }
}
