import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*Given an array A[] and a number x, check for pair in A[] with sum as x
Write a C program that, given an array A[] of n numbers and another number x, 
determines whether or not there exist two elements in S whose sum is exactly x. */

public class Array1 {
	public static void main(String[] args) {
		
		System.out.println("enter array size");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int array[] = new int[n];
		System.out.println("enter array");
		for(int i=0; i<n; i++){
			array[i] = sc.nextInt();
		}
		System.out.println("enter x : ");
		int x = sc.nextInt();
		int l = 0;
		int r = array.length - 1;
		Arrays.sort(array);
		
		while(l<r){
			if (array[l] + array[r] == x) {
				System.out.println(array[l]+":"+array[r]);
				break;
			}
			else if (array[l] + array[r] < x){
				l++;
				System.out.println("l");
			} 
			else{
				r--;
				System.out.println("l");
			}	
		}
		
		System.out.println("l="+l+"r="+r );
		if (l==r) {
			System.out.println("no such pair exist");
		}
		
		for (int i = 0; i < array.length; i++) {
				if (array[i] <= x) {
					for (int j = i+1; j < array.length; j++) {
						if(array[j] == (x - array[i])){
							System.out.println(array[i]+" : "+array[j]);
						}
					}
				}
			}
	}
}
