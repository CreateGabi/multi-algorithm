package day01;

import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
		int n, ori_number;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ������ �Է��ϼ���. ");
		n = sc.nextInt();
		ori_number = n;
		
		while (n > 0) {
			n = n / 10;
			count++;
		}
		System.out.println(ori_number + "�� " + count + "�ڸ� �Դϴ�.");
	}

}
