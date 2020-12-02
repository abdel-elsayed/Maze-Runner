import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;


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


    /**
     * This function implements the parents class abstract move function.
     * Creates a thread for the monster to constantly run in the background
     * @param dir direction of movement of the monster
     * @param m the maze that the monster is moving in
     */
    public void move(int dir, maze m) {

        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    int dir = (int) (Math.random() * (4 - 1 + 1) + 1);
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

                    //only runs first time to set temp variables
                    if (check) {
                        mX = getPlayerX();
                        mY = getPlayerY();
                        // System.out.println(mX);
                        // System.out.println(mY);
                        check = false;

                        //Delay while user types name
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //if the position of the monster this round is the same as last move then we skip the pause
                    if (mX == getPlayerX() && mY == getPlayerY()) {
                        //copy the monster position
                        mX = getPlayerX();
                        mY = getPlayerY();
                        continue;
                    } else {
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //copy the monster position
                        X = (int)getPlayerX();
                        mY = getPlayerY();
                    }

                    //Lose condition
                    if (getPlayerX() == m.getPlayer().getPlayerX() && getPlayerY() == m.getPlayer().getPlayerY()) {
                        System.out.println("YOU LOSE");

                        // setting the computer's boolean isWin variable to true.
                        setIsWin(true);
                        break;
                    }
                }
            }

        });
        thread.start();

    }

}
