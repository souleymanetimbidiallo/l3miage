package diallo.laudet.tp1;

public class Main {

	public static void main(String[] args) {
		Grille maGrille = new Grille(5,5);
		for (int l=1; l<=maGrille.getHauteur(); l++){
			String texteLigne = Integer.toString(l);
			for (int c=1; c<=maGrille.getLargeur(); c++){
				maGrille.setCellule(l, c, texteLigne + ',' + Integer.toString(c));
				}
			}
		System.out.println(maGrille) ;
	}

}
