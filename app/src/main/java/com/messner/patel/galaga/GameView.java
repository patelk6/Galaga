package com.messner.patel.galaga;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kishan on 12/4/2017.
 */

public class GameView extends SurfaceView implements Runnable , View.OnTouchListener {

    volatile boolean playing = true;
    Thread gameThread;
    SurfaceHolder surfaceHolder;
    private static final int FPS = 30;
    private static final int TBTWF = 1000/FPS;
    private long previousTimeMilliseconds;
    private long currentTimeMilliseconds;
    public static float deltaTime;
    Point screenSize;
   public static int SCREEN_HEIGHT;
    private static int SCREEN_WIDTH;
    private List<GameObject> gameObjects = new ArrayList<GameObject>();
    int i;
    private int numSides = 3;
    private Paint paint;


    GameGrid grid;

    public static int getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    public static int getScreenWidth() {
        return SCREEN_WIDTH;
    }

    public GameView(Context context, Point point) {
        super(context);
        surfaceHolder = this.getHolder();
        screenSize = point;
        SCREEN_WIDTH = point.x;
        SCREEN_HEIGHT = point.y;
        gameObjects.add(new StarField(100,30.0f));
        grid = new GameGrid(SCREEN_WIDTH,SCREEN_HEIGHT, getContext().getResources());
//        GameObject temp = new Polygon(new Vector2(getScreenWidth()/2.0f,
//                getScreenHeight()/2.0f),
//                5,
//                20.0f);
       // Enemy_Old temp = new Enemy_Old(getContext().getResources(),grid);
        Enemy temp = new Enemy(grid);
        gameObjects.add(temp);


        //this.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event){
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                gameObjects.add(new Polygon(new Vector2(event.getX(), event.getY()),
                        3,
                        20.0f));
                break;
            case MotionEvent.ACTION_UP:
                gameObjects.add(new Polygon(new Vector2(event.getX(), event.getY()),
                        numSides,
                        20.0f));
                numSides++;
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return true;

    }

    @Override
    public void run() {

        previousTimeMilliseconds = System.currentTimeMillis();

        init();
        while(playing){
            currentTimeMilliseconds = System.currentTimeMillis();
            deltaTime = (currentTimeMilliseconds - previousTimeMilliseconds)/1000.0f;

            update();
            draw();
            try{
                gameThread.sleep(TBTWF);
            }catch(InterruptedException e){

            }
            previousTimeMilliseconds = currentTimeMilliseconds;

        }
    }

    public void pause(){
        playing = false;
        try {
            gameThread.join();
        }catch(InterruptedException e){

        }
    }
    public void init(){
        if(surfaceHolder.getSurface().isValid()){
            Canvas canvas = surfaceHolder.lockCanvas();
            for(i = 0; i<gameObjects.size();i++){
                gameObjects.get(i).onDraw(canvas);
            }
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    public void resume(){
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    void update(){

        for(i = 0; i<gameObjects.size();i++){
            gameObjects.get(i).onUpdate();

        }

    }

    void draw(){

        if(surfaceHolder.getSurface().isValid()){
            Canvas canvas = surfaceHolder.lockCanvas();

            canvas.drawARGB(255,0,0,0);

            for(i = 0; i<gameObjects.size();i++){
                gameObjects.get(i).onDraw(canvas);

            }

            surfaceHolder.unlockCanvasAndPost(canvas);
        }

    }

}
