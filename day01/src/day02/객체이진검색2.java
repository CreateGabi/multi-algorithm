package day02;

import java.util.Arrays;
import java.util.Comparator;

public class 객체이진검색2 {

	public static void main(String[] args) {
		Person[] pArr = { new Person(10, "홍"),
				          new Person(20, "김"),
				          new Person(27, "최"),
				          new Person(25, "이") };
		Arrays.binarySearch(pArr, new Person(20, ""), Person.AGE_ORDER);
	}

}

class Person {
	int age;
	String name;
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	public static final Comparator<Person> AGE_ORDER = new AgeComparator();
}

class AgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return o1.age - o2.age;
	}
	
}