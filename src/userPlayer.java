import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * Represents the computer character in the game
 * Extends the abstract class character
 */
public class userPlayer extends Character {
    private int X,Y;

    // constructor
    public userPlayer(Image img, int x, int y){
        super(x,y);
        setWidth(30);
        setHeight(30);
        X = x;
        Y = y;
        setX(X);
        setY(Y);
        setFill(Color.BLACK);
        //Image img = new Image("/player.PNG");
        setFill(new ImagePattern(img));
    }


    /**
     *
     * @return X coordinate on grid
     */
    @Override
    public double getPlayerX(){
        return X;
    }

    /**
     *
     * @return Y coordinate on grid
     */
    @Override
    public double getPlayerY(){
        return Y;
    }

    /**
     * This function implements the parents class abstract move function.
     * determines if the move by the user is possible or not and then performs it
     * @param dir direction of movement of the player
     * @param m the maze that the player is moving in
     */
    public void move(int dir, maze m){

        switch (dir){
            case 1:
                if (m.getDataArray()[Y /m.getTileSize() - 1][X / m.getTileSize()] == 0 || m.getDataArray()[Y /m.getTileSize() - 1][X / m.getTileSize()] == 2 ||
                        m.getDataArray()[Y / m.getTileSize() -1 ][X / m.getTileSize()] == 5 || m.getDataArray()[Y / m.getTileSize() -1 ][X / m.getTileSize()] == 6) {
                    Y -=  m.getTileSize();
                    relocate(X, Y);
                }
                // if the player is at first teleporting tile
                if(m.getPlayer().getPlayerX() == m.tele1X && m.getPlayer().getPlayerY() == m.tele1Y ){
                    X = m.tele2X + m.getTileSize();
                    Y = m.tele2Y;
                    relocate(X, Y);
                }
                // if the player is at second teleporting tile
                else if(m.getPlayer().getPlayerX() == m.tele2X && m.getPlayer().getPlayerY() == m.tele2Y ){
                    X = m.tele1X - m.getTileSize();
                    Y = m.tele1Y;
                    relocate(X, Y);
                }
                break;
            case 2:
                if (m.getDataArray()[Y / m.getTileSize() + 1][X / m.getTileSize()] == 0 || m.getDataArray()[Y / m.getTileSize() + 1][X / m.getTileSize()] == 2 ||
                        m.getDataArray()[Y / m.getTileSize() +1][X / m.getTileSize() ] == 5 || m.getDataArray()[Y / m.getTileSize() + 1][X / m.getTileSize()] == 6) {
                    Y +=  m.getTileSize();
                    relocate(X, Y);
                }
                // if the player is at first teleporting tile
                if(m.getPlayer().getPlayerX() == m.tele1X && m.getPlayer().getPlayerY() == m.tele1Y ){
                    X = m.tele2X + m.getTileSize();
                    Y = m.tele2Y;
                    relocate(X, Y);
                }
                // if the player is at second teleporting tile
                else if(m.getPlayer().getPlayerX() == m.tele2X && m.getPlayer().getPlayerY() == m.tele2Y ){
                    X = m.tele1X - m.getTileSize();
                    Y = m.tele1Y;
                    relocate(X, Y);
                }
                break;
            case 3:
                if (m.getDataArray()[Y / m.getTileSize()][X / m.getTileSize() - 1] == 0 || m.getDataArray()[Y / m.getTileSize()][X / m.getTileSize() - 1] == 2||
                        m.getDataArray()[Y / m.getTileSize()][X / m.getTileSize() - 1] == 5 || m.getDataArray()[Y / m.getTileSize()][X / m.getTileSize() - 1] == 6) {
                    X -= m.getTileSize();
                    relocate(X, Y);
                }
                // if the player is at first teleporting tile
                if(m.getPlayer().getPlayerX() == m.tele1X && m.getPlayer().getPlayerY() == m.tele1Y ){
                    X = m.tele2X + m.getTileSize();
                    Y = m.tele2Y;
                    relocate(X, Y);
                }
                // if the player is at second teleporting tile
                else if(m.getPlayer().getPlayerX() == m.tele2X && m.getPlayer().getPlayerY() == m.tele2Y ){
                    X = m.tele1X - m.getTileSize();
                    Y = m.tele1Y;
                    relocate(X, Y);
                }
                break;
            case 4:
                if (m.getDataArray()[Y / m.getTileSize()][X / m.getTileSize() + 1] == 0 || m.getDataArray()[Y / m.getTileSize()][X / m.getTileSize() + 1] == 2  ||
                        m.getDataArray()[Y / m.getTileSize()][X / m.getTileSize() + 1] == 5 || m.getDataArray()[Y / m.getTileSize()][X / m.getTileSize() + 1] == 6) {
                    X += m.getTileSize();
                    relocate(X, Y);
                }
                //if player at the first teleporting tile
                if(m.getPlayer().getPlayerX() == m.tele1X && m.getPlayer().getPlayerY() == m.tele1Y ){
                    X = m.tele2X + m.getTileSize();
                    Y = m.tele2Y;
                    relocate(X, Y);
                }
                // if the player is at second teleporting tile
                else if(m.getPlayer().getPlayerX() == m.tele2X && m.getPlayer().getPlayerY() == m.tele2Y ){
                    X = m.tele1X - m.getTileSize();
                    Y = m.tele1Y;
                    relocate(X, Y);
                }
                break;
        }
    }
}
