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

    // moving the character
    //public abstract void move(char dir, maze m );
    public void move(int dir, maze m){

        switch (dir){
            case 1:
                if (m.getDataArray()[Y /50 - 1][X / 50] == 0 ) {
                    Y -=  50;
                    relocate(X, Y);
                }
                break;
            case 2:
                if (m.getDataArray()[Y / 50 + 1][X / 50] == 0 ) {
                    Y +=  50;
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