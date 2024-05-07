package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameSettings;
import com.mygdx.game.Levels.Levels;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.coponenets.ButtonView;
import com.mygdx.game.coponenets.ImageView;
import com.mygdx.game.coponenets.TextView;


public class ScreenLevelMenu extends ScreenAdapter {
    MyGdxGame myGdxGame;
    ImageView backGraund;
    ButtonView upButton;
    ButtonView downButton;
    ImageView levelScreen;
    TextView levelScreenText;
    ButtonView shopButton;

    public ScreenLevelMenu(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        backGraund = new ImageView(0, GameSettings.SCREEN_HEIGHT / 2 - 394, GameSettings.SCREEN_WIDTH, GameSettings.SCREEN_HEIGHT - 450, "pictures/BackGraundChanger.png");
        upButton = new ButtonView(GameSettings.SCREEN_WIDTH / 2 - 50, 866, 124, 124, "pictures/UpButtonChanger.png");
        downButton = new ButtonView(GameSettings.SCREEN_WIDTH / 2 - 50, 266, 124, 124, "pictures/DownButtonChanger.png");
        levelScreen = new ImageView(GameSettings.SCREEN_WIDTH / 2 - 248, 550, 496, 248, "pictures/BackGraundButtonLevel.png");
        shopButton = new ButtonView(GameSettings.SCREEN_WIDTH - 100, GameSettings.SCREEN_HEIGHT - 100, 100, 100, "pictures/ShopButton.png");
        levelScreenText = new TextView(GameSettings.SCREEN_WIDTH, GameSettings.SCREEN_HEIGHT, myGdxGame.largeWhiteFont);

    }


    public void render(float delta) {
        myGdxGame.camera.update();
        ScreenUtils.clear(102, 102, 102, 1);
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        levelScreenText.draw(myGdxGame.batch, Integer.toString(ScreenGame.nowlevel));
        backGraund.draw(myGdxGame.batch);
        levelScreen.draw(myGdxGame.batch);
        upButton.draw(myGdxGame.batch);
        downButton.draw(myGdxGame.batch);
        shopButton.draw(myGdxGame.batch);
        touch();

        myGdxGame.batch.end();
    }

    public void touch() {
        if (Gdx.input.justTouched()) {
            Vector3 touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (upButton.isHit(touch.x, touch.y) && ScreenGame.nowlevel <= Levels.levelSaves.length) {
                ScreenGame.nowlevel += 1;
                System.out.println(ScreenGame.nowlevel);
            }
            if (downButton.isHit(touch.x, touch.y) && ScreenGame.nowlevel < 0) {
                ScreenGame.nowlevel -= 1;
            }
            if (shopButton.isHit(touch.x, touch.y)) {
                myGdxGame.setScreen(myGdxGame.shopScreen);
            }
        }
    }

    public void show() {
        super.show();
    }

    @Override
    public void dispose() {
        upButton.dispose();
        downButton.dispose();
        levelScreenText.dispose();
        levelScreen.dispose();
        shopButton.dispose();
    }
}
