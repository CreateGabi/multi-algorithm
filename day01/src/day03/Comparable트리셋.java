package day03;

import java.util.Iterator;
import java.util.TreeSet;

public class Comparable트리셋 {

	public static void main(String[] args) {
		// TreeSet에 Person클래스를 달아줌
		// 정렬 기준은 나이순
		TreeSet<Person2> treeSet = new TreeSet<Person2>();
		treeSet.add(new Person2("a", 10));
		treeSet.add(new Person2("b", 12));
		treeSet.add(new Person2("c", 13));
		treeSet.add(new Person2("d", 14));
		treeSet.add(new Person2("e", 15));

		Iterator<Person2> it = treeSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

class Person2 implements Comparable<Person2>{
	String name;
	int age;
	public Person2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Person2 o) {
		if (age < o.age) return -1;
		else if (age == o.age) return 0;
		else return 1;
	}
	
}