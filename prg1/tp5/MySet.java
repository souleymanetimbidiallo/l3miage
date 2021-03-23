package fr.istic.prg1.list;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import fr.istic.prg1.list.util.List;
import fr.istic.prg1.list_util.Comparison;
import fr.istic.prg1.list_util.Iterator;
//import fr.istic.prg1.list_util.List;
import fr.istic.prg1.list_util.SmallSet;


/**
 * @author Mickael Foursov <foursov@univ-rennes1.fr>
 * @version 5.0
 * @since 2018-10-02
 */

public class MySet extends List<SubSet> {

	/**
	 * Borne superieure pour les rangs des sous-ensembles.
	 */
	private static final int MAX_RANG = 128;
	/**
	 * Sous-ensemble de rang maximal a mettre dans le drapeau de la liste.
	 */
	private static final SubSet FLAG_VALUE = new SubSet(MAX_RANG, new SmallSet());
	/**
	 * Entree standard.
	 */
	private static final Scanner standardInput = new Scanner(System.in);

	public MySet() {
		super();
		setFlag(FLAG_VALUE);
	}

	/**
	 * Fermer tout (actuellement juste l'entree standard).
	 */
	public static void closeAll() {
		standardInput.close();
	}

	private static Comparison compare(int a, int b) {
		if (a < b) {
			return Comparison.INF;
		} else if (a == b) {
			return Comparison.EGAL;
		} else {
			return Comparison.SUP;
		}
	}

	/**
	 * Afficher a l'ecran les entiers appartenant a this, dix entiers par ligne
	 * d'ecran.
	 */
	public void print() {
		System.out.println(" [version corrigee de contenu]");
		this.print(System.out);
	}

	// //////////////////////////////////////////////////////////////////////////////
	// //////////// Appartenance, Ajout, Suppression, Cardinal
	// ////////////////////
	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * Ajouter a this toutes les valeurs saisies par l'utilisateur et afficher
	 * le nouveau contenu (arret par lecture de -1).
	 */
	public void add() {
		System.out.println(" valeurs a ajouter (-1 pour finir) : ");
		this.add(System.in);
		System.out.println(" nouveau contenu :");
		this.printNewState();
	}

	/**
	 * Ajouter a this toutes les valeurs prises dans is.
	 * C'est une fonction auxiliaire pour add() et restore().
	 * 
	 * @param is
	 *            flux d'entree.
	 */
	public void add(InputStream is) {
		Scanner scanner = (is == System.in) ? standardInput : new Scanner(is);
		int number = readValue(scanner, -1);
		while(number != -1) {
			addNumber(number);
			number = readValue(scanner, -1);
		}
		if (scanner != standardInput) scanner.close();
	}

	/**
	 * Ajouter value a this.
	 * 
	 * @param value
	 *            valuer a ajouter.
	 */
	public void addNumber(int value) {
		int rank = value/256;
		if((rank>=0) && (rank<=MAX_RANG-1)) {
			Iterator<SubSet> it = this.iterator();
			while(it.getValue().rank < rank) { it.goForward(); }
			if(it.getValue().rank == rank) {
			//si le rang existe, on ajoute l'ensemble set
				it.getValue().set.add(value%256);
			}else { //Sinon, on ajoute un nouveau element
				SubSet subset = new SubSet(rank, new SmallSet());
				subset.set.add(value%256);
				it.addLeft(subset);
			}
		}

	}

	/**
	 * Supprimer de this toutes les valeurs saisies par l'utilisateur et
	 * afficher le nouveau contenu (arret par lecture de -1).
	 */
	public void remove() {
		System.out.println("  valeurs a supprimer (-1 pour finir) : ");
		this.remove(System.in);
		System.out.println(" nouveau contenu :");
		this.printNewState();
	}

	/**
	 * Supprimer de this toutes les valeurs prises dans is.
	 * 
	 * @param is
	 *            flux d'entree
	 */
	public void remove(InputStream is) {
		Scanner scanner = new Scanner(is);
		int number = readValue(scanner, -1);
		while(number != -1) {
			removeNumber(number);
			number = readValue(scanner, -1);
		}
		scanner.close();
	}

	/**
	 * Supprimer value de this.
	 * 
	 * @param value
	 *            valeur a supprimer
	 */
	public void removeNumber(int value) {
		int rank = value/256;
		if((rank>=0) && (rank<=MAX_RANG-1)) {
			Iterator<SubSet> it = this.iterator();
			while(it.getValue().rank < rank) { 
				it.goForward(); 
			}
			if(it.getValue().rank == rank && it.getValue().set.contains(value%256)) {
				it.getValue().set.remove(value%256);
				if (it.getValue().set.isEmpty()) {
					it.remove();
				}
			}
		}
	}

	/**
	 * @return taille de l'ensemble this
	 */
	public int size() {
		int size = 0;
		Iterator<SubSet> it = this.iterator();
		while(!it.isOnFlag()) {
			size += it.getValue().set.size();
			it.goForward();
		}
		return size;
	}


	/**
	 * @return true si le nombre saisi par l'utilisateur appartient a this,
	 *         false sinon
	 */
	public boolean contains() {
		System.out.println(" valeur cherchee : ");
		int value = readValue(standardInput, 0);
		return this.contains(value);
	}

	/**
	 * @param value
	 *            valeur a tester
	 * @return true si valeur appartient a l'ensemble, false sinon
	 */

	public boolean contains(int value) {
		int rank = value / 256;
		if((rank>=0) && (rank<=MAX_RANG-1)) {
			Iterator<SubSet> it = this.iterator();
			while(it.getValue().rank < rank) {
				it.goForward();
			}
			return it.getValue().rank == rank && it.getValue().set.contains(value%256);
		}else {
			return false;
		}
	}

	// /////////////////////////////////////////////////////////////////////////////
	// /////// Difference, DifferenceSymetrique, Intersection, Union ///////
	// /////////////////////////////////////////////////////////////////////////////

	/**
	 * This devient la difference de this et set2.
	 * 
	 * @param set2
	 *            deuxieme ensemble
	 */
	public void difference(MySet set2) {
		Iterator<SubSet> it1 = this.iterator();
		Iterator<SubSet> it2 = set2.iterator();
		while(!it1.isOnFlag()) {
			switch(compare(it1.getValue().rank, it2.getValue().rank)) {
				case EGAL:
					it1.getValue().set.difference(it2.getValue().set);
					if(it1.getValue().set.isEmpty()) {
						it1.remove();
					}else {
						it1.goForward();
					}
					it2.goForward();
					break;
				case INF: 
					it1.goForward();
					break;
				case SUP:
					it2.goForward();
					break;
			}
		}
	}

	/**
	 * This devient la difference symetrique de this et set2.
	 * 
	 * @param set2
	 *            deuxieme ensemble
	 */
	public void symmetricDifference(MySet set2) {
		Iterator<SubSet> it1 = this.iterator();
		Iterator<SubSet> it2 = set2.iterator();
		while(!it2.isOnFlag()) {
			switch(compare(it1.getValue().rank, it2.getValue().rank)) {
				case EGAL:
					it1.getValue().set.symmetricDifference(it2.getValue().set);
					if(it1.getValue().set.isEmpty()) {
						it1.remove();
					}else {
						it1.goForward();
					}
					it2.goForward();
					break;
				case INF:
					//it1.addLeft(it2.getValue().clone());
					it1.goForward();
					break;
				case SUP:
					it1.addLeft(it2.getValue().clone());
					it2.goForward();
					break;
			}
		}
	}

	/**
	 * This devient l'intersection de this et set2.
	 * 
	 * @param set2
	 *            deuxieme ensemble
	 */
	public void intersection(MySet set2) {
		Iterator<SubSet> it1 = this.iterator();
		Iterator<SubSet> it2 = set2.iterator();
		while(!it1.isOnFlag()) {
			switch(compare(it1.getValue().rank, it2.getValue().rank)) {
				case EGAL:
					it1.getValue().set.intersection(it2.getValue().set);
					if(it1.getValue().set.isEmpty()) {
						it1.remove();
						it2.goForward();
					}else {
						it1.goForward();
						it2.goForward();
					}
					break;
				case INF: 
					it1.remove();
					break;
				case SUP:
					it2.goForward();
					break;
			}
		}
	}

	/**
	 * This devient l'union de this et set2.
	 * 
	 * @param set2
	 *            deuxieme ensemble
	 */
	public void union(MySet set2) {
		Iterator<SubSet> it1 = this.iterator();
		Iterator<SubSet> it2 = set2.iterator();
		while(!it2.isOnFlag()) {
			switch(compare(it1.getValue().rank, it2.getValue().rank)) {
				case EGAL:
					it1.getValue().set.union(it2.getValue().set);
					it1.goForward();
					it2.goForward();
					break;
				case INF: 
					it1.goForward();
					break;
				case SUP:
					it1.addLeft(it2.getValue().clone());
					it2.goForward();
					break;
			}
		}
	}

	// /////////////////////////////////////////////////////////////////////////////
	// /////////////////// Egalite, Inclusion ////////////////////
	// /////////////////////////////////////////////////////////////////////////////

	/**
	 * @param o
	 *            deuxieme ensemble
	 * 
	 * @return true si les ensembles this et o sont egaux, false sinon
	 */
	@Override
	public boolean equals(Object o) {
		boolean b = true;
		if (this == o) {
			b = true;
		} else if (o == null) {
			b = false;
		} else if (!(o instanceof MySet)) {
			b = false;
		} else {
			MySet myset2 = (MySet) o;
			Iterator<SubSet> it1 = this.iterator();
			Iterator<SubSet> it2 = myset2.iterator();
			while(!it1.isOnFlag() && b==true) {
				if(it1.getValue().rank==it2.getValue().rank) {
					//Si les elements sont identiques, faire avancer les deux
					b = it1.getValue().set.equals(it2.getValue().set);
					it1.goForward();
					it2.goForward();
				}else {
					//Si l'un des �lements est diff�rent
					b = false;
				}
			}
			//Verifier si les deux drapeaux sont identiques;
			b = b && it2.isOnFlag();

		}
		return b;
	}

	/**
	 * @param set2
	 *            deuxieme ensemble
	 * @return true si this est inclus dans set2, false sinon
	 */
	public boolean isIncludedIn(MySet set2) {
		Iterator<SubSet> it1 = this.iterator();
		Iterator<SubSet> it2 = set2.iterator();
		while(!it1.isOnFlag()) {
			switch(compare(it1.getValue().rank, it2.getValue().rank)) {
				case EGAL:
					if(!it1.getValue().set.isIncludedIn(it2.getValue().set)){
						return false;
					}
					it1.goForward();
					it2.goForward();
					break;
				case INF:
					return false;
				case SUP:
					it2.goForward();
					break;
			}
		}
		return true;
	}

	// /////////////////////////////////////////////////////////////////////////////
	// //////// Rangs, Restauration, Sauvegarde, Affichage //////////////
	// /////////////////////////////////////////////////////////////////////////////

	/**
	 * Afficher les rangs presents dans this.
	 */
	public void printRanks() {
		System.out.println(" [version corrigee de rangs]");
		this.printRanksAux();
	}

	private void printRanksAux() {
		int count = 0;
		System.out.println(" Rangs presents :");
		Iterator<SubSet> it = this.iterator();
		while (!it.isOnFlag()) {
			System.out.print("" + it.getValue().rank + "  ");
			count = count + 1;
			if (count == 10) {
				System.out.println();
				count = 0;
			}
			it.goForward();
		}
		if (count > 0) {
			System.out.println();
		}
	}

	/**
	 * Creer this a partir d'un fichier choisi par l'utilisateur contenant une
	 * sequence d'entiers positifs terminee par -1 (cf f0.ens, f1.ens, f2.ens,
	 * f3.ens et f4.ens).
	 */
	public void restore() {
		String fileName = readFileName();
		InputStream inFile;
		try {
			inFile = new FileInputStream(fileName);
			System.out.println(" [version corrigee de restauration]");
			this.clear();
			this.add(inFile);
			inFile.close();
			System.out.println(" nouveau contenu :");
			this.printNewState();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("fichier " + fileName + " inexistant");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("probleme de fermeture du fichier " + fileName);
		}
	}

	/**
	 * Sauvegarder this dans un fichier d'entiers positifs termine par -1.
	 */
	public void save() {
		System.out.println(" [version corrigee de sauvegarde]");
		OutputStream outFile;
		try {
			outFile = new FileOutputStream(readFileName());
			this.print(outFile);
			outFile.write("-1\n".getBytes());
			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("pb ouverture fichier lors de la sauvegarde");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("probleme de fermeture du fichier");
		}
	}

	/**
	 * @return l'ensemble this sous forme de chaine de caracteres.
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		int count = 0;
		SubSet subSet;
		int startValue;
		Iterator<SubSet> it = this.iterator();
		while (!it.isOnFlag()) {
			subSet = it.getValue();
			startValue = subSet.rank * 256;
			for (int i = 0; i < 256; ++i) {
				if (subSet.set.contains(i)) {
					String number = String.valueOf(startValue + i);
					int numberLength = number.length();
					for (int j = 6; j > numberLength; --j) {
						number += " ";
					}
					result.append(number);
					++count;
					if (count == 10) {
						result.append("\n");
						count = 0;
					}
				}
			}
			it.goForward();
		}
		if (count > 0) {
			result.append("\n");
		}
		return result.toString();
	}

	/**
	 * Imprimer this dans outFile.
	 * 
	 * @param outFile
	 *            flux de sortie
	 */
	private void print(OutputStream outFile) {
		try {
			String string = this.toString();
			outFile.write(string.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Afficher l'ensemble avec sa taille et les rangs presents.
	 */
	private void printNewState() {
		this.print(System.out);
		System.out.println(" Nombre d'elements : " + this.size());
		this.printRanksAux();
	}

	/**
	 * @param scanner
	 * @param min
	 *            valeur minimale possible
	 * @return l'entier lu au clavier (doit �tre entre min et 32767)
	 */
	private static int readValue(Scanner scanner, int min) {
		int value = scanner.nextInt();
		while (value < min || value > 32767) {
			System.out.println("valeur incorrecte");
			value = scanner.nextInt();
		}
		return value;
	}

	/**
	 * @return nom de fichier saisi psar l'utilisateur
	 */
	private static String readFileName() {
		System.out.print(" nom du fichier : ");
		String fileName = standardInput.next();
		return fileName;
	}
}
