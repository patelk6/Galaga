package com.messner.patel.galaga;

import android.graphics.Canvas;

/**
 * Created by Kishan on 12/4/2017.
 */

public abstract class GameObject {
    public abstract void init(Canvas canvas);

    public abstract void onUpdate();

    public abstract void onDraw(Canvas canvas);

    public abstract int getxPos();

    public abstract int getyPos();

    public abstract void setxPos(int xPos);

    public abstract void setyPos(int yPos);
}
