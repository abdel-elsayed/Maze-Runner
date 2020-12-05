import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

/**
 * represents the tile that builds the maze grid
 * extends Rectangle
 */
public class tile extends Rectangle {


    // constructor
    public tile(int diff, int color, int t) {

        // setting the dimensions of the tile
        setWidth((double)t);
        setHeight((double)t);

        //Fill tile color
        //path
        if(diff == 0) {
            if (color == 0) {
                setFill(Color.valueOf("#feb"));
            }
            //walls
            else if (color == 1) {
                Image img = new Image("/grass.jpg");
                setFill(new ImagePattern(img));
            }
            //maze exit
            else if (color == 2) {
                setFill(Color.valueOf("#6495ED"));
            }
            //teleporting tile
            else if (color == 5 || color == 6) {
                Image img = new Image("/teleport1.png");
                setFill(new ImagePattern(img));
            }
        }
        else if(diff == 1){

            if (color == 0) {
                setFill(Color.valueOf("#383838"));
            }
            //walls
            else if (color == 1) {
                Image img = new Image("/lava.jpg");
                setFill(new ImagePattern(img));
            }
            //maze exit
            else if (color == 2) {
                setFill(Color.valueOf("#6495ED"));
            }
            //teleporting tile
            else if (color == 5 || color == 6) {
                Image img = new Image("/teleporting2.jpg");
                setFill(new ImagePattern(img));
            }
        }
    }

}
