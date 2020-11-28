import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

// The game runner
public class MazeRunner extends Application
{
    int mDir;
    double mX;
    double mY;
    boolean check = true;

    @Override
    public void start(Stage primaryStage) {
        // creating a root group
        Group root = new Group();

        // creating the maze instance
        maze1 m = new maze1();
        Character hero = m.getPlayer();
        Character monster = m.getComputer();

        // adding the maze and the user to the root group
        root.getChildren().addAll(m.getGrid(), hero, monster );


        //Addition of movement to the Monster
        Thread thread = new Thread(new Runnable() {

            public void run() {
                System.out.println("Thread Running");
                for (int i = 0; i < 10000; i++) {
                    mDir = (int) (Math.random() * (4 - 1 + 1) + 1);
                    System.out.println(mDir);
                    monster.move(mDir, m);
//                    System.out.println(monster.getPlayerX());
//                    System.out.println(monster.getPlayerY());
//
//                    try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    if (check){
                        mX = monster.getPlayerX();
                        mY = monster.getPlayerY();
                        System.out.println(mX);
                        System.out.println(mY);
                        check = false;
                    }


                    //if the position of the monster this round is the same as last move then we skip the pause
                    if(mX == monster.getPlayerX() && mY == monster.getPlayerY()) {
                        //copy the monster position
                        mX = monster.getPlayerX();
                        mY = monster.getPlayerY();
                        System.out.println(mX);
                        System.out.println(mY);
                        continue;
                    }
                    else{
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //copy the monster position
                        mX = monster.getPlayerX();
                        mY = monster.getPlayerY();
                        System.out.println(mX);
                        System.out.println(mY);
                    }

                }
                System.out.println("Thread Running");
            }
        });
        thread.start();



        // this is just experimenting with the menu to be on the right of the maze
        //VBox game = new VBox(root);
        //VBox menu = new VBox(new Label("hello"));
        // HBox list = new HBox(10, game, menu);


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

