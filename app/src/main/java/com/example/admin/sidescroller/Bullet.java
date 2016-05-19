package com.example.admin.sidescroller;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by admin on 5/12/2016.
 */

public class Bullet extends Space {
    int r;
    int counter;

    public Bullet(int x_pos, int y_pos, int i, int j) {
        super( x_pos, y_pos, i,j);
        counter=0;
        y = y_pos;
        x = x_pos;
        r=15;
    }

    void draw(Canvas c) {
        Paint ball = new Paint();
        ball.setColor(Color.BLACK);
        c.drawCircle(x+120, y+80, r, ball);
        //space_rect = new Rect(x, y+100, x + 80, y + 145);
    }

    int move() {
        if(counter<=9 ){
        x = x - 15;
        counter++;}
       return counter;
    }
    //These methods help determine the class type of an element in the game array
    boolean isFree() {
        return false;
    }
    boolean isBullet(){
        return true;
    }
}
