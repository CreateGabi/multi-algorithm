package day01;

import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
		int n, ori_number;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양의 정수를 입력하세요. ");
		n = sc.nextInt();
		ori_number = n;
		
		while (n > 0) {
			n = n / 10;
			count++;
		}
		System.out.println(ori_number + "는 " + count + "자리 입니다.");
	}

}
