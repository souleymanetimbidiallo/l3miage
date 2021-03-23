package fr.istic.prg1.tp2;
import java.util.Scanner;

public class Exercice1 {
	static int n;
	static Scanner clavier = new Scanner(System.in);

	public static void lecture(int tab[]) {
		for (int i = 0; i < n; i++) {
			System.out.print("Entrer un entier : ");
			tab[i] = clavier.nextInt();
		}
	}

	public static void tri(int tab[]) {
		for (int i = 0; i <= n - 2; i++) {
			int rangmin = i;
			for (int j = i + 1; j <= n - 1; j++) {
				if (tab[j] < tab[rangmin]) {
					rangmin = j;
				}
				int aux = tab[i];
				tab[i] = tab[rangmin];
				tab[rangmin] = aux;
			}
		}
	}

	public static void ecriture(int tab[]) {
		String str = "";
		System.out.println("Affichage du tableau : ");
		for (int i = 0; i < n; i++) {
			str += tab[i] + ", ";
		}
		System.out.println(str);
	}

	public static boolean dichotomique(int a, int tab[]) {
		int deb = 0, fin = n - 1, milieu = (deb + fin) / 2;
		while (deb <= fin && a != tab[milieu]) {
			if (a < tab[milieu]) {
				fin = milieu - 1;
			} else if (a > tab[milieu]) {
				deb = milieu + 1;
			}
			milieu = (deb + fin) / 2;
		}
		return deb <= fin;
	}

	public static void main(String[] args) {
		do {
			System.out.print("Entrer la taille du tableau : ");
			n = clavier.nextInt();

		} while (n < 1 || n > 50);
		int[] tab = new int[n];
		lecture(tab);
		tri(tab);
		ecriture(tab);
		System.out.println(dichotomique(5, tab));
	}

}
