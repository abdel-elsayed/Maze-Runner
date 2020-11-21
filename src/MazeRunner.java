//package application;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
//import javafx.animation.Animation;
import javafx.scene.shape.*;
import javafx.animation.PathTransition;
import javafx.scene.shape.MoveTo;
import javafx.util.Duration;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class MazeRunner extends Application
{
    public static final int TILE_SIZE = 50;
    int start = 450;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        maze1 m = new maze1(10,10);

        //Create
        Pane mapGrid = m.createBoard();
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(m.createBoard());

        //create test circle.
        Circle circle = new Circle();
        circle.setRadius(50.0f);

        //Creating a Stackpane
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(new Rectangle(700,550, Color.WHITE), borderPane, circle);

        //Add Stackpane to scene..
        Scene scene = new Scene(stackPane);


        ///Scene scene = new Scene(mapGrid);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP) {

                    //List<Node> children = stackPane.getChildren();

                    //path  testing..
                    start -= 50;
                    Path path = new Path();
                    path.getElements().add(new MoveTo(start, 50));
                    PathTransition pathTransition = new PathTransition();
                    pathTransition.setDuration(Duration.millis(4000));
                    pathTransition.setPath(path);
                    pathTransition.setNode(circle);
                    pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                    pathTransition.play();
                }
            }
        });
        primaryStage.setTitle("Maze Runner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}