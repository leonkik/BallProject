package com.mygdx.game.Levels;

import com.mygdx.game.GameSettings;

public class Levels {

    static LevelSave[] levelSaves = {
            new LevelSave(

                    new BarierSave[]{
                           new BarierSave(GameSettings.SCREEN_WIDTH,
                                   GameSettings.BARRIER_WIDTH,
                                   GameSettings.BARRIER_HEIGHT,
                                   true,
                                   2000)
                    }
            ),
            new LevelSave(

                    new BarierSave[]{
                          
                    }
            ),
    };

}