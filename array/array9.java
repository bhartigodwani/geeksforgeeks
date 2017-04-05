import java.util.Scanner;

public class Array9 {
	/*Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter array size:");
		int arrSize = sc.nextInt();
		System.out.println("enter array:");
		int arr[] = new int[arrSize];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("enter location from where you want Rotation");
		int locationFromRotate = sc.nextInt();
		
		rotateFunction(arr, locationFromRotate, arrSize);
		System.out.println("array after rotation:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");
		}
	}
	
	static public void rotateFunction(int []arr, int locationFromRotate, int arrSize){
		int temp[] = new int[locationFromRotate];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = arr[i];
		}
		int t = locationFromRotate;
		for (int i = 0; i < arr.length-locationFromRotate; i++) {
			arr[i] = arr[t];
			t++;
		}
		int tempIndex = 0;
		for (int i = 0; i < temp.length; i++) {
			System.out.println("temp array = "+temp[i]);			
		}
		System.out.println("arr");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		
		}
		
		for (int i = t; i < arr.length; i++) {
			arr[i] = temp[tempIndex];
			System.out.println("arr[] " +arr[i]);
			tempIndex++;
		}
	}
}
