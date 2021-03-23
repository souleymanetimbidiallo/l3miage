   package fr.istic.prg1.tp3;

import java.util.Scanner;

public class InsertionInteger{
	
	private static final int SIZE_MAX = 10;
	/**
	 * le nombre d'entiers presents dans t, 
	 * 0 <= size <= SIZE_MAX
	 */
	private int size;
	
	private int[] array = new int[SIZE_MAX];
	
	/**
	 * Constructeur
	 */
	public InsertionInteger() {
		this.size = 0;
	}
	
	/**
	 * @return copie de la partie remplie du tableau
	 */
	public int[] toArray() {
		int[] copy = new int[size];
		for(int i=0; i<size; i++) {
			copy[i] = this.array[i];
		}
		return copy;
	}
	
	/**
	 * 
	 * @param value
	 * @return true si la value existe dans le tableau array, false sinon.      
	 */
	private boolean exist(int value) {
		boolean trouve = false;
		int i=0;
		while(i<size && !trouve) {
			if(array[i]==value) {
				trouve=true;
			}
			i++;
		}
		return trouve;
	}
	
	/**
	 * 
	 * @param value
	 * 		  valeur a inserer
	 * @pre les valeurs de array[0..size-1] sont tries 
	 * par ordre croissant
	 * @return false si x appartient a array[0..size-1] ou 
	 * 		   si array est completement rempli;
	 * 		   true si x n'appartient pas a array[0...size-1]
	 */
	public boolean insert(int value) {
		
		if(value < 0) { //Vérifier si la valeur est négatif
			return false;
		}
		else if(size==SIZE_MAX) { /*verifier que le tableau est remplie*/
			return false; 
		}
		else if(exist(value)) { /* Verifier que la valeur n'est pas dans le tableau*/
			return false;
		}else { /*Inserer la valeur dans le tableau */
			//Trouver la position pour insérer la valeur
			int position = 0;
			while(position<size && array[position]<value) {
				position++;
			}
			//Faire le décalage des valeurs supérieurs à l'indice de position
			for(int j=size; j>position; --j) {
				array[j] = array[j-1];
			}
			//Inserer la valeur
			array[position] = value;
			size++;
			return true;
		}
	}
	
	/**
	 * array est rempli, par ordre croissant, en utilisant la
	 * fonction insert avec les valeurs lues par scanner
	 * 
	 * @param scanner
	 */
	public void createArray(Scanner scanner) {
		int value = scanner.nextInt();
		while(value != -1){
			insert(value);
			value = scanner.nextInt();
		}
	}
	
	
	/**
	 * @return la liste des valeurs du tableau sous forme de chaine
	 */
	@Override
	public String toString(){
		String str = "";
		for(int i=0; i<size; i++) {
			str += array[i] +" ";
		}
		return str;
	}
	
}