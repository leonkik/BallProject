package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameSettings;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Objects.BallObj;
import com.mygdx.game.Objects.BarrierObj;
import com.mygdx.game.Objects.DeckObj;
import com.mygdx.game.Objects.GameObj;
import com.mygdx.game.ScreenGameState;
import com.mygdx.game.TimeManeger;
import com.mygdx.game.coponenets.ButtonView;
import com.mygdx.game.coponenets.ImageView;
import com.mygdx.game.coponenets.TextView;

import java.util.ArrayList;

public class ScreenGame extends ScreenAdapter {
    GameObj blackOutInterface;
    MyGdxGame myGdxGame;
    BallObj ballobj;
    Texture texture;
    TimeManeger timeManeger;
    SpriteBatch batch;
    DeckObj deck_botom;
    DeckObj deck_upper;
    ImageView blackoutView;
    Vector3 vector3;
    BarrierObj barrierObj;
    ArrayList arrayListOfBarrier;
    ScreenGameState screenGameState;
    TextView pauseTitleView;
    ButtonView pauseButton;

    public void show() {
        timeManeger.beginSession();
    }

    public ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        batch = new SpriteBatch();
        ballobj = new BallObj(GameSettings.SCREEN_WIDTH / 2, GameSettings.SCREEN_WIDTH / 2);
        deck_botom = new DeckObj(125, GameSettings.SCREEN_HEIGHT / 2 - 544,
                "Rectangle 94.png");
        deck_upper = new DeckObj(125, GameSettings.SCREEN_HEIGHT / 2 + 335,
                "Rectangle 94.png");
        timeManeger = new TimeManeger();
        blackOutInterface = new GameObj(0,
                GameSettings.SCREEN_HEIGHT - 100 ,
                100,
                GameSettings.SCREEN_WIDTH ,
                "pictures/Rectangle 90.png");
        vector3 = new Vector3();
        barrierObj = new BarrierObj(GameSettings.SCREEN_WIDTH, GameSettings.BARRIER_WIDTH ,  GameSettings.BARRIER_HEIGHT,true);
        timeManeger = new TimeManeger();
        blackoutView  = new ImageView(0,0,GameSettings.BALL_WIDTH,GameSettings.BALL_HEIGHT, "pictures/Group 2.png");
        //pauseTitleView = new TextView();
        pauseButton = new ButtonView(GameSettings.SCREEN_WIDTH - 10 ,
                GameSettings.SCREEN_HEIGHT - 48,
                48,
                48,
                "pictures/Group 2.png");
    }

    @Override
    public void render(float delta) {
       if(timeManeger.getState() == ScreenGameState.PLAYING) {
           draw();
           Toched();
           ballobj.move(GameSettings.BALL_SPEED);
           barrierObj.move(GameSettings.BARRIER_SPEED);
           collision();
           console();
       }

    }

    public void draw() {
        myGdxGame.camera.update();
        ScreenUtils.clear(Color.WHITE);
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        ballobj.draw(myGdxGame.batch);
        deck_botom.draw(myGdxGame.batch);
        deck_upper.draw(myGdxGame.batch);
        blackOutInterface.draw(myGdxGame.batch);
        barrierObj.draw(myGdxGame.batch);
        pauseButton.draw(myGdxGame.batch);


        myGdxGame.batch.end();
        if (timeManeger.getState() == screenGameState.PAUSED) {
            blackoutView.draw(myGdxGame.batch);
            pauseTitleView.draw(myGdxGame.batch, "Pause");

        }

    }

    @Override
    public void dispose() {
        super.dispose();
        ballobj.dispose();
        deck_botom.dispose();
        deck_upper.dispose();
        blackOutInterface.dispose();
    }

    public void Toched() {
        if (Gdx.input.justTouched()) {
            Vector3 touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (ballobj.getisMoveup()) {

                ballobj.toggleIsMoveup(false);


            } else if (!ballobj.getisMoveup()) {

                ballobj.toggleIsMoveup(true);


            }
        }
    }

     public void collision(){
         if(ballobj.getYTop() >= deck_upper.getY()){
             ballobj.toggleIsMoveup(false);
         }
         if(ballobj.getY() <= deck_botom.getYTop()){
             ballobj.toggleIsMoveup(true);
         }
         if(barrierObj.isHit()){
             System.out.println("isHit");
         }
         if(pauseButton.isHit(GameSettings.SCREEN_WIDTH - 300,GameSettings.SCREEN_HEIGHT - 40)){
             System.out.println("Button was click");
         }
    }


    private void console() {

        //System.out.println(barrierObj.getX());

    }


}


