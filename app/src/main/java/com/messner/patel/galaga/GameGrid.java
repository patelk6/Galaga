package com.messner.patel.galaga;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Created by Joseph on 12/7/2017.
 */

public class GameGrid {
    private Bitmap redgalaga, bluegalaga, greengalaga, greengalaga2;

    private Bitmap fighter;
    
    private GridBox[][] gameboard;
    private int SCREEN_HEIGHT;
    private int SCREEN_WIDTH;

    private final int gridWidth = 14;
    private int gridHeight;
    private int pixelsPerBox;

    private final int boxesPerControl = 1;

    private int playableHeight;

    public GameGrid(int x, int y, Resources resources) {
        SCREEN_HEIGHT = y;
        SCREEN_WIDTH = x;


        createBoard();
        initializeImages(resources);

    }

    public void initializeImages(Resources resources){
        redgalaga = BitmapFactory.decodeResource(resources, R.drawable.redgalaga);
        bluegalaga = BitmapFactory.decodeResource(resources, R.drawable.bluegalaga);
        greengalaga = BitmapFactory.decodeResource(resources,R.drawable.greengalaga);
        greengalaga2 = BitmapFactory.decodeResource(resources,R.drawable.greengalaga2);

        fighter = BitmapFactory.decodeResource(resources , R.drawable.fighter);


        redgalaga = Bitmap.createScaledBitmap(redgalaga,pixelsPerBox,pixelsPerBox,false);
        bluegalaga = Bitmap.createScaledBitmap(bluegalaga,pixelsPerBox,pixelsPerBox,false);
        greengalaga = Bitmap.createScaledBitmap(greengalaga,pixelsPerBox,pixelsPerBox,false);
        greengalaga2 = Bitmap.createScaledBitmap(greengalaga2,pixelsPerBox,pixelsPerBox,false);

        fighter = Bitmap.createScaledBitmap(fighter,pixelsPerBox,pixelsPerBox,false);
    }

    public Bitmap getImage(String enemyType){
        switch(enemyType){
            case "red":
                return redgalaga;

            case "blue":
                return bluegalaga;

            case "green":
                return greengalaga;

            case "fighter":
                return fighter;

            default:
                return null;
        }
    }





    private void createBoard(){
        pixelsPerBox = SCREEN_WIDTH / gridWidth;
        gridHeight = SCREEN_HEIGHT / pixelsPerBox;
        int totalPixelsUsed = gridHeight*pixelsPerBox;
        playableHeight = totalPixelsUsed;
        GridBox[][] tempMatrix = new GridBox[gridWidth][gridHeight];
        for(int j = 0; j < gridHeight; j++) {
            for (int i = 0; i < gridWidth; i++) {
                tempMatrix[i][j] = new GridBox(i,j,pixelsPerBox);
            }
        }

        gameboard = tempMatrix;

    }







    public int getPixelsPerBox(){
        return pixelsPerBox;
    }

    public GridBox[][] getBoard(){
        return gameboard;
    }

    public int[] moveDown(int[] temp){
        temp[1] = temp[1] + pixelsPerBox;
        return temp;
    }

    public int getPlayableHeight(){
        return playableHeight;
    }

    public class GridBox{
        private int[] cornerCoord = new int[2];
        private int[] pixelCoord = new int[2]; //x,y

        public GridBox(int widthIndex, int heightIndex,int pixelsPerBox){
            cornerCoord[0] = widthIndex*pixelsPerBox;
            cornerCoord[1] = heightIndex*pixelsPerBox;
            pixelCoord[0] = cornerCoord[0] + pixelsPerBox;
            pixelCoord[1] = cornerCoord[1] + pixelsPerBox;
        }

        public int[] getCornerCoord(){
            return cornerCoord;
        }

        public int[] getPixelCoord(){
            return pixelCoord;
        }


    }
}
