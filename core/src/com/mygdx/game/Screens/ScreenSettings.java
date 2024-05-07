package com.mygdx.game.Screens;

import com.badlogic.gdx.ScreenAdapter;
import com.mygdx.game.GameSettings;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.coponenets.ImageView;

public class ScreenSettings extends ScreenAdapter {
    MyGdxGame myGdxGame;
    ImageView blackOutOfSettings;
    ImageView QuitButton;
    public ScreenSettings(MyGdxGame myGdxGame) {
            this.myGdxGame = myGdxGame;
            blackOutOfSettings = new ImageView(10 , 200 , "pictures/BackGraundOfSettings .png");
            QuitButton = new ImageView(10, GameSettings.SCREEN_HEIGHT-100,"pictures/Quit.png");
    }

    @Override
    public void render(float delta) {
        blackOutOfSettings.draw(myGdxGame.batch);
        QuitButton.draw(myGdxGame.batch);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dispose() {
        blackOutOfSettings.dispose();
        QuitButton.dispose();
    }
}
