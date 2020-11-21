
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class tile extends Rectangle {

    boolean isWall;

    public tile(int color) {
        setWidth(MazeRunner.TILE_SIZE);
        setHeight(MazeRunner.TILE_SIZE);


        //Fill tile color
        if(color == 0){
            setFill(Color.valueOf("#feb"));
            isWall = false;
        }
        else if (color == 1) {
            setFill(Color.valueOf("#582"));
            isWall = true;
        }
        else if (color == 2){
            setFill(Color.valueOf("#6495ED"));
            isWall = false;
        }
        else if (color == 3){
            setFill(Color.valueOf("#FF0000"));
            isWall = false;
        }

     /*   //Fill tile Character
        if(character.type == "Player"){
            setFill(Color.valueOf("#feb"));
            isWall = false;
        }
        else if (character.type == "Monster") {
            setFill(Color.valueOf("#582"));
            isWall = true;
        }
       */



    }

}
