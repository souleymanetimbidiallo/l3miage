package fr.istic.prg1.tp3;

import java.util.Scanner;

public class InsertionPair{
	
	private static final int SIZE_MAX = 10;
	
	private int size;
	
	private Pair[] array = new Pair[SIZE_MAX];
	
	/**
	 * Constructeur
	 */
	public InsertionPair() {
                 		this.size = 0;
	}
	
	/**
	 * @return copie de la partie remplie du tableau de doublets
	 */
	public Pair[] toArray() {
		Pair[] copy = new Pair[size];
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
	private boolean exist(Pair value) {
		boolean trouve = false;
		int i=0;
		while(i<size && trouve==false) {
			if(array[i].equals(value)) {
				trouve = true;
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
	public boolean insert(Pair value) {
		if(size>=SIZE_MAX) {  /* Verifier que le tableau n'est pas rempli*/
			return false; 
		}else if(exist(value)) { /* Verifier que la valeur n'est pas dans le tableau*/
			return false;
		}else { /*Inserer la valeur dans le tableau */
			int position = 0;
			while(position<size && array[position].less(value)) {
				position++;
			}
			for(int j=size; j>position; --j) {
				array[j] = array[j-1];
			}
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
		int x = scanner.nextInt();
		boolean end = false;
		while(x > -1 && !end){
			int y = scanner.nextInt();
			if(y == -1) {
				end = true;
			}else {
				insert(new Pair(x, y));
				x = scanner.nextInt();
			}
		}
	}
	
	@Override
	/**
	 * @return la liste des doublets du tableau sous forme de chaine
	 */
	public String toString(){
		String str = "";
		for(int i=0; i<size; i++) {
			str += array[i] +", ";
		}
		return str;
	}
	
}