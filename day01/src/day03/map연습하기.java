package day03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//key 전화 뒷자리 "3334" 값 회원번호 111 
//key   value
//3334   1111
//2224   1112
//1114   1113
//1234   1000
//
//위의 자료를 map에 넣고 전체를 출력하는 프로그램을 작성하시오
public class map연습하기 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("3334", 1111);
		map.put("2224", 1112);
		map.put("1114", 1113);
		map.put("1234", 1000);
		
		Set keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.print(key + " ");
			System.out.println(map.get(key));
		}
	}

}
