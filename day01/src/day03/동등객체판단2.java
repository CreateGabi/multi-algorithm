package day03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Person String tel, String name, int total
// 전화번호 같고 이름 같으면 같은 사람 풀어보기

public class 동등객체판단2 {

	public static void main(String[] args) {
		Set<Person> pSet = new HashSet<Person>();
		pSet.add(new Person("0000", "홍1", 10));
		pSet.add(new Person("2222", "홍2", 20));
		pSet.add(new Person("1111", "홍3", 30));
		pSet.add(new Person("0000", "홍1", 10));
		pSet.add(new Person("1111", "홍1", 30));
		
		Iterator<Person> it = pSet.iterator();
		while (it.hasNext()) {
			// 주소 상 같은 것을 동등객체로 판단해서 중복 제거 안됨
			System.out.println(it.next());
		}
	}

}

class Person {
	private String tel;
	private String name;
	private int total;
	
	public Person(String tel, String name, int total) {
		super();
		this.tel = tel;
		this.name = name;
		this.total = total;
	}

	@Override
	public String toString() {
		return "Person [tel=" + tel + ", name=" + name + ", total=" + total + "]";
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}