/*
Maximum sum such that no two elements are adjacent
Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that 
no 2 numbers in the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 
and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.

Examples :
Input : arr[] = {5, 5, 10, 100, 10, 5}
Output : 110
Input : arr[] = {1, 2, 3}
Output : 4
Input : arr[] = {1, 20, 3}
Output : 20
*/
class Array10{
    public static void main (String[] args) {
        int []arr = {5,  5, 10, 40, 50, 35};
        int incmax=arr[0], excMax = 0;
        int excTemp;
        for (int i=1; i<arr.length; i++){
            excTemp = (incmax > excMax) ? incmax : excMax;
            incmax = excMax + arr[i];
            excMax = excTemp;
        }
        
        System.out.println("max sum is : "+((incmax > excMax) ? incmax : excMax));
    }
}
