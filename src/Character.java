import javafx.scene.shape.Rectangle;

/***
 * abstract class that extends Rectangle and represents the characters in the game
 */
public abstract class Character extends Rectangle {
    private String name;
    private boolean isWin;

    // constructor
    public  Character( int x, int y) {
        isWin = false;
    }

    // accessors and mutators
    public void setName(String n){
        name = n;
    }
    public String getName(){return name;}
    public void setIsWin(boolean w){isWin = w;}
    public boolean getIsWin(){return isWin;}

    /**
     * abstract function to move the character on maze
     * @param dir
     * @param m
     */
    public abstract void move(int dir, maze m);

    /**
     * get the Y coordinate of the character
     * @return Y coordinate on grid
     */
    public abstract double getPlayerY();

    /**
     * get the X coordinate of the character
     * @return X coordinate on grid
     */
    public abstract double getPlayerX();
}