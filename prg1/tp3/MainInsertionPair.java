package fr.istic.prg1.tp3;

import java.util.Arrays;
import java.util.Scanner;

public class MainInsertionPair {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		Pair p1 = new Pair(5, 4);
		Pair p2 = p1.clone();
		Pair p3 = new Pair(5, 2);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.equals(p2));
		System.out.println(p3.less(p2));
		System.out.println("-------------");
		
		
		InsertionPair it = new InsertionPair();
		
		 boolean result = it.insert(new Pair(3, 8));
		result = it.insert(new Pair(1, 4));
		result = it.insert(new Pair(3, 8));
		result = it.insert(new Pair(1, 3));
		System.out.println(Arrays.toString(it.toArray()));
		
		it.createArray(scanner);
		System.out.println(it);

	}

}
