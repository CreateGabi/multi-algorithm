package day05;

public class 퀵정렬 {

	public static void main(String[] args) {
		int[] x = {5, 8, 4, 2, 6, 1, 3, 9, 7};
		int nx = x.length;
		partition(x, x.length);
		quickSort(x, 0, nx - 1);  // 재귀호출을 활용한 퀵정렬
//		System.out.println("퀵정렬 했습니다.");
//		for (int i : x) {
//			System.out.printf("%3d", i);
//		}
		quickSort2(x, 0, nx - 1);
	}

	private static void quickSort2(int[] x, int left, int right) {
		IntStack lstack = new IntStack(right - left + 1);
		IntStack rstack = new IntStack(right - left + 1);
	}

	private static void quickSort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl + pr) / 2];
		
		System.out.printf("a[%d]~a[%d] : {", left, right);
		for (int i=left; i<right; i++) {
			System.out.printf("%3d", a[i]);
		}
		System.out.printf("%3d  }\n", a[right]);
		do {
			while (a[pl] < x) pl++;
			while (a[pr] > x) pr--;
			if (pl <= pr) swap(a, pl++, pr--);
		} while (pl <= pr);
		
		if (left < pr) quickSort(a, left, pr);
		if (pl < right) quickSort(a, pl, right);
	}

	private static void partition(int[] a, int n) {
		int pl = 0;  // 왼쪽의 시작 포인트는 인덱스 0
		int pr = n - 1;  // 오른쪽  시작포인트는 인덱스 n-1
		int x = a[n/2];
		do {
			while (a[pl] < x) pl++;
			while (a[pr] > x) pr--;
			if(pl <= pr) swap(a, pl++, pr--);
			
		} while (pl <= pr);
		System.out.println("피벗 값은 " + x + "입니다.");
		
		System.out.println("피벗 이하의 그룹");
		for (int i = 0; i <= pl - 1; i++) {
			System.out.printf("%3d", a[i]);
		}
		System.out.println();
		
		System.out.println("피벗과 같은 그룹");
		if (pl > pr + 1) {
			for (int i = pr+1; i <= pl-1; i++) {
				System.out.printf("%3d", a[i]);
			}
			System.out.println();
		}
		
		System.out.println("비벗 이상의 그룹");
		for (int i=pr+1; i<n; i++) {
			System.out.printf("%3d", a[i]);
		}
		System.out.println();
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
