import javafx.scene.Group;
import javafx.scene.layout.GridPane;

public class maze1 extends maze {

        private userPlayer player;
        private Character computer;
        private Group tileGroup = new Group();
        private Group CharacterGroup = new Group();

        public userPlayer getPlayer()
        {
          return player;
        };

        public Character getComputer()
        {
            return computer;
        };

        private  int [][] data =
                        { {1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                        , {1,2,1,0,1,0,1,0,1,0,0,0,3,1}
                        , {1,0,1,0,0,0,1,0,1,0,1,1,1,1}
                        , {1,0,0,0,1,1,1,0,0,0,0,0,0,1}
                        , {1,0,1,0,0,0,0,0,1,1,1,1,0,1}
                        , {1,0,1,0,1,0,1,0,1,0,1,0,0,1}
                        , {1,0,1,0,1,1,1,0,1,0,0,0,1,1}
                        , {1,0,0,0,0,1,0,0,1,0,1,0,0,0}
                        , {1,0,1,1,0,1,0,0,1,1,1,0,0,1}
                        , {1,0,0,1,0,1,1,0,0,0,0,0,0,1}
                        , {1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                };

            //
        public maze1(int width, int length) {
            super(width, length);
            // TODO Auto-generated constructor stub
        }


        @Override
        public GridPane createBoard() {

            GridPane grid = new GridPane();
            tile tile;
            int w = data[0].length;

            for (int j = 0; j < w; j++) {
                for(int i = 0; i < data.length; i++) {
                    if(data[i][j] == 2){
                        player = new userPlayer(i,j);
                        System.out.println(player.getRow());
                        grid.add(player, j, i);
                    }else{
                    tile = new tile(data[i][j]);
                    grid.add(tile, j, i);
                    }
                }
            }
            return grid;
        }
    }
