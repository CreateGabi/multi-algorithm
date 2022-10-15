package day03;

import java.util.Stack;

public class 컬렉션스택 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(90);
		stack.push(91);
		stack.push(92);
		stack.push(93);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
