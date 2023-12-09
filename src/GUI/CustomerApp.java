package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**Customer App class
 * @author : Hanan Nisar
 * @version 1
 * Date created : 21 April 2021
 */

public class CustomerApp extends Application{

	/**
	 * App class for testing the customer window
	 */
	@Override
	public void start(Stage stage) throws Exception {
		Pane root= FXMLLoader.load(getClass().getResource("MainCustWindow.fxml"));
		stage.setScene(new Scene(root, 600,400));
		stage.setTitle("Customer App");
		stage.show();
	}
	
	/**
	 * main
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
