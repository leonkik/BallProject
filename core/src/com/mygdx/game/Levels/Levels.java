package com.mygdx.game.Levels;

import com.mygdx.game.GameSettings;

public class Levels {

   public static LevelSave[] levelSaves = {
            new LevelSave(

                    new BarierSave[]{
                           new BarierSave(GameSettings.SCREEN_WIDTH,
                                   GameSettings.BARRIER_WIDTH,
                                   GameSettings.BARRIER_HEIGHT,
                                   false,
                                   1000),
                            new BarierSave(GameSettings.SCREEN_WIDTH,
                                    GameSettings.BARRIER_WIDTH,
                                    GameSettings.BARRIER_HEIGHT,
                                    true,
                                    2000),
                            new BarierSave(GameSettings.SCREEN_WIDTH,
                                    GameSettings.BARRIER_WIDTH,
                                    GameSettings.BARRIER_HEIGHT,
                                    true,
                                    3000),

//                            new BarierSave(GameSettings.SCREEN_WIDTH,
//                                    GameSettings.BARRIER_WIDTH,
//                                    GameSettings.BARRIER_HEIGHT,
//                                    false,
//                                    1000),
//                            new BarierSave(GameSettings.SCREEN_WIDTH,
//                                    GameSettings.BARRIER_WIDTH,
//                                    GameSettings.BARRIER_HEIGHT,
//                                    false,
//                                    2000),
//                            new BarierSave(GameSettings.SCREEN_WIDTH,
//                                    GameSettings.BARRIER_WIDTH,
//                                    GameSettings.BARRIER_HEIGHT,
//                                    false,
//                                    3000)

                    }
            ),
            new LevelSave(

                    new BarierSave[]{
                          
                    }

                    ),
    };

}