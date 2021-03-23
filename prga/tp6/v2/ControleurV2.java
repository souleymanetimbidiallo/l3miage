package diallo.laudet.tp6.v2;

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

public class ControleurV2 {

	private MotsCroisesTP6 modele;

	@FXML
	private GridPane grille;

	@FXML
	private void initialize() throws SQLException {
		ChargerGrille cg = new ChargerGrille();
		// this.modele = cg.extraireGrille(1);
		this.modele = cg.extraireGrille(10);
		creerGrille();
		for (Node n : grille.getChildren()) {

			// Initialisation du TextField tf ayant pour coordonn�es (lig, col)
			if (n instanceof TextField) {
				TextField tf = (TextField) n;
				int lig = ((int) n.getProperties().get("gridpane-row")) + 1;
				int col = ((int) n.getProperties().get("gridpane-column")) + 1;
				tf.textProperty().bindBidirectional(modele.propositionProperty(lig, col));

				String texte = "";
				if (modele.getDefinition(lig, col, true) != null && modele.getDefinition(lig, col, false) != null) {
					texte += modele.getDefinition(lig, col, true);
					texte += "/" + modele.getDefinition(lig, col, false);
				} else if (modele.getDefinition(lig, col, true) != null) {
					texte += modele.getDefinition(lig, col, true);
				} else if (modele.getDefinition(lig, col, false) != null) {
					texte += modele.getDefinition(lig, col, false);
				}
				tf.setTooltip(new Tooltip(texte));

				tf.setOnMouseClicked((e) -> {
					this.clicCase(e);
				});

			}
		}
	}

	@FXML
	public void clicCase(MouseEvent e) {
		if (e.getButton() == MouseButton.PRIMARY) {
			// C'est un clic "central"
			TextField cellule = (TextField) e.getSource();
			int lig = ((int) cellule.getProperties().get("gridpane-row")) + 1;
			int col = ((int) cellule.getProperties().get("gridpane-column")) + 1;

			cellule.textProperty().bindBidirectional(modele.propositionProperty(lig, col));
			// demande de r�v�lation de la solution sur (lig,col)}}
			modele.reveler(lig, col);
		}
	}

	/**
	 * R�creer une grille pour le jeu.
	 */
	private void creerGrille() {
		TextField tf0 = (TextField) grille.getChildren().get(0);
		grille.getChildren().clear();

		for (int i = 1; i <= modele.getHauteur(); i++) {
			for (int j = 1; j <= modele.getLargeur(); j++) {
				TextField tf = new TextField();
				tf.setPrefWidth(tf0.getPrefWidth());
				tf.setPrefHeight(tf0.getPrefHeight());
				for (Object cle : tf0.getProperties().keySet()) {
					tf.getProperties().put(cle, tf0.getProperties().get(cle));
				}
				grille.add(tf, j - 1, i - 1);
			}
		}
	}
}
