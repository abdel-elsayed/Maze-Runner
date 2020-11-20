import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

    public class maze1 extends maze {


        private  int [][] data =
                { {2,2,2,2,2,2,2,2,2,2,2,2,2,2}
                        , {2,0,1,0,1,0,1,0,1,0,0,0,1,2}
                        , {2,0,1,0,0,0,1,0,1,0,1,1,1,2}
                        , {2,0,0,0,1,1,1,0,0,0,0,0,1,2}
                        , {2,0,1,0,0,0,0,0,1,1,1,0,0,2}
                        , {2,0,1,0,1,0,1,0,1,0,1,0,0,2}
                        , {2,0,1,0,1,1,1,0,1,0,0,0,1,2}
                        , {2,0,0,0,0,0,0,0,0,0,1,0,0,0}
                        , {2,0,1,1,0,0,0,0,1,1,1,0,1,2}
                        , {2,0,0,0,0,1,1,0,0,0,0,0,1,2}
                        , {2,2,2,2,2,2,2,2,2,2,2,2,2,2}
                };


        public maze1(int width, int length) {
            super(width, length);
            // TODO Auto-generated constructor stub
        }


        @Override
        public Parent createBoard() {

            GridPane grid = new GridPane();
            tile tile;
            int w = data[0].length;

            //System.out.println(data.get(0));
            for (int j = 0; j < w; j++) {
                for(int i = 0; i < data.length; i++) {
                    tile = new tile(data[i][j]);
                    grid.add(tile,j,i);
                }
            }
            return grid;
        }
    }
