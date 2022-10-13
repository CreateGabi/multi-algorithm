package day02;

public class ArrayEx02 {

	public static void main(String[] args) {
		// 1. 2차원 배열을 만들어 두고 학번, 이름 넣기
		String[][] s = new String[5][2];
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
		
		// 2. 학번을 숫자로 변경하기
		int[] s1 = new int[5];  // 학번을 숫자로 변경해서 담아 둘 1차원 배열
		for (int i=0; i<s1.length; i++) {
			s1[i] = Integer.parseInt(s[i][0]);
		}
		
		// 3. 학번이 누가 제일 적은 사람인지 찾기
		// 랭킹 구하는 알고리즘
		int[] s2 = new int[5];  // 각 학번의 랭킹 구하여 담아둘 1차원 배열
		for (int i=0; i<s1.length; i++) {
			int cnt = 0;
			for (int j=0; j<s2.length; j++) {
				if (s1[i] > s1[j]) {
					cnt++;
				}
			}
			s2[i] = cnt;
		}
		
		for (int x : s2) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		// 4. 랭킹 배열에 있는 값을 이용해서 so[][] 배열 안에 넣기
		String[][] so = new String[5][2];
		for (int i=0; i<s2.length; i++) {
			so[s2[i]][0] = s[i][0];
			so[s2[i]][1] = s[i][1];
		}
		for (String[] str : so) {
			for (String str2 : str) {
				System.out.print(str2 + " ");
			}
			System.out.println();
		}
	}

}
