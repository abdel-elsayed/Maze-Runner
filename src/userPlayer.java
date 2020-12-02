import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * this class creates the user character and extends the character class
 */
public class userPlayer extends Character {
    int X,Y;
    // constructor
    public userPlayer(int x, int y){
        super(x,y);
        setWidth(40);
        setHeight(40);
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
                if (m.getDataArray()[Y /m.getTileSize() - 1][X / m.getTileSize()] == 0 || m.getDataArray()[Y /m.getTileSize() - 1][X / m.getTileSize()] == 2 ||
                        m.getDataArray()[Y / m.getTileSize() -1 ][X / m.getTileSize()] == 5 || m.getDataArray()[Y / m.getTileSize() -1 ][X / m.getTileSize()] == 6) {
                    Y -=  m.getTileSize();
                    relocate(X, Y);
                }
                if(m.getPlayer().getPlayerX() == m.tele1X && m.getPlayer().getPlayerY() == m.tele1Y ){
                    X = m.tele2X + m.getTileSize();
                    Y = m.tele2Y;
                    relocate(X, Y);
                }else if(m.getPlayer().getPlayerX() == m.tele2X && m.getPlayer().getPlayerY() == m.tele2Y ){
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
                if(m.getPlayer().getPlayerX() == m.tele1X && m.getPlayer().getPlayerY() == m.tele1Y ){
                    X = m.tele2X + m.getTileSize();
                    Y = m.tele2Y;
                    relocate(X, Y);
                }else if(m.getPlayer().getPlayerX() == m.tele2X && m.getPlayer().getPlayerY() == m.tele2Y ){
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
                if(m.getPlayer().getPlayerX() == m.tele1X && m.getPlayer().getPlayerY() == m.tele1Y ){
                    X = m.tele2X + m.getTileSize();
                    Y = m.tele2Y;
                    relocate(X, Y);
                }else if(m.getPlayer().getPlayerX() == m.tele2X && m.getPlayer().getPlayerY() == m.tele2Y ){
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
                if(m.getPlayer().getPlayerX() == m.tele1X && m.getPlayer().getPlayerY() == m.tele1Y ){
                    X = m.tele2X + m.getTileSize();
                    Y = m.tele2Y;
                    relocate(X, Y);
                }else if(m.getPlayer().getPlayerX() == m.tele2X && m.getPlayer().getPlayerY() == m.tele2Y ){
                    X = m.tele1X - m.getTileSize();
                    Y = m.tele1Y;
                    relocate(X, Y);
                }
                break;
        }
    }
}
