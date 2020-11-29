import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;

// The game runner
public class MazeRunner extends Application
{
    //3 game states 0 = running, 1 = win, 2 = lose
    int isWin = 0;
    Scene scene1, scene2;
    @Override
    public void start(Stage primaryStage) {
        // Layout1 (menu screen)
        Button button1 = new Button("Start");
        button1.setStyle("-fx-background-color: #F39C12;\n" + "-fx-text-fill: white;\n" + "-fx-padding: 14px 28px;\n"
        + "-fx-border-radius: 20px;\n" +"-fx-cursor: pointer;\n" );
        button1.setOnAction(e -> primaryStage.setScene(scene2));
        button1.setLayoutX(320);
        button1.setLayoutY(200);

        Image image = new Image("/background1.png");
        ImageView mv = new ImageView(image);
        mv.setFitHeight(550);
        mv.setFitWidth(700);

        Group root1 = new Group();
        root1.getChildren().addAll(mv, button1);
        scene1 = new Scene(root1, 700, 550);

        // Layout2 ( the maze )
        // creating a root group
        Group root = new Group();
        // creating the maze instance
        maze1 m = new maze1();
        Character hero = m.getPlayer();
        Character monster = m.getComputer();

        // adding the maze and the user to the root group
        root.getChildren().addAll(m.getGrid(), hero, monster);

        //starts the movements of the monster
        monster.move(1,m);

        // creating the scene and adding the root group
        scene2 = new Scene(root);

        // moving the user on the grid
        scene2.setOnKeyPressed(new EventHandler<KeyEvent>() {
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
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }

}

