package com.example.admin.sidescroller;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by admin on 5/17/2016.
 */
public class Lives extends Space {
        public Lives(int x, int y, int i, int j) {super( x, y,i,j);
        }

        void draw(Canvas c) {
            Paint wall = new Paint();
            wall.setColor(Color.GREEN);
            c.drawRect(x, y+50, x + 125, y + 145, wall);
            //space_rect = new Rect(x, y, x + 125, y + 145);
        }
}

