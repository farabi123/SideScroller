package com.example.admin.sidescroller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by admin on 5/10/2016.
 */


// This is the ‘‘game engine ’ ’.
public class ScrollerView extends SurfaceView implements SurfaceHolder.Callback {
    public ScrollerView(Context context) {
        super(context);
        // Notify the SurfaceHolder that you’d like to receive // SurfaceHolder callbacks .
        getHolder().addCallback(this);
        setFocusable(true);
    }
//500, 600, 1000, 900
    public static final float Width = 500;
    public static final float Height = 600;
    Background bgd;
    ScrollerThread st;
    int i, j;
    Space[][] game;
    Space player;
    Space bullet;
    Space life;
    Space bulletplayer;
    float Dx, Dy;
    int count=0;
    int countt=0;
    int counter=0;
    int countCoins=0;
    int countDeaths=0;
    int x_r= 5*122;
    int y_r= 11*119;
    int x_l= 3*122;
    int y_l= 11*119;
    int x_u= 4*122;
    int y_u= 10*119;
    int x_d= 4*122;
    int y_d= 12*119;
    boolean upward = false;
    boolean downward = false;
    boolean canFire = true;
    boolean killedOpponent=false;
    boolean playerCanFire = true;
    boolean deadPlayer=false;
    Level level;
    long time1=0;
    int PlayerIndexX=0;
    int BulletIndexX=0;
    boolean reset=false;
    int newLevel=1;


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //Construct game initial state .
        // Launch animator thread .
        // Allocating memory for alien called instance
        bgd=new Background(BitmapFactory.decodeResource(getResources(), R.drawable.waterfall));
        bgd.setPosition(-5);
        level= new Level();
        level.loadLevel(1);
        game=level.getMap();
        player=level.getPlayer();
        bullet=level.getBullet();

        st = new ScrollerThread(this);
        st.start();
    }

    @Override
    public void draw(Canvas c) {
        final float scalingFactorX = getWidth() / Width;
        final float scalingFactorY = getHeight() / Height;

        if (c != null) {
            final int savedState = c.save();
            c.scale(scalingFactorX, scalingFactorY);
            bgd.draw(c);
            c.restoreToCount(savedState);
        }

        if (reset && !deadPlayer) {
            System.out.println("RESET THE FUCKING LEVEL");
            level.loadLevel(newLevel);
            /*if (countDeaths == 1) {
                game[2][12] = new Wall(2 * 135, 12 * 119, 2, 12);
            } else if (countDeaths == 2) {
                game[1][12] = new Wall(1 * 135, 12 * 119, 1, 12);
                game[2][12] = new Wall(2 * 135, 12 * 119, 2, 12);
            } else if (countDeaths == 3) {
                game[0][12] = new Wall(0 * 135, 12 * 119, 0, 12);
                game[1][12] = new Wall(1 * 135, 12 * 119, 1, 12);
                game[2][12] = new Wall(2 * 135, 12 * 119, 2, 12);
            }*/
            game = level.getMap();
            player = level.getPlayer();
            // bullet=level.getBullet();
            reset = false;
        }
        bgd.update(player.x);


        for (i = 0; i < 15; i++) {
            for (j = 0; j < 13; j++) {
                if (game[i][j] != null) {
                    game[i][j].draw(c);
                }
            }
        }
        boolean complete = checkLevelComplete();
        //System.out.println("COMPLETE? "+complete);
        if (complete) {
            newLevel = newLevel + 1;
            System.out.println("NEW LEVEL=" + newLevel);
            level.loadLevel(newLevel);
            game = level.getMap();
            player = level.getPlayer();
            //bullet=level.getBullet();
        }
        Bitmap fire = BitmapFactory.decodeResource(getResources(), R.drawable.fire);
        Bitmap dino = BitmapFactory.decodeResource(getResources(), R.drawable.dino);
        Bitmap one = BitmapFactory.decodeResource(getResources(), R.drawable.one);
        Bitmap two = BitmapFactory.decodeResource(getResources(), R.drawable.two);
        Bitmap three = BitmapFactory.decodeResource(getResources(), R.drawable.three);
        Bitmap fireball = BitmapFactory.decodeResource(getResources(), R.drawable.firebullet);

        c.drawBitmap(fire, null, game[7][8].space_rect, null);
        if (!deadPlayer) {
            c.drawBitmap(dino, null, player.space_rect, null);
            //c.drawBitmap(fireball, null, bullet.space_rect, null);
        }

        if(countDeaths==0){
            c.drawBitmap(dino, null, game[0][12].space_rect, null);
            c.drawBitmap(dino, null, game[1][12].space_rect, null);
            c.drawBitmap(dino, null, game[2][12].space_rect, null);
        }
        else if(countDeaths==1) {
            c.drawBitmap(dino, null, game[0][12].space_rect, null);
            c.drawBitmap(dino, null, game[1][12].space_rect, null);
        }
        else if(countDeaths==2) {
            c.drawBitmap(dino, null, game[0][12].space_rect, null);
        }


        if(newLevel==1) {
            c.drawBitmap(one, null, game[4][12].space_rect, null);
        }
        else if(newLevel==2) {
            c.drawBitmap(two, null, game[4][12].space_rect, null);
        }
        else if(newLevel==3) {
            c.drawBitmap(three, null, game[4][12].space_rect, null);
        }
        opponentShoot();
        //playerShoot();

        //PlayerIndexX=player.Xindex;
        //BulletIndexX=bullet.Xindex;
      //  level.update(PlayerIndexX, newLevel);
       // game=level.getNewMap(game,player,PlayerIndexX);
       /// player=level.getNewPlayer();
       /// System.out.println("player x position after is="+player.x);
        //bullet=level.getNewBullet();


    }//END OF DRAWING


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // Respond to surface changes , e.g. ,
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // The cleanest way to stop a thread is by interrupting it.
        // SpaceThread regularly checks its interrupt flag.
        st.interrupt();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {

        int action = e.getAction();
        switch (action) {

            case MotionEvent.ACTION_DOWN:
                System.out.println("CLICK DOWN");
                Dx = e.getX();
                Dy = e.getY();
                //System.out.println("player x after getnewplayer="+player.x);
                int indexX = player.Xindex;
                int indexY = player.Yindex;
                System.out.println("indexX"+indexX);
                System.out.println("IndexY"+indexY);

                //System.out.println("click down can_fire: "+canFire);
                if(playerCanFire) {
                    if (Dx >= x_u && Dx <= (x_u + 125) && Dy >= (y_u + 50) && Dy <= (y_u + 145)) {
                        System.out.println("CLICK SHOOT");
                        //game[indexX+1][indexY]= new BulletPlayer(player.x+90, player.y);
                        bulletplayer= game[indexX+1][indexY];
                        playerCanFire = false;
                        //counter++;
                    }
                }
                downward = true;
                upward= false;

                //Move method called here depending on which arrow pad is clicked
                if (Dx >= x_r && Dx <= (x_r + 125) && Dy >= (y_r + 50) && Dy <= (y_r + 145)) {
                    System.out.println("CLICK RIGHT");
                    move(indexX, indexY, indexX + 1, indexY);
                }
                if (Dx >= x_l && Dx <= (x_l + 125) && Dy >= (y_l + 50) && Dy <= (y_l + 145)) {
                    System.out.println("CLICK LEFT");
                    move(indexX, indexY, indexX - 1, indexY);
                }
                break;
            //(This case is not used for anything)
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }



    //Move method body
    public void move(int from_x, int from_y, int to_x, int to_y) {
        System.out.println("fromx="+from_x);
        System.out.println("tox="+to_x);
        System.out.println("CLASS IN MOVE from: "+String.valueOf(game[from_x][from_y].getClass()));
        System.out.println("CLASS IN MOVE to: "+String.valueOf(game[to_x][to_y].getClass()));
        if (game[to_x][to_y].isFree()) {
            game[to_x][to_y] = new Player(to_x * 135, to_y * 119, to_x,to_y);
            System.out.println("CLASS is now: "+String.valueOf(game[to_x][to_y].getClass()));
            player = game[to_x][to_y];
        }
         if (game[from_x][from_y].isPlayer()) {
            game[from_x][from_y] = new Space(from_x * 135, from_y * 119,from_x,from_y);
        }
        if (game[to_x][to_y].isCoin()) {
            game[to_x][to_y] = new Player(to_x * 135, to_y * 119, to_x,to_y);
            player = game[to_x][to_y];
        }
        if (game[to_x][to_y].isOpponent()){
            countDeaths++;
            System.out.println("countdeaths"+countDeaths);
                if(countDeaths<3) {
                    reset=true;
                    System.out.println("RESET="+reset);

                if(countDeaths==1) {
                    System.out.println("HE DIED ONCE=");
                }
                else if(countDeaths==2) {
                    System.out.println("HE DIED TWICE=");
                }
            } else if(countDeaths>=3){
                    reset=false;
                canFire=false;
                game[to_x][to_y] = new DeadPlayer(to_x * 135, to_y * 119, to_x,to_y);
                deadPlayer=true;
            }
        }
    }

    //opponent shooting method
    public void opponentShoot() {

        //long time2 = System.currentTimeMillis()/1000;

        //long timeDifference=time2-time1;
        //System.out.println("time in seconds="+timeDifference);
        if (canFire) {
            //&& timeDifference%3==0) {
            //time1= System.currentTimeMillis()/1000;
            game[6][8] = new Bullet(6 * 135, 8 * 119, 6, 8);
            bullet = game[6][8];
            canFire = false;
            System.out.println("MADE THE BULLET");

        }
        count = bullet.move();
        int fromX = bullet.x/135 + 2;
        int fromY = bullet.y/119;
        int toX = fromX - 1;
        System.out.println("count=" + count);
        System.out.println("bullet x=" + bullet.x);
        //System.out.println("bulletplayer y=" + bulletplayer.y);
        System.out.println("fromX=" + fromX);
        System.out.println("toX=" + toX);
        if (bullet.x == -45) {
            fromX = 1;
            toX = 0;
            count = 4;
        }

        if (count == 4) {
            if (game[toX][fromY].isPlayer() && killedOpponent == false) {
                game[fromX][fromY] = new Space(fromX * 135, fromY * 119, fromX, fromY);
                game[toX][fromY] = new Space(toX * 135, fromY * 119, toX, fromY);
                countDeaths++;
                System.out.println("countdeaths" + countDeaths);
                if (countDeaths < 3) {
                    reset = true;
                    System.out.println("RESET=" + reset);
                    if (countDeaths == 1) {
                        System.out.println("HE DIED ONCE bullet=");
                    } else if (countDeaths == 2) {
                        System.out.println("HE DIED TWICE bullet=");
                    }
                    canFire = true;
                } else if (countDeaths >= 3) {
                    deadPlayer = true;
                    reset = false;
                    canFire = false;
                    playerCanFire = false;
                    game[toX][fromY] = new DeadPlayer((toX) * 135, fromY * 119, toX, fromY);

                }
            }

            /*else if (game[toX][fromY].isPlayer() && killedOpponent==true) {
                System.out.print("he thinks it's a free space after killing the opponent");
                game[fromX][fromY] = new Space(fromX * 135, fromY * 119);
                game[toX][fromY] = new Space(fromX * 135, fromY * 119);
                canFire=false;
                playerCanFire=true;
            }*/
            else if (game[toX][fromY].isFree()) {
                game[toX][fromY] = new Bullet(toX * 135, fromY * 119, toX, fromY);
                bullet = game[toX][fromY];
                game[fromX][fromY] = new Space(fromX * 135, fromY * 119, fromX, fromY);
                canFire = false;
            } else {
                System.out.print("he thinks it's something ELSE");
                System.out.println("CLASS ELSE: " + String.valueOf(game[toX][fromY].getClass()));
            }
        }
    }
            /*else if(game[toX][fromY].isBulletPlayer()) {
                game[toX][fromY] = new Space(toX * 135, fromY * 119);
                game[fromX][fromY] = new Space(fromX * 135, fromY * 119);
                canFire=true;
                playerCanFire = true;
            }*?
    }

    //Player shooting method
    /*public void playerShoot(){
        countt = bulletplayer.move();
        int fromXp = bulletplayer.x / 135;
        int fromYp = bulletplayer.y / 119;
        int toXp = fromXp + 1;

        if (countt == 2) {
            if(game[toXp][fromYp].isOpponent()){
                game[toXp][fromYp] = new Space(toXp * 135, fromYp * 119);
                game[fromXp][fromYp] = new Space(fromXp * 135, fromYp * 119);
                canFire=false;
                playerCanFire = true;
                killedOpponent=true;
            }
            else if (game[toXp][fromYp].isFree()) {
                game[toXp][fromYp] = new BulletPlayer(toXp * 135, fromYp * 119);
                bulletplayer = game[toXp][fromYp];
                game[fromXp][fromYp] = new Space(fromXp * 135, fromYp * 119);
                playerCanFire= false;
            }
            else if(game[toXp][fromYp].isBullet()) {
                game[toXp][fromYp] = new Space(toXp * 135, fromYp * 119);
                game[fromXp][fromYp] = new Space(fromXp * 135, fromYp * 119);
                canFire=true;
                playerCanFire = true;
            }
        }
        return;
    }*/
    //Check if level is complete method bode
    public boolean checkLevelComplete(){
        countCoins=0;
        for (i = 0; i < 15; i++) {
            for (j = 0; j < 13; j++) {
                if (game[i][j] != null) {
                    if (game[i][j].isCoin()) {
                        countCoins++;
                        //System.out.println("COUNT COINS INSIDE CHECKING FUNCTION"+countCoins);
                    }
                }
            }
        }
        //System.out.println("COUNT COINS BEFORE IF "+countCoins);
        if (countCoins == 0) {
            return true;
        }
        return false;
    }
}

