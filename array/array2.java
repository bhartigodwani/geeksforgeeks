/*
Majority Element
Majority Element: A majority element in an array A[] of size n is an element
that appears more than n/2 times (and hence there is at most one such element).

Write a function which takes an array and emits the majority element
(if it exists), otherwise prints NONE as follows:

       I/P : 3 3 4 2 4 4 2 4 4
       O/P : 4 

       I/P : 3 3 4 2 4 4 2 4
       O/P : NONE
       
*/

import java.util.Arrays;
import java.util.Scanner;

public class Array2 {
	public static void main(String[] args) {
		System.out.println("enter array size");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//array size
		
		int array[] = new int[n];
		System.out.println("enter array");
		for(int i=0; i<n; i++){
			array[i] = sc.nextInt();
		}
		
		int l = 0;
		int r = array.length - 1;
		
		int count[] = new int[10];
		
		for (int i = 0; i < array.length; i++) {
			count[i] = 0;
		}
		
		int flag = 0;
		for (int i = 0; i < array.length; i++) {
			count[array[i]] ++;
			if (count[array[i]] > n/2) {
				System.out.println("max = "+array[i]);
				flag = 1;
				break;
			}
		}
		
		if (flag == 0) {
			System.out.println("NONE");
		}
		
	}
}
