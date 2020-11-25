import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
        }
        //maze exit
        else if (color == 2){
            setFill(Color.valueOf("#6495ED"));
        }
        //monster
        else if (color == 3){
            setFill(Color.valueOf("#FF0000"));
        }
        //tile
        else if (color == 4){
            setFill(Color.valueOf("#0000FF"));
        }

    }

}
