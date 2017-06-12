/*
Interpolation Search

Given a sorted array of n uniformly distributed values arr[], write a function to search for a particular element x in the 
array.

Linear Search finds the element in O(n) time, Jump Search takes O(√ n) time and Binary Search take O(Log n) time.
The Interpolation Search is an improvement over Binary Search for instances, where the values in a sorted array are 
uniformly distributed. Binary Search always goes to middle element to check. On the other hand interpolation search may 
go to different locations according the value of key being searched. For example if the value of key is closer to the last 
element, interpolation search is likely to start search toward the end side.

To find the position to be searched, it uses following formula.

// The idea of formula is to return higher value of pos
// when element to be searched is closer to arr[hi]. And
// smaller value when closer to arr[lo]
pos = lo + [ (x-arr[lo])*(hi-lo) / (arr[hi]-arr[Lo]) ]

arr[] ==> Array where elements need to be searched
x     ==> Element to be searched
lo    ==> Starting index in arr[]
hi    ==> Ending index in arr[]
*/

class Array{
    static int arr[] = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47};
    
    public static void main(String[] args) 
    {
         int x = 18; // Element to be searched
         int index = interpolationSearch(x);
          
         // If element was found
         if (index != -1)
            System.out.println("Element found at index " + index);
         else
            System.out.println("Element not found.");
    }
    
    // If x is present in arr[0..n-1], then returns
    // index of it, else returns -1.
    static int interpolationSearch(int x)
    {
        // Find indexes of two corners
        int low = 0, high = (arr.length - 1);
      
        // Since array is sorted, an element present
        // in array must be in range defined by corner
        while (low <= high && x >= arr[low] && x <= arr[high])
        {
            int pos = low + (((high-low) /
                  (arr[high]-arr[low]))*(x - arr[low]));
      
            // Condition of target found
            if (arr[pos] == x)
                return pos;
      
            // If x is larger, x is in upper part
            if (arr[pos] < x)
                low = pos + 1;
      
            // If x is smaller, x is in lower part
            else
                high = pos - 1;
        }
        return -1;
    }
    
}
