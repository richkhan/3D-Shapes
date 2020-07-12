package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
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

        // Build the scene and set up camera
        Group sceneGrp = new Group();
        Scene scene = new Scene(sceneGrp, sceneWidth, sceneHeight);
        scene.setFill(Color.BLACK);
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);
        camera.setTranslateZ(-1000);
        scene.setCamera(camera);
        primaryStage.setTitle("SimpleScene3D");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("shapes.png")));

        primaryStage.show();

        // Create a Cylinder primitive
        final Cylinder cylinder = new Cylinder(50,100);
        final PhongMaterial greenMaterial = new PhongMaterial();
        greenMaterial.setDiffuseColor(Color.DARKGREEN);
        greenMaterial.setSpecularColor(Color.GREEN);
        cylinder.setMaterial(greenMaterial);
        //sceneGrp.getChildren().add(cylinder);

        // Create a Cube primitive
        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.DARKBLUE);
        blueMaterial.setSpecularColor(Color.BLUE);
        final Box cube = new Box(50, 50, 50);
        cube.setMaterial(blueMaterial);

        //Create a Sphere primitive
        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.DARKRED);
        redMaterial.setSpecularColor(Color.RED);
        final Sphere sphere = new Sphere(50);
        sphere.setMaterial(redMaterial);

        // Translate and Rotate cylinder
        cylinder.setRotationAxis(Rotate.X_AXIS);
        cylinder.setRotate(45);
        cylinder.setTranslateX(200);

        // Translate and rotate Cube
        cube.setRotationAxis(Rotate.Y_AXIS);
        cube.setRotate(45);
        cube.setTranslateX(150);
        cube.setTranslateY(150);
        cube.setTranslateZ(-150);

        // Translate and rotate Sphere
        sphere.setRotate(30);
        sphere.setTranslateX(-150);
        sphere.setTranslateY(-150);
        sphere.setTranslateZ(150);
        sceneGrp.getChildren().addAll(cylinder,cube,sphere);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
