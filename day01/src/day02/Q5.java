package day02;

import java.util.Scanner;

public class Q5 {
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("요솟수: ");
		int num = stdIn.nextInt();
		int[] x = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = stdIn.nextInt();
		}

		System.out.print("검색할 값: ");
		int ky = stdIn.nextInt();

		int idx = binSearch(x, num, ky);

		if (idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println("그 값은 x[" + idx + "]에 있습니다.");
	}
	
	private static int binSearch(int[] a, int length, int key) {
		// 변수선언
		int pl = 0;
		int pr = length - 1;
		do {
			int pm = (pl + pr) / 2;
			if (a[pm] == key) {
				int idx = pm;
				while (a[idx] == key) {
					idx--;
				}
				return idx + 1;
			}
			else if(a[pm] > key) pr = pm - 1;
			else pl = pm + 1;
		} while (pl <= pr);
		return -1;
	}

}
