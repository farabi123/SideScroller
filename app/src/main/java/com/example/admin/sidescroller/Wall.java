package com.example.admin.sidescroller;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Wall extends Space {
    public Wall(int x, int y, int i, int j) {
        super( x, y,i,j);
    }

    void draw(Canvas c) {
        Paint wall = new Paint();
        wall.setColor(Color.WHITE);
        c.drawRect(x, y+50, x + 125, y + 145, wall);
    }
    //These methods help determine the class type of an element in the game array
    boolean isFree() {
        return false;
    }
    boolean isWall(){return true;}
}