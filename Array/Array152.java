/*
Rearrange an array in maximum minimum form | Set 1
Given a sorted array of positive integers, rearrange the array alternately i.e first element should be maximum value, second 
minimum value, third second max, fourth second min and so on.

Examples:

Input  : arr[] = {1, 2, 3, 4, 5, 6, 7} 
Output : arr[] = {7, 1, 6, 2, 5, 3, 4}

Input  : arr[] = {1, 2, 3, 4, 5, 6} 
Output : arr[] = {6, 1, 5, 2, 4, 3}
*/
import java.util.Arrays;
class Array{
    public static void main(String []args){
        //int a[] = {2, 3, 4, 5};
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("array = "+Arrays.toString(a));
        int aux[]= new int[a.length];
        int right = a.length-1, k=0;
        for(int i=0; i<=a.length/2; i++){
            aux[k++] = a[right--];
            if(k<a.length)
                aux[k++] = a[i];
            else
                break;
        }
        System.out.println("new array = "+Arrays.toString(aux));
    }
}
