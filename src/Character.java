import javafx.scene.shape.Rectangle;

/***
 * abstract class that extends triangle and represents the characters in the game
 * NOTE: NOT USED YET IN MAIN
 */
public abstract class Character extends Rectangle {
    private boolean isWin;
    private int X;
    private int Y;


    public  Character( int x, int y) {
          isWin = false;
          X = x;
          Y = y;
    }

    // abstract method moving the character
    public abstract void move(int dir, maze m );

}