/*

Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is 
able to trap after raining.

Examples:

Input: arr[]   = {2, 0, 2}
Output: 2
Structure is like below
| |
|_|
We can trap 2 units of water in the middle gap.

Input: arr[]   = {3, 0, 0, 2, 0, 4}
Output: 10
Structure is like below
     |
|    |
|  | |
|__|_| 
We can trap "3*2 units" of water between 3 an 2,
"1 unit" on top of bar 2 and "3 units" between 2 
and 4.  See below diagram also.

Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Output: 6
       | 
   |   || |
_|_||_||||||
Trap "1 unit" between first 1 and 2, "4 units" between
first 2 and 3 and "1 unit" between second last 1 and last 2 
*/
import java.util.Arrays;
class Array{
    public static void main(String []args){
        int a[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int leftMax[] = new int[a.length];
        int rightMax[] = new int[a.length];
        /*calculating tower of max height in left*/
        leftMax[0] = 0;
        int maxSofar = leftMax[0];
        for(int i=1; i<a.length; i++){
            if(a[i] < maxSofar)
                leftMax[i] = maxSofar;
            else{
                maxSofar = a[i];
                leftMax[i] = 0;
            }
        }
        
        rightMax[a.length-1] = 0;
        maxSofar = rightMax[a.length-1];
        for(int i=a.length-2; i>=0; i--){
            if(a[i] < maxSofar)
                rightMax[i] = maxSofar;
            else{
                maxSofar = a[i];
                rightMax[i] = 0;
            }
        }
        
        System.out.println("array = "+Arrays.toString(a));
        System.out.println("left = "+Arrays.toString(leftMax));
        System.out.println("right = "+Arrays.toString(rightMax));
        int total = 0;
        for(int i=0; i<a.length; i++){
            total = total + Math.max((Math.min(leftMax[i], rightMax[i])-a[i]), 0);
        }
        System.out.println("result = "+total);
    }
}
