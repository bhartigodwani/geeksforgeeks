/*

Dynamic Programming | Set 9 (Binomial Coefficient)

Following are common definition of Binomial Coefficients.
1) A binomial coefficient C(n, k) can be defined as the coefficient of X^k in the expansion of (1 + X)^n.

2) A binomial coefficient C(n, k) also gives the number of ways, disregarding order, that k objects can be chosen from among n objects; more formally, the number of k-element subsets (or k-combinations) of an n-element set.

The Problem
Write a function that takes two parameters n and k and returns the value of Binomial Coefficient C(n, k). For example, your function should return 6 for n = 4 and k = 2, and it should return 10 for n = 5 and k = 2.
*/
import java.util.Arrays;
class DP{
    public static void main(String []args){
        int n = 5;
        int k = 2;
        int dp[][] = new int[n+1][k+1];
        System.out.println(binomialCoefficient(n, k, dp));
        System.out.println(binomialCoefficientWith_O_n_Space(n,k));
    }
    
    static int binomialCoefficient(int n, int k, int [][]dp){
        for(int i=0; i<=n; i++){
            int min = Math.min(i,k);
            for(int j=0; j <= min; j++){
                if(j==0 || i==j)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }
        return dp[n][k];
    }
    
    static int binomialCoefficientWith_O_n_Space(int n, int k){
        int C[] = new int[k+1];
        
        C[0] = 1;  // nC0 is 1

        for (int i = 1; i <= n; i++)
        {
            // Compute next row of pascal triangle using
            // the previous row
            for (int j = Math.min(i, k); j > 0; j--)
                C[j] = C[j] + C[j-1];
        }
        return C[k];        
    }

}
