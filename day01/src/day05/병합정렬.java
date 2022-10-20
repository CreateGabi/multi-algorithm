package day05;

public class 병합정렬 {

	public static void main(String[] args) {
		int[] a = {2, 4, 6, 8, 11, 13};
		int[] b = {1, 2, 3, 4, 9, 16, 21};
		int[] c = new int[13];
		
		mergeSort(a, a.length, b, b.length, c);
		for (int i : c) {
			System.out.printf("%3d", i);
		}
	}

	private static void mergeSort(int[] a, int na, int[] b, int nb, int[] c) {
		int pa = 0;
		int pb = 0;
		int pc = 0;
		
		while (pa < na && pb < nb) 
			c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];	
		
		while (pa < na) c[pc++] = a[pa++];
		while (pb < nb) c[pc++] = b[pb++];
	}

}
