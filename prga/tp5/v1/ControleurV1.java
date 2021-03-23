package diallo.laudet.tp5.v1;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import diallo.laudet.tp5.modele.ModeleMorpionFX;

public class ControleurV1 {

	private ModeleMorpionFX modele;

	@FXML
	private GridPane grille;

	@FXML
	private void initialize() {
		this.modele = new ModeleMorpionFX();
		for (Node n : grille.getChildren()) {
			n.setOnMouseClicked(e -> this.clicBouton(e));
		}
	}

	private void clicBouton(MouseEvent e) {
		Node n = (Node) e.getSource();
		Integer ligne = ((Integer) n.getProperties().get("gridpane-row")) + 1;
		Integer colonne = ((Integer) n.getProperties().get("gridpane-column")) + 1;
		modele.jouerCoup(ligne, colonne);
		System.out.println("Coup joué : " + ligne + "/" + colonne);
		System.out.println("résultat: " + modele.getEtatJeu());
		
	}

}
