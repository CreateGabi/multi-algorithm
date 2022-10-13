package day0201;

public class KMP법 {

	public static void main(String[] args) {
		String txt = "ABABCDEFGHA";
		String pat = "ABC";
		int idx = mkpMatch(txt, pat);
		if (idx == -1) System.out.println("텍스트에 패턴이 없습니다.");
		else {
			int len = 0;
			for (int i=0; i<idx; i++) {
				len += txt.substring(i, i+1).getBytes().length;
			}
			len += pat.length();
			System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
			System.out.println("텍스트 : " + txt);
			System.out.printf(String.format("패턴  : %%%ds\n", len), pat);
		}
	}

	private static int mkpMatch(String txt, String pat) {
		int pt = 1;
		int pp = 0;
		int[] skip = new int[pat.length() + 1];
		
		// 건너뛰기 표 만들기
		skip[pt] = 0;
		while (pt != pat.length()) {
			if (pat.charAt(pt) == pat.charAt(pp))
				skip[++pt] = ++pp;
			else if (pp == 0)
				skip[++pp] = pp;
			else
				pp = skip[pp];
		}
		
		// 검색
		pt = pp = 0;
		while (pt != txt.length() && pp != pat.length()) {
			if (txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			} else if (pp == 0)
				pt++;
			else
				pp = skip[pp];
		}
		
		if (pp == pat.length())
			return pt - pp;
		return -1;
	}

}
