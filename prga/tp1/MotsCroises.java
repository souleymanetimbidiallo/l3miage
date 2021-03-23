package diallo.laudet.tp1;

public class MotsCroises {
	private Grille solution;
	private Grille proposition;
	private Grille horizontal;
	private Grille vertical;
	
	/**
	 * Constructeur créant une instance de MotsCroises
	 * dotée de 4 instances de Grille, suivant les
	 * spécifications données.
	 */
	public MotsCroises(int hauteur, int largeur) {
		solution = new Grille(hauteur, largeur);
		proposition = new Grille(hauteur, largeur);
		horizontal = new Grille(hauteur, largeur);
		vertical = new Grille(hauteur, largeur);
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
			solution.setCellule(lig, col, "");
		}
	}

	/**
	 * Accesseurs à la grille de solution
	 */
	public char getSolution(int lig, int col) {
		assert (coordCorrectes(lig, col) && !estCaseNoire(lig, col));
		return solution.getCellule(lig, col).charAt(0);
	}
	public void setSolution(int lig, int col, char sol) {
		String str = Character.toString(sol);
		solution.setCellule(lig, col, str);
	}
	
	/**
	 * Accesseurs à la grille du joueur
	 */
	public char getProposition(int lig, int col) {
		assert (coordCorrectes(lig, col) && !estCaseNoire(lig, col));
		return proposition.getCellule(lig, col).charAt(0);
	}
	public void setProposition(int lig, int col, char sol) {
		String str = Character.toString(sol);
		proposition.setCellule(lig, col, str);
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
}
