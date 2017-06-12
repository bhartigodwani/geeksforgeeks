/*
Union and Intersection of two sorted arrays
Given two sorted arrays, find their union and intersection.

For example, if the input arrays are: 
arr1[] = {1, 3, 4, 5, 7}
arr2[] = {2, 3, 5, 6}
Then your program should print Union as {1, 2, 3, 4, 5, 6, 7} and Intersection as {3, 5}. 
*/
import java.util.Arrays;
class Array{
    public static void main(String []args){
        int []a1 =  {1, 3, 4, 5, 7};
        int []a2 = {1, 2, 3,4, 5, 6, 7, 8, 9, 12};
        unionArray(a1, a2);
        intersectionArray(a1, a2);
    }
    
    static void unionArray(int []a1, int []a2){
        int[] union = new int[a1.length + a2.length];
        int i1=0, i2 = 0, k=0;
        while(i1<a1.length && i2<a2.length){
            if(a1[i1] < a2[i2]){
                union[k] = a1[i1];
                i1++;
                k++;
            }
            else{
                union[k] = a2[i2];
                if(a1[i1] == a2[i2])
                    i1++;
                i2++;
                k++;
            }
        }
        while(i1<a1.length){
            union[k] = a1[i1];
                i1++;
                k++;
        }
        while(i2<a2.length){
            union[k] = a2[i2];
                i2++;
                k++;
        }
        System.out.println("union array = "+Arrays.toString(union));
    }
    
    static void intersectionArray(int []a1, int[]a2){
        int intersection[] = new int[Math.min(a1.length , a2.length)];
        int i1=0, i2 = 0, k=0;
        while(i1<a1.length && i2<a2.length){
            if(a1[i1] == a2[i2]){
                intersection[k] = a1[i1];
                k++;
                i1++;
                i2++;
            }
                
            else if(a1[i1] < a2[i2])
                i1++;
            
            else
                i2++;
        }
        System.out.println("intersection array = "+Arrays.toString(intersection));
    }
}
