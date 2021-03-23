package diallo.laudet.tp5.v2;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import diallo.laudet.tp5.modele.ModeleMorpionFX;

public class ControleurV2 {

	private ModeleMorpionFX modele;

	@FXML
	private GridPane grille;

	@FXML
	private Label labelNbCoups;

	@FXML
	private Label labelEtatJeu;
	
	@FXML
	private Label labelJoueur;


	@FXML
	private void initialize() {
		this.modele = new ModeleMorpionFX();

		recalculerLabelEtatJeu();
		//modele.setSymboleJoueurCourant(modele.symboleJoueur(modele.getJoueur()));
		for (Node n : grille.getChildren()) {
			n.setOnMouseClicked(e -> this.clicBouton(e));
		}

		modele.nbCoupsProperty().addListener(
				(obsValue, oldValue, newValue) 
				-> 
				majNbCoups(newValue.intValue())
		);
		
	}

	private void majNbCoups(int nb) {
		if (nb == 0) {
			labelNbCoups.setText("aucun coup jou�");
		} else {
			String ch;
			if (nb == 1)
				ch = " coup jou�";
			else
				ch = " coups jou�s";
			labelNbCoups.setText(Integer.toString(nb) + ch);
		}
	}

	private void clicBouton(MouseEvent e) {
		Node n = (Node) e.getSource();
		Integer ligne = ((Integer) n.getProperties().get("gridpane-row")) + 1;
		Integer colonne = ((Integer) n.getProperties().get("gridpane-column")) + 1;

		modele.jouerCoup(ligne, colonne);

		recalculerLabelEtatJeu();
		System.out.println("Coup jou� : (" + ligne + "," + colonne + ")");
		System.out.println("r�sultat: " + modele.getEtatJeu());
	}

	private void recalculerLabelEtatJeu() {
		switch (modele.getEtatJeu()) {
		case J1_JOUE:
			labelEtatJeu.setText("C'est au tour du joueur 1");
			break;

		case J2_JOUE:
			labelEtatJeu.setText("C'est au tour du joueur 2");
			break;

		case J1_VAINQUEUR:
			labelEtatJeu.setText("Le gagnant est le joueur 1");
			break;

		case J2_VAINQUEUR:
			labelEtatJeu.setText("Le gagnant est le joueur 2");
			break;
		default:
			break;
		}
	}
	
	
	

}
