

package com.example.admin.sidescroller;

/**
 * Created by admin on 5/15/2016.
 */
public class Level {
    Space player;
    Space bullet;
    Space newPlayer;
    Space [][] game;
    int previous=0;
    int delta = 0;
    int level=1;
    public Level(){}

    public void update( int playerIndex, int thelevel) {
        if(thelevel==level+1) {
            delta = 0;
            previous=0;
            level=thelevel;
        }
        //if the players index has changed
        if((playerIndex > previous) && playerIndex >= 4 && playerIndex < 15) {
            delta++;
            previous = playerIndex;
        }
    }
    public void loadLevel(int level) {
        int i, j;
        game = new Space[15][13];

        switch (level) {
            case 1:
                for (i = 0; i < 15; i++) {
                    game[i][9] = new Wall((i) * 135, 9 * 119,i,9);
                }


                //SPACES
                for (i = 0; i < 15; i++) {
                    for (j = 0; j < 7; j++) {
                        game[i][j] = new Space((i) * 135, j * 119, i, j);
                    }
                }
                for (i = 0; i < 14; i++) {
                    game[i][7] = new Space((i) * 135, 7 * 119, i, 7);
                }

                //COINS AND SPACES
                game[1][8] = new Space((1) * 135, 8 * 119, 1, 8);
                game[2][8] = new Space((2) * 135, 8 * 119, 2, 8);
                game[3][8] = new Coin((3) * 135, 8 * 119, 3, 8);
                game[4][8] = new Space((4) * 135, 8 * 119, 4, 8);
                game[5][8] = new Coin((5) * 135, 8 * 119, 5, 8);
                game[6][8] = new Space((6) * 135, 8 * 119, 6, 8);
                game[7][8] = new Coin((7) * 135, 8 * 119, 7, 8);
                game[8][8] = new Space((8) * 135, 8 * 119, 8, 8);
                game[9][8] = new Coin((9) * 135, 8 * 119, 9, 8);
                game[10][8] = new Space((10) * 135, 8 * 119, 10, 8);
                game[11][8] = new Coin((11) * 135, 8 * 119, 11, 8);
                game[12][8] = new Space((12) * 135, 8 * 119, 12, 8);
                game[13][8] = new Coin((13) * 135, 8 * 119, 13, 8);
                game[14][8] = new Coin((14) * 135, 8 * 119, 14, 8);

                game[0][8] = new Player(0 * 135, 8 * 119, 0, 8);
                player = game[0][8];
                // Make the arrow pad
                game[4][10] = new Wall(4 * 122, 10 * 119, 4, 10);
                game[3][11] = new Wall(3 * 122, 11 * 119, 3, 11);
                game[5][11] = new Wall(5 * 122, 11 * 119, 5, 11);
                game[4][12] = new Lives(4 * 122, 12 * 119, 4, 12);

                //Make the lives
                game[0][12] = new Lives(0 * 135, 12 * 119, 0, 12);
                game[1][12] = new Lives(1 * 135, 12 * 119, 1, 12);
                game[2][12] = new Lives(2 * 135, 12 * 119, 2, 12);


                break;
            case 2:
                for (i = 0; i < 15; i++) {
                    game[i][9] = new Wall((i) * 135, 9 * 119,i,9);
                }


                //SPACES
                for (i = 0; i < 15; i++) {
                    for (j = 0; j < 7; j++) {
                        game[i][j] = new Space((i) * 135, j * 119, i, j);
                    }
                }
                for (i = 0; i < 14; i++) {
                    game[i][7] = new Space((i) * 135, 7 * 119, i, 7);
                }

                //COINS AND SPACES
                game[1][8] = new Coin((1) * 135, 8 * 119, 1, 8);
                game[2][8] = new Space((2) * 135, 8 * 119, 2, 8);
                game[3][8] = new Coin((3) * 135, 8 * 119, 3, 8);
                game[4][8] = new Coin((4) * 135, 8 * 119, 4, 8);
                game[5][8] = new Coin((5) * 135, 8 * 119, 5, 8);
                game[6][8] = new Space((6) * 135, 8 * 119, 6, 8);
                game[7][8] = new Coin((7) * 135, 8 * 119, 7, 8);
                game[8][8] = new Space((8) * 135, 8 * 119, 8, 8);
                game[9][8] = new Coin((9) * 135, 8 * 119, 9, 8);
                game[10][8] = new Space((10) * 135, 8 * 119, 10, 8);
                game[11][8] = new Coin((11) * 135, 8 * 119, 11, 8);
                game[12][8] = new Space((12) * 135, 8 * 119, 12, 8);
                game[13][8] = new Coin((13) * 135, 8 * 119, 13, 8);
                game[14][8] = new Coin((14) * 135, 8 * 119, 14, 8);

                game[0][8] = new Player(0 * 135, 8 * 119, 0, 8);
                player = game[0][8];
                // Make the arrow pad
                game[4][10] = new Wall(4 * 122, 10 * 119, 4, 10);
                game[3][11] = new Wall(3 * 122, 11 * 119, 3, 11);
                game[5][11] = new Wall(5 * 122, 11 * 119, 5, 11);
                game[4][12] = new Lives(4 * 122, 12 * 119, 4, 12);

                //Make the lives
                game[0][12] = new Lives(0 * 135, 12 * 119, 0, 12);
                game[1][12] = new Lives(1 * 135, 12 * 119, 1, 12);
                game[2][12] = new Lives(2 * 135, 12 * 119, 2, 12);


                break;
            case 3:
                for (i = 0; i < 15; i++) {
                    game[i][9] = new Wall((i) * 135, 9 * 119,i,9);
                }


                //SPACES
                for (i = 0; i < 15; i++) {
                    for (j = 0; j < 7; j++) {
                        game[i][j] = new Space((i) * 135, j * 119, i, j);
                    }
                }
                for (i = 0; i < 14; i++) {
                    game[i][7] = new Space((i) * 135, 7 * 119, i, 7);
                }

                //COINS AND SPACES
                game[1][8] = new Coin((1) * 135, 8 * 119, 1, 8);
                game[2][8] = new Space((2) * 135, 8 * 119, 2, 8);
                game[3][8] = new Coin((3) * 135, 8 * 119, 3, 8);
                game[4][8] = new Coin((4) * 135, 8 * 119, 4, 8);
                game[5][8] = new Coin((5) * 135, 8 * 119, 5, 8);
                game[6][8] = new Space((6) * 135, 8 * 119, 6, 8);
                game[7][8] = new Coin((7) * 135, 8 * 119, 7, 8);
                game[8][8] = new Space((8) * 135, 8 * 119, 8, 8);
                game[9][8] = new Coin((9) * 135, 8 * 119, 9, 8);
                game[10][8] = new Space((10) * 135, 8 * 119, 10, 8);
                game[11][8] = new Coin((11) * 135, 8 * 119, 11, 8);
                game[12][8] = new Space((12) * 135, 8 * 119, 12, 8);
                game[13][8] = new Coin((13) * 135, 8 * 119, 13, 8);
                game[14][8] = new Coin((14) * 135, 8 * 119, 14, 8);

                game[0][8] = new Player(0 * 135, 8 * 119, 0, 8);
                player = game[0][8];
                // Make the arrow pad
                game[4][10] = new Wall(4 * 122, 10 * 119, 4, 10);
                game[3][11] = new Wall(3 * 122, 11 * 119, 3, 11);
                game[5][11] = new Wall(5 * 122, 11 * 119, 5, 11);
                game[4][12] = new Lives(4 * 122, 12 * 119, 4, 12);

                //Make the lives
                game[0][12] = new Lives(0 * 135, 12 * 119, 0, 12);
                game[1][12] = new Lives(1 * 135, 12 * 119, 1, 12);
                game[2][12] = new Lives(2 * 135, 12 * 119, 2, 12);

                break;
        }

    }

    public Space [][] getMap(){
        return game;
    }
    public Space [][] getNewMap( Space[][] newGame,Space nePlayer, int IndX) {
        int i, j;
        if ( IndX>= 0 && IndX < 4) {
            for (i = 0; i < 15; i++) {
                for (j = 0; j < 9; j++) {
                    newGame[i][j].x = i * 135;
                }
            }
        } else if (IndX >= 4 && IndX < 15) {
            for (i = 0; i < 15; i++) {
                for (j = 0; j < 9; j++) {
                    newGame[i][j].x = (-delta + i) * 135;
                    newPlayer = newGame[IndX][8];
                }
            }
        }
        return newGame;
    }

    public Space getPlayer() {
        return player;
    }
    public Space getBullet(){
        return bullet;
    }
    public Space getNewPlayer() {
        return newPlayer;
    }

}

