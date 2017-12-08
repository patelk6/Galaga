package com.messner.patel.galaga;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Kishan on 12/4/2017.
 */

public class Polygon extends GameObject {
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

    protected  Vector2 position;
    protected int numSides = 3;
    protected Vector2 points[];
    protected Paint paint;
    protected float radius;

    public Polygon(Vector2 position, int numSides, float radius) {
        this.position = position;

        if(numSides <3){
            numSides = 3;
        }

        this.numSides = numSides;

        if(radius <=0.0f){
            radius = 1.0f;
        }

        this.radius = radius;
        paint = new Paint();
        paint.setColor(Color.argb(255,0,255,0));
        paint.setStrokeWidth(10.0f);
        points = new Vector2[numSides];
        calculatePoints();
    }

    protected void calculatePoints(){
        float angle = (float) (2.0f * Math.PI / numSides);
        double cumulativeRadians = angle;

        for(int i = 0 ; i<numSides ; i++){
            points[i] = new Vector2(
                    radius * (float) Math.cos(cumulativeRadians),
                    radius* (float) Math.sin(cumulativeRadians));

            cumulativeRadians += angle;
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void onUpdate() {

    }

    @Override
    public void onDraw(Canvas canvas) {

        int length = points.length;
        Vector2 temp1,temp2;

        for(int i = 0; i<length-1; i++){
            temp1 = Vector2.add(position, points[i]);
            temp2 = Vector2.add(position, points[i+1]);
            canvas.drawLine(temp1.x,temp1.y , temp2.x, temp2.y , paint);
        }
        temp1 = Vector2.add(position, points[length-1]);
        temp2 = Vector2.add(position, points[0]);
        canvas.drawLine(temp1.x,temp1.y , temp2.x, temp2.y , paint);

    }
}
