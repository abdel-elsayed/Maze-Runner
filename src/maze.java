import javafx.scene.layout.GridPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
/***
 * this is an abstract class that implements the interface board
 * and creates the maze board
 */
public abstract class maze implements board{

    //the x&y coordinates of the win tile
    private int winX, winY;

    // the width of the maze
    private int width;

    // the length of the maze
    private int length;

    // holds the maze data in array to be used when moving the user on the grid
    private int [][] data;

    private GridPane grid;
    //teleporting tiles coordinates
    public int tele1X;
    public int tele1Y;
    public int tele2X;
    public int tele2Y;

    public maze(){

    }

    // constructor
    public maze( int width, int length, int diff, String filename, int tileSize) {
         this.width = width;
         this.length = length;
         grid = initializeLevel(diff, filename, tileSize);
    }

    // the game characters
    private Character player;
    private Character computer;
    //additional game monsters
    private Character computer2;
    private Character computer3;
    private Character computer4;
    private Character computer5;
    private Character computer6;

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
    public int getWinX(){return winX;}
    public int getWinY(){return winY;}
    public Character getPlayer(){  return player;}
    public void setPlayer(Character p){player = p;}
    public void setWinY(int w){winY = w;}
    public void setWinX(int w){winX = w;}
    //added to set more monsters
    public void setComputer(Character c){computer = c;}
    public void setComputer2(Character c){computer2 = c;}
    public void setComputer3(Character c){computer3 = c;}
    public void setComputer4(Character c){computer4 = c;}
    public void setComputer5(Character c){computer5 = c;}
    public void setComputer6(Character c){computer6 = c;}
    //added to get more monsters
    public Character getComputer() { return computer; }
    public Character getComputer2() { return computer2; }
    public Character getComputer3() { return computer3; }
    public Character getComputer4() { return computer4; }

    public Character getComputer5() { return computer5; }
    public Character getComputer6() { return computer6; }

    // returns the maze grid
    public GridPane getGrid(){
        return grid;
    }

    // the back-ground array of data to move players
    public int [][] getDataArray(){
        return data;
    }

    // abstract function
    public abstract int getTileSize();

    /**
     * implements the parent's class method and creates the grid of the maze from a text file input
     * @param fileName the file that has the design of the maze
     * @param tileSize the size of each tile that sets the size of the grid
     * @return a grid with the maze
     */
    @Override
    public GridPane initializeLevel(int diff, String fileName, int tileSize) {

        GridPane grid = new GridPane();
        tile tile;
        String file = "/Users/abdelrahmanelsayed/Desktop/IdeaProjects/Maze-Runner/src/";
        file += fileName;
        try{
            // reading the data from file
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
                        if(data[i][j] == 2) // if the tile is exit
                            {
                            winY = i*tileSize;
                            winX = j*tileSize;
                        }else if(data[i][j] == 5) // if tile is the teleporting 1 tile
                        {
                            tele1X = j*tileSize;
                            tele1Y = i*tileSize;
                        }else if(data[i][j] == 6) // if tile is the teleporting 2 tile
                        {
                            tele2X = j*tileSize;
                            tele2Y = i*tileSize;
                        }
                        tile = new tile(diff,data[i][j], tileSize);
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


