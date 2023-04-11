import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;

public class App extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Text text = new Text("Hello world!");
        text.setLayoutY(80);    // установка положения надписи по оси Y
        text.setLayoutX(80);   // установка положения надписи по оси X

        Button btn = new Button();
        btn.setText("Exit");

        btn.setOnAction(event -> stage.close());

        Group root = new Group(btn, text);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.setTitle("JavaFX Application");
        stage.setWidth(1000);
        stage.setHeight(800);
        stage.show();
    }
}