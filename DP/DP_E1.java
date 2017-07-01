/*
DP | coin change
minimum number of coids required
*/
class DP{
    public static void main(String []args){
        int a[] = {1,5,6,8};
        int sum = 11;
        int dp[][] = new int[a.length][sum+1];
        
        for(int i=0; i<a.length; i++){
            for(int j=0; j<=sum; j++){
                if(j==0)
                    dp[i][j] = 0;
                else if(i==0)
                    dp[i][j] = dp[i][j-1]+1;//for 1 coin
                else{
                    if(a[i] > j)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = Math.min(dp[i][j-a[i]]+1, dp[i-1][j]);
                }
            }
        }
        System.out.println("dp table");
        for(int i=0; i<a.length; i++){
            for(int j=0; j<=sum; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        String res = "";
        int l = a.length-1;
        int r = sum;
        while(dp[l][r] != 0){
            if(r-a[l] >= 0 && dp[l][r] == (dp[l][r-a[l]]+1)){
                res = a[l] + " " + res;
                r -= a[l];
            }
            else
                l--;
        }
        System.out.println("coins required for the sum = "+res);
    }
}
