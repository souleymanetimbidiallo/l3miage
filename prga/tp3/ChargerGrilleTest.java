package diallo.laudet.tp3;

import java.sql.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Test de chargement de grille
 */

class ChargerGrilleTest {
	@Test
	void test() throws SQLException {
		String solution = "ARCHERDOUANEJUIN*BONT*VOID*GINN*RENDTIFOSI";
		ChargerGrille chargerGrille = new ChargerGrille();
		MotsCroises mots = chargerGrille.extraireGrille(10);
		String reponse = "";
		for (int i = 1; i < mots.getHauteur()+1; i++) {
			for (int j = 1; j < mots.getLargeur()+1; j++) {
				char c = mots.getSolution(i, j);
				reponse += String.valueOf(c);
			}
		}
		assertEquals(solution,reponse);
	}

}
