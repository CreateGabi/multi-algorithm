package day05;

import java.util.Iterator;

//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;

public class 선형리스트만들기 {

	public static void main(String[] args) {
		List arr = new List();
		arr.createList(10);
		System.out.println(arr.isEmpty());
		arr.insert(0, 1);
		arr.insert(1, 2);
		arr.insert(2, 3);
		arr.insert(1, 4);
		arr.insert(4, 5);
		arr.insert(5, 6);
		arr.insert(6, 7);
		arr.insert(7, 8);
		arr.insert(8, 9);
		arr.insert(9, 10);
		
		arr.printall();
		System.out.println();
		
		arr.delete(0);
		arr.printall();
		
//		List ulist = new ArrayList<Integer>();
//		ulist.add(10);
//		ulist.add(20);
//		ulist.add(1, 40);
//		ulist.add(30);
//		for (int i=0; i<ulist.size(); i++) {
//			System.out.println(i + " " + ulist.get(i));
//		}
	}

}

class List {
	int arr[];
	int size;
	public void createList(int number) {
		// 배열의 크기가 10인 배열 생성
		arr = new int[number];
		size = 0;
	}
	public void delete(int x) {
		// 해당 값을 찾아서 삭제
//		for (int i=0; i<size; i++) {
//			if (i == x) {
//				int j = i;
//				while (j < size - 1) {
//					arr[j] = arr[j+1];
//					j++;
//				}
//				size--;
//			}
//		}  // 강사가 사용한 방법
		// 내가 수정함
		for (int i=x; i<size; i++) {
			if (i+1 >= size) arr[i] = 0;
			else arr[i] = arr[i+1];
		}
		size--;
	}
	public void printall() {
		// 전체 출력
		for (int i=0; i<size; i++) {
			System.out.printf("%3d", arr[i]);
		}
	}
	public void insert(int i, int x) {
		// 리스트에 값 삽입
		int len = size;
		while (i != len) {
			arr[len] = arr[len - 1];
			len--;
		}
		arr[i] = x;
		size++;
	}
	public boolean isEmpty() {
		// 배열이 비어있는지 확인
		return size == 0;
	}
}
// 리스트는 데이터를 순서대로 나열한 구조
// 노드는 리스트에 있는 개별 요소
// head node - 제일 처음에 있는 노드, tail node - 제일 마지막에 있는 노드
// predecessor node - 하나의 노드를 기준으로 바로 앞에 노드
// successor node - 하나의 노드를 기준으로 바로 뒤에 노드