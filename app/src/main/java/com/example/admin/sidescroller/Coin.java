package com.example.admin.sidescroller;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by admin on 5/15/2016.
 */
public class Coin extends Space {
    int r;

    public Coin(int x, int y, int i, int j) {
        super(x,y,i,j);
        r = 25;
    }
    void draw(Canvas c) {
        Paint ball = new Paint();
        ball.setColor(Color.YELLOW);
        c.drawCircle(x + 70, y + 80, r, ball);
    }
    //These methods help determine the class type of an element in the game array
    boolean isFree() {
        return false;
    }
    boolean isCoin() {
        return true;
    }

}
