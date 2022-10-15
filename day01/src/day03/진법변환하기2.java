package day03;

public class 진법변환하기2 {

	public static void main(String[] args) {
		Util util = new Util();
		System.out.println("<< 진법 변환하는 프로그램 >> ");
		// 10진수를 2진수로 바꾸기
		int n = 10;
		System.out.println("10진수 " + n + "를 2진수로 바꾸면 " + util.decToBin(n));
		
		// 2진수를 10진수로 바꾸기
		String bn = "1111";
		System.out.println("10진수 " + bn + "를 2진수로 바꾸면 " + util.binToDec(bn));		
	}

}

class Util {

	public String decToBin(int value) {
		String result = "";  // 결과값 변수
		int q, r;  // 몫, 나머지
		q = value;
		while (q != 0) {
			r = q % 2;  // r = 0;
			// 숫자 0을 문자로 만들기 String.valueOf(r);
			// 유니코드표에 문자 0은 코드표로 48입니다. 그래서 숫자(0) + 48을 하면 문자 0이 나옴
			result += (char)(r + '0');
			System.out.println(result);
			q = q / 2;
		}
		
		// 문자열로 된 결과를 반대로 뒤집기
		char[] c = result.toCharArray();
		for (int i = 0; i < c.length / 2; i++) {
			char temp = c[i];
			c[i] = c[c.length - i - 1];
			c[c.length - i - 1] = temp;
		}
		
		return String.valueOf(c);
	}

	public int binToDec(String value) {
		int result = 0;
		for (int i = 0; i < value.length(); i++) {
			result = result * 2 + value.charAt(i) - '0';
		}
		return result;
	}
	
}