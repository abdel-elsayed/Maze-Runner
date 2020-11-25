import javafx.scene.layout.GridPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/***
 * this is an abstract class that implements the interface board
 */
public abstract class maze implements board{

    // the width of the maze
    private int width;

    // the length of the maze
    private int length;

    // holds the maze data in array to be used when moving the user on the grid
    private int [][] data;

    // constructor
    public maze( int width, int length) {
         this.width = width;
         this.length = length;
    }

    // accessors & mutators
    public int getWidth() {
            return width;
        }
    public int getLength() {
            return length;
        }
    public void setWidth(int w) {
            width = w;
        }
    public void setLength(int l) {
            length = l;
        }
    public int [][] getDataArray(){
        return data;
    }


    // the interface methods implemented to create the gridPane for every maze of different level
    // takes the file name for the maze design
    @Override
    public GridPane initializeLevel(String fileName, int tileSize) {

        GridPane grid = new GridPane();
        tile tile;
        String file = "..\\MazeRunner\\src\\";
        file += fileName;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            Scanner sc = new Scanner(reader);
            int rows =  Integer.parseInt(sc.nextLine());
            int columns = Integer.parseInt(sc.nextLine());
            data = new int[rows][columns];
            while(sc.hasNextLine()) {
                for (int i = 0; i < data.length; i++) {
                    String[] line = sc.nextLine().trim().split("");
                    for (int j = 0; j < line.length; j++) {
                        data[i][j] = Integer.parseInt(line[j]);
                        tile = new tile(data[i][j], tileSize);
                        grid.add(tile, j, i);
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return grid;
    }


}


