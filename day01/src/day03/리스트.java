package day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class 리스트 {

	public static void main(String[] args) {
		// 배열 대신 사용하는 컬렉션
		// 배열의 단점은 중간에 자료가 지워진 경우 빈 상태로 그대로 진행
		// 배열의 크기를 늘리는 것이 안되니까 다른 배열을 만들어서 옮겨야 함
		List<String> list = new ArrayList<String>();
		
		list.add("AA");
		list.add("BB");
		list.add(1, "CC");
		list.add("AA");
		list.add("DD");
		
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		list.remove("DD");
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i) + "~~");
		}
		
		List<String> list1 = Arrays.asList("11", "22", "33", "44");
		for (String string : list1) {
			System.out.print(string + " ");
		}
	}

}
