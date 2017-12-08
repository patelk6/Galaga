package com.messner.patel.galaga;

import android.app.Activity;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.SurfaceHolder;

public class MainActivity extends Activity {

    GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        gameView = new GameView(this,point);
        setContentView(gameView);

    }

    @Override
    protected void onResume() {
        gameView.resume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        gameView.pause();
        super.onPause();
    }
}
