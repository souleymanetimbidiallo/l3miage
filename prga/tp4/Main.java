package tp4;

public class Main {

	public static void main(String[] args) {
		ModeleMorpions mm = new ModeleMorpions();

		System.out.println("Etat du jeu: "+mm.getEtatJeu());
		System.out.println("Joueur "+mm.getJoueur());
		mm.jouerCoup(0, 0);
		System.out.println("Etat du jeu: "+mm.getEtatJeu());
		System.out.println("Joueur "+mm.getJoueur());
		mm.jouerCoup(0, 2);
		System.out.println("Etat du jeu: "+mm.getEtatJeu());
		System.out.println("Joueur "+mm.getJoueur());

		System.out.println(mm.estCoupAutorise(0, 1));

		mm.jouerCoup(0, 1);

		System.out.println("Nombre de coups "+mm.getNombreCoups());
		System.out.println("Etat du jeu: "+mm.getEtatJeu());
		System.out.println("Fini: "+mm.estFinie());
		System.out.println("Vainqueur: "+mm.getVainqueur());
		
	}
	

}
