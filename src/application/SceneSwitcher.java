package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {

    private Stage stage;
    private Scene scene;
    private Parent root;

    // switch to start scene
    public void switchtoStartGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("StartGame.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    // switch to main scene
    public void switchToMainScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
    
    // switch to rules scene
    public void switchScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HowToPlay.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    // switch to end scene
    public void switchToEndScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FinalScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    // alert box when exit game
    public void exitGame(ActionEvent event) throws IOException {

        Alert alertBox = new Alert(AlertType.CONFIRMATION);
        alertBox.setTitle("Log out");
        alertBox.setHeaderText("You are about to exit Nanu?");
        alertBox.setContentText("Thanks for playing our (not so great) game :')");

        if (alertBox.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

}
