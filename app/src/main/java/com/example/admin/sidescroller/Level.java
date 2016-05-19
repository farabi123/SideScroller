

package com.example.admin.sidescroller;

/**
 * Created by admin on 5/15/2016.
 */
public class Level {
    Space player;
    Space bullet;
    Space newPlayer;
    Space newBullet;
    Space [][] game;
    int previous=0;
    int delta = 0;
    public Level(){}

    public void update( int playerIndex) {
        //int i, j;
        //if the players index has changed
        if(playerIndex > previous && playerIndex >= 4 && playerIndex < 15) {
            System.out.println("previous >=" + previous);
            System.out.println("playerIndex >=" + playerIndex);
            delta++;
            System.out.println("delta >=" + delta);
            previous = playerIndex;
        }
        // else if(playerIndex < previous) {
        // System.out.println("previous <=" + previous);
        //   System.out.println("playerIndex <=" + playerIndex);
        //delta--;
        //System.out.println("delta <=" + delta);
        //previous = playerIndex;
        //}
    }
    public void loadLevel(int level) {
        int i, j;
        System.out.println("delta inside loadlevel=" + delta);
        game = new Space[20][13];

        switch (level) {
            case 1:
                game[0][8] = new Player((0) * 135, 8 * 119, 0, 8);
                player = game[0][8];
                // Make the arrow pad
                game[4][10] = new Wall(4 * 122, 10 * 119, 4, 10);
                game[3][11] = new Wall(3 * 122, 11 * 119, 3, 11);
                game[5][11] = new Wall(5 * 122, 11 * 119, 5, 11);
                game[4][12] = new Wall(4 * 122, 12 * 119, 4, 12);



/*
                //SPACES
                for (i = 0; i < 20; i++) {
                    for (j = 0; j < 8; j++) {
                        game[i][j] = new Space((i) * 135, j * 119, i, j);
                    }
                }
*/

               /* game[1][8] = new Space((1) * 135, 8 * 119, 1, 8);
                game[2][8] = new Space((2) * 135, 8 * 119, 2, 8);
                game[6][8] = new Space((6) * 135, 8 * 119, 6, 8);
*/

                //COINS
  /*              game[3][8] = new Coin((3) * 135, 8 * 119, 3, 8);
                game[4][8] = new Coin((4) * 135, 8 * 119, 4, 8);
                game[5][8] = new Coin((5) * 135, 8 * 119, 5, 8);
                game[8][8] = new Coin((8) * 135, 8 * 119, 8, 8);

*/


                /*//Make the lives
                game[0][12] = new Lives(0 * 135, 12 * 119, 0, 12);
                game[1][12] = new Lives(1 * 135, 12 * 119, 1, 12);
                game[2][12] = new Lives(2 * 135, 12 * 119, 2, 12);*/

//PLAYER

                break;
            case 2:
                for (i = 0; i < 20; i++) {
                    game[i][9] = new Wall((i) * 135, 9 * 119, i, 9);
                }

             /*   //SPACES
                for (i = 0; i < 20; i++) {
                    for (j = 0; j < 8; j++) {
                        game[i][j] = new Space((i) * 135, j * 119, i, j);
                    }
                }*/
/*
                //COINS AND SPACES
                game[1][8] = new Coin((1) * 135, 8 * 119, 1, 8);
                game[2][8] = new Coin((2) * 135, 8 * 119, 2, 8);
                game[3][8] = new Space((3) * 135, 8 * 119, 3, 8);
                game[4][8] = new Coin((4) * 135, 8 * 119, 4, 8);
                game[5][8] = new Coin((5) * 135, 8 * 119, 5, 8);
                game[6][8] = new Space((6) * 135, 8 * 119, 6, 8);
                game[7][8] = new Coin((7) * 135, 8 * 119, 7, 8);
                game[8][8] = new Space((8) * 135, 8 * 119, 8, 8);
                game[9][8] = new Coin((9) * 135, 8 * 119, 9, 8);
                game[10][8] = new Space((10) * 135, 8 * 119, 10, 8);
                game[11][8] = new Space((11) * 135, 8 * 119, 11, 8);
                game[12][8] = new Coin((12) * 135, 8 * 119, 12, 8);
                game[13][8] = new Space((13) * 135, 8 * 119, 13, 8);
                game[14][8] = new Coin((14) * 135, 8 * 119, 14, 8);
                game[15][8] = new Space((15) * 135, 8 * 119, 15, 8);
                game[16][8] = new Coin((16) * 135, 8 * 119, 16, 8);
                game[17][8] = new Space((17) * 135, 8 * 119, 17, 8);
                game[18][8] = new Space((18) * 135, 8 * 119, 18, 8);
                game[19][8] = new Coin((19) * 135, 8 * 119, 19, 8);
                //PLAYER
                game[0][8] = new Player((0) * 135, 8 * 119, 0, 8);
                player = game[0][8];

                // Make the arrow pad
                game[4][10] = new Wall(4 * 122, 10 * 119, 4, 10);
                game[3][11] = new Wall(3 * 122, 11 * 119, 3, 11);
                game[5][11] = new Wall(5 * 122, 11 * 119, 5, 11);
                game[4][12] = new Wall(4 * 122, 12 * 119, 4, 12);
                //Make the lives
                game[0][12] = new Lives(0 * 135, 12 * 119, 0, 12);
                game[1][12] = new Lives(1 * 135, 12 * 119, 1, 12);
                game[2][12] = new Lives(2 * 135, 12 * 119, 2, 12);
*/
               break;
/*            case 3:

                for (i = 0; i < 20; i++) {
                    game[i][9] = new Wall((i) * 135, 9 * 119, i, 9);
                }

                //SPACES
                for (i = 0; i < 20; i++) {
                    for (j = 0; j < 8; j++) {
                        game[i][j] = new Space((i) * 135, j * 119, i, j);
                    }
                }

             /*   //COINS AND SPACES
                game[1][8] = new Space((1) * 135, 8 * 119, 1, 8);
                game[2][8] = new Space((2) * 135, 8 * 119, 2, 8);
                game[3][8] = new Coin((3) * 135, 8 * 119, 3, 8);
                game[4][8] = new Coin((4) * 135, 8 * 119, 4, 8);
                game[5][8] = new Coin((5) * 135, 8 * 119, 5, 8);
                game[6][8] = new Space((6) * 135, 8 * 119, 6, 8);

                game[8][8] = new Coin((8) * 135, 8 * 119, 8, 8);
                game[9][8] = new Space((9) * 135, 8 * 119, 9, 8);
                game[10][8] = new Space((10) * 135, 8 * 119, 10, 8);
                game[11][8] = new Space((11) * 135, 8 * 119, 11, 8);
                game[12][8] = new Space((12) * 135, 8 * 119, 12, 8);
                game[13][8] = new Space((13) * 135, 8 * 119, 13, 8);
                game[14][8] = new Space((14) * 135, 8 * 119, 14, 8);
                game[15][8] = new Space((15) * 135, 8 * 119, 15, 8);
                game[16][8] = new Space((16) * 135, 8 * 119, 16, 8);
                game[17][8] = new Space((17) * 135, 8 * 119, 17, 8);
                game[18][8] = new Space((18) * 135, 8 * 119, 18, 8);
                game[19][8] = new Space((19) * 135, 8 * 119, 19, 8);


                //OPPONENT
                game[7][8] = new Opponent((7) * 135, 8 * 119, 7, 8);

                //PLAYER
                game[0][8] = new Player((0) * 135, 8 * 119, 0, 8);
                player = game[0][8];

                // Make the arrow pad
                game[4][10] = new Wall(4 * 122, 10 * 119, 4, 10);
                game[3][11] = new Wall(3 * 122, 11 * 119, 3, 11);
                game[5][11] = new Wall(5 * 122, 11 * 119, 5, 11);
                game[4][12] = new Wall(4 * 122, 12 * 119, 4, 12);
                //Make the lives
                game[0][12] = new Lives(0 * 135, 12 * 119, 0, 12);
                game[1][12] = new Lives(1 * 135, 12 * 119, 1, 12);
                game[2][12] = new Lives(2 * 135, 12 * 119, 2, 12);
                break;*/
        }

    }

    public Space [][] getMap(){
        return game;
    }
    public Space [][] getNewMap( Space[][] newGame, Space newplayer, int IndX, int bulletIndX) {
        int i, j;
        if ( IndX>= 0 && IndX < 4) {
            // System.out.println("BEGININNING SCREEN");
            for (i = 0; i < 20; i++) {
                for (j = 0; j < 9; j++) {
                    newGame[i][j].x = i * 135;
                }
            }
        } else if (IndX >= 4 && IndX < 20) {
            for (i = 0; i < 20; i++) {
                for (j = 0; j < 9; j++) {
                    newGame[i][j].x = (-delta + i) * 135;
                    newPlayer = newGame[IndX][8];
                    newBullet = newGame[bulletIndX][8];
                    //System.out.println("MIDDLE SCREEN");
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
    public Space getNewBullet() {
        return newBullet;
    }

}

