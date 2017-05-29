/*
Ceiling and flooring in a sorted array
Given a sorted array and a value x, the ceiling of x is the smallest element in array greater than or equal to x, and 
the floor is the greatest element smaller than or equal to x. Assume than the array is sorted in non-decreasing order. 
Write efficient functions to find floor and ceiling of x.

For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
For x = 0:    floor doesn't exist in array,  ceil  = 1
For x = 1:    floor  = 1,  ceil  = 1
For x = 5:    floor  = 2,  ceil  = 8
For x = 20:   floor  = 19,  ceil doesn't exist in array
*/
class Array22{
    public static void main (String[] args) {
        int []a = {1, 2, 8, 10, 10, 12, 19};
        int l = 0,r = a.length-1;
        int x = 5;
        x = 20;//ceil doesn't exist
        x = 0;//floor doesn't exist
        x = 12;//element exist and it is floor and ceil
        x = 11;//contains ceil and floor both
        int flag = 0;
        if (x > a[r]){
            System.out.println("floor = "+a[r]);
            System.out.println("ceil doesn't exist");
            flag = 1;
        }
        
        if (x < a[l]){
            System.out.println("floor doesn't exist");
            System.out.println("ceil = "+a[0]);
            flag = 1;
        }
        
        if(flag == 0)
            searchForFloorAndCeil(a,l,r,x);
    }
    
    static void searchForFloorAndCeil(int []a, int l, int r, int x){
        int mid = (l+r)/2;
        
        if (l < r){ 
            if (a[mid] == x){
                System.out.println("floor = "+a[mid]);
                System.out.println("ceil = "+a[mid]);
                return;
            }
            
            else if(x < a[mid]){
                if(x > a[mid-1]){
                    System.out.println("floor = "+a[mid-1]);
                    System.out.println("ceil = "+a[mid]);
                }
                searchForFloorAndCeil(a,l,mid-1,x);
            }
            
            else if(x > a[mid]){
                if (x < a[mid+1]){
                    System.out.println("floor = "+a[mid]);
                    System.out.println("ceil = "+a[mid+1]);
                } 
                searchForFloorAndCeil(a, mid+1, r, x);
            }
        }
    }
}
