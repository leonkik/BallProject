package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.*;
import com.mygdx.game.Levels.Levels;
import com.mygdx.game.Objects.BallObj;
import com.mygdx.game.Objects.BarrierObj;
import com.mygdx.game.Objects.DeckObj;
import com.mygdx.game.Objects.GameObj;
import com.mygdx.game.coponenets.ButtonView;
import com.mygdx.game.coponenets.ImageView;
import com.mygdx.game.coponenets.TextView;

import java.util.ArrayList;

public class ScreenGame extends ScreenAdapter {
    int lastAppeareBarrierIdx;
    public static int nowlevel;


    ArrayList<BarrierObj> barrierObjsArray;
    GameObj blackOutInterface;
    MyGdxGame myGdxGame;
    BallObj ballobj;
    Texture texture;
    TimeManeger timeManeger;
    SpriteBatch batch;
    DeckObj deckBottom;
    DeckObj deckUpper;
    ImageView blackoutView;
    ImageView ProgressBar;
    ImageView nowProgressBar;
    Vector3 vector3;
    TextView coinScore;
    TextView pauseTitleView;
    ButtonView pauseButton;
    ButtonView resumeButton;
    ButtonView homeButton;
    ButtonView quitButton;


    public void show() {
        timeManeger.beginSession();
        lastAppeareBarrierIdx = 0;
        nowlevel = MemoryManager.loadProgress();

    }

    public ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        batch = new SpriteBatch();
        ballobj = new BallObj(GameSettings.SCREEN_WIDTH / 2, GameSettings.SCREEN_WIDTH / 2);
        deckBottom = new DeckObj(125, GameSettings.SCREEN_HEIGHT / 2 - 544,
                "Deck.pngngle 94.png");
        deckUpper = new DeckObj(125, GameSettings.SCREEN_HEIGHT / 2 + 335,
                "pictures/Deck.pngngle 94.png");
        blackOutInterface = new GameObj(0,
                GameSettings.SCREEN_HEIGHT - 100,
                100,
                GameSettings.SCREEN_WIDTH,
                "pictures/BlackOut.png");
        vector3 = new Vector3();
        timeManeger = new TimeManeger();
        blackoutView = new ImageView(0, 0, 725, 1285, "pictures/BlackOut.png");
        pauseTitleView = new TextView(GameSettings.SCREEN_WIDTH / 2 - 40, GameSettings.SCREEN_HEIGHT / 2 + 140, myGdxGame.largeWhiteFont);
        pauseButton = new ButtonView(GameSettings.SCREEN_WIDTH - 78,
                GameSettings.SCREEN_HEIGHT - 68,
                60,
                60,
                "pictures/Pause.png");
        barrierObjsArray = new ArrayList<>();
        resumeButton = new ButtonView(GameSettings.SCREEN_WIDTH / 2 - 115, 500,
                302, 60, "pictures/BackGraundButtonSmall.png", myGdxGame.commonWhiteFont, "Resume"

        );
        homeButton = new ButtonView(GameSettings.SCREEN_WIDTH / 2 - 115,
                400,
                302, 60, "pictures/BackGraundButtonSmall.png",
                myGdxGame.commonWhiteFont,
                "Home");
        quitButton = new ButtonView(GameSettings.SCREEN_WIDTH / 2 - 115, 300,
                302,
                60,
                "pictures/BackGraundButtonSmall.png",
                myGdxGame.commonWhiteFont,
                "Quit");
        ProgressBar = new ImageView(10, GameSettings.SCREEN_HEIGHT - 56, "pictures/ProgressBar.png");
        nowProgressBar = new ImageView(10, GameSettings.SCREEN_HEIGHT - 56, getProgress(), 26, "pictures/nowProgress.png");
    }

    @Override
    public void render(float delta) {
        draw();
        touch();
        if (timeManeger.getState() == ScreenGameState.PLAYING) {
//            System.out.println(barrierObjsArray.size());
            collision();
            updateBarriers();
            ballobj.move(GameSettings.BALL_SPEED);
            for (BarrierObj barrierObj : barrierObjsArray) barrierObj.move();

            if (isLevelPassed()) {
                if (!Levels.levelSaves[nowlevel].nowLevelWasPassed) {
                        //MemoryManager.saveProgress(MemoryManager.loadProgress() + 1);
                    Levels.levelSaves[nowlevel].toggleNowLevelPassed(true);
                }
                myGdxGame.setScreen(myGdxGame.levelMenuScreen);

            }
           // console();
        }

    }

    public void draw() {
        myGdxGame.camera.update();
        ScreenUtils.clear(Color.WHITE);
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        nowProgressBar.draw(myGdxGame.batch);
        ProgressBar.draw(myGdxGame.batch);
        ballobj.draw(myGdxGame.batch);
        deckBottom.draw(myGdxGame.batch);
        deckUpper.draw(myGdxGame.batch);
        blackOutInterface.draw(myGdxGame.batch);
        pauseButton.draw(myGdxGame.batch);


        for (BarrierObj barrier : barrierObjsArray) {
            barrier.draw(myGdxGame.batch);
            // System.out.println("drawed");
        }


        if (timeManeger.getState() == ScreenGameState.PAUSED) {
            resumeButton.draw(myGdxGame.batch);
            quitButton.draw(myGdxGame.batch);
            homeButton.draw(myGdxGame.batch);
            blackoutView.draw(myGdxGame.batch);
            pauseTitleView.draw(myGdxGame.batch, "Pause");

        }
        myGdxGame.batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        ballobj.dispose();
        deckBottom.dispose();
        deckUpper.dispose();
        blackOutInterface.dispose();
    }

    public void touch() {
        if (Gdx.input.justTouched()) {
            Vector3 touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (ballobj.getisMoveup()) {

                ballobj.toggleIsMoveup(false);


            } else if (!ballobj.getisMoveup()) {

                ballobj.toggleIsMoveup(true);


            }
            if (pauseButton.isHit(touch.x, touch.y)) {
                timeManeger.pauseSession();

            }
            if (homeButton.isHit(touch.x, touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuScreen);
            }
            if (resumeButton.isHit(touch.x, touch.y)) {
                timeManeger.resumeSession();
            }
            if (quitButton.isHit(touch.x, touch.y)) {
                Gdx.app.exit();
            }
        }
    }

    public void updateBarriers() {
//        System.out.println(nowlevel);
        for (int i = lastAppeareBarrierIdx; i < Levels.levelSaves[nowlevel].barierSaves.length; i++) {
            if (timeManeger.timer() >= Levels.levelSaves[nowlevel].barierSaves[i].getAppeareneTime()) {
                lastAppeareBarrierIdx += 1;
                barrierObjsArray.add(Levels.levelSaves[nowlevel].barierSaves[i]);
            }

            if (GameSettings.BARRIER_WIDTH * -1 >= Levels.levelSaves[nowlevel].barierSaves[i].getX()) {
                barrierObjsArray.remove(i);
                i--;
            }
        }

    }

    public void collision() {
        if (ballobj.getYTop() >= deckUpper.getY()) {
            ballobj.toggleIsMoveup(false);
        }
        if (ballobj.getY() <= deckBottom.getYTop()) {
            ballobj.toggleIsMoveup(true);
        }
        for(BarrierObj barrierObj : barrierObjsArray){
            if(barrierObj.isHit(ballobj)){
                System.out.println("l");
            }
        }

    }


    public int getProgress() {
        return 100 / Levels.levelSaves[nowlevel].barierSaves.length * lastAppeareBarrierIdx * 175 / 100;
    }

    public boolean isLevelPassed() {

        if (Levels.levelSaves[nowlevel].barierSaves[Levels.levelSaves[nowlevel].barierSaves.length - 1].getX()
                + GameSettings.BARRIER_WIDTH <= 0) {
            return true;
        }
        return false;
    }


    private void console() {

        for (int i = 0; i < barrierObjsArray.size(); i++)
            System.out.println("number:" + i + "x:" + Levels.levelSaves[nowlevel].barierSaves[i].getX() +
                    "y" + Levels.levelSaves[nowlevel].barierSaves[i].getY());
    }


}


