/*
@author Bharti Godwani

Maximum Length Bitonic Subarray | Set 1 (O(n) tine and O(n) space)

Given an array A[0 … n-1] containing n positive integers, a subarray A[i … j] is bitonic if there is a k with i <= k <= j 
such that A[i] <= A[i + 1] ... <= A[k] >= A[k + 1] >= .. A[j – 1] > = A[j]. Write a function that takes an array as argument 
and returns the length of the maximum length bitonic subarray.
Expected time complexity of the solution is O(n)

Simple Examples
1) A[] = {12, 4, 78, 90, 45, 23}, the maximum length bitonic subarray is {4, 78, 90, 45, 23} which is of length 5.

2) A[] = {20, 4, 1, 2, 3, 4, 2, 10}, the maximum length bitonic subarray is {1, 2, 3, 4, 2} which is of length 5.

Extreme Examples
1) A[] = {10}, the single element is bitnoic, so output is 1.

2) A[] = {10, 20, 30, 40}, the complete array itself is bitonic, so output is 4.

3) A[] = {40, 30, 20, 10}, the complete array itself is bitonic, so output is 4.

*/
import java.util.Arrays;
class Array41{
    public static void main(String []args){
        //int a[] = {12, 4, 78, 90, 45, 23};
        //int a[] = {20, 4, 1, 2, 3, 4, 2, 10};
        int a[] = {10,20};
        //int a[] = {10, 20, 30, 40};
        //int a[] = {40, 30, 20, 10};
        
        int index[] = new int[a.length];
        for(int i=0; i<a.length; i++){
            index[i] = i;    
        }
        System.out.println("array = "+Arrays.toString(a));
        System.out.println("index = "+Arrays.toString(index));
        int l=-1,r=-1;
        int curr=0, length=1;
        int finalL = 0, finalR = 0;
        for(int i=0; i<a.length-1; ){
            if(i<a.length-1 && a[i] < a[i+1]){
                l = i;
                i++;
                r = i;
                while(i<a.length-1 && a[i] < a[i+1]){
                    i++;
                    r = i;//if only increasing order is there
                }
                while(i<a.length-1 && a[i] > a[i+1]){
                    i++;
                    r = i;
                }
            }
            else if(i<a.length-1 && a[i] > a[i+1]){ 
                l = i;
                while(i<a.length-1 && a[i] > a[i+1]){
                    i++;
                    r = i;
                }
            }
            
            curr = r-l+1;
            if(curr > length){
                finalL = l;
                finalR = r;
                length = curr; 
            }
            
        }
        
        System.out.println("leftIndex = "+finalL+" rightIndex = "+finalR+" final length = "+length);
        System.out.println("bitonic subarray");
        for(int i=finalL; i<=finalR; i++)
            System.out.print(a[i]+"  ");
    }
}
