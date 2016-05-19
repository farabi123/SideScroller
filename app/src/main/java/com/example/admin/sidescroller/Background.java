package com.example.admin.sidescroller;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by admin on 5/11/2016.
 */
public class Background {
    private Bitmap image;
    private float x,y, xPos;

    public Background(Bitmap res){
     image=res;
    }

    public void setPosition(int xPos){
        this.xPos=xPos;
    }

    public void update(float PlayerX){
        //x=x+xPos;
        x=xPos-PlayerX;
        if(x < -ScrollerView.Width) {
            x = 0;
        }
    }

    public void draw(Canvas c) {
        c.drawBitmap(image, x, y, null);
        if (x < 0) {
            c.drawBitmap(image, x+ ScrollerView.Width, y, null);
        }
    }
}
