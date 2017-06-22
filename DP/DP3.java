/*
Dynamic Programming | Set 3 (Longest Increasing Subsequence)
The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such 
that all elements of the subsequence are sorted in increasing order. For example, the length of LIS for
{10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.

More Examples:
Input  : arr[] = {3, 10, 2, 1, 20}
Output : Length of LIS = 3
The longest increasing subsequence is 3, 10, 20

Input  : arr[] = {3, 2}
Output : Length of LIS = 1
The longest increasing subsequences are {3} and {2}

Input : arr[] = {50, 3, 10, 7, 40, 80}
Output : Length of LIS = 4
The longest increasing subsequence is {3, 7, 40, 80}
*/

import java.util.Arrays;
class DP{
    public static void main(String []args){
        int a[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int number[] = new int[a.length];
        int index[] = new int[a.length];
        /*------------table creation-------------*/
        createTables(a, number, index);
        
        System.out.println("array = "+Arrays.toString(a));
        System.out.println("count = "+Arrays.toString(number));
        System.out.println("index = "+Arrays.toString(index));
        
        String result = storeResultOrder(a, index, number);
        System.out.println("resultant increasing subsequence array = "+result);
    }
    
    static String storeResultOrder(int []a, int []index, int[]number){
        int maxIndex = 0;
        for(int i=1; i<number.length; i++){
            if(number[maxIndex] < number[i])
                maxIndex = i;
        }
        
        String result = ""+a[maxIndex];
        int temp = maxIndex;
        while(index[temp] != -1){
            result = (a[index[temp]]+" , ")+result;
            temp = index[temp];
        }
        return result;
    } 
    
    static void createTables(int []a, int []number, int []index){
        for(int i=0; i<a.length; i++){
            number[i] = 1;
            index[i] = -1;
        }
        for(int i=1; i<a.length; i++){
            for(int j=0; j<i; j++){
                if(a[j] < a[i]){
                    if((number[j]+1) > number[i]){
                        number[i] = number[j] + 1;
                        index[i] = j; 
                    }
                }
            }
        }
    }
}
