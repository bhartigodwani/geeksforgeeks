import java.util.Iterator;
import java.util.Scanner;

/*Find the Number Occurring Odd Number of Times
Given an array of positive integers. 
All numbers occur even number of times except one number which occurs odd number of times. 
Find the number in O(n) time & constant space.

Example:
I/P = [1, 2, 3, 2, 3, 1, 3]
O/P = 3

7
1 2 3 2 3 1 3
solution - take exor of all the numbers final result will be the solution*/

public class Array3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp[] = new int[10];
		int arr[] = new int[n];
		int flag = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(result);
			result = result ^ arr[i];
		}
		System.out.println("\n"+result);
		
    /*for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			temp[arr[i]]++;
		}
		
		for (int j = 0; j < 10; j++) {
			if (temp[j] % 2 == 1) {
				System.out.println("output - "+j);
				flag = 1;
				break;
			}
		}
		
	  
		if (flag == 0) {
			System.out.println("no odd found");
		}*/
	}
}
