import javafx.scene.paint.Color;

/**
 * this class craetes the user character and extends the character class
 * NOTE: NOT USED YET IN MAIN
 */
public class userPlayer extends Character {

    double X,Y;
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
    }



}
