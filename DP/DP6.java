/*

Dynamic Programming | Set 6 (Min Cost Path)

Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to
reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell. Total cost of a path to 
reach (m, n) is sum of all the costs on that path (including both source and destination). You can only traverse down, right 
and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be
traversed. You may assume that all costs are positive integers.

For example, in the following figure, what is the minimum cost path to (2, 2)?
_____________
| 1 | 2 | 3 |
| 4 | 8 | 2 |
|_1_|_5_|_3_|

The path with minimum cost is highlighted in the following figure. The path is (0, 0) –> (0, 1) –> (1, 2) –> (2, 2). The cost
of the path is 8 (1 + 2 + 2 + 3).
*/
import java.util.Scanner;
class DP6{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int table[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++)
                table[i][j] = sc.nextInt();
        }
        int fm = sc.nextInt(), fn = sc.nextInt();
        int dp[][] = new int [m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++)
                dp[i][j] = -1;
        }
        double startTime = System.nanoTime();
        int result = calculateCostWithoutDP(table, 0, 0, fm, fn);
        System.out.println("min cost without dp = "+result);
        double endTime   = System.nanoTime();
        double totalTime = endTime - startTime;
        System.out.println("time without DP = "+totalTime);
        
        startTime = System.nanoTime();
        result = calculateCostDP(table, 0, 0, fm, fn, dp);
        System.out.println("min cost with dp = "+result);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("time with DP = "+totalTime);
    }
    
    static int calculateCostDP(int [][]table, int cm, int cn, int fm, int fn, int [][]dp){
        if(cm > fm || cn > fn)
            return Integer.MAX_VALUE;
        if(cm == fm && cn == fn)
            return table[fm][fn];
        if(dp[cm][cn] != -1)
            return dp[cm][cn];
        
        int l = calculateCostDP(table, cm+1, cn, fm, fn, dp);
        int c = calculateCostDP(table, cm+1, cn+1, fm, fn, dp);
        int r = calculateCostDP(table, cm, cn+1, fm, fn, dp);
        dp[cm][cn] = table[cm][cn] + Math.min(l, Math.min(c,r));
        return dp[cm][cn];
    }
    
    static int calculateCostWithoutDP(int [][]table, int cm, int cn, int fm, int fn){
        if(cm > fm || cn > fn)
            return Integer.MAX_VALUE;
        if(cm == fm && cn == fn)
            return table[fm][fn];
        int l = calculateCostWithoutDP(table, cm+1, cn, fm, fn);
        int c = calculateCostWithoutDP(table, cm+1, cn+1, fm, fn);
        int r = calculateCostWithoutDP(table, cm, cn+1, fm, fn);
        int result = table[cm][cn] + Math.min(l, Math.min(c,r));
        return result;
    }
}
