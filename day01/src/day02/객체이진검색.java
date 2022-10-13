package day02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 객체이진검색 {

	public static void main(String[] args) {
		// 1. Student 클래스를 캑체화하여 배열에 담아 둔다.
		Student[] sArr = { new Student("강민하", 162, 0.3),
						   new Student("이수연", 172, 0.5),
						   new Student("황지민", 156, 1.0),
						   new Student("김찬우", 173, 1.2) };
		
		// 2. 검색해줄 키값을 입력받는다.
		Scanner sc = new Scanner(System.in);
		System.out.print("찾고 싶은 키: ");
		int key = sc.nextInt();
//		int idx = Arrays.binarySearch(sArr, key);  // error -> 주소를 찾는게 아니라 객체의 필드인 키를 찾아야함
		int idx = Arrays.binarySearch(sArr, new Student("", key, 0.0), Student.HEIGHT_ORDER);
		if (idx < 0)
			System.out.println(key + "키는 없습니다.");
		else {
			System.out.println("그 값은 " + idx + "에 있습니다.");
			System.out.println("찾는 데이터는 " + sArr[idx] + " 입니다.");
		}
	}

}

class Student {
	String name;
	int height;
	double vision;
	public Student(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	// 상수처리
	public static final Comparator<Student> HEIGHT_ORDER = new HeightComparator();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public double getVision() {
		return vision;
	}
	public void setVision(double vision) {
		this.vision = vision;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", height=" + height + ", vision=" + vision + "]";
	}
}

class HeightComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// o1는 이미 들어온 자료 o2는 넣을 자료
		System.out.println("이곳은 키를 정렬하기위한 기준을 셋팅하는 부분임");
		return (o1.height > o2.height) ? 1 : (o1.height == o2.height) ? 0 : -1;
		// 또는 return (o1.height - o2.height);
	}
	
}