import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;

// The game runner
public class MazeRunner extends Application
{
    //3 game states 0 = running, 1 = win, 2 = lose
    int isWin = 0;

    //
    Scene scene1, scene2;
    @Override
    public void start(Stage primaryStage) {

        // creating the maze instance
        maze1 m = new maze1();

        // Layout1 (menu screen)
        // the title of the game
        Label title = new Label("WELCOME TO THE MAZE!");
        title.setFont(new Font("Arial", 24));

        //the name text box
        Label label1 = new Label("Name:");
        label1.setFont(new Font("Arial", 18));
        TextField textField = new TextField ();
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField);
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);

        // the start button
        Button button1 = new Button("Start");
        button1.setStyle("-fx-background-color: #F39C12;\n" + "-fx-text-fill: white;\n"
                + "-fx-padding: 8px 28px;\n");
        button1.setOnAction(e ->
                {
                    primaryStage.setScene(scene2);
                     m.getPlayer().setName(textField.getText());
                }
        );

        // creating the vbox and loading the content to it
        VBox vbox = new VBox(10, title,hb, button1);
        vbox.setStyle("-fx-padding: 10;" +
                "-fx-background-color: #BDB76B;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color:#F0E68C ;");
        vbox.setLayoutX(180);
        vbox.setLayoutY(180);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefWidth(350);
        vbox.setPrefHeight(100);

        // the background image
        Image image = new Image("/background1.png");
        ImageView mv = new ImageView(image);
        mv.setFitHeight(550);
        mv.setFitWidth(700);

        //adding the image and the vbox to a group
        Group root1 = new Group();
        root1.getChildren().addAll(mv,vbox);
        scene1 = new Scene(root1, 700, 550);

        // Layout2 ( the maze )
        // creating a root group
        Group root = new Group();
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

