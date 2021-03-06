package diallo.laudet.tp6.v4;

import java.sql.SQLException;

import diallo.laudet.tp6.modele.ChargerGrille;
import diallo.laudet.tp6.modele.MotsCroisesTP6;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class ControllerV4 {

	private MotsCroisesTP6 model;

	@FXML
	private GridPane crosswords;


	private KeyCode dir;

	// Reference to the main application.
	private MainApp mainApp;

	public ControllerV4(int gridNumber) throws SQLException {
		ChargerGrille cg = new ChargerGrille();
		model = cg.extraireGrille(gridNumber);
		dir = KeyCode.RIGHT;
	}

	/**
	 * Initialisation de la vue du jeu
	 * @throws SQLException
	 */
	@FXML
	private void initialize() throws SQLException {
		// G�n�rer une grille initiale
		createGridPane();
		fillCrosswords(crosswords);
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	
	/**
	 * Cr�er une grille � l'aide d'un num�ro pr�sent dans la base de donn�es
	 * 
	 * @param num, num�ro de la grille
	 * @throws SQLException
	 */
	public void createGridPane() throws SQLException {
		TextField tf0 = (TextField) crosswords.getChildren().get(0);
		crosswords.getChildren().clear();
		for (int i = 1; i <= model.getHauteur(); i++) {
			for (int j = 1; j <= model.getLargeur(); j++) {
				TextField tf = new TextField();
				tf.setPrefWidth(tf0.getPrefWidth());
				tf.setPrefHeight(tf0.getPrefHeight());
				for (Object cle : tf0.getProperties().keySet()) {
					tf.getProperties().put(cle, tf0.getProperties().get(cle));
				}
				tf.setText("");
				if (model.estCaseNoire(i, j)) {

					tf.getStyleClass().add("custom-black-cell");
					tf.setDisable(true);
				}
				crosswords.add(tf, j - 1, i - 1);

			}
		}
	}
	
	
	/**
	 * Manipulation de la grille de mots crois�s et gestion d'un champ de texte
	 * @param crosswords
	 */
	private void fillCrosswords(GridPane crosswords) {
		for (Node n : crosswords.getChildren()) {
			// Initialisation du TextField tf ayant pour coordonn�es (lig, col)
			if (n instanceof TextField) {
				TextField tf = (TextField) n;
				int lig = ((int) n.getProperties().get("gridpane-row")) + 1;
				int col = ((int) n.getProperties().get("gridpane-column")) + 1;

				// Saisie des propositions
				tf.textProperty().bindBidirectional(model.propositionProperty(lig, col));

				// Affichage des infobulles
				String texte = getTooltip(lig, col);
				tf.setTooltip(new Tooltip(texte));

				// Revelation d'une solution sur demande
				tf.setOnMouseClicked((e) -> {
					this.clicCase(e);
				});

				// Pression d'une touche du clavier:
				tf.setOnKeyPressed((e) -> {
					this.keyPressed(e);
				});

				// Modification d'un champ de texte
				tf.textProperty().addListener((observable, oldValue, newValue) -> {
					checkTextField(tf);
					goForward(tf);
				});

			}
		}
	}
	
	@FXML
	public void keyPressed(KeyEvent e) {
		KeyCode code = e.getCode();
		TextField tf = (TextField) e.getSource();

		if (e.getCode() == KeyCode.ENTER) { // Gestion de la touche "ENTREE"
			for (Node n : crosswords.getChildren()) {
				if (n instanceof TextField) {
					TextField tfi = (TextField) n;
					int lig = ((int) n.getProperties().get("gridpane-row")) + 1;
					int col = ((int) n.getProperties().get("gridpane-column")) + 1;
					if (!model.estCaseNoire(lig, col)) {
						if (tfi.getText().matches(model.getSolution(lig, col) + "")) {
							tfi.getStyleClass().add("custom-green-cell");
						}
					}

				}
			}
		} else if (e.getCode() == KeyCode.BACK_SPACE) { // Gestion de la touche "BACKSPACE"
			tf.setText("");
			goBackward(tf);

		} else if (e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.DOWN) { //gestion des touches pour la direction
			dir = code;
			goForward(tf);
		}

		transition(tf);

	}

	/**
	 * Transition d'un champs de texte
	 * @param tf
	 */
	private void transition(TextField tf) {
		ScaleTransition transition = new ScaleTransition(Duration.millis(2000), tf);
		transition.setFromY(0);
		transition.setFromX(0);
		transition.setToX(1);
		transition.setToY(1);
		transition.setAutoReverse(true);
		transition.play();
	}
	
	
	/**
	 * V�rification de la taille et le format d'un champ de texte
	 * @param tf
	 */
	private void checkTextField(TextField tf) {
		int lig = ((int) tf.getProperties().get("gridpane-row")) + 1;
		int col = ((int) tf.getProperties().get("gridpane-column")) + 1;

		String texte = tf.getText();
		if (texte.length() > 1) {

			model.setProposition(lig, col, texte.charAt(0));
		}
		String pattern = "^[A-Za-z]$";
		if (!texte.matches(pattern)) {
			tf.setText("");
		}

	}

	/**
	 * Avancer le curseur vers le champs de texte suivant
	 * @param tf
	 */
	private void goForward(TextField tf) {
		int lig = ((int) tf.getProperties().get("gridpane-row")) + 1;
		int col = ((int) tf.getProperties().get("gridpane-column")) + 1;
		int lig_s = lig, col_s = col;

		String pattern = "^[A-Za-z]$";
		if (!tf.getText().matches(pattern) && dir != KeyCode.RIGHT && dir != KeyCode.DOWN) {
			return;
		}

		if (dir == KeyCode.RIGHT && col != model.getLargeur()) {
			col++;
			while (col < model.getLargeur() && model.estCaseNoire(lig, col)) {
				col++;
			}
			if (col == model.getLargeur() && model.estCaseNoire(lig, col)) {
				col = col_s;
			}

		} else if (dir == KeyCode.DOWN && lig != model.getHauteur()) {
			lig++;
			while (lig < model.getHauteur() && model.estCaseNoire(lig, col)) {
				lig++;
			}
			if (lig == model.getHauteur() && model.estCaseNoire(lig, col)) {
				lig = lig_s;
			}
		}

		TextField nextCell = (TextField) getNodeByIndex(lig - 1, col - 1);
		nextCell.requestFocus();
	}

	/**
	 * Avancer le curseur vers le champs de texte pr�c�dant
	 * @param tf
	 */
	private void goBackward(TextField tf) {
		int lig = ((int) tf.getProperties().get("gridpane-row")) + 1;
		int col = ((int) tf.getProperties().get("gridpane-column")) + 1;
		int lig_s = lig, col_s = col;

		if (dir == KeyCode.RIGHT && col != model.getLargeur()) {
			col--;
			while (col >= model.getLargeur() && model.estCaseNoire(lig, col)) {
				col--;
			}
			if (col == model.getLargeur() && model.estCaseNoire(lig, col)) {
				col = col_s;
			}

		} else if (dir == KeyCode.DOWN && lig != model.getHauteur()) {
			lig--;
			while (lig >= model.getHauteur() && model.estCaseNoire(lig, col)) {
				lig--;
			}
			if (lig == model.getHauteur() && model.estCaseNoire(lig, col)) {
				lig = lig_s;
			}
		}

		TextField suivant = (TextField) getNodeByIndex(lig - 1, col - 1);
		suivant.requestFocus();
	}

	/**
	 * R�cuperer un noeud � travers la ligne et colonne
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	private Node getNodeByIndex(int row, int column) {
		Node result = null;

		for (Node node : crosswords.getChildren()) {
//			int lig = ((int) node.getProperties().get("gridpane-row"));
//			int col = ((int) node.getProperties().get("gridpane-column"));

			if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
				result = node;
				break;
			}
		}

		return result;
	}

	/**
	 * 
	 * Recup�re l'infobulle correspondant � la d�finition d'une case de mots croises
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	private String getTooltip(int row, int col) {
		String text = "";
		String horizontal = model.getDefinition(row, col, true);
		String vertical = model.getDefinition(row, col, false);
		if (horizontal != null && vertical != null) {
			text += horizontal + "/" + vertical;
			text += "/" + model.getDefinition(row, col, false);
		} else if (horizontal != null) {
			text += horizontal;
		} else if (vertical != null) {
			text += vertical;
		} else {
			text = null;
		}

		return text;
	}

	/**
	 * Evenement de click d'une case pour reveler une solution
	 * 
	 * @param e
	 */
	@FXML
	public void clicCase(MouseEvent e) {
		if (e.getButton() == MouseButton.SECONDARY) {
			TextField cell = (TextField) e.getSource();
			int row = ((int) cell.getProperties().get("gridpane-row")) + 1;
			int col = ((int) cell.getProperties().get("gridpane-column")) + 1;

			cell.textProperty().bindBidirectional(model.propositionProperty(row, col));

			model.reveler(row, col);
		}
	}
}
