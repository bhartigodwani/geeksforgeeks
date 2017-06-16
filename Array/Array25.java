/*

Find the two repeating elements in a given array

You are given an array of n+2 elements. All elements of the array are in range 1 to n. And all elements occur once except two numbers which occur twice. Find the two repeating numbers.

For example, array = {4, 2, 4, 5, 2, 3, 1} and n = 5

The above array has n + 2 = 7 elements with all elements occurring once except 2 and 4 which occur twice. So the output should be 4 2.*/
import java.util.Arrays;
class Array{
    public static void main(String []args){
        int[] arr = {4, 2, 4, 5, 2, 3, 1};
        int max = arr[0];
        for(int i=1; i<arr.length; i++)
            max = (arr[i] > max) ? arr[i] : max;
        
        int temp, count=0;
        for(int i=0; i<arr.length; i++){
            int j = i;
            if(arr[i] != -1){
                while(j<arr.length && j>=0 && j != -1){
                    //System.out.println("j = "+j);
                    temp = arr[j];
                    System.out.println("temp = "+temp);
                    j = arr[temp];
                    System.out.println("j2 = "+j);
                    if(j == -1){
                        System.out.println(temp+"  ");
                        count++;
                        break;
                    }
                    else
                        arr[temp] = -1;
                    System.out.println("\narray = "+Arrays.toString(arr));        
                 }
                if(count == 2)
                        break;
           }
        }
        
        System.out.println("\neven odd array = "+Arrays.toString(arr));
    }
}
