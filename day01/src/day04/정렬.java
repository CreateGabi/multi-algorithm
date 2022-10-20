package day04;

import java.util.Iterator;

public class 정렬 {

	int[] nums;
	// 정렬되기 전에 자료 만들어주기(초기화)
	void init() {
		nums = new int[] {6, 4, 3, 7, 1, 9, 8};
	}
	// 배열 안에 있는 것 출력하기
	void display() {
		for (int i : nums) {
			System.out.printf("%3d", i);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		정렬 s = new 정렬();
		// 내부정렬 - 메모리 안에 올려두고 정렬하는 것
		// 외부정렬 - 정렬할 데이터가 많아서 메모리에 올려 처리하기 힘든 경우(기본 알고리즘은 내부정렬 알고리즘 도입함)
		// 정렬의 핵심요소는 교환 선택 삽입
		// 버블정렬
		System.out.println("----- 버블 정렬하기 전");
		s.init();
		s.display();
		s.bubbleSort1();
		System.out.println("----- 버블 정렬하기 후");
		s.display();
		
		System.out.println("----- 버블 정렬하기 전");
		s.init();
		s.display();
		s.bubbleSort2();
		System.out.println("----- 버블 정렬하는 중에 정렬 완료된 것 체크(향상된 버블 정렬)");
		s.display();
		
		System.out.println("----- 선택 정렬하기 전");
		s.init();
		s.display();
		s.selectSort();
		System.out.println("----- 선택 정렬하는 중에 정렬 완료된 것 체크");
		s.display();
		
		System.out.println("----- 삽입 정렬하기 전");
		s.init();
		s.display();
		s.insertSort();
		System.out.println("----- 삽입 정렬하는 중에 정렬 완료된 것 체크");
		s.display();
	}
	
	void bubbleSort1() {
		System.out.println("버블 정렬 중 ------->");
		for (int i = 0; i < nums.length - 1; i++) {  // i=0 i=1
			for (int j = 0; j < nums.length - 1 - i; j++) {  // j=0 j<6, j=0 j<5
				if (nums[j] > nums[j+1]) {
					int temp = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = temp;
				}
			}
			System.out.printf("%3d 회 : ", (i+1));
			display();
		}
		System.out.println();
	}

	void bubbleSort2() {
		boolean flag = false;
		System.out.println("버블 정렬 중 ------->");
		for (int i = 0; i < nums.length - 1; i++) {
			flag = false;
			for (int j = 0; j < nums.length - 1 - i; j++) {
				if (nums[j] > nums[j+1]) {
					flag = true;
					int temp = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = temp;
				}
			}
			if (flag == false) break;
			System.out.printf("%3d 회 : ", (i+1));
			display();
		}
		System.out.println();
	}
	
	void selectSort() {
		System.out.println("선택 정렬 중 ------->");
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
				}
			}
			System.out.printf("3%d 회 : ", (i+1));
			display();
		}
	}
	
	void insertSort() {
		int i, j;
		System.out.println("삽입 정렬 중 ------->");
		for (i = 1; i < nums.length; i++) {
			int temp = nums[i];  // 위치 찾을 변수값을 temp에 저장함
			j = i;
			while (j > 0 && temp < nums[j-1]) {
				nums[j] = nums[j-1];  // nums[1] = nums[0]
				j--;
			}
			nums[j] = temp;
			display();
		}
	}
}
