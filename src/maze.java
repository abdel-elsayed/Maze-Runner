import javafx.scene.layout.GridPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


/***
 * this is an abstract class that implements the interface board
 */
public abstract class maze implements board{

    //the x&y coordinates of the win tile
    int winX, winY;

    // the width of the maze
    private int width;

    // the length of the maze
    private int length;

    // holds the maze data in array to be used when moving the user on the grid
    private int [][] data;

    //teleporting tiles coordinates
    public int tele1X;
    public int tele1Y;
    public int tele2X;
    public int tele2Y;


    // constructor
    public maze( int width, int length) {
         this.width = width;
         this.length = length;

    }

    // the game characters
    private Character player;
    private Character computer;
    //additional game monsters
    private Character computer2;
    private Character computer3;
    private Character computer4;

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
    public Character getPlayer(){  return player;}
    public Character getComputer() { return computer; }
    public void setPlayer(Character p){player = p;}
    public void setComputer(Character c){computer = c;}

    //added to set more monsters
    public void setComputer2(Character c){computer2 = c;}
    public void setComputer3(Character c){computer3 = c;}
    public void setComputer4(Character c){computer4 = c;}

    //added to get more monsters
    public Character getComputer2() { return computer2; }
    public Character getComputer3() { return computer3; }
    public Character getComputer4() { return computer4; }

    public int [][] getDataArray(){
        return data;
    }

    public abstract int getTileSize();

    // the interface methods implemented to create the gridPane for every maze of different level
    // takes the file name for the maze design
    @Override
    public GridPane initializeLevel(String fileName, int tileSize) {

        GridPane grid = new GridPane();
        tile tile;
        String file = "\\C:\\Users\\Haysus\\IdeaProjects\\Maze-Runner\\src\\";
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
                        if(data[i][j] == 2)
                            {
                            winY = i*tileSize;
                            winX = j*tileSize;
                        }else if(data[i][j] == 5)
                        {
                            tele1X = j*tileSize;
                            tele1Y = i*tileSize;
                        }else if(data[i][j] == 6)
                        {
                            tele2X = j*tileSize;
                            tele2Y = i*tileSize;
                        }
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


