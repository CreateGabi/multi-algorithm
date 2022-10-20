package day05;

import java.util.Arrays;
import java.util.Comparator;

public class 퀵병합정렬응용 {
	
	static class PhyscData {
		String name;
		int height;
		double vision;
		public PhyscData(String name, int height, double vision) {
			super();
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
		@Override
		public String toString() {
			return "PhyscData [name=" + name + ", height=" + height + ", vision=" + vision + "]";
		}
		
		static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
		
		private static class HeightOrderComparator implements Comparator<PhyscData> {
			@Override
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.height > d2.height) ? 1 : (d1.height > d2.height) ? 0 : -1;
			}
		}
	}

	public static void main(String[] args) {
		PhyscData[] x = {
				new PhyscData("김민하", 162, 0.3),
				new PhyscData("김찬우", 173, 0.7),
				new PhyscData("박준서", 175, 1.0),
				new PhyscData("유서범", 171, 0.3),
				new PhyscData("이수연", 168, 0.3),
				new PhyscData("장경오", 174, 0.3),
				new PhyscData("황지안", 169, 0.3) };
		Arrays.sort(x, PhyscData.HEIGHT_ORDER);
		System.out.println("신체검사 리스트");
		System.out.println("이름       키   시력");
		System.out.println("-----------------");
		for (int i = 0; i < x.length; i++) {
			System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
		}
		System.out.println();
		
		int[] aa = {3, 6, 0, 2, 8, 5};
		Arrays.sort(aa);
		for (int i = 0; i < aa.length; i++) {
			System.out.printf("%3d", aa[i]);
		}
	}

}

