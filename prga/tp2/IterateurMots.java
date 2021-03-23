package diallo.laudet.tp2;

import java.util.Iterator;

public class IterateurMots implements Iterator<String> {
	
	private Object tab[];
	private int cursor;
	/**
	 * Contructeur de la classe
	 * @param array
	 */
	public IterateurMots(Object[] array) {
		tab = new Object[array.length];
		for (int i = 0; i < array.length; i++) {
			tab[i] = array[i];
		}
		int i=0;
		while(i<tab.length && tab[i]==null) { i++; }
		cursor = (i==tab.length)?i+1:i;
	}
	
	@Override
	/*
	 * @return true s'il y a un élément suivant, 
	 * 		   false sinon.
	 * 
	 */
	public boolean hasNext() {
		return cursor < tab.length;
	}

	@Override
	public String next() {
		String res= "";
		if(tab[cursor]!=null) {
			res += tab[cursor];
			res += " - ";
		}
		cursor++;
		return res;
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
