//package application;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class MazeRunner extends Application
{
    public static final int TILE_SIZE = 50;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {

        maze m = new maze1(10,10);

        //TESTING IF PUSHED TO GIT REPO

        //Setting the margin to the nodes
        //vBox.setMargin(welcome, new Insets(20, 20, 20, 20));
        //  vBox.setMargin(playButton, new Insets(20, 20, 20, 20));
        //   vBox.setMargin(stopButton, new Insets(20, 20, 20, 20));
        BorderPane borderPane = new BorderPane();


        borderPane.setCenter(m.createBoard());
        //borderPane.setRight(vBox);

        Scene scene = new Scene(borderPane);


        primaryStage.setTitle("Maze Runner");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}