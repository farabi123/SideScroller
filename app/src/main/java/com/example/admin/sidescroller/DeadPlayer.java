package com.example.admin.sidescroller;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by admin on 5/14/2016.
 */
public class DeadPlayer extends Space {
    int r;
    public DeadPlayer(int x, int y, int i, int j) {
        super(x, y,i,j);
        r = 45;
    }
    void draw(Canvas c) {
        Paint ball = new Paint();
        ball.setColor(Color.RED);
        c.drawCircle(x + 70, y + 80, r, ball);
    }

    //These methods help determine the class type of an element in the game array
    boolean isFree() {
        return false;
    }
    boolean isDeadPlayer() {
        return true;
    }
}
