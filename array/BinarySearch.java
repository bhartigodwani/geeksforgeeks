
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter array size");
		int n = sc.nextInt();
		int temp[] = new int[10];
		int arr[] = new int[n];
		System.out.println("enter array elements");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		System.out.println("enter element to be searched");
		int elementToBeSearched = sc.nextInt();
		int l=0,r=arr.length-1;
		int flag = binarySearch(arr, elementToBeSearched, l, r);
		if (flag == -1) {
			System.out.println("element not found");
		}
		

	}
	public static int binarySearch(int []arr, int x, int l, int r) {
		int mid = (l+r)/2;
		
		if (l <= r) {
			if (x == arr[mid]) {
				System.out.println(mid);
				return 1;
			}
			
			else if(x > arr[mid]){
				l = mid+1;
				binarySearch(arr, x, l, r);
			}
			
			else{
				r = mid - 1;
				binarySearch(arr, x, l, r);
			}			
		}
		return -1;
	}
}
