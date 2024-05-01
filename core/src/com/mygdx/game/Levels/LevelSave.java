package com.mygdx.game.Levels;



public class LevelSave  {
    public boolean nowLevelWasPassed = false;
    public int speed;
    public BarierSave[] barierSaves;

    public LevelSave(BarierSave[] barierSaves) {
        this.speed = speed;
        this.barierSaves = barierSaves;

    }
    public void toggleNowLevelPassed( boolean nowLevelWasPassed){
        this.nowLevelWasPassed = nowLevelWasPassed;

    }
}

