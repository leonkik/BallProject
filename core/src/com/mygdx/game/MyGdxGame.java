package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;


import static com.mygdx.game.GameSettings.*;
import static com.mygdx.game.GameSettings.SCREEN_HEIGHT;


public class MyGdxGame extends Game {

    public OrthographicCamera camera;
    public SpriteBatch batch;

    public ScreenGame gameScreen;
    public ScreenMenu menuScreen;
    public ScreenSettings settingsScreen;
    public ScreenShop shopScreen;
    public ScreenLevelMenu levelMenuScreen;
    public BitmapFont commonWhiteFont;
    public BitmapFont largeWhiteFont;

    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
        largeWhiteFont = FontBuilder.generate(68, Color.WHITE, "font/MuseoModerno-ExtraLightItalic.ttf");
        commonWhiteFont = FontBuilder.generate(28, Color.WHITE, "font/MuseoModerno-Regular.ttf");


        gameScreen = new ScreenGame(this);
        menuScreen = new ScreenMenu(this);
        shopScreen = new ScreenShop(this);
        levelMenuScreen = new ScreenLevelMenu(this);
        setScreen(gameScreen);

    }


    @Override
    public void dispose() {
        batch.dispose();
    }
}