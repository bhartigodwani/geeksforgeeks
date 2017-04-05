import java.util.Scanner;

public class Array8 {
	/*Write a program to reverse an array or string
	  Recursive approach
	 */
	
	public static void main(String[] args) {
		System.out.println("enter array size to be reversed");
		Scanner sc = new Scanner(System.in);
		int arraysize = sc.nextInt();
		int arr[] = new int[arraysize];
		System.out.println("enter "+arraysize+" elements");
		for (int i = 0; i < arraysize; i++) {
			arr[i] = sc.nextInt();
		}
		/*int r = arr.length-1;
		int temp;
		for (int i = 0; i < arr.length/2 ; i++) {
			temp = arr[i];
			arr[i] = arr[r];
			arr[r] = temp;
			r--;
		}*/
		
		reverse(arr, 0, arr.length-1);
		System.out.println("reversed array: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ "    ");
		}
	}
	
	static public void reverse(int arr[], int left, int right){
		System.out.println("left = "+left+"   right = "+right);
		if (left > right) {
			System.out.println("upar");
			System.out.println("arr[left] = "+arr[left]+"   arr[right] =  "+arr[right]);
			return;
		}
		if(left <= right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			System.out.println("arr[left] = "+arr[left]+"   arr[right] =  "+arr[right]);
			left++;
			right--;
			reverse(arr, left, right);
		}
		
	}
}
