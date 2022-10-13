package day02;

import java.util.Arrays;
import java.util.Scanner;

public class StringBinarySearch121 {

	public static void main(String[] args) {
		Scanner stdId = new Scanner(System.in);
		
		String[] x = {"boolean", "byte", "char", "double", "float", "int", "long", "short"};
		System.out.print("찾고 싶은 글자는? ");
		String key = stdId.next();
		
		int idx = Arrays.binarySearch(x, key);
		if (idx < 0)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println("그 값은 x[" + idx + "]에 있습니다.");
		
		double[] x1 = {12.2, 23.4, 55.7};
		System.out.print("찾고 싶은 실수는? ");
		double x1key = stdId.nextDouble();
		
		idx = Arrays.binarySearch(x1, x1key);
		if (idx < 0)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println("그 값은 x[" + idx + "]에 있습니다.");
	}

}
