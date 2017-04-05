import java.util.Scanner;

/*
Largest Sum Contiguous Subarray

Write an efficient C program to find the sum of contiguous subarray 
within a one-dimensional array of numbers which has the largest sum.

input = -2 -3 4 -1 -2 1 5 -3
output = 7

Solution = Kadane algorithm
*/

public class Array4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp[] = new int[10];
		int arr[] = new int[n];
		int flag = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int resultMaxSubarray = 0;
		int tempMaxSubarray = 0;
		for (int i = 0; i < arr.length; i++) {
			tempMaxSubarray += arr[i];
			if (tempMaxSubarray < 0) {
				tempMaxSubarray = 0;
			}
			if (resultMaxSubarray < tempMaxSubarray) {
				resultMaxSubarray = tempMaxSubarray;
			}
		}
		
		 System.out.println("result max array sum = "+resultMaxSubarray);
	}
}
