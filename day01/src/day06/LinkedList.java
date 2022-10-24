package day06;

import java.util.Comparator;

public class LinkedList<E> {
	class Node<E> {
		private E data;  // 실제 데이터
		private Node<E> next;  // 다음 노드를 가리키는 주소
		
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head;  // 머리포인트(시작 노드 주소를 담는 곳)
	private Node<E> crnt;  // 선택포인트(선태간 노드 주소를 담는 곳)
	
	public LinkedList() {
		head = null;
		crnt = null;
	}
	
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head;
		
		while (ptr != null) {
			if (c.compare(obj, ptr.data) == 0) {
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null;
	}
	
	public void addFirst(E obj) {
		Node<E> ptr = head;
		head = crnt = new Node<E>(obj, ptr);
	}
	
	public void addLast(E obj) {
		if (head == null) addFirst(obj);
		else {
			Node<E> ptr = head;
			while (ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = crnt = new Node<E>(obj, null);
		}
	}
	
	// 중간에 삽입하기는 직접 만들기
	public void addMid(E obj, E insertFrontData) {
		
	}
	
	public void removeFirst() {
		if (head != null) {
			head = crnt = head.next;
		}
	}
	
	public void removeLast() {
		if (head != null) {
			if (head.next == null) {
				removeFirst();
			} else {
				Node<E> ptr = head;  // 스캔 중인 노드
				Node<E> pre = head;  // 스캔 중인 노드 앞의 노드
				while (ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null;
				crnt = pre;
			}
		}
	}
	
	public void remove(Node p) {
		if (head != null) {
			if (p == head) removeFirst();
			else {
				Node<E> ptr = head;
				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr == null) return;
				}
				ptr.next = p.next;
				crnt = ptr;
			}
			
		}
	}
	
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	// 모든 노드 삭제
	public void clear() {
		while (head != null) {
			removeFirst();
		}
		crnt = null;
	}
	
	public boolean next() {
		if (crnt == null || crnt.next == null) return false;
		crnt = crnt.next;
		return true;
	}
	
	// 선택된 노드 출력
	public void printCurrentnode() {
		if (crnt == null) System.out.println("선택한 노드가 없습니다.");
		else System.out.println(crnt.data);
	}
	
	// 전체 출력
	public void dump() {
		Node<E> ptr = head;
		   while( ptr != null) {
			   System.out.println(ptr.data);
			   ptr = ptr.next;
		   }
	}
}
