package GUI;
/**
* @author Salma Shady 202005204
* @version 1.0
* Created on: 16/04/2021
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import Car_Rental_System.*;
public class GUIApp extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("FCar Company Rental System");
        stage.show();
    }

    public static void main(String[] args) {
       launch(args);
    }
}
