import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class computerPlayer extends Character {

    int X,Y;
    double mX, mY;
    boolean check = true;
    // constructor
    public computerPlayer(int x, int y){
        super(x,y);
        setWidth(50);
        setHeight(50);
        X = x;
        Y = y;
        setX(X);
        setY(Y);
        setFill(Color.RED);
        Image img = new Image("/monster.PNG");
        setFill(new ImagePattern(img));
    }
    public double getPlayerX(){
        return X;
    }
    public double getPlayerY(){
        return Y;
    }


    public void move(int dir, maze m) {

        Thread thread = new Thread(new Runnable() {
        public void run() {
             //System.out.println("Thread Running");
            for (int i = 0; i < 10000; i++) {
                int dir = (int) (Math.random() * (4 - 1 + 1) + 1);
                //System.out.println(dir);

                switch (dir) {
                    case 1:
                        if (m.getDataArray()[Y / 50 - 1][X / 50] == 0) {
                            Y -= 50;
                            relocate(X, Y);

                        }
                        break;
                    case 2:
                        if (m.getDataArray()[Y / 50 + 1][X / 50] == 0) {
                            Y += 50;
                            relocate(X, Y);

                        }
                        break;
                    case 3:
                        if (m.getDataArray()[Y / 50][X / 50 - 1] == 0) {
                            X -= 50;
                            relocate(X, Y);

                        }
                        break;
                    case 4:
                        if (m.getDataArray()[Y / 50][X / 50 + 1] == 0) {
                            X += 50;
                            relocate(X, Y);

                        }
                        break;
                }

                if (check){
                    mX = getPlayerX();
                    mY = getPlayerY();
                   // System.out.println(mX);
                   // System.out.println(mY);
                    check = false;
                }


                //if the position of the monster this round is the same as last move then we skip the pause
                if(mX == getPlayerX() && mY == getPlayerY()) {
                    //copy the monster position
                    mX = getPlayerX();
                    mY = getPlayerY();
                    //System.out.println(mX);
                    //System.out.println(mY);
                    continue;
                }
                else{
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //copy the monster position
                    X = (int)getPlayerX();
                    mY = getPlayerY();
                    //System.out.println(mX);
                   // System.out.println(mY);
                }

                //Lose condition
                if(getPlayerX() == m.getPlayer().getPlayerX() && getPlayerY() == m.getPlayer().getPlayerY()) {
                //    isWin = 2;
                   System.out.println("YOU LOSE");
                }


            }
            // System.out.println("Thread Running");
        }
        });
        thread.start();
    }
}
