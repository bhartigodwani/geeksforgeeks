import java.util.Scanner;

/*Search an element in a sorted and rotated array
An element in a sorted array can be found in O(log n) time via binary search.
But suppose we rotate an ascending order sorted array at some pivot unknown to 
you beforehand.So for instance, 1 2 3 4 5 might become 3 4 5 1 2. 
Devise a way to find an element in the rotated array in O(log n) time.

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 3
Output : Found at index 8

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 30
Output : Not found

Input : arr[] = {30, 40, 50, 10, 20}
        key = 10   
Output : Found at index 3

input 
5 
6 7 3 4 5          

7
6 7 1 2 3 4 5     

6
6 7 8 9 1 2
*/
public class Array6 {
	static int locationWhereRotated = 0, foundLocation;
	public static void main(String[] args) {
	int i = 1;
		while (i == 1) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int temp[] = new int[10];
			int arr[] = new int[n];
			int flag = 0;
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			
			System.out.println("enter element to be found:");
			int x = sc.nextInt();
			int first = arr[0], l=0,r=arr.length-1;
			search(arr, l, r, first);
			System.out.println("locationWhereRotated = "+locationWhereRotated);
			
			if (x >= arr[locationWhereRotated] && x < first) {
				System.out.println("1 searched between "+l+" and "+r);
				binarySearch(arr,locationWhereRotated,r,x);
			}
			else{
				System.out.println("2 searched between "+l+" and "+(locationWhereRotated-1));
				binarySearch(arr, l, locationWhereRotated-1, x);
			}
			System.out.println("location = "+foundLocation);
			System.out.println("enter 1 to continue ");
			i = sc.nextInt();
		}
	}
	
	public static void binarySearch(int []arr, int l, int r, int x) {
		int mid = (l+r)/2;
		System.out.println("mid = "+mid);
		int flag = -1;
		if (arr[mid] == x){
			System.out.println("mid  "+mid);
			foundLocation = mid;
		}
		
		else if(arr[mid] > x){
			System.out.println("1st");
			r = mid-1;
			binarySearch(arr, l, r, x);
		}
		
		else if(arr[mid] < x){
			System.out.println("2nd");
			l = mid+1;
			System.out.println("l = "+l+"   r= "+r);
			binarySearch(arr, l, r, x);
		}
		
	}
	
	public static void search(int []arr, int l, int r, int first) {
		int mid = (l+r)/2;
		int flag = -1;
		if (arr[mid] < first && arr[mid] < arr[mid-1]){
			System.out.println("mid  "+mid);
			locationWhereRotated = mid;
		}
		else if(arr[mid] < first){
			System.out.println("1st");
			r = mid-1;
			search(arr, l, r, first);
		}
		else if(arr[mid] > first){
			System.out.println("2nd");
			l = mid+1;
			search(arr, l, r, first);
		}
	}
}
