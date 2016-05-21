package com.example.admin.sidescroller;

        import android.graphics.Bitmap;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.Rect;

/**
 * Created by admin on 5/10/2016.
 */

public class Player extends Space{
    int r;
    int county;
    public Player(int x, int y, int i, int j) {
        super(x, y,i,j);
        r = 45;
        county=0;
    }

    void draw(Canvas c)
    {
        //Paint ball = new Paint();
        //ball.setColor(Color.BLUE);
        //c.drawCircle(x+70, y+80, r, ball);
        space_rect = new Rect(x, y+50, x + 125, y + 145);
    }

    //These methods help determine the class type of an element in the game array
    boolean isFree() {return false;}
    boolean isPlayer(){return true;}
}