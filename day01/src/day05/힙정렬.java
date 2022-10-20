package day05;

public class 힙정렬 {

	public static void main(String[] args) {
		int[] x = {6, 4, 3, 7, 1, 9, 8};
		int nx = x.length;
		heapSort(x, nx);
		System.out.println("오름 차순을 힙정렬했습니다.");
		for (int i : x) {
			System.out.printf("%3d", i);
		}
	}

	private static void heapSort(int[] a, int n) {
		for (int i=(n-1)/2; i>=0; i--) {
			downHeap(a, i, n-1);
		}
		for (int i=n-1; i>0; i--) {
			swap(a, 0, i);
			downHeap(a, 0, i-1);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void downHeap(int[] a, int left, int right) {
		int temp = a[left];
		int child;
		int parent;
		
		for (parent=left; parent < (right+1)/2; parent=child) {
			int cl = parent * 2 + 1;
			int cr = cl + 1;
			child = (cr <= right && a[cr] > a[cl]) ? cr : cl;
			if (temp >= a[child]) {
				break;
			}
			a[parent] = a[child];
		}
		
		a[parent] = temp;
	}

}
