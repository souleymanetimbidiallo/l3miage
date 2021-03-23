package diallo.laudet.tp2;

public class Grille<Type> {
	private int hauteur; //Nombre de lignes
	private int largeur; //Nombre de colonnes
	private Type tab[][];  //tableau générique à deux dimensions, avec taille = hauteur x largeur
	
	/**
	 * Constructeur permettant d’obtenir une grillesDisponibles
	 * dotée d’un tableau de dimensions conformes aux valeurs
	 * respectives de hauteur et de largeur, dont tous les
	 * éléments contiennent la valeur null.
	 */
	public Grille(int hauteur, int largeur) {
		assert (hauteur >= 0 && largeur >= 0);
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.tab = (Type[][]) new Object[hauteur][largeur];
	}
	
	/* Accesseurs (getters) */
	public int getHauteur() {
		return hauteur;
	}
	public int getLargeur() {
		return largeur;
	}

	/**
	 * Validité des coordonnées
	 * Resultat : vrai si et seulement si lig (resp. col)
	 * est compris entre 1 et getHauteur() (resp. getlargeur()) 
	 */
	public boolean coordCorrectes(int lig, int col) {
		return (lig >= 1 && lig <= getHauteur())&&(col >= 1 && col <= getLargeur());
	}

	/**
	 * Valeur de la cellule ayant pour coordonnées (lig, col)
	 */
	public Type getCellule(int lig, int col) {
		assert coordCorrectes(lig, col);
		return tab[lig-1][col-1];
	}

	/**
	 * Modification de la cellule de coordonnées (lig, col)
	 */
	public void setCellule(int lig, int col, Type ch) {
		assert coordCorrectes(lig, col);
		tab[lig-1][col-1] = ch;
	}
	
	/**
	 * Retourne un itérateur sur la ligne ou la colonne spécifiée par ses paramètres.
	 */
	public IterateurMots iterateurMots(boolean horizontal, int num) {
		int param = (horizontal) ? tab[num-1] : columnTab(num-1);
		return new IterateurMots(param);
	}
	
	public Type[] columnTab(int col) {
		Type[] column = (Type[]) new Object[getHauteur()];
		for(int i=0; i<getHauteur(); i++) {
			for(int j=1; j<=getLargeur(); j++) {
				column[i] = getCellule(i+1, col+1);
			}
		}
		return column;
		
	}
	
	/**
	 * Texte sur “hauteur” lignes, colonnes séparées par des |
	 */
	@Override
	public String toString() {
		String result = "";
		for(int i = 1; i <= getHauteur(); i++) {
			for(int j = 1; j <= getLargeur(); j++) {
				if(j==getLargeur()) {
					result += i+","+j;
				}
				else {
				result += i+","+j+"|";
				}
			}
			result += "\n";
		}
		return result;
	}
}
