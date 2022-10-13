package day01;

import java.util.Scanner;

public class BasicEx01 {

	public static void main(String[] args) {
		Scanner sc;
		int a, b, c;
		int max = -999999;
		int min = 999999;
		int mid;
		
		System.out.println("새 정수의 최대값을 구합니다.");
		sc = new Scanner(System.in);
		System.out.print("a의 값 ");
		a = sc.nextInt();
		System.out.print("b의 값 ");
		b = sc.nextInt();		
		System.out.print("c의 값 ");
		c = sc.nextInt();
		
		if (max < a) max = a;
		if (max < b) max = b;
		if (max < c) max = c;
		System.out.println("최대값은 " + max + "입니다.");
		
		if (min > a) min = a;
		if (min > b) min = b;
		if (min > c) min = c;
		System.out.println("최소값은 " + min + "입니다.");
		
		if (a >= b)
			if (b >= c)
				mid = b;
			else if (a <= c)
				mid = a;
			else
				mid = c;
		else if (a > c)
			mid = a;
		else if (b > c)
			mid = c;
		else
			mid = b;
		System.out.println("중앙값은 " + mid + "입니다.");
	}

}
