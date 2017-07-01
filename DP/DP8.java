/*

Dynamic Programming | Set 8 (Matrix Chain Multiplication)

Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.

We have many options to multiply a chain of matrices because matrix multiplication is associative. In other words, no matter how we parenthesize the product, the result will be the same. For example, if we had four matrices A, B, C, and D, we would have:

    (ABC)D = (AB)(CD) = A(BCD) = ....

However, the order in which we parenthesize the product affects the number of simple arithmetic operations needed to compute the product, or the efficiency. For example, suppose A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a 5 × 60 matrix. Then,

    (AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations
    A(BC) = (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations.

*/
class DP{
    public static void main(String []args){
        int a[] = new int[] {1, 2, 3, 4, 3};
        int n = a.length;
            
        double start = System.currentTimeMillis();
        System.out.println("Minimum number of multiplications by recursion is "+MatrixChainOrder(a, 1, n-1));
        double end = System.currentTimeMillis();
        System.out.println("time by recursion : "+(end-start));
        start = System.currentTimeMillis();
        /*------------left with DP--------------
        int dp[][] = new int[n][n-1];
        System.out.println("Minimum number of multiplications by DP is "+MatrixChainOrderDP(a, 1, n-1, dp));
        end = System.currentTimeMillis();
        System.out.println("time by DP : "+(end-start));*/
    }
    
    /*
    -----------------------solve it again----------------------------------
    static int MatrixChainOrderDP(int []a, int left, int right, int [][]dp){
        if(left == right)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int k=left; k<right; k++){
            int x, y;
            if(dp[left][k] == -1)
                x = MatrixChainOrder(a, left, k);
            else
                x = dp[left][k];
            
            if(dp[k+1][right] == -1)
                y = MatrixChainOrder(a, k+1, right);
            else
                y = dp[k+1][right];
            
            int count = x + y + a[left-1] * a[k] * a[right];
            if(count < min)
                min = count;
        }
        return min;
    }*/
    
    static int MatrixChainOrder(int []a, int left, int right){
        if(left == right)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int k=left; k<right; k++){
            int count = MatrixChainOrder(a, left, k) + MatrixChainOrder(a, k+1, right) + a[left-1] * a[k] * a[right];
            if(count < min)
                min = count;
        }
        return min;
    }
}
