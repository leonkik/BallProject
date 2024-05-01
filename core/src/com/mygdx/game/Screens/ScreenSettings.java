package com.mygdx.game.Screens;

import com.badlogic.gdx.ScreenAdapter;
import com.mygdx.game.MyGdxGame;

public class ScreenSettings extends ScreenAdapter {
    MyGdxGame myGdxGame;
    public ScreenSettings(MyGdxGame myGdxGame) {
            myGdxGame = new MyGdxGame();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
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
