package com.mygdx.game;

import com.badlogic.gdx.utils.TimeUtils;

public class TimeManeger {
    int score;
     private ScreenGameState state;
    long lastTime;

    public ScreenGameState getState() {
        return state;
    }

    public void beginSession() {
        score = 0;
        state = ScreenGameState.PLAYING;
        lastTime = TimeUtils.millis();
    }

    public void pauseSession() {
        state = ScreenGameState.PAUSED;
    }

    public void resumeSession() {
        state = ScreenGameState.PLAYING;
    }
    public void badGame(){
        state = ScreenGameState.BadGame;
    }

    public long timer(){
        return TimeUtils.millis() - lastTime ;
    }




}
