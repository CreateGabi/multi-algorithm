package day01;

import java.util.Scanner;

public class Q7 {

	public static void main(String[] args) {
		Scanner sc;
		int n, result;
		
		sc = new Scanner(System.in);
		n = sc.nextInt();
//		if (n % 2 == 0) 
//			result = (1 + n) * (n / 2);
//		else
//			result = (1 + n) * (n / 2) + ((n + 1) / 2);
//		System.out.println(result);
		
		double sum = 0;
		sum = (1 + n) * (n / 2.0);
		System.out.println((int)sum);
	}

}
