package day06;

import java.util.Comparator;
import java.util.Scanner;

public class 링크드리스트 {
	static Scanner stdIn = new Scanner(System.in);

	static class Data {
		static final int NO = 1;
		static final int NAME = 2;
		private Integer no;
		private String name;

		@Override
		public String toString() {
			return "Data [no=" + no + ", name=" + name + "]";
		}

		void scanData(String guide, int sw) {
			System.out.println(guide + "할 데이터를 입력하세요");
			if ((sw & NO) == NO) {
				System.out.print("번호 :");
				no = stdIn.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("이름 :");
				name = stdIn.next();
			}
		}

		// 찾기 함수를 처리하기 위해서 찾을 기준
		// 비교할 대상자(no 순) 구현
		public static final Comparator<Data> NO_ORDER = new NoOrderComparator();

		private static class NoOrderComparator implements Comparator<Data> {
			@Override
			public int compare(Data d1, Data d2) {
				return (d1.no > d2.no) ? 1 : (d1.no == d2.no) ? 0 : -1;
			}
		}

		public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

		private static class NameOrderComparator implements Comparator<Data> {
			@Override
			public int compare(Data d1, Data d2) {
				return d1.name.compareTo(d2.name);
			}
		}
	}

	// 열거형 객체는 정해져있는 값을 처리할 때 주로 사용
	enum Menu {
		ADD_FIRST("머리에 노드를 삽입"),
		ADD_LAST("꼬리에 노드를 삽입"),
		RMV_FIRST("머리에 노드를 삭제"), 
		RMV_LAST("꼬리에 노드를 삭제"),
		RMV_CRNT("선택 노드를 삭제"), 
		CLEAR("모든 노드를 삭제"), 
		SEARCH_NO("번호로 검색"), 
		SEARCH_NAME("이름으로 검색"),
		NEXT("선택 노드를 하나 뒤쪽으로 진행"), 
		PRINT_CRNT("선택 노드를 출력"),
		DUMP("모든 노드를 출력"), 
		TERMINATE("종료");

		private final String message;

		static Menu MenuAt(int idx) {
			for (Menu m : Menu.values()) {
				if (m.ordinal() == idx)
					return m;
			}
			return null;
		}

		private Menu(String string) {
			message = string;
		}

		public String getMessage() {
			return message;
		}
	}

	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s    ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.TERMINATE.ordinal())
					System.out.println();
			}
			System.out.print(":");
			key = stdIn.nextInt();

		} while (key < Menu.ADD_FIRST.ordinal() || key > Menu.TERMINATE.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		// 링크드리스트 추가, 삭제, 검색
		Menu menu; // 메뉴
		Data data; // 추가용 데이터 참조
		Data ptr; // 검색용 데이터 참조
		Data temp = new Data(); // 입력용 데이터

		LinkedList<Data> list = new LinkedList<Data>();

		do {
			switch (menu = SelectMenu()) {
			case ADD_FIRST:
				data = new Data();
				data.scanData("머리에 삽입", Data.NO | Data.NAME);
				list.addFirst(data);
				break;
			case ADD_LAST:
				data = new Data();
				data.scanData("꼬리에 삽입", Data.NO | Data.NAME);
				list.addLast(data);
				break;
			case RMV_FIRST:
				list.removeFirst();
				break;
			case RMV_LAST:
				list.removeLast();
				break;
			case RMV_CRNT:
				list.removeCurrentNode();
				break;
			case SEARCH_NO:
				temp.scanData("검색", Data.NO);
				ptr = list.search(temp, Data.NO_ORDER);
				if (ptr == null)
					System.out.println("그 번호의 데이터가 없습니다.");
				else
					System.out.println("검색 성공 : " + ptr);
				break;
			case SEARCH_NAME:
				temp.scanData("검색", Data.NAME);
				ptr = list.search(temp, Data.NAME_ORDER);
				if (ptr == null)
					System.out.println("그 이름의 데이터가 없습니다.");
				else
					System.out.println("검색 성공 : " + ptr);
				break;
			case NEXT:
				list.next();
				break;
			case PRINT_CRNT:
				list.printCurrentnode();
				break;
			case DUMP:
				list.dump();
				break;
			case CLEAR:
				list.clear();
				break;
			}
		} while (menu != Menu.TERMINATE);
	}

}
