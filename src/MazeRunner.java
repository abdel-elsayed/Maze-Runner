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
    Scene scene1, scene2, scene3;
    VBox vbox1, vbox2;
    HBox nameBox, buttons;
    Label title, label1;
    TextField textField;
    Button button1, button2;
    Image bckGround, image1;
    Group root1, root2;

    @Override
    public void start(Stage primaryStage) {

        // creating the maze instance
        maze1 m = new maze1();

        // ------------Layout1 (menu screen) --------------
        // the title of the game
        title = new Label("WELCOME TO THE MAZE!");
        title.setFont(new Font("Arial", 24));

        //the name text box
        label1 = new Label("Name:");
        label1.setFont(new Font("Arial", 18));
        textField = new TextField ();

        // the Start & Exit button
        button1 = new Button("Start");
        button2 = new Button("Exit");
        button1.setStyle("-fx-background-color: #F39C12;\n" + "-fx-text-fill: white;\n"
                + "-fx-padding: 5px 28px;\n");
        button2.setStyle("-fx-background-color: #F39C12;\n" + "-fx-text-fill: white;\n"
                + "-fx-padding: 5px 28px;\n");

        // events of the buttons
        button1.setOnAction(e ->{ primaryStage.setScene(scene2);
                    m.getPlayer().setName(textField.getText()); } );
        button2.setOnAction(e ->{
            System.exit(0);});


        // the name field HBox
        nameBox = new HBox();
        nameBox.getChildren().addAll(label1, textField);
        nameBox.setSpacing(10);
        nameBox.setAlignment(Pos.CENTER);

        // Hbox to hold the start and the exit button together for scene3
        buttons = new HBox();
        buttons.getChildren().add(button1);
        buttons.getChildren().add(button2);
        buttons.setSpacing(10);
        buttons.setAlignment(Pos.CENTER);

        // the background image in scene1
        bckGround = new Image("/background1.png");
        ImageView mv = new ImageView(bckGround);
        mv.setFitHeight(550);
        mv.setFitWidth(700);

        // creating the vbox and loading the content to it
        vbox1 = new VBox(10, title , nameBox , button1);
        vbox1.setStyle("-fx-padding: 10;" +
                "-fx-background-color: #BDB76B;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color:#F0E68C ;");
        vbox1.setLayoutX(180);
        vbox1.setLayoutY(180);
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setPrefWidth(350);
        vbox1.setPrefHeight(100);

        //adding the image and the vbox to a group
        root1 = new Group();
        root1.getChildren().addAll(mv,vbox1);
        scene1 = new Scene(root1);


        // ----------- Scene2 (the maze) -------------

        // creating a root group
        root2 = new Group();

        // the user's character
        Character hero = m.getPlayer();
        // the computer's character
        Character monster = m.getComputer();

        // displays you won or you lose
        Label status = new Label();
        status.setFont(new Font("Arial", 14));
        // adding the maze and the user to the root group
        root2.getChildren().addAll(m.getGrid(), hero, monster);

        //starts the movements of the monster
        monster.move(1, m);

        // creating the scene and adding the root group
        scene2 = new Scene(root2);

        // moving the user on the grid
        scene2.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        hero.move(1 , m);
                        if(m.getPlayer().getPlayerX() == m.winX && m.getPlayer().getPlayerY() == m.winY ){
                            status.setText(" Congratulation!!! " + hero.getName() + "\n YOU WON!!!");
                            vbox2.setStyle(  " -fx-background-color: green;" + "-fx-border-color: green ;");
                            primaryStage.setScene(scene3);
                        }
                        if(m.getComputer().getIsWin() == true) {
                            status.setText(" Hard Luck!!! " + hero.getName() + "\n YOU LOST!!!");
                            primaryStage.setScene(scene3);
                        }
                       // System.out.println(m.getComputer().getIsWin());
                        break;
                    case DOWN:
                        hero.move(2 , m);
                        if(m.getPlayer().getPlayerX() == m.winX && m.getPlayer().getPlayerY() == m.winY ){
                            status.setText(" Congratulation!!! " + hero.getName() + "\n YOU WON!!!");
                            vbox2.setStyle(  " -fx-background-color: green;" + "-fx-border-color: green ;");
                            primaryStage.setScene(scene3);

                        }
                        if(m.getComputer().getIsWin() == true) {
                            status.setText(" Hard Luck!!! " + hero.getName() + "\n YOU LOST!!!");
                            primaryStage.setScene(scene3);
                        }
                        //System.out.println(m.getComputer().getIsWin());
                        break;
                    case LEFT:
                        hero.move(3 , m);
                        if(m.getPlayer().getPlayerX() == m.winX && m.getPlayer().getPlayerY() == m.winY ){

                            vbox2.setStyle(  " -fx-background-color: green;" + "-fx-border-color: green ;");
                            status.setText(" Congratulation!!! " + hero.getName() + "\n YOU WON!!!");
                            primaryStage.setScene(scene3);

                        }
                        if(m.getComputer().getIsWin() == true) {
                            status.setText(" Hard Luck!!! " + hero.getName() + "\n YOU LOST!!!");

                            primaryStage.setScene(scene3);
                        }
                        //System.out.println(m.getComputer().getIsWin());
                        break;
                    case RIGHT:
                        hero.move(4, m);
                        if(m.getPlayer().getPlayerX() == m.winX && m.getPlayer().getPlayerY() == m.winY ){
                            status.setText(" Congratulation!!! " + hero.getName() + "\n YOU WON!!!");
                            vbox2.setStyle(  " -fx-background-color: green;" + "-fx-border-color: green ;");
                            primaryStage.setScene(scene3);

                        }
                        if(m.getComputer().getIsWin() == true) {
                            status.setText(" Hard Luck!!! " + hero.getName() + "\n YOU LOST!!!");
                            primaryStage.setScene(scene3);
                        }
                        //System.out.println(m.getComputer().getIsWin());
                        break;

                }
            }
        });


        // --------- Layout3(GameOver) ------------
        // the background image
        image1 = new Image("/gameOver.PNG");
        ImageView mv1 = new ImageView(image1);
        mv1.setFitHeight(550);
        mv1.setFitWidth(700);

        vbox2 = new VBox(10,status, buttons);
        vbox2.setStyle("-fx-padding: 10;" +
                "-fx-background-color: red;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color:#F0E68C ;");
        vbox2.setLayoutX(200);
        vbox2.setLayoutY(300);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setPrefWidth(250);

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

}}

