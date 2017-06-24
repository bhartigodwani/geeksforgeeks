/*
Dynamic Programming | Set 5 (Edit Distance)
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) 
required to convert ‘str1’ into ‘str2’.

    Insert
    Remove
    Replace

All of the above operations are of equal cost.

Examples:

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations. 
Replace 'n' with 'r', insert t, insert a
*/
class DP{
    public static void main(String []args){
        /*String s1 = "sunday";
        String s2 = "saturday";
        String s1 = "cat";
        String s2 = "cut";*/
        String s1 = "ABCDE";
        String s2 = "BEDF";
        System.out.println("s1 = "+s1+" s2 = "+s2);
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        createDPTable(s1, s2, dp);
    }
    
    static void createDPTable(String s1, String s2, int [][]dp){
        for(int i=0; i<s1.length()+1; i++){
            for(int j=0; j<s2.length()+1; j++){
                if(i==0)
                    dp[i][j] = j;
                else if(j==0)
                    dp[i][j] = i;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
            }
        }
        System.out.println("number of operations required is = "+dp[s1.length()][s2.length()]);
    }
}
