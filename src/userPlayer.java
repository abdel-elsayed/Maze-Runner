import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * this class craetes the user character and extends the character class
 * NOTE: NOT USED YET IN MAIN
 */
public class userPlayer extends Character {
    int X,Y;
    // constructor
    public userPlayer(int x, int y){
        super(x,y);
        setWidth(50);
        setHeight(50);
        X = x;
        Y = y;
        setX(X);
        setY(Y);
        setFill(Color.BLACK);
        Image img = new Image("/player.PNG");
        setFill(new ImagePattern(img));
    }

    public double getPlayerX(){
        return X;
    }
    public double getPlayerY(){
        return Y;
    }

    public void move(int dir, maze m){

        switch (dir){
            case 1:
                if (m.getDataArray()[Y /50 - 1][X / 50] == 0 || m.getDataArray()[Y /50 - 1][X / 50] == 2) {
                    Y -=  50;
                    relocate(X, Y);
                }
                break;
            case 2:
                if (m.getDataArray()[Y / 50 + 1][X / 50] == 0 || m.getDataArray()[Y / 50 + 1][X / 50] == 2) {
                    Y +=  50;
                    relocate(X, Y);
                }
                break;
            case 3:
                if (m.getDataArray()[Y / 50][X / 50 - 1] == 0 || m.getDataArray()[Y / 50][X / 50 - 1] == 2) {
                    X -= 50;
                    relocate(X, Y);
                }
                break;
            case 4:
                if (m.getDataArray()[Y / 50][X / 50 + 1] == 0 || m.getDataArray()[Y / 50][X / 50 + 1] == 2) {
                    X += 50;
                    relocate(X, Y);
                }
                break;
        }
    }
}
