

import java.util.Scanner;

/*
Merge an array of size n into another array of size m+n
Question:
There are two sorted arrays. First one is of size m+n containing only m elements. 
Another one is of size n and contains n elements. Merge these two arrays into the first array of size m+n 
such that the output is sorted.
*/
public class Array7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter m: (number of elements present in first array:)");
		int m = sc.nextInt();
		System.out.println("enter second array size(n)");
		int n = sc.nextInt();
		int arr1[] = new int[m+n];
		System.out.println("enter array1");
		for (int i = n; i < m+n; i++) {
			arr1[i] = sc.nextInt();
		}
		
		int arr2[] = new int[n];
		System.out.println("enter array2");
		for (int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
		}
		
		//fill the arr1 from last eg arr1= _,_,_,1,3,6,7
		//arr2 = 2,5,8
		//compare each element of both arrays and whichever is smaller one insert it into arr1 from beginning
		//if element of arr1 is smaller one then substitute arr1[l] by arr2[r] to avoid error in last element 
		//of arr2 if it is bigger one
		
		int p=0;
		int l=n,r=0;
		while(p < m+n && l < m+n && r < n){
			if (arr1[l] < arr2[r]) {
				arr1[p] = arr1[l];
				arr1[l] = arr2[r];
				System.out.println("arr1[p] = "+arr1[p]);
				l++;
			}
			else{
				arr1[p] = arr2[r];
				System.out.println("arr1[p] = "+arr1[p]);
				r++;
			}
			p++;
		}
		System.out.println("output array");
		for (int i = 0; i < m+n; i++) {
			System.out.print(arr1[i]+"   ");
		}
	}
}
