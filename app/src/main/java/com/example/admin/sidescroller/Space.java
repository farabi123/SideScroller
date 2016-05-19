package com.example.admin.sidescroller;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Space {
        public int x, y,Xindex,Yindex;
        public Rect space_rect;

            public Space(int x, int y, int Xindex, int Yindex) {
                this.x = x;
                this.y = y;
                this.Xindex=Xindex;
                this.Yindex=Yindex;
            }
            void draw(Canvas c) {
                Paint space = new Paint();
                space.setColor(Color.WHITE);
                c.drawRect(x, y, x + 140, y + 145, space);
            }
    int move(){
        return -1;
    }
    boolean outOfBox(){
        return false;
    }
    int jump(){
        return -1;
    }

    boolean isFree() {
            return true;
        }
    boolean isPlayer(){
            return false;
        }
    boolean isOpponent(){return false;}
    boolean isBulletPlayer(){
        return false;
    }
    boolean isBullet(){
        return false;
    }
    boolean isCoin(){ return false;}
    boolean isDeadPlayer() {
        return false;
    }
}

