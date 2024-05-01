package com.mygdx.game.Levels;

import com.mygdx.game.Objects.BarrierObj;
import com.mygdx.game.TimeManeger;

public class BarierSave extends BarrierObj {

    TimeManeger timeManeger;
    long appearanceTime;

    public BarierSave(int x, int wight, int hight, boolean isOnUpDeck, long appearanceTime) {
        super(x, wight, isOnUpDeck);
        this.appearanceTime = appearanceTime;

    }
    public long getAppeareneTime(){
        return appearanceTime;
    }
}
