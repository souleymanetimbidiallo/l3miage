package fr.istic.prg1.tp3;

/**
 * 
 * @author Mickaël Foursov <foursov@univ-rennes1.fr>
 * @version 5.0
 * @since 2015-11-10
 * 
 *        Classe représentant des doublets non modifiables
 */

public class Pair implements Comparable<Pair> {

	private int x;
	private int y;
	
	public Pair() {
		this.x = 0;
		this.y = 0;
	}
	/**
	 * Constructeur avec parametres
	 */
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * GETTERS 	&& SETTERS
	 */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	/**
	 * Compare deux doublets (Pair)
	 * @return 0 si les doublets sont identiques
	 * 		  -1 si le premier doublet est inferieur au second doublet
	 * 		   1 si le premier doublet est superieur au second doublet
	 */
	@Override
	public int compareTo(Pair d) {
		if(this.equals(d)) {
			return 0;
		}else if (this.less(d)) {
			return -1;
		}else {
			return 1;
		}
	}
	
	/**
	 * Retourne le clone d'un doublet
	 */
	@Override
	public Pair clone() {
	    return new Pair(this.x, this.y);
	}

	/**
	 * @return la description d'un doublet (Pair)
	 */
	@Override
	public String toString() {
	    return "("+this.x+","+this.y+")";
	}

	/**
	 * @return true si les doublets sont identiques non nuls 
	 * 		   false sinon.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}else if (obj == null) {
			return false;
		}else if (!(obj instanceof Pair)) {
			return false;
		}else {
			Pair p = (Pair) obj;
			return (this.x == p.x) && (this.y == p.y);
		}
	}
	
	/**
	 * @param p
	 * @return true si le premier doublet est plus petit que le second, false sinon.
	 */
	public boolean less(Pair p) {
		if(this.x < p.x) {
			return true;
		}else if((this.x == p.x) && (this.y < p.y)) {
			return true;
		}else {
			return false;
		}
	}
}