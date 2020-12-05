import javafx.scene.image.Image;
/**
 * Inherits from the parent maze class
 * represents the first level of the maze
 */
public class maze1 extends maze {
    // tile size
    private int TILE_SIZE = 30;


    // constructor
    public maze1(int diff){
      super(700, 550,0,"level1.txt", 30);
      super.setPlayer(new userPlayer(new Image("/player.PNG"),TILE_SIZE,TILE_SIZE));
      super.setComputer(new computerPlayer(300,90));
      super.setComputer2(new computerPlayer(600,210));
      super.setComputer3(new computerPlayer(900,210));
      super.setComputer4(new computerPlayer(450,210));
      super.setComputer5(new computerPlayer(480,210));
    }

    /**
     *
     * @return the size of the maze tiles
     */
    @Override
    public int getTileSize(){
        return TILE_SIZE;
    }


}
