package tp4;

public class ModeleMorpions implements SpecifModeleMorpions {

    private int[][] tab;
    private Etat actuel;
    private int joueur;
    private int nbCoups;

    public ModeleMorpions() {
        tab = new int[TAILLE][TAILLE];
        actuel = Etat.J1_JOUE;
        joueur = 1;
        nbCoups = 0;
    }

    @Override
    public Etat getEtatJeu() {

        if (getJoueur() == 1) {
            actuel = Etat.J1_JOUE;
        } else if (getJoueur() == 2) {
            actuel = Etat.J2_JOUE;
        } else if (getVainqueur() == 1) {
            actuel = Etat.J1_VAINQUEUR;
        } else if (getVainqueur() == 2) {
            actuel = Etat.J2_VAINQUEUR;
        } else if (getVainqueur() == 0 && estFinie()) {
            actuel = Etat.MATCH_NUL;
        }
        return actuel;
    }

    @Override
    public int getJoueur() {
         if (estFinie()) {
             return 0;
         }

        return joueur;
    }

    @Override
    public int getVainqueur() {
    	int lig = 0, col = 0, diag = 0;
        //ligne par ligne
    	for(int i=0; i<3; i++) {
			lig = tab[i][0];
			if (lig != 0 && tab[i][1] == lig && tab[i][2] == lig) {
				return lig;
			}
    	 }
    	
    	//colonne par colonne
    	for(int j=0; j<3; j++) {
			col = tab[0][j];
			if (col != 0 && tab[1][j] == col && tab[2][j] == col) {
				return col;
			}
    	 }
        
    	

		diag = tab[0][0];

		if (diag != 0 && tab[1][1] == diag && tab[2][2] == diag) {
			return diag;

		}
		

		diag = tab[0][2];
		if (diag != 0 && tab[1][1] == diag && tab[2][0] == diag) {
			return diag;
		}
    	
         return 0;
    }

    @Override
    public int getNombreCoups() {
        return nbCoups;
    }

    @Override
    public boolean estFinie() {
        if(getVainqueur()!=0 || getNombreCoups()==9) {return true;}
        return false;
    }

    @Override
    public boolean estCoupAutorise(int ligne, int colonne) {
        if (tab[ligne][colonne] == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void jouerCoup(int ligne, int colonne) {
    	if(estCoupAutorise(ligne, colonne)) {
            tab[ligne][colonne] = this.joueur;
            nbCoups++;
    	}
    	
    	joueur = (joueur == 1)?2:1;
    }

}
