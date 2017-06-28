/*

Find a sorted subsequence of size 3 in linear time

Given an array of n integers, find the 3 elements such that a[i] < a[j] < a[k] and i < j < k in 0(n) time. If there are 
multiple such triplets, then print any one of them.

Examples:

Input:  arr[] = {12, 11, 10, 5, 6, 2, 30}
Output: 5, 6, 30

Input:  arr[] = {1, 2, 3, 4}
Output: 1, 2, 3 OR 1, 2, 4 OR 2, 3, 4

Input:  arr[] = {4, 3, 2, 1}
Output: No such triplet

*/
import java.util.Arrays;
class Array{
    public static void main(String args[]){
        //int []a = {12, 11, 10, 5, 6, 2, 30};
        int a[] = {1, 2, 3, 4};
        //int a[] = {4, 3, 2, 1};
        System.out.println("given array : "+Arrays.toString(a));
        System.out.println("output from method1 O(n^2)");
        printSortedSubsequenceM1(a);
        System.out.println();
        System.out.println("output from method2 O(n)");
        printSortedSubsequenceM2(a);
    }
    
    static void printSortedSubsequenceM2(int a[]){//O(n)
        int small[] = new int[a.length];
        int large[] = new int[a.length];
        
        createSmallArray(a, small);
        createLargeArray(a, large);
        
        /*System.out.println("array = "+Arrays.toString(a));
        System.out.println("small = "+Arrays.toString(small));
        System.out.println("large = "+Arrays.toString(large));*/
        int i=0;
        int n = a.length;
        for(i=0; i<n; i++){
            if(small[i] != -1 && large[i] != -1){
                System.out.println("resultant increasing subsequence array = "+a[small[i]]+" , "+a[i]+" , "+a[large[i]]);
                break;
            }
        }
        if(i==n)
            System.out.println("no such triplet");
    }
    
    static void createSmallArray(int a[], int small[]){
        int n = a.length;
        small[0] = -1;//no smaller ele on left
        int min = 0;
        for(int i=1; i<n; i++){
            if(a[i] <= a[min]){
                min = i;
                small[i] = -1;
            }
            else
                small[i] = min;
        }
    }
    
    static void createLargeArray(int a[], int large[]){
        int n = a.length;
        large[n-1] = -1;//no larger ele on right
        int max = n-1;
        for(int i=n-2; i>=0; i--){
            if(a[i] >= a[max]){
                max = i;
                large[i] = -1;
            }
            else
                large[i] = max;
        }
    }
    
    static void printSortedSubsequenceM1(int a[]){//O(n^2)
        int index[] = new int[a.length];
        int number[] = new int[a.length];
        createTables(a, number, index);
        
        /*System.out.println("array = "+Arrays.toString(a));
        System.out.println("count = "+Arrays.toString(number));
        System.out.println("index = "+Arrays.toString(index));*/
        
        String result = storeResultOrder(a, index, number);
        System.out.println((result == null) ? "no such triplet" : "resultant increasing subsequence array = "+result);
    }
    
    static String storeResultOrder(int []a, int []index, int[]number){
        int indexWith3 = 0;
        for(int i=1; i<number.length; i++){
            if(number[i] == 3){
                indexWith3 = i;
                break;
            }
        }
        if(indexWith3 == 2){
            String result = ""+a[indexWith3];
            int temp = indexWith3;
            while(index[temp] != -1){
                result = (a[index[temp]]+" , ")+result;
                temp = index[temp];
            }
            return result;
        }
        else
            return null;
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
