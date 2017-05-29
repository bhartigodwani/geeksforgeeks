import java.util.Scanner;

public class Array8 {
    /*Write a program to reverse an array or string
      Recursive approach
     */
    public static void main(String[] args) {
        System.out.println("enter array size to be reversed");
        Scanner sc = new Scanner(System.in);
        int arraysize = sc.nextInt();
        int arr1[] = new int[arraysize];
        int arr2[] = new int[arraysize];

        System.out.println("enter "+arraysize+" elements");
        for (int i = 0; i < arraysize; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("enter "+arraysize+" elements");
        for (int i = 0; i < arraysize; i++) {
            arr2[i] = sc.nextInt();
        }

        firstWay(arr1);//for loop

        secondWay(arr2, 0, arr2.length-1);//recursive approach
        System.out.println("\nsecondWay");
        System.out.println("reversed array: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+ "    ");
        }
        System.out.println();
    }
    
    static void firstWay(int []a){
        System.out.println("\nfirstWay");
        int right = a.length-1;
        int temp;
        for (int i=0; i<(a.length-1)/2; i++){
            temp = a[i];
            a[i] = a[right];
            a[right] = temp;
            right--;
        }
        
        System.out.println("reversed array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+ "    ");
        }
        System.out.println();
        
    }
    
    static void secondWay(int arr[], int left, int right){
        
        if (left > right) {
            return;
        }
        if(left <= right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
            secondWay(arr, left, right);
        }
    }
}
