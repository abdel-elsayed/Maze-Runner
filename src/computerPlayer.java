import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

import java.util.concurrent.TimeUnit;

public class computerPlayer extends Character {

    int X,Y;
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

    }
}
