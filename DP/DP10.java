/*
knapsack problem 
*/

class DP{
    public static void main(String []args){
        int val[] = new int[]{1,4,5,7};
        int wt[] = new int[]{1,3,4,5};
        int weight = 7;
        int dp[][] = new int[wt.length+1][weight+1];
        for(int i=0; i<=wt.length; i++){
            for(int j=0; j<=weight; j++){
                if(j==0 || i==0)
                    dp[i][j] = 0;
                else if(wt[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max((wt[i-1] + dp[i-1][j-wt[i-1]]), dp[i-1][j]);
                }
            }
        }
        
        for(int i=0; i<wt.length; i++){
            for(int j=0; j<=weight; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        
        System.out.println("result = "+dp[wt.length-1][weight]);
        
    }
}
