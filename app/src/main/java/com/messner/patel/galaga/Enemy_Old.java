package com.messner.patel.galaga;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by Joseph on 12/7/2017.
 */

public class Enemy_Old extends GameObject{

    private int count = 0;
    private final int enenyMatrixWidth = 10;
    private final int enemyMatrixHeight = 5;

    private final int quantGreenGalaga = 4;
    private final int quantRedGalaga = 16;
    private final int quantBlueGalaga = 20;

    private final int startPosRedGalaga = 3;
    private final int startPosBlueGalaga = 2;
    private final int startPosGreenGalaga = 5;



    private EnemyCharacter_Old[][] enemyRestPosition = new EnemyCharacter_Old[14][5];
    private ArrayList<EnemyCharacter_Old> moveCharArray = new ArrayList<>();
    Bitmap redgalaga;
    Bitmap bluegalaga;
    Bitmap greengalaga;
    Bitmap greengalaga2;

    GameGrid grid;

    public Enemy_Old(Resources resources, GameGrid grid) {
        this.grid = grid;
        initCharacterImages(resources, grid.getPixelsPerBox());
        setStartPositions();


    }

    private void setStartPositions(){
        EnemyCharacter_Old.restBlueLoc = startPosBlueGalaga;
        EnemyCharacter_Old.restRedLoc = startPosRedGalaga;
        EnemyCharacter_Old.restGreenLoc = startPosGreenGalaga;
        setStartRedGalaga();
        setStartBlueGalaga();
        setStartGreenGalaga();
        chooseMovingChar();
    }

    public void setStartRedGalaga(){
        int startLoc = 3;
        for(int i = startLoc; i < quantRedGalaga/2 + startLoc; i++){
            enemyRestPosition[i][1] = new EnemyCharacter_Old("red",grid.getBoard()[i][1].getCornerCoord());
        }
        for(int i = startLoc; i < quantRedGalaga/2 + startLoc; i++) {
            enemyRestPosition[i][2] = new EnemyCharacter_Old("red", grid.getBoard()[i][2].getCornerCoord());
        }

    }

    public void setStartBlueGalaga(){
        int startLoc = 2;
        for(int i = startLoc; i < quantBlueGalaga/2 + startLoc; i++){
            enemyRestPosition[i][3] = new EnemyCharacter_Old("blue",grid.getBoard()[i][3].getCornerCoord());
        }
        for(int i = startLoc; i < quantBlueGalaga/2 + startLoc; i++){
            enemyRestPosition[i][4] = new EnemyCharacter_Old("blue",grid.getBoard()[i][4].getCornerCoord());
        }
    }

    public void setStartGreenGalaga(){
        int startLoc = 5;
        for(int i = startLoc; i < quantGreenGalaga + startLoc; i++){
            enemyRestPosition[i][0] = new EnemyCharacter_Old("green",grid.getBoard()[i][0].getCornerCoord());
        }
    }




    @Override
    public void init(Canvas canvas) {


    }

    @Override
    public void onUpdate() {

    }

    @Override
    public void onDraw(Canvas canvas) {
        if(count == 2) {
            moveCharacter();
            count = 0;
        }
        count++;
        for (EnemyCharacter_Old e: moveCharArray) {

            int[] temp = e.getPlaceCoordinates();
            canvas.drawBitmap(getBitmap(e.getCharType()),temp[0],temp[1], null);
        }
        int[] arr = new int[2];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 14; j++){
                EnemyCharacter_Old temp = enemyRestPosition[j][i];
                if(temp != null){
                    arr = temp.getPlaceCoordinates();
                    canvas.drawBitmap(getBitmap(temp.getCharType()),arr[0],arr[1], null);

                }
            }
        }

    }

    private void initCharacterImages(Resources resources, int boxSize){
        redgalaga = BitmapFactory.decodeResource(resources, R.drawable.redgalaga);
        bluegalaga = BitmapFactory.decodeResource(resources, R.drawable.bluegalaga);
        greengalaga = BitmapFactory.decodeResource(resources,R.drawable.greengalaga);
        greengalaga2 = BitmapFactory.decodeResource(resources,R.drawable.greengalaga2);

        redgalaga = Bitmap.createScaledBitmap(redgalaga,boxSize,boxSize,false);
        bluegalaga = Bitmap.createScaledBitmap(bluegalaga,boxSize,boxSize,false);
        greengalaga = Bitmap.createScaledBitmap(greengalaga,boxSize,boxSize,false);
        greengalaga2 = Bitmap.createScaledBitmap(greengalaga2,boxSize,boxSize,false);
    }

    private Bitmap getBitmap(String type){
        switch(type){
            case "red":
                return redgalaga;

            case "blue":
                return bluegalaga;

            case "green":
                return greengalaga;
        }
        return null;
    }

    public void chooseMovingChar(){
        moveCharArray.add(0,enemyRestPosition[2][4]);
        moveCharArray.add(1,enemyRestPosition[3][3]);
    }

    public void moveCharacter(){
        for (EnemyCharacter_Old e: moveCharArray) {
           int[] temp = e.getPlaceCoordinates();
            temp = grid.moveDown(temp);
            if(temp[1] > grid.getPlayableHeight()) {
                temp[1] = 0;
                e.setPlaceCoordinates(temp);
            }
        }


    }
}
