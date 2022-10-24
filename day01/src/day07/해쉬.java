package day07;

public class 해쉬 {

	public static void main(String[] args) {
		Hash hash = new Hash();
		hash.createHashTable();
		hash.display();
		hash.search("비비빅");
		hash.search("김밥");
		String name = "홍길동";
		System.out.println(name.hashCode());
		Integer kor = 80;
		System.out.println(kor.hashCode());
		Double rate = 3.14;
		System.out.println(rate.hashCode());
	}

}

class Hash {
	int BUCKET_SIZE = 10;
	Node[] bucket = new Node[BUCKET_SIZE];
	
	public Hash() {
		for (int i=0; i<BUCKET_SIZE; i++) {
			bucket[i] = new Node();
		}
	}

	public void search(String key) {
		int hash = getHash(key);
		Node trace = bucket[hash].next;
		boolean find = false;
		while (trace != null) {
			if (trace.data.equals(key)) {
				find = true;
				break;
			}
			else trace = trace.next;
		}
		
		if (find) System.out.println("found");
		else System.out.println("not found");
	}

	public void display() {
		for (int i=0; i<BUCKET_SIZE; i++) {
			Node trace = bucket[i].next;
			while (trace != null) {
				System.out.print(trace.data + " ");
				trace = trace.next;
			}
			System.out.println();
		}
	}

	public void createHashTable() {
		String[] words = new String[] {"학교", "곰돌이", "김밥", "비비빅", "비빔밥"};
		for (String w : words) insert(w);
	}

	private void insert(String data) {
		int hash = getHash(data);
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = bucket[hash].next;
		bucket[hash].next = newNode;
	}

	private int getHash(String data) {
		int i, sum = 0;
		for (i=0; i<data.length(); i++) sum += data.charAt(i);
		return sum % BUCKET_SIZE;
	}
}

class Node {
	String data = "";
	Node next = null;
}