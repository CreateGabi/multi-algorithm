package day0201;

public class 문자열예제 {

	public static void main(String[] args) {
		String s = "abcdefgc이지스123社五";
		System.out.println("문자열 길이 " + s.length());
		System.out.println("문자열 길이 " + s.getBytes().length);
		System.out.println("문자열 안에 특정 문자를 꺼내는 메소드 " + s.charAt(1));
		System.out.println("부분 문자열을 꺼내는 메소드 substring " + s.substring(3));
		System.out.println("부분 문자열을 꺼내는 메소드 substring " + s.substring(2, 4));
		System.out.println("다른 문자열과 내용이 같은지 조사하는 메소드 " + s.equals("abc"));
		System.out.println("다른 문자열과 비교하는 메소드 " + s.compareTo("abcdefg"));
		System.out.println("문자열을 검색하기 " + s.indexOf("c"));
		System.out.println("문자열을 검색하기 " + s.lastIndexOf("c"));
	}

}
