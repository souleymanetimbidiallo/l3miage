package diallo.laudet.tp2;

public class Cellule {
	
	public Cellule(char solution, char proposition, String horizontal, String vertical, boolean caseNoire) {
		super();
		this.solution = solution;
		this.proposition = proposition;
		this.horizontal = horizontal;
		this.vertical = vertical;
		this.caseNoire = caseNoire;
	}
	public Cellule() {
		super();
		this.solution = ' ';
		this.proposition = ' ';
		this.horizontal = "";
		this.vertical = "";
		this.caseNoire = false;
	}
	
	private char solution;
	private char proposition;
	private String horizontal;
	private String vertical;
	private boolean caseNoire;
	

	/**
	 * GETTERS et SETTERS 
	 */
	public char getSolution() {
		return solution;
	}
	public void setSolution(char solution) {
		this.solution = solution;
	}
	public char getProposition() {
		return proposition;
	}
	public void setProposition(char proposition) {
		this.proposition = proposition;
	}
	public String getHorizontal() {
		return horizontal;
	}
	public void setHorizontal(String horizontal) {
		this.horizontal = horizontal;
	}
	public String getVertical() {
		return vertical;
	}
	public void setVertical(String vertical) {
		this.vertical = vertical;
	}
	public boolean isCaseNoire() {
		return caseNoire;
	}
	public void setCaseNoire(boolean caseNoire) {
		this.caseNoire = caseNoire;
	}
	
}
