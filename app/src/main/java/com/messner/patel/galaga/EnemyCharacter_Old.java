package com.messner.patel.galaga;

/**
 * Created by Joseph on 12/8/2017.
 */

public class EnemyCharacter_Old {

    String charType;
    int moveSpeed = 1; //set as a constant for the moment
    int[] cornerCoord = new int[2];
    int health;
    int startLoc;


    public static int restRedLoc;
    public static int restGreenLoc;
    public static int restBlueLoc;


    public EnemyCharacter_Old(String charType, int[] cornerCoord) {
        this.charType = charType;
        this.cornerCoord = cornerCoord;
        switch(charType){
            case "blue":
                health = 1;
                startLoc = 2;
                break;

            case "red":
                health = 1;
                startLoc = 3;
                break;

            case "green":
                health = 2;
                startLoc = 5;
                break;
        }
    }

    public void setPlaceCoordinates(int[] temp){
        cornerCoord = temp;
    }

    public int[] getPlaceCoordinates(){
        return cornerCoord;
    }

    public void setMoveSpeed(){

    }

    public int getMoveSpeed(){
        return moveSpeed;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int h){
        health = h;
    }

    public int getStartLoc(){
        return startLoc;
    }

    public static int getRedLoc(){
        return 3;
    }

    public String getCharType(){
        return charType;
    }

}
