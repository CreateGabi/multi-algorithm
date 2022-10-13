package day01;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayEx02 {

	public static void main(String[] args) {
		String[][] s = new String[10][2];
		s[0][0] = "0397134";
		s[0][1] = "김효진";
		s[1][0] = "0465345";
		s[1][1] = "이종협";
		s[2][0] = "0427214";
		s[2][1] = "서상춘";
		s[3][0] = "0487342";
		s[3][1] = "배영미";
		s[4][0] = "0512478";
		s[4][1] = "김예진";
		
		// 비어있는 인덱스 5를 구해서 넣기
		int i = 0;
		for (; i < s.length; i++) {
			if (s[i][0] == null) break;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("학번은 ");
		s[i][0] = sc.next();
		System.out.print("이름은 ");
		s[i][1] = sc.next();
		
		for (String[] strings : s) {
			for (String strings2 : strings) {
				System.out.print(strings2 + " ");
			}
			System.out.println();
		}
		
		// 배영미 삭제
		// 배영미 찾아서 null로 바꾸어주기
		String deleteName = "배영미";
		int j = 0;
		for (; j < s.length; j++) {
			if (s[j][1].equals(deleteName)) break;
		}
		System.out.println(s[j][1] + " " + j);
		s[j][0] = null;
		s[j][1] = null;
		System.out.println("--------삭제 후 출력---------");
		for (String[] strings : s) {
			for (String strings2 : strings) {
				System.out.print(strings2 + " ");
			}
			System.out.println();
		}
		
		// 김예진이 우리반인지 검색
		// 우리반이면 학번과 이름 출력, 아니면 아닙니다라고 출력
		String searchName = "박예진";
		int k = 0;
		boolean searchFlag = false;
		for (; k < s.length; k++) {
			if (s[k][1] != null && s[k][1].equals(searchName)) {
				searchFlag = true;
				break;
			}
		}
		System.out.println("--------검색 후 출력---------");
		if (searchFlag) {
			System.out.println(s[k][0] + " " + s[k][1]);
		} else {
			System.out.println("우리반이 아닙니다.");
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
