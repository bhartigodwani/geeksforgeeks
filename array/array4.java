/*
Largest Sum Contiguous Subarray
Write an efficient C program to find the sum of contiguous subarray within a one-dimensional array 
of numbers which has the largest sum. 
Eg:
arr = {-2, -3, 4, -1, -2, 1, 5, -3}
result = 7.
*/

class largestSum{
    public static void main (String[] args) {
        int n = 8;
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        //int a[] = {4, 1,-3 -2};
        
        firstWay(a);//kanades's algorithm
        secondWay(a);//for all values(+ve or -ve) finds the max sum only 
        thirdWay(a);//find first and last index of subarray too
    }
    
    static void firstWay(int a[]){
        System.out.println("firstway");
        int size = a.length;
        int max_so_far = 0, curr_max = 0;
        for (int i = 0; i < size; i++)
            {
                curr_max = curr_max + a[i];
                if (max_so_far < curr_max)
                    max_so_far = curr_max;
                if (curr_max < 0)
                    curr_max = 0;
            }
        System.out.println("max sum = "+max_so_far+"\n");
    }
    
    static void secondWay(int []a){
        System.out.println("secondWay");
        int curr_max = a[0];
        int max_so_far = a[0];
        for (int i=1; i<a.length; i++){
            curr_max = Math.max(curr_max+a[i] , a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        } 
        System.out.println("max sum = "+max_so_far+"\n");
    }
    
    static void thirdWay(int []a){
        System.out.println("thirdWay");
        int leftIndex=0, rightIndex=0;
        int curr_max = a[0];
        int max_so_far = a[0];
        for (int i=1; i<a.length; i++){
            if((curr_max + a[i]) > a[i]){
                curr_max += a[i];
                rightIndex = i;
            }
            else{
                curr_max = a[i];
                leftIndex = i;
            }
            max_so_far = Math.max(max_so_far, curr_max);
        } 
        System.out.println("max sum = "+max_so_far+ " leftIndex = "+leftIndex+"  rightIndex = "+(rightIndex-1));
    }
}
