package day01;

import java.util.Iterator;

public class ArrayEx01 {

	public static void main(String[] args) {
		int[] aa = new int[10];
		String[][] b = new String[2][3];
		b[0][0] = "a";
		b[0][1] = "b";
		b[0][2] = "c";
		b[1][0] = "d";
		b[1][1] = "e";
		b[1][2] = "f";

		double[][][] c = new double[2][3][2];

		// 문1)
		int[] arr1 = new int[10];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = (i + 1) * 100;
		}
//		for (int i = 0; i < arr1.length; i++) {
//			System.out.print(arr1[i] + " ");
//		}
//		System.out.println();
		// 향상된 for문  foreach
		for (int i : arr1) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();

		// 문2)
		int[][] arr2 = new int[2][3];
		int number = 100;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = number;
				number -= 5;
			}
		}
//		for (int i = 0; i < arr2.length; i++) {
//			int sum = 0;
//			for (int j = 0; j < arr2[i].length; j++) {
//				sum += arr2[i][j];
//				System.out.print(arr2[i][j] + " ");
//			}
//			System.out.println(sum);
//		}
//		System.out.println();
		// foreach
		for (int[] is : arr2) {
			int sum = 0;
			for (int is2 : is) {
				sum += is2;
				System.out.print(is2 + " ");
			}
			System.out.println(sum);
		}
		System.out.println();

		// 문3)
		String[][][] str = { { { "a", "b" }, { "c", "d" }, { "e", "f" } }, 
				             { { "g", "h" }, { "i", "j" }, { "k", "l" } } };
		
		System.out.println("면의 갯수" + str.length);
		System.out.println("행의 갯수" + str[0].length);
		System.out.println("열의 갯수" + str[0][0].length);
		
//		for (int i = 0; i < str.length; i++) {
//			for (int j = 0; j < str[i].length; j++) {
//				for (int j2 = 0; j2 < str[i][j].length; j2++) {
//					System.out.print(str[i][j][j2] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		// foreach
		for (String[][] strings : str) {
			for (String[] strings2 : strings) {
				for (String strings3 : strings2) {
					System.out.print(strings3 + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
