import java.util.Scanner;
import java.util.Arrays;

/*Find the Missing Number
You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer.

We strongly recommend that you click here and practice it, before moving on to the solution.

Example:
I/P    1 2 4 6 3 7 8
O/P    5

Solution 1 = count if any of the number is missing
Solution 2 = (count sum of all numbers from 1 to n) - (count of given numbers)*/

public class Array5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}*/
		
		int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		
		firstWay(arr);//using sum of the array
		secondWay(arr);//using xor operation
		
	}
	
	static void firstWay(int []arr){
	    System.out.println("firstWay");
	    int sum = 0;
		int n = arr.length;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		
		int total = ((n+1) * (n+2)) / 2;//n is 1 number less than the total number thats y n+1 is taken
		int result = total - sum ;
		System.out.println("missing element is = "+result+"\n");
	}
	
	static void secondWay(int []a){
	    System.out.println("secondWay");
        int max = Arrays.stream(a).max().getAsInt();
        int X1 = 1;
        int i ;
        for(i=2; i<=max;i++)
            X1 ^= i;
            
	    int X2 = a[0];
	    for (i=1; i<a.length; i++){
	        X2 ^= a[i];
	    } 
	    System.out.println("missing element is = "+(X1 ^ X2));
	}
}
