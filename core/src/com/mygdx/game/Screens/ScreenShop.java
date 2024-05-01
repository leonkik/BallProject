package com.mygdx.game.Screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameSettings;
import com.mygdx.game.MyGdxGame;

public class ScreenShop extends ScreenAdapter {
    MyGdxGame myGdxGame;
    public ScreenShop(MyGdxGame myGdxGame) {
        myGdxGame = new MyGdxGame();
    }

    @Override
    public void render(float delta) {
       myGdxGame.camera.update();
        ScreenUtils.clear(102,102,102,1);
       myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
       myGdxGame.batch.begin();
       
       myGdxGame.batch.end();
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
