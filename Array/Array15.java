/*
Find the smallest and second smallest element in an array
Example:
Input:  arr[] = {12, 13, 1, 10, 34, 1}
Output: The smallest element is 1 and 
        second Smallest element is 10
        
Input:  arr[] = {1}
Output: Invalid input

Input:  arr[] = {1, 1}
Output: The smallest element is 1 and
        second element doesnot exist
*/
class Array15{
    public static void main (String[] args) {
        //int arr[] = {12, 13, 1, 10, 34, 1};//trivial example
        int arr[] = {1,1};//no second minimum exist
        int arr[] = {1};//invalid example because to find 2 min elements there must be atleast two elements in the array
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        //int secondMin = (arr[0] > arr[1] && arr[0] != arr[1]) ? arr[0] : arr[1];;
        //int firstMin = (arr[0] < arr[1]) ? arr[0] : arr[1];
        
        if (arr.length >= 2){ 
            for (int i=0; i<arr.length; i++){
                if (arr[i] < firstMin){
                    secondMin = firstMin;
                    firstMin = arr[i];
                }
                
                else if(arr[i] < secondMin && arr[i] != firstMin)
                    secondMin = arr[i];
            } 
            
            System.out.println("firstMin = "+firstMin);
            String secondMinValue = (secondMin == Integer.MAX_VALUE) ? "no secondMin exist" : "secondMin = "+secondMin;
            System.out.println(secondMinValue);
        }
        else
            System.out.println("invalid input");
    }
}
