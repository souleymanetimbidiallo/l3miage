package fr.istic.prg1.tp3;

import java.util.Arrays;
import java.util.Scanner;

public class MainInsertionInteger {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		InsertionInteger it = new InsertionInteger();
		boolean result = it.insert(36);
		System.out.println(result);
		result = it.insert(4);
		System.out.println(result);
		result = it.insert(36);
		System.out.println(result);
		System.out.println(Arrays.toString(it.toArray()));
		it.createArray(scanner);
		System.out.println(it.toString());
		
	}

}
