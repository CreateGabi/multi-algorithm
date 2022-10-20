package day04;


public class 스택 {

	public static void main(String[] args) {
		Stack<Character> s = new Stack<Character>(50);
		
		s.push('A');
		s.push('B');
		s.push('C');
		s.push('D');
		s.push('E');
		
		System.out.println(s.pop());
	}

}

class Stack<T> {
	private T stack[];
	private int top;
	
	@SuppressWarnings("unchecked")
	public Stack() {
		stack = (T[]) new Object[10];
		top = -1;
	}
	
	@SuppressWarnings("unchecked")
	public Stack(int size) {
		if (size < 10) size = 10;
		stack = (T[]) new Object[size];
		top = -1;
	}
	
	public void push(T a) {
		// 스택의 공간이 꽉차있는지 확인
		if (isFull()) {
			System.out.println("Stack OverFlower");
			return;
		}
		top++; // System.out.println(top + "~~");
		stack[top] = a; // System.out.println(stack[top] + "~~~");
	}
	
	private boolean isFull() {
		if (top == stack.length - 1) return true;
		else return false;
	}
	
	public T pop() {
		if (isEmpty()) {
			System.out.println("Stack UnderFlower");
			return null;
		}
		T temp = stack[top];
		top--;
		return temp;
	}

	private boolean isEmpty() {
		if (top == -1) return true;
		else return false;
	}
}