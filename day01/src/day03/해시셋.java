package day03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 해시셋 {

	public static void main(String[] args) {
		// set-중복을 제거하고자 하는 알고리즘일 때 이용함
		Set<String> set = new HashSet<String>();
		set.add("AA");
		set.add("BB");
		set.add("CC");
		set.add("BB");
		set.add("AA");
		set.add("DD");
		
		System.out.println(set.size());
		// set에는 get이 없어서 iterator 이용
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

}
