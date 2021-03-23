package diallo.laudet.tp3;

import java.sql.*;
import java.util.*;

public class ChargerGrille {
	private Connection connexion;
	public ChargerGrille() {
		try {
			connexion = connecterBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection connecterBD() throws SQLException {
		Connection connect;
		connect = DriverManager.getConnection("jdbc:mysql://localhost/base_bousse", "root", "");
		return connect;
	}

	/**
	 * Chaque grille est decrite par la concatenation des valeurs
	 * 
	 * @return la liste des grilles disponibles dans la B.D.
	 * @throws SQLException
	 */
	public Map<Integer, String> grillesDisponibles() throws SQLException {
		Map<Integer, String> grilles = new HashMap<Integer, String>();
		Statement stmt = connecterBD().createStatement();
		ResultSet rs = stmt.executeQuery("select * from tp5_grille");
		while (rs.next()) {
			String desc = rs.getString("nom_grille") + " ";
			desc += rs.getString("hauteur") + "x";
			desc += rs.getString("largeur");
			Integer id = rs.getInt("num_grille");
			grilles.put(id, desc);
		}
		return grilles;
	}
	
	
	/**
	 * Récuperer une instance de mots croises à partir d'une grille de la base de données
	 * @param numGrille
	 * @return une instance de mots croisés
	 * @throws SQLException
	 */

	public MotsCroisesTP6 extraireGrille(int numGrille) throws SQLException {
		MotsCroisesTP6 mc = null;
		// Récupère les données utiles de grille.
		String query = "select hauteur, largeur from tp5_grille where num_grille=?";
		PreparedStatement ps = connecterBD().prepareStatement(query);
		ps.setInt(1, numGrille);
		ResultSet res_grille = ps.executeQuery();
		int hauteur = 0, largeur = 0;
		if (res_grille.next()) {
			hauteur = res_grille.getInt("hauteur");
			largeur = res_grille.getInt("largeur");
		}
		
		// Mettre à jour les mots croises.
		mc = new MotsCroisesTP6(hauteur, largeur);
		query = "select * from tp5_mot where num_grille = ?";
		ps = connecterBD().prepareStatement(query);
		ps.setInt(1, numGrille);
		ResultSet res_mot = ps.executeQuery();
		while (res_mot.next()) {
			boolean horizontal = (res_mot.getInt("horizontal") == 1);
			int ligne = res_mot.getInt("ligne");
			int colonne = res_mot.getInt("colonne");
			String solution = res_mot.getString("solution");
			mc.setDefinition(ligne, colonne, horizontal, res_mot.getString("definition"));
			
			//Récuperer les solutions de manière horizontale ou verticale:
			if (horizontal) {
				for (int i = 0; i < solution.length(); i++) {
					mc.setSolution(ligne, colonne + i, solution.charAt(i));
				}
			} else {
				for (int i = 0; i < solution.length(); i++) {
					mc.setSolution(ligne + i, colonne, solution.charAt(i));
				}
			}
		}
		return mc;
	}

}