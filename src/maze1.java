import javafx.scene.layout.GridPane;

public class maze1 extends maze {
    // tile size
    private int TILE_SIZE = 50;
    //private Rectangle player = new Rectangle(50,50, 50, 50);

    private Character player = new userPlayer(TILE_SIZE,TILE_SIZE);
    //private Character computer = new computer(50,50);

    // constructor
    public maze1(){
      super(700, 550);
    }

    public Character getPlayer(){
        return player;
    }

    /*
    public Character getComputer() {
        return computer;
    }*/

    public int getTileSize(){
        return TILE_SIZE;
    }

    private GridPane grid = super.initializeLevel("level1.txt", TILE_SIZE);;

    public GridPane getGrid(){
        return grid;
    }

}
