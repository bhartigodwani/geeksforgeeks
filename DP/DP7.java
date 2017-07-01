/*
Dynamic Programming | Set 7 (Coin Change)

Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued 
coins, how many ways can we make the change? The order of coins doesn’t matter.

For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For 
N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output 
should be 5.
*/
class DP{
    public static void main(String []args){
        //int a[] = {1,5,6,8};
        //int sum = 11;
        int a[] = {1,2,3};
        int sum = 5;
        int dp[][] = new int[a.length][sum+1];
        
        for(int i=0; i<a.length; i++){
            for(int j=0; j<=sum; j++){
                if(j==0)
                    dp[i][j] = 1;
                else if(i==0)
                    dp[i][j] = 1;//for 1 coin
                else{
                    if(a[i] > j)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = (dp[i][j-a[i]]) + (dp[i-1][j]);
                }
            }
        }
        for(int i=0; i<=sum; i++)
            System.out.print(" "+i);
        System.out.println();
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
            for(int j=0; j<=sum; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        
        System.out.println("number of ways = "+dp[a.length-1][sum]);
    }
}
