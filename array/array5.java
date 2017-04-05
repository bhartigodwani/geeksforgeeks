import java.util.Scanner;

/*Find the Missing Number
You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer.

We strongly recommend that you click here and practice it, before moving on to the solution.

Example:
I/P    1 2 4 6 3 7 8
O/P    5

Solution 1 = count if any of the number is missing
Solution 2 = (count sum of all numbers from 1 to n) - (count of given numbers)*/

public class Array5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp[] = new int[10];
		int arr[] = new int[n];
		int flag = 0;
		int count [] = new int[n+2];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			sum = sum + arr[i];
		}
		
		System.out.println(sum);
		int total = ((n+1) * (n+2)) / 2;//n is 1 number less than the total number thats y n+1 is taken
		System.out.println(total);
		int result = total - sum ;
		System.out.println("result = "+result);
		
		/*for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			count[arr[i]]++;
		}
		for (int i = 1; i < count.length; i++) {
			if (count[i] == 0) {
				System.out.println("result = "+i);
				break;
			}
		}*/
	}
}
