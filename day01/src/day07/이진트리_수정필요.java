package day07;

public class 이진트리_수정필요 {

	public static void main(String[] args) {
		// 비즈니스 클래스 - 처리하는 내용 만들기
		BinarySearchTree bst = new BinarySearchTree();
		// 1. 이진검색트리에 자료를 삽입하기
		bst.makeTree();
		
		// 2. 운행(트리에 어떤 노드가 있는지 검색하기) 1) 중위운행, 2) 전위원행, 3) 후위운행
		System.out.println("-----------");
		System.out.println("중위(InOrder) 운행 Left-Root-Right");
		bst.inOrder(bst.root);
		System.out.println();
//		System.out.println("-----------");
//		System.out.println("전위(PreOrder) 운행 Root-Left-Right");
//		bst.preOrder(bst.root);
//		System.out.println();
//		System.out.println("-----------");
//		System.out.println("후위(PostOrder) 운행 Left-Right-Root");
//		bst.postOrder(bst.root);
		
		// 검색하기
		bst.search("snowman");
		
		// 삭제하기
		bst.delete("opera");
		System.out.println("-----------");
		System.out.println("중위(InOrder) 운행 Left-Root-Right");
		bst.inOrder(bst.root);
	}

}

class BinarySearchTree {
	TreeNode root = null;
	
	public void inOrder(TreeNode t) {
		// 중위운행
		if (t == null) return;
		inOrder(t.left);
		System.out.print(t.data + " ");
		inOrder(t.right);
	}
	
	public void preOrder(TreeNode t) {
		// 전위운행
		if (t == null) return;
		
		System.out.print(t.data + " ");
		preOrder(t.left);
		preOrder(t.right);
	}
	
	public void postOrder(TreeNode t) {
		// 후위운행
		if (t == null) return;	
		
		preOrder(t.left);
		preOrder(t.right);
		System.out.print(t.data + " ");
	}
	
	// 삽입
	public void makeTree() {
		String[] words = {"rain", "rainbow", "opera", "question", 
				"cloud", "windy", "snow", "snowman", "sunny", 
				"cold", "hot", "desk", "flower", "survey"};
		for (String w : words)
			insert(w);
	}
	
	public void insert(String data) {
		// 트리에 달아주기
		// 새로운 노드를 만들어서 root에서
		// data를 비교해서 작으면 노드의 왼쪽으로 이동한다. null을 찾을 때까지
		// data를 비교해서 크면 노드의 오른쪽으로 이동한다. null을 찾을 때까지
		
		// 새로운 노드가 들어갈 위치 찾기
		TreeNode pTrace = root;
		TreeNode pTrace2 = null;
		
		while (pTrace != null) {
			if (pTrace.data.equals(data)) return;
			pTrace2 = pTrace;
			if (pTrace.data.compareTo(data) > 0) pTrace = pTrace.left;
			else pTrace = pTrace.right;
			// pTrace2에는 달아줄 노드의 부모 위치, pTrace 달아줄 노드 위치
		}
		
		TreeNode newNode = new TreeNode(data);
		if (pTrace2 == null) root = newNode;  // 제일 처음인 경우
		else {
			if (pTrace2.data.compareTo(data) > 0) pTrace2.left = newNode;
			/*if (pTrace2.data.compareTo(data) < 0)*/ pTrace2.right = newNode;
		}
	}
	
	// 검색
	public void search(String data) {
		// data가 트리에 있는지 찾아 주는 것
		TreeNode pTrace = root;
		int cnt = 0;  // 몇번만에 찾았는지
		while (pTrace != null) {
			cnt++;
			if (pTrace.data.equals(data)) {
				System.out.printf("%d번만에 데이터를 찾았음", cnt);
				return;
			}
			if (pTrace.data.compareTo(data) > 0) pTrace = pTrace.left;
			else pTrace = pTrace.right;
		}
		System.out.println("못찾음");
	}
	
	// 삭제
	public void delete(String data) {
		// 1. 위치 찾기 삭제하고 나면 부모노드에 대한 정보가 필요하다
		TreeNode pTrace = root;
		TreeNode parent = null;
		boolean isLeftChild = true;
		
		boolean found = false;
		while (pTrace != null) {
			if (pTrace.data.equals(data)) {
				found = true;
				break;
			}
			parent = pTrace;
			if (pTrace.data.compareTo(data) > 0)
				pTrace = pTrace.left;
			else {
				pTrace = pTrace.right;
				isLeftChild = false;
			}
		}
		if (!found) return;
		
		// 2. 왼쪽 자식이 없을 경우
		if (pTrace.left == null) {
			if (pTrace == root) root = pTrace.right;
			else if (isLeftChild) parent.left = pTrace.right;
			else parent.right = pTrace.right;
			return;
		}
		
		// 3. 오른쪽 자식이 없을 경우
		if (pTrace.right == null) {
			if (pTrace == root) root = pTrace.left;
			else if (isLeftChild) parent.left = pTrace.left;
			else parent.right = pTrace.left;
			return;
		}
		// 4. 자식이 둘인 경우
		// 위치배정을 다시 해야함. 그냥 아무데나 골라서 바꿔치기한 후 삭제한다.
		// 삭제할 대상의 노드의 오른쪽 서브트리에서 가장 작은 대상을 찾아 바꿔치기한다.
		// 삭제 대상의 오른쪽 서브트리의 참조를 가져온다.
		TreeNode pSubParent = pTrace;
		TreeNode pSub = pTrace.right;
		while (pSub.left != null) {
			pSubParent = pSub;
			pSub = pSub.left;
		}
		
		pTrace.data = pSub.data;
		if (pSubParent.left == pSub) pSubParent.left = pSub.right;
		else pSubParent.right = pSub.right;
	}
}

class TreeNode {
	String data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode() {
		data = "";
		left = null;
		right = null;
	}
	
	public TreeNode(String data) {
		this.data = data;
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		return data;
	}
}