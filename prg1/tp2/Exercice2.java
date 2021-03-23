package fr.istic.prg1.tp2;
import java.util.Arrays;
import java.util.Scanner;

public class Exercice2 {
	
	static Scanner clavier = new Scanner(System.in);
	
	/**
	 * Retourne un chiffre à partir d'une position de bit de poids
	 * @param pos
	 * @param nombre
	 * @return chiffre
	 */
	public static int digit(int pos, int nombre) {
		int i=-1;
		int chiffre = 0;
		while(nombre != 0 && i != pos) {
			chiffre =  nombre % 10;
			nombre = nombre / 10;
			i++;
		}
		return chiffre;
	}
	
	public static int nbDigits(int nombre) {
		int cpt=0;
		while(nombre != 0) {
			nombre = nombre / 10;
			cpt++;
		}
		return cpt;
	}
	
	public static boolean estMysterieux(int n){
		boolean tab[] = new boolean[10];
		int carre = n*n, cube = n*n*n;
		
		//Initialisation du tableau a false
		for(int i=0; i<tab.length; i++) {
			tab[i]=false;
		}
		
		//On marque les chiffres cochés pour n*n
		int cpt=0;
		for(int i=0; i<nbDigits(carre); i++) {
			for(int j=0; j<10; j++) {
				if(digit(i,carre) == j) {
					if(tab[j]==true) {
						return false;
					}
					tab[j] = true;
				}
			}
		}
		//On marque les chiffres cochés pour n*n*n
		for(int i=0; i<nbDigits(cube); i++) {
			for(int j=0; j<10; j++) {
				if(digit(i,cube) == j) {
					if(tab[j]==true) {
						return false;
					}
					tab[j] = true;
				}
			}
		}
		//Verification du tableau
		for(int i=0; i<tab.length; i++) {
			if(tab[i]==true) {
				cpt++;
			}
		}
		
		if(cpt==tab.length) {
			return true;
		}else {
			return false;
		}
		
		
		//System.out.println(Arrays.toString(tab));
	}
	
	public static void listMyterieux(int limite) {
		for(int i=1; i<=limite; i++) {
			if(estMysterieux(i)) {
				int carre=i*i;
				int cube =i*i*i;
				System.out.println(i+" est mysterieux!");
				System.out.println("\tn*n="+carre+" et n*n*n="+cube);
			}
		}
	}
	public static void main(String[] args) {
		System.out.print("Entrer un entier : ");
		int n = clavier.nextInt();
		listMyterieux(n);
	}

}
