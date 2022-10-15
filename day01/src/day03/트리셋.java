package day03;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class 트리셋 {

	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		
		scores.add(87);
		scores.add(88);
		scores.add(98);
		scores.add(75);
		scores.add(80);
		scores.add(85);
		
		Integer score = null;
		score = scores.first();
		System.out.println("가장 낮은 점수 " + score);
		score = scores.last();
		System.out.println("가장 낮은 점수 " + score);
		score = scores.lower(95);
		System.out.println("95점 아래 점수 " + score);
		score = scores.higher(95);
		System.out.println("95점 위 점수 " + score);
		
		NavigableSet<Integer> descedingSet = scores.descendingSet();
		for (Integer integer : descedingSet) {
			System.out.print(integer + " ");
		}
		System.out.println();
		NavigableSet<Integer> descendingSet1 = descedingSet.descendingSet();
		for (Integer integer : descendingSet1) {
			System.out.print(integer + " ");
		}
	}

}
