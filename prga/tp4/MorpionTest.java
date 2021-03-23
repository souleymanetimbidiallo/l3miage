package tp4.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import morpions.kit.test.*;
import morpions.kit.test.SpecifModeleMorpions.Etat;
import tp4.ModeleMorpions;
import tp4.SpecifModeleMorpions;

public class MorpionTest
{
	SpecifModeleMorpions morpions ;
	public static final int TAILLE = 3 ;
	public static final int NB_CASES = 9 ;


	@BeforeEach
	public void setUp() throws Exception
	{
		// morpions = new MorpionsReference() ;
		// morpions = new Bogue1() ;
		// morpions = new Bogue2() ;
		// morpions = new Bogue3() ;
		// morpions = new Bogue4() ;
		// morpions = new Bogue5() ;
		morpions = new ModeleMorpions() ;
	}

	
	// Scénario(s) vérifiant l'état du jeu avant le premier coup :
	// * non-fin de partie
	// * cases accessibles
	@Test
	public void testInit()
	{
		// Test de l'invariant de la classe
		testInvariant() ;
	}

	// Scénario vérifiant le premier coup joué, notamment :
	// * position correcte ou non
	// * non-fin de partie
	// * identité du premier joueur
	@Test
	public void testPremierCoup()
	{
		morpions.jouerCoup(1, 1) ;
		assertTrue(! morpions.estFinie(), "Partie pas finie après premier coup") ;
		// ----------------------
		// SÉQUENCE 2 À COMPLÉTER
		// ----------------------

		// On reteste l'invariant
		testInvariant() ;
	}

	// Scénario tentant divers coups non autorisés,
	// avec vérification systématique de estCoupAutorise()
	@Test
	public void testControleCoup(){

	}

	private void testInvariant()
	{
		// Le nombre de coups est positif ou nul, et inférieur ou égal au nombre de cases
		assertTrue(morpions.getNombreCoups() >= 0, "Nombre de coups >= 0") ;
		assertTrue(morpions.getNombreCoups() <= NB_CASES,
				"Nombre de coups <= " + NB_CASES) ;
		// ----------------------
		// SÉQUENCE 3 À COMPLÉTER
		// ----------------------
	}
	@Test
	public void testCoupDejaJoue()
	{
		morpions.jouerCoup(1, 1);
		assertTrue(!morpions.estCoupAutorise(1,1), "La case (1,1) ne peut être jouée") ;
	}

	// Scénario explorant les situations de non-fin de partie,
	// avec vérification systématique de estFinie() == false
	@Test
	public void testPartiePasFinie()
	{
		morpions.jouerCoup(1, 1);
		morpions.jouerCoup(2, 2);
		// ----------------------
		// SÉQUENCE 4 À COMPLÉTER
		// ----------------------
		assertTrue(!morpions.estFinie(), "Partie pas finie encore");
	}

	@Test
	public void testJoueur1gagnant()
	{

		morpions.jouerCoup(0, 0);
		morpions.jouerCoup(2, 0);
		morpions.jouerCoup(0, 1);
		morpions.jouerCoup(2, 1);
		morpions.jouerCoup(0, 2);

		assertTrue(morpions.estFinie(), "Partie pas finie encore");
	}
	
	@Test
	public void testJoueur1gagnantDiag()
	{

		morpions.jouerCoup(0, 0);
		morpions.jouerCoup(2, 0);
		morpions.jouerCoup(1, 1);
		morpions.jouerCoup(1, 2);
		morpions.jouerCoup(2, 2);

		assertTrue(morpions.estFinie(), "Partie pas finie encore");
	}
	
	@Test
	public void testJoueur2gagnantBis()
	{

		morpions.jouerCoup(0, 0);
		morpions.jouerCoup(2, 0);
		morpions.jouerCoup(0, 1);
		morpions.jouerCoup(2, 1);
		morpions.jouerCoup(1, 0);
		morpions.jouerCoup(2, 2);
		System.out.println(morpions.getVainqueur());

		assertTrue(morpions.estFinie(), "Partie pas finie encore");
	}
	
	
	@Test
	public void testJoueur2gagnant()
	{

		morpions.jouerCoup(0, 0);
		morpions.jouerCoup(0, 1);
		morpions.jouerCoup(1, 2);
		morpions.jouerCoup(1, 1);
		morpions.jouerCoup(2, 0);
		morpions.jouerCoup(2, 1);
		System.out.println(morpions.getVainqueur());

		assertTrue(morpions.estFinie(), "Partie pas finie encore");
	}
	
	@Test
	public void testNombreDeCoup1() {

		morpions.jouerCoup(0, 0);
		morpions.jouerCoup(2, 0);
		morpions.jouerCoup(0, 1);
		morpions.jouerCoup(2, 1);
		morpions.jouerCoup(0, 2);
		morpions.jouerCoup(2, 2);
		
		assertEquals(morpions.getNombreCoups(), 6);
	}
	
	@Test
	public void testEtatJeu() {

		morpions.jouerCoup(0, 0);
		morpions.jouerCoup(2, 0);
		morpions.jouerCoup(2, 0);
		morpions.jouerCoup(2, 2);
		//System.out.println(morpions.getEtatJeu());
		
		assertEquals(morpions.getEtatJeu(), Etat.J2_JOUE);
	}

	// Scénarios explorant les situations de fin de partie,
	// avec vérification systématique de estFinie() et de
	// getVainqueur() :
	// * alignement horizontal (grille pleine ou non)
	// * alignement vertical (grille pleine ou non)
	// * alignement diagonal (grille pleine ou non)
	// et ainsi de suite...
	@Test
	public void testJeuFini() {
		morpions.jouerCoup(0, 0);		
		morpions.jouerCoup(2, 0);
		morpions.jouerCoup(0, 1);		
		morpions.jouerCoup(2, 1);
		morpions.jouerCoup(0, 2);		
		morpions.jouerCoup(2, 2);
		System.out.println(morpions.getEtatJeu());

		assertTrue(morpions.estFinie(), "Le jeu n'est pas fini");
	}
	
	// ------------------------------
	// SÉQUENCE À COMPLÉTER
	// avec d'autres méthodes de test
	// (une méthode par scénario)
	// ------------------------------
}
