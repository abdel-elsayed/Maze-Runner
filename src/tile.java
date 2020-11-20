
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class tile extends Rectangle {


    public tile(int color) {
        setWidth(MazeRunner.TILE_SIZE);
        setHeight(MazeRunner.TILE_SIZE);

        //relocate(  Main.TILE_SIZE , Main.TILE_SIZE );

        if(color == 0)
            setFill(Color.valueOf("#feb"));
        else if (color == 1)
            setFill(Color.valueOf("#582"));
        else{
            setFill(Color.valueOf("#000000"));
            //setWidth(20);
        }
    }

}