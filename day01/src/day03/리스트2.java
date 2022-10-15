package day03;

import java.util.List;
import java.util.Vector;

public class 리스트2 {

	public static void main(String[] args) {
		// 스레드를 활용한 멀티프로그램할 때 동기화 처리 해 준 리스트
		List<Board> vlist = new Vector<Board>();
		vlist.add(new Board("제목1", "내용1", "작성자1"));
		vlist.add(new Board("제목2", "내용2", "작성자2"));
		vlist.add(new Board("제목3", "내용3", "작성자3"));
		System.out.println(vlist.get(0));
	}

}

class Board {
	String subject;
	String content;
	String writer;
	public Board(String subject, String content, String writer) {
		super();
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "Board [subject=" + subject + ", content=" + content + ", writer=" + writer + "]";
	}
}