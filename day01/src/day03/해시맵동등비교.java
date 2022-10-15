package day03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class 해시맵동등비교 {

	public static void main(String[] args) {
		// HashTable은 스레드 동기화 어쩌구..
		Map<Student, Integer> map = new HashMap<Student, Integer>();
		map.put(new Student(11, "홍길동"), 95);
		map.put(new Student(22, "이순신"), 100);
		map.put(new Student(33, "홍길동"), 90);
		map.put(new Student(44, "최길동"), 95);
		// 주소가 달라서 키가 같아도 다른 객체로 인식
		map.put(new Student(22, "이순신"), 80);
		map.put(new Student(22, "이순신"), 70);
		
		Set<Student> set = map.keySet();
		Iterator<Student> it = set.iterator();
		while (it.hasNext()) {
			Student key = it.next();
			System.out.println(key + " " + map.get(key));
		}
	}

}

class Student {
	int sno;
	String name;
	public Student(int sno, String name) {
		super();
		this.sno = sno;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + "]";
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode() + sno;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student s = (Student)obj;
			return name.equals(s.name) && sno == s.sno;
		} else {
			return false;
		}
	}
}