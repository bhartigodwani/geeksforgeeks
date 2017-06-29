/*

Find the row with maximum number of 1s

Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.

Example
Input matrix
0 1 1 1
0 0 1 1
1 1 1 1  // this row has maximum 1s
0 0 0 0

Output: 2
*/
class Array{
    public static void main(String []args){
        int a[][] = { {0, 0, 0, 1},
        {0, 1, 1, 1},
        {1, 1, 1, 1},
        {0, 0, 0, 0}
      };
        
        int i = 0;
        int j = a.length-1;
        while(i<a.length && j>=0){
            if(a[i][j] == 1)
                j--;
            else if(a[i][j] == 0)
                i++;
        }
        System.out.println("row = "+i);
    }
}
