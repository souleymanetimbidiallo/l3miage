package diallo.laudet.tp6.v3;

import java.sql.SQLException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class RootController {
	@FXML
	private Menu menu;
	
	@FXML
	private MenuItem itemRandom;
	
	
	@FXML
	private MenuItem itemChoice;
	
	
	
	@FXML 
	private MenuItem itemClose;
	

	// Reference to the main application.
	private MainApp mainApp;
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	private void initialize() throws SQLException {

		itemRandom.setOnAction((e) -> { try {
			this.randomCrosswords(e);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} });
		
		itemChoice.setOnAction((e) -> { try {
			this.chooseCrosswords(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} });
		itemClose.setOnAction((e) -> { this.close(e); });
	}
	
	@FXML 
	private void randomCrosswords(ActionEvent e) throws SQLException {
		
		//ControllerV3 ct = new ControllerV3(5);
		
		
		
	}
	
	@FXML 
	private void chooseCrosswords(ActionEvent e) throws SQLException {
//		ControllerV3 ct = new ControllerV3();
//		ct.createGridPane(10);
	}
	
	@FXML
	private void close(ActionEvent e) {
		System.exit(0);
	}
	
	public void setController() {
		
	}

	
}
