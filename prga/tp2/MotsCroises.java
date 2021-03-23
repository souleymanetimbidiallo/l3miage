package diallo.laudet.tp2;

public class MotsCroises {

	private Grille<Character> solution;
	private Grille<Character> proposition;
	private Grille<String> horizontal;
	private Grille<String> vertical;

	/**
	 * Constructeur créant une instance de MotsCroises
	 * dotée de 4 instances de Grille, suivant les
	 * spécifications données.
	 */
	public MotsCroises(int hauteur, int largeur) {
		solution = new Grille<Character>(hauteur, largeur);
		proposition = new Grille<Character>(hauteur, largeur);
		horizontal = new Grille<String>(hauteur, largeur);
		vertical = new Grille<String>(hauteur, largeur);
	}

	/**
	 * Nombre de rangées
	 */
	public int getHauteur() {
		return solution.getHauteur();
	}

	/**
	 * Nombre de colonnes
	 */
	public int getLargeur() {
		return solution.getLargeur();
	}

	/**
	 * Validité des coordonnées
	 * Resultat : vrai si et seulement si (lig, col)
	 * désignent une cellule existante de la grille
	 */
	public boolean coordCorrectes(int lig, int col) {
		return solution.coordCorrectes(lig, col);
	}

	/**
	 * Accesseurs aux cases noires
	 */
	public boolean estCaseNoire(int lig, int col) {
		assert coordCorrectes(lig, col);
		return solution.getCellule(lig, col)==null;
	}
	public void setCaseNoire(int lig, int col, boolean noire) {
		assert coordCorrectes(lig, col);
		if(noire) {
			solution.setCellule(lig, col, null);
		}else {
			solution.setCellule(lig, col, ' ');
		}
	}

	/**
	 * Accesseurs à la grille de solution
	 */
	public Character getSolution(int lig, int col) {
		assert (coordCorrectes(lig, col) && !estCaseNoire(lig, col));
		return solution.getCellule(lig, col);
	}
	public void setSolution(int lig, int col, Character sol) {
		solution.setCellule(lig, col, sol);
	}

	/**
	 * Accesseurs à la grille du joueur
	 */
	public Character getProposition(int lig, int col) {
		assert (coordCorrectes(lig, col) && !estCaseNoire(lig, col));
		return proposition.getCellule(lig, col);
	}
	public void setProposition(int lig, int col, char sol) {
		proposition.setCellule(lig, col, sol);
	}

	/**
	 * Accesseurs aux définitions.
	 * Le paramètre "horiz" est "true" pour les définitions
	 * horizontales, "false" pour les définitions verticales.
	 */
	public String getDefinition(int lig, int col, boolean horiz) {
		assert (coordCorrectes(lig, col) && !estCaseNoire(lig, col));
		if(horiz) {
			return horizontal.getCellule(lig, col);
		}
		else {
			return vertical.getCellule(lig, col);
		}		
	}
	public void setDefinition(int lig, int col, boolean horiz, String def) {
		assert (coordCorrectes(lig, col) && !estCaseNoire(lig, col));
		if(horiz) {
			horizontal.setCellule(lig, col, def);
		}
		else {
			vertical.setCellule(lig, col, def);
		}
	}

	/**
	 * Affichage des grilles de mots croises
	 */
	@Override
	public String toString() {
		return solutions();
	}

	/**
	 * Affichage des solutions de mots croises
	 */
	public String solutions() {
		String str = "";
		for(int lig=1; lig<=getHauteur(); lig++) {
			for(int col=1; col<=getLargeur(); col++) {
				str += solution.getCellule(lig, col);
			}
		}
		return str;
	}
}
