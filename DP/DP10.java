import java.util.Calendar;
import java.util.Arrays;
class DP{
    public static void main(String[]args){
        int val[] = {1,4,5,7};
        int wt[] = {1,3,4,5};
        int W = 7;
        
        /*int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;*/
        int n = val.length;
        double start = (double)(Calendar.getInstance().get(Calendar.MILLISECOND))/ 1000;
        System.out.println("max weight : "+KnapsackRec(val, wt, W, n));
        double end = (double)(Calendar.getInstance().get(Calendar.MILLISECOND)) / 1000;
        System.out.println("time taken by recursion : "+(end-start)+" sec");
        
        start = (double)(Calendar.getInstance().get(Calendar.MILLISECOND))/ 1000;
        int dp[][] = new int[n][W+1];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], 0);
        System.out.println("max weight : "+KnapsackDP(val, wt, W, n, dp));
        end = (double)(Calendar.getInstance().get(Calendar.MILLISECOND)) / 1000;
        System.out.println("time taken by recursion : "+(end-start)+" sec");
        System.out.println("dp array");
        for(int i=0; i<n; i++){
            for(int j=0; j<=W; j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }
    }
    
    static int KnapsackDP(int []val, int wt[], int W, int n, int [][]dp){
        //System.out.println("n = "+n+" wt[n-1] = "+wt[n-1]+" W = "+W);
        if(n <= 0 || W < 0)
            return 0;
        
        else if(wt[n-1] > W && W >= 0){
            if(n == 1)
                dp[n-1][W] = 0;
            else
                dp[n-1][W] = (dp[n-1][W] >= 0) ? dp[n-1][W] : KnapsackDP(val, wt, W, n-1, dp);
        }
        
        //two cases:
        //take wt[n-1]
        //dont take wt[n-1]
        dp[n-1][W] = Math.max(val[n-1] + KnapsackDP(val, wt, W-wt[n-1], n-1, dp), KnapsackDP(val, wt, W, n-1, dp));
        //System.out.println("dp["+(n-1)+"]["+W+"] = "+dp[n-1][W]);
        return dp[n-1][W];
    }
    
    static int KnapsackRec(int []val, int []wt, int W, int n){
        if(n == 0)
            return n;
        
        if(wt[n-1] > W)
            return KnapsackRec(val, wt, W, n-1);
        
        //two cases:
        //take wt[n-1]
        //dont take wt[n-1]
        return Math.max(val[n-1] + KnapsackRec(val, wt, W-wt[n-1], n-1), KnapsackRec(val, wt, W, n-1));
    }
}
