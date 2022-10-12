package day01;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayEx02 {

	public static void main(String[] args) {
		String[][] s = new String[10][2];
		s[0][0] = "0397134";
		s[0][1] = "��ȿ��";
		s[1][0] = "0465345";
		s[1][1] = "������";
		s[2][0] = "0427214";
		s[2][1] = "������";
		s[3][0] = "0487342";
		s[3][1] = "�迵��";
		s[4][0] = "0512478";
		s[4][1] = "�迹��";
		
		// ����ִ� �ε��� 5�� ���ؼ� �ֱ�
		int i = 0;
		for (; i < s.length; i++) {
			if (s[i][0] == null) break;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("�й��� ");
		s[i][0] = sc.next();
		System.out.print("�̸��� ");
		s[i][1] = sc.next();
		
		for (String[] strings : s) {
			for (String strings2 : strings) {
				System.out.print(strings2 + " ");
			}
			System.out.println();
		}
		
		// �迵�� ����
		// �迵�� ã�Ƽ� null�� �ٲپ��ֱ�
		String deleteName = "�迵��";
		int j = 0;
		for (; j < s.length; j++) {
			if (s[j][1].equals(deleteName)) break;
		}
		System.out.println(s[j][1] + " " + j);
		s[j][0] = null;
		s[j][1] = null;
		System.out.println("--------���� �� ���---------");
		for (String[] strings : s) {
			for (String strings2 : strings) {
				System.out.print(strings2 + " ");
			}
			System.out.println();
		}
		
		// �迹���� �츮������ �˻�
		// �츮���̸� �й��� �̸� ���, �ƴϸ� �ƴմϴٶ�� ���
		String searchName = "�ڿ���";
		int k = 0;
		boolean searchFlag = false;
		for (; k < s.length; k++) {
			if (s[k][1] != null && s[k][1].equals(searchName)) {
				searchFlag = true;
				break;
			}
		}
		System.out.println("--------�˻� �� ���---------");
		if (searchFlag) {
			System.out.println(s[k][0] + " " + s[k][1]);
		} else {
			System.out.println("�츮���� �ƴմϴ�.");
		}
		
		
		String[][] so = new String[10][2];
		int hakbun = Integer.parseInt(s[0][0]);
		int minHakbun = hakbun;
		int minHakbunIndex = 0;
		int soIndex = 0;
		for (int l = 0; l < s.length; l++) {
			if (s[l][0] != null && minHakbun > Integer.parseInt(s[l][0])) {
				minHakbun = Integer.parseInt(s[l][0]);
				minHakbunIndex = l;
			}
		}
		so[soIndex][0] = String.valueOf(minHakbun);
		so[soIndex][1] = s[minHakbunIndex][1];
		System.out.println(so[soIndex][0] + " " + so[soIndex][1]);
	}

}
