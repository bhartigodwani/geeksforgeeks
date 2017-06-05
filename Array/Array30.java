/*

Turn an image by 90 degree

Given an image, how will you turn it by 90 degrees? A vague question. Minimize the browser and try your solution before 
going further.

An image can be treated as 2D matrix which can be stored in a buffer. We are provided with matrix dimensions and it’s base 
address. How can we turn it?

For example see the below picture,

* * * ^ * * *
* * * | * * *
* * * | * * *
* * * | * * *

After rotating right, it appears (observe arrow direction)

* * * *
* * * *
* * * *
-- - - >
* * * *
* * * *
* * * *
*/

import java.io.*;
import java.util.*;

public class Array30 {

    public static void main(String[] args) {
        char [][]a = new char[4][7];
        int i,j;
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        for(i=0; i<rows; i++){
            for(j=0; j<columns; j++){
                a[i][j] = sc.next().charAt(0);
            }
        }
        
        char newA[][] = new char[columns][rows];
        /*-------------one way----------*/
        for( i=columns-1;i>=0 ;i--){
            for( j=rows-1; j>=0; j--){
                newA[i][rows-j-1] = a[j][i];
            }
        }
        
        /*-------------second way----------*/
        int row , col=columns;
        /*for(int r=columns-1; r>=0; r--){
            row = rows-1;
            col--; 
            for(int c=0; c<rows; c++){
                if(row>=0){
                    newA[r][c] = a[row][col];
                }
                row--; 
            }
        }*/
        
        System.out.println("original image");        
        for(int r=0; r<rows; r++){
            for(int c=0; c<columns; c++){
                System.out.print(a[r][c]+"  ");
            }
            System.out.println();
        }
        
        System.out.println("new rotated image");
        for(int r=0; r<columns; r++){
            for(int c=0; c<rows; c++){
                System.out.print(newA[r][c]+"  ");
            }
            System.out.println();
        }
    }
}
