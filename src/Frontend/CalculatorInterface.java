package Frontend;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorInterface extends Application {

    // Main Nodes
    @FXML
    public Parent root;
    @FXML
    protected Stage stage;
    @FXML
    protected Scene scene;

    // Main AnchorPane
    @FXML
    protected AnchorPane FullPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainScene.fxml"));
        FullPane = loader.load();
        //start testing
        scene = new Scene(FullPane);
        scene.getStylesheets().add(getClass().getResource("stylesheets.css").toExternalForm());
        //end testing

        this.stage.setTitle("Calculator");
        primaryStage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
