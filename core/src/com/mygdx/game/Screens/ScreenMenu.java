package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.FontBuilder;
import com.mygdx.game.GameSettings;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.coponenets.ButtonView;
import com.mygdx.game.coponenets.ImageView;

public class ScreenMenu extends ScreenAdapter {
    ButtonView playButton;
    ButtonView quitButton;
    ButtonView settingsButton;
   MyGdxGame myGdxGame;
   Vector3 vector3;
   ImageView mainLogo;
   ScreenShop screenShop;
   ScreenSettings screenSettings;
   BitmapFont bitmapFont;
   FontBuilder fontBuilder;

    public ScreenMenu(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        vector3 = new Vector3();
        bitmapFont = new BitmapFont();
        fontBuilder = new FontBuilder();
        playButton = new ButtonView(GameSettings.SCREEN_WIDTH - 300 , GameSettings.SCREEN_HEIGHT - 200,245,75,"pictures/BackGraondButtonLarge.png",myGdxGame.largeWhiteFont,"play");
        quitButton = new ButtonView(GameSettings.SCREEN_WIDTH - 300 , GameSettings.SCREEN_HEIGHT - 200,245,75,"pictures/BackGraondButtonLarge.png",myGdxGame.largeWhiteFont,"play");
        settingsButton = new ButtonView(GameSettings.SCREEN_WIDTH - 300 , GameSettings.SCREEN_HEIGHT - 200,245,75,"pictures/BackGraondButtonLarge.png",myGdxGame.largeWhiteFont,"play");
        mainLogo = new ImageView(GameSettings.SCREEN_WIDTH - 300 , GameSettings.SCREEN_HEIGHT - 200,"pictures/MainLogo.png");
    }

    @Override
    public void render(float delta) {
        myGdxGame.camera.update();
        ScreenUtils.clear(102,102,102,1);
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        playButton.draw(myGdxGame.batch);
        quitButton.draw(myGdxGame.batch);
        settingsButton.draw(myGdxGame.batch);
        myGdxGame.batch.end();
        handlInput();
    }

   public void handlInput(){

      if(Gdx.input.justTouched()) {
          Vector3 touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX() , Gdx.input.getY(),0 ));
          if (playButton.isHit(touch.x, touch.y)) {
              myGdxGame.setScreen(screenShop);
          }
          if (quitButton.isHit(touch.x, touch.y)) {
              Gdx.app.exit();
          }
          if (settingsButton.isHit(touch.x, touch.y)) {
              myGdxGame.setScreen(screenSettings);
          }
      }
      }

    @Override
    public void dispose() {
        playButton.dispose();
        quitButton.dispose();
        settingsButton.dispose();
    }
}
