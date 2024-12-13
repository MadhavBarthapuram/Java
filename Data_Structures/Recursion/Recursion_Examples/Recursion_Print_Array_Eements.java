package Recursion_Examples;

public class Recursion_Print_Array_Eements {
	public static int i=0;
	//print array element from start;
	private static void printArrayElements(int[] arr) {
		System.out.print(" "+arr[i]);
		i++;
		if(i<arr.length) {
			printArrayElements(arr);
		}
	}
	//print array elements from a specific index
	private static void printArrayElements2(int[] arr, int j) {
		if(j>=arr.length) {
			return;
		}
		System.out.print(" "+arr[j]);
		printArrayElements2(arr,j+1);
	}
	public static void main(String[] args) {
		int arr[]= {1,3,5,63,6,3,6,3};
		printArrayElements(arr);
		System.out.println();
		printArrayElements2(arr,5);
	}


	
}
