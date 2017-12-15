package com.messner.patel.galaga;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Kishan on 12/10/2017.
 */

public class SoundManager {
    Context context;
    public SoundManager(Context context){
        this.context = context;



    }

    public void laserShot(){
        MediaPlayer mp = MediaPlayer.create(context,R.raw.defaultshot);
        mp.start();
        //mp.release();
    }

    public void enemyDestroyed(){
        MediaPlayer mp = MediaPlayer.create(context,R.raw.explosion);
        mp.start();
       // mp.release();
    }

    public void startMusic(){
        MediaPlayer mp = MediaPlayer.create(context,R.raw.themesong);
        mp.start();
       // mp.release();
    }



}
