import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;

// The game runner
public class MazeRunner extends Application
{

    @Override
    public void start(Stage primaryStage) {
        // creating a root group
        Group root = new Group();

        // creating the maze instance
        maze1 m = new maze1();
        Character hero = m.getPlayer();

        // adding the maze and the user to the root group
        root.getChildren().addAll(m.getGrid(), hero );

        // creating the scene and adding the root group
        Scene scene = new Scene(root);

        // moving the user on the grid
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        hero.move(1 , m);
                        break;
                    case DOWN:
                        hero.move(2 , m);
                        break;
                    case LEFT:
                        hero.move(3 , m);
                        break;
                    case RIGHT:
                        hero.move(4, m);
                        break;
                }
            }
        });

        // setting the scene in the stage and the title
        primaryStage.setTitle("Maze Runner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }

}

