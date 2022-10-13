package day02;

public class Q4 {
	
	public static void main(String[] args) {
		int[] a = {5, 7, 15, 28, 29, 31, 39, 58, 68, 70, 95};
		int key = 39;
		
		int idx = binSearch(a, a.length, key);
		if (idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println("그 값은 x[" + idx + "]에 있습니다.");
	}

	private static int binSearch(int[] a, int length, int key) {
		System.out.print("  |");
		for (int i = 0; i < length; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		System.out.println("--+----------------------------");
		
		int pl = 0;
		int pr = length - 1;
		do {
			int pm = (pl + pr) / 2;
			System.out.printf("  |  ");
			for (int j = 0; j < length; j++)
				if (j == pm)
					System.out.print("+");
				else if (j == pl)
					System.out.print("<-");
				else if (j == pr)
					System.out.print("->");
				else
					System.out.print("   ");
			System.out.println();
			System.out.print(pm + " |");
			for (int j = 0; j < length; j++)
				System.out.printf("%3d", a[j]);
			System.out.println();
			System.out.println("  |");
			if (a[pm] == key) return pm;
			else if(a[pm] > key) pr = pm - 1;
			else pl = pm + 1;
		} while (pl <= pr);
		return -1;
	}

}
