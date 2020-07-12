package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private PerspectiveCamera camera;
    private final double cameraModifier = 50.0;
    private final double cameraQuantitiy = 10.0;
    private final double sceneWidth = 600;
    private final double sceneHeight = 600;
    private double mouseXold = 0;
    private double mouseYold = 0;
    private final double cameraYlimir = 15;
    private final double rotateModifier = 25;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Group sceneGrp = new Group();
        Scene scene = new Scene(sceneGrp, sceneWidth, sceneHeight);
        scene.setFill(Color.BLACK);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
