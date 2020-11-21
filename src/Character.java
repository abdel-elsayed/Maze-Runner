import javafx.scene.shape.Rectangle;

public abstract class Character extends Rectangle {
    private String type;
    protected boolean isWin;

    public  Character(){};
    public  Character(String type) {
          this.type = type;
    }

    public String getType() {
      return this.type;
    }
    public abstract void move(char dir);

}