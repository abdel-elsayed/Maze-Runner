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

import java.util.concurrent.atomic.AtomicBoolean;


// The game runner
public class MazeRunner extends Application
{
    private AtomicBoolean lose = new AtomicBoolean(false);
    //3 game states 0 = running, 1 = win, 2 = lose
    int isWin = 0;
    Scene scene1, scene2, scene3;
    double mX, mY;
    boolean check = true;


    @Override
    public void start(Stage primaryStage) {

        // creating the maze instance
        maze1 m = new maze1(primaryStage);

        // Layout1 (menu screen)
        // the title of the game
        Label title = new Label("WELCOME TO THE MAZE!");
        title.setFont(new Font("Arial", 24));

        //the name text box
        Label label1 = new Label("Name:");
        label1.setFont(new Font("Arial", 18));
        TextField textField = new TextField ();

        // the start button
        Button button1 = new Button("Start");
        Button button2 = new Button("Exit");

        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField);
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);



        button1.setStyle("-fx-background-color: #F39C12;\n" + "-fx-text-fill: white;\n"
                + "-fx-padding: 5px 28px;\n");
        button2.setStyle("-fx-background-color: #F39C12;\n" + "-fx-text-fill: white;\n"
                + "-fx-padding: 5px 28px;\n");

        button1.setOnAction(e ->
                {
                    primaryStage.setScene(scene2);
                     m.getPlayer().setName(textField.getText());
                }
        );
        button2.setOnAction(e ->
                {
                    System.exit(0);
                }
        );

        HBox buttons = new HBox();
        buttons.getChildren().add(button1);
        buttons.getChildren().add(button2);
        buttons.setSpacing(10);
        buttons.setAlignment(Pos.CENTER);

        // creating the vbox and loading the content to it
        VBox vbox = new VBox(10, title , hb , button1);
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
        scene1 = new Scene(root1);

        // Layout2 ( the maze )
        // creating a root group
        Group root2 = new Group();
        Character hero = m.getPlayer();
        Character monster = m.getComputer();

        Label status = new Label();
        // adding the maze and the user to the root group
        root2.getChildren().addAll(m.getGrid(), hero, monster);

        //starts the movements of the monster
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while(lose.get() == false){
                for (int i = 0; i < 10000; i++) {
                    monster.move(1, m, scene3);

                    if (check) {
                        mX = monster.getPlayerX();
                        mY = monster.getPlayerY();
                        // System.out.println(mX);
                        // System.out.println(mY);
                        check = false;
                    }

                    //if the position of the monster this round is the same as last move then we skip the pause
                    if (mX == monster.getPlayerX() && mY == monster.getPlayerY()) {
                        //copy the monster position
                        mX = monster.getPlayerX();
                        mY = monster.getPlayerY();
                        //System.out.println(mX);
                        //System.out.println(mY);
                        continue;
                    } else {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //copy the monster position
                        //X = (int)monster.getPlayerX();
                        mY = monster.getPlayerY();
                        //System.out.println(mX);
                        //System.out.println(mY);
                    }

                    //Lose condition
                    if (monster.getPlayerX() == m.getPlayer().getPlayerX() && monster.getPlayerY() == m.getPlayer().getPlayerY()) {
                        //    isWin = 2;
                        //    m.getStage().setScene(scene3);
                        lose.set(true);
                        System.out.println("YOU LOSE");
                    }
                }
                }
            }
    });
        thread.start();
        if(lose.get() == true){
            primaryStage.setScene(scene3);
        }

        // creating the scene and adding the root group
        scene2 = new Scene(root2);

        // moving the user on the grid
        scene2.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        hero.move(1 , m, scene3);
                        if(m.getPlayer().getPlayerX() == m.winX && m.getPlayer().getPlayerY() == m.winY ){
                            System.out.println("you won!");
                            status.setText("YOU WON!!!!");
                            primaryStage.setScene(scene3);
                        }
                        break;
                    case DOWN:
                        hero.move(2 , m, scene3);
                        if(m.getPlayer().getPlayerX() == m.winX && m.getPlayer().getPlayerY() == m.winY ){
                            System.out.println("you won!");
                            status.setText("YOU WON!!!!");
                            primaryStage.setScene(scene3);
                        }break;
                    case LEFT:
                        hero.move(3 , m, scene3);
                        if(m.getPlayer().getPlayerX() == m.winX && m.getPlayer().getPlayerY() == m.winY ){
                            System.out.println("you won!");
                            status.setText("YOU WON!!!!");
                            primaryStage.setScene(scene3);
                        }break;
                    case RIGHT:
                        hero.move(4, m, scene3);
                        if(m.getPlayer().getPlayerX() == m.winX && m.getPlayer().getPlayerY() == m.winY ){
                            System.out.println("you won!");
                            status.setText("YOU WON!!!!");
                            primaryStage.setScene(scene3);
                        }break;
                }
            }
        });

        // the background image
        Image image1 = new Image("/gameOver.PNG");
        ImageView mv1 = new ImageView(image1);
        mv1.setFitHeight(550);
        mv1.setFitWidth(700);


        VBox vbox2 = new VBox(10,status, buttons);
        vbox2.setStyle("-fx-padding: 10;" +
                "-fx-background-color: red;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color:#F0E68C ;");
        vbox2.setLayoutX(180);
        vbox2.setLayoutY(300);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setPrefWidth(350);
        vbox2.setPrefHeight(100);

        // adding the image and the vbox to a group
        Group root3 = new Group();
        root3.getChildren().addAll(mv1 , vbox2);
        scene3 = new Scene(root3, 700, 550);

        // setting the scene in the stage and the title
        primaryStage.setTitle("Maze Runner");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }

}

