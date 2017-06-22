/*
Dynamic Programming | Set 4 (Longest Common Subsequence)

LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A subsequence is 
a sequence that appears in the same relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”,
‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of length n has 2^n different possible subsequences.

Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
*/
class DP4{
    public static void main(String []args){
        /*String s1 = "AEDFHR";
        String s2 = "ABCDGH";*/
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println("string 1 = "+s1);
        System.out.println("string 2 = "+s2);
        int lookup[][] = new int[s1.length()+1][s2.length()+1];
        createLookupTable(s1, s2, lookup);
        System.out.println("------------------------------\nLookup table\n------------------------------");
        printLookupTable(s1, s2, lookup);
        System.out.println("------------------------------");
        printAndCalculateLCS(s1, s2, lookup);
    }
    
    static void createLookupTable(String s1, String s2, int[][] lookup){
        for(int i=0; i<=s1.length(); i++){
            for(int j=0; j<=s2.length(); j++){
                if(i==0 || j==0)
                    lookup[i][j] = 0;
                else{
                    if(s1.charAt(i-1) == s2.charAt(j-1))
                        lookup[i][j] = lookup[i-1][j-1] + 1;
                    else
                        lookup[i][j] = Math.max(lookup[i-1][j], lookup[i][j-1]);
                }
            }
        }
    }
    
    static void printLookupTable(String s1, String s2, int[][] lookup){
        System.out.print("   ");
        for(int i=0; i<s2.length(); i++)
            System.out.print(" "+s2.charAt(i));
        System.out.println();
        for(int i=0; i<=s1.length(); i++){
            System.out.print(((i>0) ? s1.charAt(i-1) : " ")+" ");
            for(int j=0; j<=s2.length(); j++){
                System.out.print(lookup[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    static void printAndCalculateLCS(String s1, String s2, int [][]lookup){
        int t_i = s1.length();
        int t_j = s2.length();
        String LCS = "";
        int lengthLCS = 0;
        while(lookup[t_i][t_j] != 0){
            if(lookup[t_i][t_j] == lookup[t_i-1][t_j]){
                t_i--;
            }
            else if(lookup[t_i][t_j] == lookup[t_i][t_j-1]){
                t_j--;
            }
            else if(lookup[t_i][t_j] == (lookup[t_i-1][t_j-1]+1)){
                LCS = s1.charAt(t_i-1)+" "+LCS;
                lengthLCS++;
                t_i--;
                t_j--;
            }
        }
        System.out.println("length of LCS = "+lengthLCS+((LCS=="") ? "\nno LCS found" : "\nLCS = "+LCS));
    }
}
