package diallo.laudet.tp6.v3;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Mots croisés");
		
		initRootLayout();
		
		showCrossWords();
		
	}

	/**
	 * Initializes the root layout
	 */
	private void initRootLayout() {
		try{
			//Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader() ;
            loader.setLocation(MainApp.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            //show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			
			scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the gridPane inside the root layout
	 */
	private void showCrossWords() {
        try {

    		//Load root layout from fxml file.
    		FXMLLoader loader = new FXMLLoader() ;
            loader.setLocation(MainApp.class.getResource("CrosswordsOverview.fxml"));
			BorderPane crosswords = (BorderPane) loader.load();
			rootLayout.setCenter(crosswords);
			
			// Give the controller access to the main app.
			ControllerV3 controller = loader.getController();
            controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
