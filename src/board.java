import javafx.scene.layout.GridPane;

/**
 * interface Board that has the initialization method for the board
 */
public interface board {
    public GridPane initializeLevel(String fileName, int tileSize);
}