import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.util.Duration;

// The game runner
public class MazeRunner extends Application
{
    Scene scene1, scene2, scene3, scene4;
    VBox vbox1;
    HBox nameBox, timer;
    Label title, label1, timerText, status;
    TextField textField;
    Button button1;
    Image bckGround, image1;
    Group root1, root2, root3;
    ToggleButton easy, hard;
    Timeline timeline;
    Label timerLabel = new Label();
    Integer timeSeconds = 0;
    maze m1 = new maze1(0);
    maze m2 = new maze2(1);


    @Override
    public void start(Stage primaryStage) {

        // ------------Layout1 (menu screen) --------------
        // the title of the game
        title = new Label("WELCOME TO THE MAZE!");
        title.setFont(new Font("Arial", 24));

         easy = new ToggleButton("Easy");
         hard = new ToggleButton("Hard");
         ToggleGroup tglGroup = new ToggleGroup();
         easy.setSelected(true);
         easy.setToggleGroup(tglGroup);
         hard.setToggleGroup(tglGroup);
         HBox toggleBox = new HBox(easy, hard);
         toggleBox.setAlignment(Pos.CENTER);

        //the name text box
        label1 = new Label("Name:");
        label1.setFont(new Font("Arial", 18));
        textField = new TextField ();

        // the Start & Exit button
        button1 = new Button("Start");
        button1.setStyle("-fx-background-color: #F39C12;\n" + "-fx-text-fill: white;\n"
                + "-fx-padding: 5px 28px;\n");

        // events of the buttons(start button)
        button1.setOnAction(e ->{
            if (timeline != null) {
                timeline.stop();
            }

            // check which toggle button is selected
            if(easy.isSelected()){
                timeSeconds = 50;
                //starts the movements of the monsters
                m1.getComputer().move(1, m1);
                m1.getComputer2().move(1, m1);
                m1.getComputer3().move(1, m1);
                m1.getComputer4().move(1, m1);
                m1.getComputer5().move(1, m1);

                // setting the name of the player
                m1.getPlayer().setName(textField.getText());

                // adding the maze and the user to the root group // now new monsters spawn in aswell
                root2.getChildren().addAll(m1.getGrid(), m1.getPlayer(), m1.getComputer(),m1.getComputer2(), m1.getComputer3(), m1.getComputer4(), m1.getComputer5(), timer);
                primaryStage.setScene(scene2);
            }else if(hard.isSelected()){
                timeSeconds = 40;
                //starts the movements of the monsters
                m2.getComputer().move(1, m2);
                m2.getComputer2().move(1, m2);
                m2.getComputer3().move(1, m2);
                m2.getComputer4().move(1, m2);
                m2.getComputer5().move(1, m2);
                m2.getComputer6().move(1, m2);
                // setting the name of the player
                m2.getPlayer().setName(textField.getText());

                root3.getChildren().addAll(m2.getGrid(), m2.getPlayer(), m2.getComputer(),m2.getComputer2(), m2.getComputer3(), m2.getComputer4(), m2.getComputer5(), m2.getComputer6(), timer);
                // m = new maze2(diff);
                primaryStage.setScene(scene3);
            }


            // update timerLabel
            timerLabel.setText( timeSeconds.toString());
            timeline = new Timeline();
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(1),
                            new EventHandler() {
                                @Override// KeyFrame event handler
                                public void handle(Event event) {
                                    timeSeconds--;
                                    // update timerLabel
                                    timerLabel.setText(
                                            timeSeconds.toString());
                                    if (timeSeconds <= 0) {
                                        timeline.stop();
                                    }
                                }
                            }));
            timeline.playFromStart();

        });


        // the name field HBox
        nameBox = new HBox();
        nameBox.getChildren().addAll(label1, textField);
        nameBox.setSpacing(10);
        nameBox.setAlignment(Pos.CENTER);



        // timer
        timerText = new Label("Time remaining: ");
        timerText.setTextFill(Color.RED);
        timer = new HBox(20);
        timer.setAlignment(Pos.CENTER);
        timerLabel.setText(timeSeconds.toString());
        timerLabel.setTextFill(Color.RED);
        timer.getChildren().addAll(timerText , timerLabel);
        timer.setPrefWidth(200);
        //timer.setStyle();
        timer.setStyle("-fx-background-color: black;");



        // the background image in scene1
        bckGround = new Image("/background1.png");
        ImageView mv = new ImageView(bckGround);
        mv.setFitHeight(550);
        mv.setFitWidth(700);

        // creating the vbox and loading the content to it
        vbox1 = new VBox(10, title , nameBox ,toggleBox, button1);
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


        // ----------- Scene2 (the easy maze) -------------

        // creating a root group
        root2 = new Group();

        // creating the scene and adding the root group
        scene2 = new Scene(root2);

        // moving the user on the grid
        scene2.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        m1.getPlayer().move(1 , m1);
                        if(m1.getPlayer().getPlayerX() == m1.getWinX() && m1.getPlayer().getPlayerY() == m1.getWinY() ){
                            status.setText(" Congratulation!!! " + m1.getPlayer().getName() + "\n YOU WON!!!");
                            primaryStage.setScene(scene4);
                        }
                        if(m1.getComputer().getIsWin() == true || m1.getComputer2().getIsWin() == true || m1.getComputer3().getIsWin() == true || m1.getComputer4().getIsWin() == true || m1.getComputer5().getIsWin() == true) {
                            status.setText(" Hard Luck!!! " + m1.getPlayer().getName() + "\n YOU LOST!!!");
                            primaryStage.setScene(scene4);
                        }
                       // System.out.println(m.getComputer().getIsWin());
                        if(timeSeconds == 0){
                            m1.getComputer().setIsWin(true);
                            m1.getComputer2().setIsWin(true);
                            m1.getComputer3().setIsWin(true);
                            m1.getComputer4().setIsWin(true);
                            status.setText(" Hard Luck!!! " + m1.getPlayer().getName() + "\n YOU LOST!!!");
                            primaryStage.setScene(scene4);
                        }
                        break;
                    case DOWN:
                        m1.getPlayer().move(2 , m1);
                        if(m1.getPlayer().getPlayerX() == m1.getWinX() && m1.getPlayer().getPlayerY() == m1.getWinY()){
                            status.setText(" Congratulation!!! " + m1.getPlayer().getName() + "\n YOU WON!!!");
                            primaryStage.setScene(scene4);

                        }
                        if(m1.getComputer().getIsWin() == true || m1.getComputer2().getIsWin() == true || m1.getComputer3().getIsWin() == true || m1.getComputer4().getIsWin() == true || m1.getComputer5().getIsWin() == true) {
                            status.setText(" Hard Luck!!! " + m1.getPlayer().getName() + "\n YOU LOST!!!");
                            primaryStage.setScene(scene4);
                        }
                        //System.out.println(m.getComputer().getIsWin());
                        if(timeSeconds == 0){
                            m1.getComputer().setIsWin(true);
                            m1.getComputer2().setIsWin(true);
                            m1.getComputer3().setIsWin(true);
                            m1.getComputer4().setIsWin(true);
                            status.setText(" Hard Luck!!! " + m1.getPlayer().getName() + "\n YOU LOST!!!");
                            primaryStage.setScene(scene4);
                        }
                        break;
                    case LEFT:
                        m1.getPlayer().move(3 , m1);
                        if(m1.getPlayer().getPlayerX() == m1.getWinX() && m1.getPlayer().getPlayerY() == m1.getWinY() ){

                            status.setText(" Congratulation!!! " + m1.getPlayer().getName() + "\n YOU WON!!!");
                            primaryStage.setScene(scene4);

                        }
                        if(m1.getComputer().getIsWin() == true || m1.getComputer2().getIsWin() == true || m1.getComputer3().getIsWin() == true || m1.getComputer4().getIsWin() == true || m1.getComputer5().getIsWin() == true) {
                            status.setText(" Hard Luck!!! " + m1.getPlayer().getName() + "\n YOU LOST!!!");
                            primaryStage.setScene(scene4);
                        }
                        //System.out.println(m.getComputer().getIsWin());
                        if(timeSeconds == 0){
                            m1.getComputer().setIsWin(true);
                            m1.getComputer2().setIsWin(true);
                            m1.getComputer3().setIsWin(true);
                            m1.getComputer4().setIsWin(true);
                            status.setText(" Hard Luck!!! " + m1.getPlayer().getName() + "\n YOU LOST!!!");
                            primaryStage.setScene(scene4);
                        }
                        break;
                    case RIGHT:
                        m1.getPlayer().move(4, m1);
                       // System.out.println(m.tele1X);
                        if(m1.getPlayer().getPlayerX() == m1.getWinX() && m1.getPlayer().getPlayerY() == m1.getWinY() ){
                            status.setText(" Congratulation!!! " + m1.getPlayer().getName() + "\n YOU WON!!!");
                            primaryStage.setScene(scene4);

                        }
                        if(m1.getComputer().getIsWin() == true || m1.getComputer2().getIsWin() == true || m1.getComputer3().getIsWin() == true || m1.getComputer4().getIsWin() == true  || m1.getComputer5().getIsWin() == true) {
                            status.setText(" Hard Luck!!! " + m1.getPlayer().getName() + "\n YOU LOST!!!");
                            primaryStage.setScene(scene4);
                        }
                        if(timeSeconds == 0){
                            m1.getComputer().setIsWin(true);
                            m1.getComputer2().setIsWin(true);
                            m1.getComputer3().setIsWin(true);
                            m1.getComputer4().setIsWin(true);
                            status.setText(" Hard Luck!!! " + m1.getPlayer().getName() + "\n YOU LOST!!!");
                            primaryStage.setScene(scene4);
                        }
                        break;

                }
            }
        });

        //-----------Layout3(harder maze)----------------

        // creating a root group
        root3 = new Group();

        // creating the scene and adding the root group
        scene3 = new Scene(root3);

        // moving the user on the grid
        scene3.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        m2.getPlayer().move(1 , m2);
                        if(m2.getPlayer().getPlayerX() == m2.getWinX() && m2.getPlayer().getPlayerY() == m2.getWinY() ){
                            status.setText(" Congratulation!!! " + m2.getPlayer().getName() + "\n YOU WON!!!");
                            primaryStage.setScene(scene4);
                        }
                        if(m2.getComputer().getIsWin() == true || m2.getComputer2().getIsWin() == true || m2.getComputer3().getIsWin() == true || m2.getComputer4().getIsWin() == true
                                || m2.getComputer5().getIsWin() == true || m2.getComputer6().getIsWin() == true)
                        {  status.setText(" Hard Luck!!! " + m2.getPlayer().getName() + "\n YOU LOST!!!");
                            primaryStage.setScene(scene4);
                        }
                        // System.out.println(m.getComputer().getIsWin());
                        break;
                    case DOWN:
                        m2.getPlayer().move(2 , m2);
                        if(m2.getPlayer().getPlayerX() == m2.getWinX() && m2.getPlayer().getPlayerY() == m2.getWinY()){
                            status.setText(" Congratulation!!! " + m1.getPlayer().getName() + "\n YOU WON!!!");
                            primaryStage.setScene(scene4);

                        }
                        if(m2.getComputer().getIsWin() == true || m2.getComputer2().getIsWin() == true || m2.getComputer3().getIsWin() == true || m2.getComputer4().getIsWin() == true
                                || m2.getComputer5().getIsWin() == true || m2.getComputer6().getIsWin() == true) {
                            status.setText(" Hard Luck!!! " + m2.getPlayer().getName() + "\n YOU LOST!!!");
                            primaryStage.setScene(scene4);
                        }
                        //System.out.println(m.getComputer().getIsWin());
                        break;
                    case LEFT:
                        m2.getPlayer().move(3 , m2);
                        if(m2.getPlayer().getPlayerX() == m2.getWinX() && m2.getPlayer().getPlayerY() == m2.getWinY() ){

                            status.setText(" Congratulation!!! " + m2.getPlayer().getName() + "\n YOU WON!!!");
                            primaryStage.setScene(scene4);

                        }
                        if(m2.getComputer().getIsWin() == true || m2.getComputer2().getIsWin() == true || m2.getComputer3().getIsWin() == true || m2.getComputer4().getIsWin() == true
                                || m2.getComputer5().getIsWin() == true || m2.getComputer6().getIsWin() == true) {
                            status.setText(" Hard Luck!!! " + m2.getPlayer().getName() + "\n YOU LOST!!!");
                            primaryStage.setScene(scene4);
                        }
                        //System.out.println(m.getComputer().getIsWin());
                        break;
                    case RIGHT:
                        m2.getPlayer().move(4, m2);
                        // System.out.println(m.tele1X);
                        if(m2.getPlayer().getPlayerX() == m2.getWinX() && m2.getPlayer().getPlayerY() == m2.getWinY() ){
                            status.setText(" Congratulation!!! " + m2.getPlayer().getName() + "\n YOU WON!!!");
                            primaryStage.setScene(scene4);

                        }
                        if(m2.getComputer().getIsWin() == true || m2.getComputer2().getIsWin() == true || m2.getComputer3().getIsWin() == true || m2.getComputer4().getIsWin() == true
                                || m2.getComputer5().getIsWin() == true || m2.getComputer6().getIsWin() == true) {
                            status.setText(" Hard Luck!!! " + m2.getPlayer().getName() + "\n YOU LOST!!!");
                            primaryStage.setScene(scene4);
                        }
                        if(timeSeconds == 0){
                            m2.getComputer().setIsWin(true);
                            m2.getComputer2().setIsWin(true);
                            m2.getComputer3().setIsWin(true);
                            m2.getComputer4().setIsWin(true);
                            status.setText(" Hard Luck!!! " + m2.getPlayer().getName() + "\n YOU LOST!!!");
                            primaryStage.setScene(scene4);
                        }
                        break;

                }
            }
        });


        // --------- Layout4(GameOver) ------------------

        // displays you won or you lose
        status = new Label();
        status.setFont(new Font("Bradley Hand, cursive", 28));
        status.setStyle("-fx-text-fill: green");
        status.setAlignment(Pos.TOP_RIGHT);
        status.setLayoutX(250);

        // the background image
        image1 = new Image("/background2.PNG");
        ImageView mv1 = new ImageView(image1);
        mv1.setFitHeight(550);
        mv1.setFitWidth(700);

        // adding the image and the vbox to a group
        Group root3 = new Group();
        root3.getChildren().addAll(mv1 , status);
        scene4 = new Scene(root3, 700, 550);

        // setting the scene in the stage and the title
        primaryStage.setTitle("Maze Runner");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);

}}

