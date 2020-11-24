//package application;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
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
import java.lang.Math;


public class MazeRunner extends Application
{
    private  int [][] data =
                    { {1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                    , {1,0,1,0,1,0,1,0,1,0,0,0,0,1}
                    , {1,0,1,0,0,0,1,0,1,0,1,1,1,1}
                    , {1,0,0,0,1,1,1,0,0,0,0,0,0,1}
                    , {1,0,1,0,0,0,0,0,1,1,1,1,0,1}
                    , {1,0,1,0,1,0,1,0,1,0,1,0,0,1}
                    , {1,0,1,0,1,1,1,0,1,0,0,0,1,1}
                    , {1,0,0,0,0,1,0,0,1,0,1,0,0,0}
                    , {1,0,1,1,0,1,0,0,1,1,1,0,0,1}
                    , {1,0,0,1,0,1,1,0,0,0,0,0,0,1}
                    , {1,1,1,1,1,1,1,1,1,1,1,1,1,1}
            };

    public static final double TILE_SIZE = 50;
    int start = 450;
    private static final double W = 600, H = 400;
    boolean running, goNorth, goSouth, goEast, goWest;
    double x = 50;
    double y = 50;
    double radius = 20;
    Circle hero = new Circle(x, y, radius);



    @Override
    public void start(Stage primaryStage) {

        maze1 m = new maze1(600, 400);
        //moveHeroTo(100, 85);

        Group root = new Group();
        root.getChildren().addAll(m.createBoard(), hero);

        Scene scene = new Scene(root);
        System.out.println((int) x);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        //double checkPosition1 = y - 10;

                        System.out.println("your index was in the array: " + (int) y / 50 + ' ' + ((int) x / 50));
                        System.out.println("looking up in the array: " + ((int) y / 50 - 1) + ' ' + (((int) x / 50)));
                        System.out.println("looking up: " + data[((int) y / 50)][((int) x / 50 - 1)]);
                        if (data[((int) y / 50) - 1][((int) x / 50)] == 0) {
                            y -= 30;
                            System.out.println("X coordinate: " + x);
                            System.out.println("Y coordinate: " + y);
                            hero.relocate(x, y);
                        }
                        System.out.println("your index now in the array: " + (int) x / 50 + ' ' + ((int) y / 50));
                        break;
                    case DOWN:
                        //double checkPosition2 = y + 10;

                        // System.out.println("looking down: " + data[(int)x/30][((int)y/30)-1]);
                        if (data[(int) y / 50 + 1][((int) x / 50)] == 0) {
                            y += 30;
                            System.out.println("X coordinate: " + x);
                            System.out.println("Y coordinate: " + y);
                            hero.relocate(x, y);
                        }
                        break;
                    case LEFT:
                        //double checkPosition3 = x  - 10;
                        //System.out.println("looking Left: " + data[((int)x/30) - 1][(int)y/30]);
                        if (data[(int) y / 50][(int) x / 50 - 1] == 0) {
                            x -= 30;
                            System.out.println("X coordinate: " + x);
                            System.out.println("Y coordinate: " + y);
                            hero.relocate(x, y);
                        }
                        break;
                    case RIGHT:
                        // double checkPosition4 = x  + 10;
                        // System.out.println("looking right: " + data[((int)x/30) + 1][(int)y/30]);
                        if (data[(int) y / 50][(int) x / 50 + 1] == 0) {
                            x += 30;
                            System.out.println("X coordinate: " + x);
                            System.out.println("Y coordinate: " + y);
                            hero.relocate(x, y);
                        }
                        break;
                    //case SHIFT: running = true; break;
                }
            }
        });
        /*
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        hero.relocate(100, 5);
                        //goNorth = false; break;
                    //case DOWN:  goSouth = false; break;
                    //case LEFT:  goWest  = false; break;
                    //case RIGHT: goEast  = false; break;
                    //case SHIFT: running = false; break;
                }
            }
        });
         */

        primaryStage.setTitle("Maze Runner");
        primaryStage.setScene(scene);
        primaryStage.show();

       AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;

                if (goNorth) dy -= 1;
                if (goSouth) dy += 1;
                if (goEast)  dx += 1;
                if (goWest)  dx -= 1;
                if (running) { dx *= 3; dy *= 3; }

                moveHeroBy(dx, dy);
            }
        };
        timer.start();
    }
    private void moveHeroBy(int dx, int dy) {
        if (dx == 0 && dy == 0) return;

        final double cx = hero.getBoundsInLocal().getWidth() ;
        final double cy = hero.getBoundsInLocal().getHeight();

        double x = cx + hero.getLayoutX() + dx;
        double y = cy + hero.getLayoutY() + dy;

        moveHeroTo(1, 1);
    }

    private void moveHeroTo(double x, double y) {
        final double cx = hero.getBoundsInLocal().getWidth();
        final double cy = hero.getBoundsInLocal().getHeight();
        System.out.println(hero.getBoundsInLocal().getWidth());
        if (x - cx >= 0 &&
                x + cx <= W &&
                y - cy >= 0 &&
                y + cy <= H) {
            hero.relocate(x - cx, y - cy);
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}