package diallo.laudet.tp6.v4;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

import diallo.laudet.tp6.modele.ChargerGrille;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RootController {
	@FXML
	private MenuBar menuBar;

	@FXML
	private Menu menuRandom;

	@FXML
	private Menu menuChoice;

	@FXML
	private MenuItem itemRandom;

	@FXML
	private MenuItem itemClose;

	// Reference to the main application.
	private MainApp mainApp;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	private void initialize() throws SQLException {

		// Chargement des donn�es de la base et ajout de menu:
		ChargerGrille cg = new ChargerGrille();
		Map map = cg.grillesDisponibles();
		Iterator<Map.Entry> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry m = it.next();
			menuChoice.getItems().addAll(new MenuItem(m.getKey() + " -> " + m.getValue()));
		}
		
		// Clique sur le bouton "Grille al�atoire"
		itemRandom.setOnAction((e) -> {
			this.randomCrosswords();
		});

		// Clique sur le bouton "Quitter"
		itemClose.setOnAction((e) -> {
			this.close(e);
		});		

		// Clique sur les choix du menu de s�lection des grilles
		for (MenuItem mi : menuChoice.getItems()) {
			mi.setOnAction((e) -> {
				String[] str = mi.getText().split(" -> ");
				int gridNumber = Integer.parseInt(str[0]);
				chooseCrosswords(gridNumber);
			});
		}
	}

	/**
	 * Cr�ation d'une grille al�atoire entre 1 (min) et 11 (max)
	 * 
	 * @param e evenement li� au clic d'un bouton du menu
	 * @throws SQLException
	 */
	@FXML
	private void randomCrosswords() {
		int min = 1, max = 11;
		int gridNumber = (int) (Math.random() * (max - min + 1) + min);
		chooseCrosswords(gridNumber);
	}

	/**
	 * Choix d'une grille sp�cifique parmi les grille disponibles
	 * 
	 * @param gridNumber
	 */
	private void chooseCrosswords(int gridNumber) {
		displayGridPane(gridNumber);
	}

	/**
	 * Fermeture de l'application
	 * 
	 * @param e, evenement li� au clic sur le bouton du menu "Quitter"
	 */
	@FXML
	private void close(ActionEvent e) {
		System.exit(0);
	}

	/**
	 * Affichage de la vue en fonction des diff�rents choix de la grille.
	 * 
	 * @param gridNumber
	 */

	private void displayGridPane(int gridNumber) {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			ControllerV4 ct = new ControllerV4(gridNumber);
			loader.setController(ct);
			loader.setLocation(MainApp.class.getResource("CrosswordsOverview.fxml"));
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
