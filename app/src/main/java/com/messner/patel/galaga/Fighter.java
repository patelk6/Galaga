package com.messner.patel.galaga;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.Display;
import android.widget.ImageView;


/**
 * Created by Kishan on 12/7/2017.
 */

public class Fighter extends GameObject implements Shootable {
    int xPos , yPos;
    int lives = 1;

    GameGrid grid;

    public Fighter(GameGrid grid,int xPos , int yPos){
        this.xPos = xPos;
        this.yPos = yPos;

        //thisFighter = BitmapFactory.decodeResource(resources , R.drawable.fighter);
        this.grid = grid;


    }
    public int getxPos(){
        return xPos;
    }

    public int getyPos(){
        return yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }



    public void shoot(){


    }

    @Override
    public void init() {

    }

    @Override
    public void onUpdate() {

    }

    @Override
    public void onDraw(Canvas canvas) {
       // canvas.drawBitmap(Bitmap.createScaledBitmap(thisFighter,150,150,false),xPos,yPos,null);

        canvas.drawBitmap(grid.getImage("fighter"),xPos,yPos,null);
    }
}
