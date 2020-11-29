import javafx.scene.layout.GridPane;

public class maze1 extends maze {
    // tile size
    private int TILE_SIZE = 50;

    // constructor
    public maze1(){
      super(700, 550);
      super.setPlayer(new userPlayer(50,50));
      super.setComputer(new computerPlayer(500,50));
    }

    public int getTileSize(){
        return TILE_SIZE;
    }

    private GridPane grid = super.initializeLevel("level1.txt", TILE_SIZE);;

    public GridPane getGrid(){
        return grid;
    }

}
