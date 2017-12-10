package com.messner.patel.galaga;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/**
 * Created by Kishan on 12/9/2017.
 */

public class FighterMissile extends GameObject {

    Bitmap thisFighter;
    int xPos , yPos;

    public FighterMissile(Resources resources, int xPos , int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
        thisFighter = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resources , R.drawable.galagamissile),150,150,false);
    }

    @Override
    public void init() {

    }

    @Override
    public void onUpdate() {
        yPos -= 10;
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(thisFighter,xPos,yPos,null);

    }

    @Override
    public int getxPos() {
        return 0;
    }

    @Override
    public int getyPos() {
        return 0;
    }

    @Override
    public void setxPos(int xPos) {

    }

    @Override
    public void setyPos(int yPos) {

    }
}
