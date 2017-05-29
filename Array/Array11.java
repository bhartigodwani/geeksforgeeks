/*
Leaders in an array
Write a program to print all the LEADERS in the array. An element is leader if it is greater than 
all the elements to its right side. And the rightmost element is always a leader. For example int 
the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2. 
*/
class Array11{
    public static void main (String[] args) {
        int []arr = {16, 17, 4, 3, 5, 2};
        int maxElement = arr[arr.length-1];
        String output = ""+maxElement;
        for (int i=arr.length-2; i>=0; i--){
            if (arr[i] > maxElement){
                maxElement = arr[i];
                output = maxElement + " " + output;
            } 
        } 
        
        System.out.println("final output : "+output);
    }
}
