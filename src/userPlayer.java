import javafx.scene.paint.Color;

public class userPlayer extends Character {
    private int row;
    private int col;


    public userPlayer(int r, int c){
        row = r;
        col = c;
        setFill(Color.valueOf("#6495ED"));
    };

    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }

    public void setRow(int r){
        row = r;
    }
    public void setCol(int c){
        col = c;
    }


    @Override
    public void move(char dir){

        if (dir == 'u') {
            System.out.println("am moving upwards");
            System.out.println(row);
            System.out.println(col);

        }
    }
}
