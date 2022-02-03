package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class StartController {
    
    @FXML public TextField userName;
    @FXML public ImageView logo;
    
    public static String username;
    public static ArrayList<String> users = new ArrayList<String>();
    public MainController mainController = new MainController();

    public void handleJoin() {
    	System.out.println(userName.getText());
    	username = userName.getText();
    	users.add(username);
        changeWindow();
    }

    public void changeWindow() {
        try {
            Stage stage = (Stage) userName.getScene().getWindow();
            Parent root = FXMLLoader.load(this.getClass().getResource("/view/MainWindow.fxml"));
            stage.setScene(new Scene(root, 330, 560));
            stage.setTitle(username + "");
            stage.setOnCloseRequest(event -> {
                System.exit(0);
            });
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}