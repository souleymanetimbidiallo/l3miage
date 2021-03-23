package diallo.laudet.tp2;

public class MotsCroisesAvecHeritage extends Grille<Cellule>{

	/**
	 * Constructeur créant une instance de MotsCroises
	 * dotée d'une plusieurs cellules contenant chacun 4 infos sur la grille
	 */
	public MotsCroisesAvecHeritage(int hauteur, int largeur) {
		super(hauteur, largeur);
		
		for(int i = 1; i <= getHauteur(); i++) {
			for(int j = 1; j <= getLargeur(); j++) {
				this.setCellule(i, j, new Cellule());
			}
		}
	}

	/**
	 * Nombre de rangées
	 */
	public int getHauteur() {
		return super.getHauteur();
	}

	/**
	 * Nombre de colonnes
	 */
	public int getLargeur() {
		return super.getLargeur();
	}

	/**
	 * Validité des coordonnées
	 * Resultat : vrai si et seulement si (lig, col)
	 * désignent une cellule existante de la grille
	 */
	public boolean coordCorrectes(int lig, int col) {
		return super.coordCorrectes(lig, col);
	}

	/**
	 * Accesseurs aux cases noires
	 */
	public boolean estCaseNoire(int lig, int col) {
		assert coordCorrectes(lig, col);
		return super.getCellule(lig, col).isCaseNoire();
	}
	public void setCaseNoire(int lig, int col, boolean noire) {
		super.getCellule(lig, col).setCaseNoire(noire);
	}

	/**
	 * Accesseurs à la grille de solution
	 */
	public char getSolution(int lig, int col) {
		assert (coordCorrectes(lig, col) && !estCaseNoire(lig, col));
		return super.getCellule(lig, col).getSolution();
	}
	public void setSolution(int lig, int col, char sol) {
		super.getCellule(lig, col).setSolution(sol);
	}

	/**
	 * Accesseurs à la grille du joueur
	 */
	public char getProposition(int lig, int col) {
		assert (coordCorrectes(lig, col) && !estCaseNoire(lig, col));
		return super.getCellule(lig, col).getProposition();
	}
	public void setProposition(int lig, int col, char sol) {
		super.getCellule(lig, col).setProposition(sol);
	}

	/**
	 * Accesseurs aux définitions.
	 * Le paramètre "horiz" est "true" pour les définitions
	 * horizontales, "false" pour les définitions verticales.
	 */
	public String getDefinition(int lig, int col, boolean horiz) {
		assert (coordCorrectes(lig, col) && !estCaseNoire(lig, col));
		if(horiz) {
			return super.getCellule(lig, col).getHorizontal();
		}
		else {
			return super.getCellule(lig, col).getVertical();
		}		
	}
	public void setDefinition(int lig, int col, boolean horiz, String def) {
		assert (coordCorrectes(lig, col) && !estCaseNoire(lig, col));
		if(horiz) {
			super.getCellule(lig, col).setHorizontal(def);
		}
		else {
			super.getCellule(lig, col).setVertical(def);
		}
	}
}
