package diallo.laudet.tp6.v1;

import java.sql.SQLException;

import diallo.laudet.tp6.modele.ChargerGrille;
import diallo.laudet.tp6.modele.MotsCroisesFactory;
import diallo.laudet.tp6.modele.MotsCroisesTP6;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ControleurV1 {

	private MotsCroisesTP6 modele;

	@FXML
	private GridPane grille;

	@FXML
	private void initialize() throws SQLException {
		this.modele = MotsCroisesFactory.creerMotsCroises2x3();
		
		for (Node n : grille.getChildren()) {

			// Initialisation du TextField tf ayant pour coordonn�es (lig, col)
			if (n instanceof TextField) {
				TextField tf = (TextField) n;
				int lig = ((int) n.getProperties().get("gridpane-row")) + 1;
				int col = ((int) n.getProperties().get("gridpane-column")) + 1;
				
				//Saisie des propositions
				tf.textProperty().bindBidirectional(modele.propositionProperty(lig, col));
				
				//Affichage des infobulles
				String texte = getTooltip(lig, col);
				tf.setTooltip(new Tooltip(texte));
				
				//Revelation d'une solution sur demande
				tf.setOnMouseClicked((e) -> {this.clicCase(e);});
				
				
			}
		}
	}
	
	/**
	 * Recup�re la chaine correspondant � la d�finition d'une case de grille
	 * @param lig
	 * @param col
	 * @return
	 */
	private String getTooltip(int lig, int col) {
		String texte = "";
		if (modele.getDefinition(lig, col, true) != null && modele.getDefinition(lig, col, false) != null) {
			texte += modele.getDefinition(lig, col, true);
			texte += "/" + modele.getDefinition(lig, col, false);
		} else if (modele.getDefinition(lig, col, true) != null) {
			texte += modele.getDefinition(lig, col, true);
		}else if (modele.getDefinition(lig, col, false) != null) {
			texte += modele.getDefinition(lig, col, false);
		}else {
			texte = null;
		}
		
		return texte;
	}

	/**
	 * R�velation de la solution a l'aide d'un clic de souris
	 * @param e, Evenement lie au clic de la souris
	 */
	@FXML
	public void clicCase(MouseEvent e) {
		if (e.getButton() == MouseButton.PRIMARY) { // C'est un clic "central"
			TextField cellule = (TextField) e.getSource();
			int lig = ((int) cellule.getProperties().get("gridpane-row")) + 1;
			int col = ((int) cellule.getProperties().get("gridpane-column")) + 1;

			cellule.textProperty().bindBidirectional(modele.propositionProperty(lig, col));
			
			modele.reveler(lig, col);// demande de r�v�lation de la solution sur (lig,col)}}
		}
	}
}
