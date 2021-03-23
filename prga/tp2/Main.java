package diallo.laudet.tp2;

public class Main {

	public static void main(String[] args) {
		Grille<String> maGrille = new Grille<String>(5,5);
		for (int l=1; l<=maGrille.getHauteur(); l++){
			String texteLigne = Integer.toString(l);
			for (int c=1; c<=maGrille.getLargeur(); c++){
				maGrille.setCellule(l, c, texteLigne + ',' + Integer.toString(c));
				}
			}
		System.out.println(maGrille) ;
		

		System.out.println("--------------");
		System.out.print("La ligne 3 de la grille générique: [");
		IterateurMots it1 = maGrille.iterateurMots(true, 3);
		while(it1.hasNext()) {
			System.out.print(it1.next());
		}
		System.out.println("]");
		System.out.print("La colonne 5 de la grille générique: [");
		IterateurMots it2 = maGrille.iterateurMots(false, 3);
		while(it2.hasNext()) {
			System.out.print(it2.next());
		}
		System.out.println("]");
		
		
		System.out.println("\n--------------");
		
		Character[] tab = new Character[8];
		tab[0]=null;
		tab[1]='A';
		tab[2]='B';
		tab[3]=null;
		tab[4]=null;
		tab[5]='C';
		tab[6]='D';
		tab[7]=null;
		IterateurMots it3 = new IterateurMots(tab);
		while(it3.hasNext()) {
			System.out.print(it3.next());
		}
		
		MotsCroises mc = new MotsCroises(5, 5);
		
		mc.setSolution(1, 1, 'A');
		System.out.println(mc);
	}

}
