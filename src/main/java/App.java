import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        var loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        var root = (Parent) loader.load();
        var scene = new Scene(root);

        // scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.show();
        stage.setTitle("Pomodoro timer");
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
