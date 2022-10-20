package day04;

public class 문제 {
	
	String[] data;
	void init() {
		data = new String[] { "권수진", "최명진", "한경미", "박현진", "서유미"};
	}
	void display() {
		for (String i : data) {
			System.out.printf("%3s ", i);
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		문제 s = new 문제();
		
		System.out.println("----- 버블 정렬하기 전");
		s.init();
		s.display();
		s.bubbleSort2();
		System.out.println("----- 버블 정렬하는 중에 정렬 완료된 것 체크(향상된 버블 정렬)");
		s.display();
	}

	void bubbleSort2() {
		boolean flag = false;
		System.out.println("버블 정렬 중 ------->");
		for (int i = 0; i < data.length - 1; i++) {
			flag = false;
			for (int j = 0; j < data.length - 1 - i; j++) {
				if (data[j].compareTo(data[j+1]) > 0) {
					flag = true;
					String temp = data[j+1];
					data[j+1] = data[j];
					data[j] = temp;
				}
			}
			if (flag == false) break;
			System.out.printf("%3d 회 : ", (i+1));
			display();
		}
		System.out.println();
	}
}
