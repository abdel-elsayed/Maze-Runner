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
    public tile(int color, int t) {

        // setting the dimensions of the tile
        setWidth((double)t);
        setHeight((double)t);

        //Fill tile color
        //path
        if(color == 0){
            setFill(Color.valueOf("#feb"));
        }
        //walls
        else if (color == 1) {
            setFill(Color.valueOf("#582"));
            Image img = new Image("/grass.jpg");
            setFill(new ImagePattern(img));
        }
        //maze exit
        else if (color == 2){
            setFill(Color.valueOf("#6495ED"));
        }
        //teleporting tile
        else if (color == 5 || color == 6){
            setFill(Color.valueOf("#7F00FF"));
            Image img = new Image("/teleport1.png");
            setFill(new ImagePattern(img));
        }

    }

}
