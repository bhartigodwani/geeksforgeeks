import java.util.Scanner;

public class Array9 {
	/*Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.*/
	public static void main (String[] args) {
		/*
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
		*/
		int []a = {1,2,3,4,5,6};
		int position = 4;
		int temp[] = new int[position];
		for (int i=0; i<position; i++){
		    temp[i] = a[i];
		} 
		int index = 0;
		for(int i=position;i<a.length;i++){
		    a[index] = a[i];
		    index++;
		}
		int index2 = a.length - position , j=0;
		for (int i=index2; i<a.length; i++){
		    a[i] = temp[j];
		    j++;
		} 

		System.out.println("rotated array is : ");
		for (int i=0; i<a.length; i++)
		    System.out.print(a[i]+"   ");
    }
}
