package com.example.admin.sidescroller;

/**
 * Created by admin on 5/15/2016.
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class BulletPlayer extends Space {
    int r;
    int counting;

    public BulletPlayer(int x, int y, int i, int j) {
        //x-pos and y-pos are coordinates of opponent
        super( x, y, i, j);
        counting=0;
        r=15;
    }
    void draw(Canvas c) {
        Paint ball = new Paint();
        ball.setColor(Color.RED);
        c.drawCircle(x+70, y+80, r, ball);
    }

    int move() {
        if(counting<=2 ){
            x = x + 45;
            counting++;}
        return counting;
    }

    //These methods help determine the class type of an element in the game array
    boolean isFree() {return false;}
    boolean isBulletPlayer(){return true;}
}
