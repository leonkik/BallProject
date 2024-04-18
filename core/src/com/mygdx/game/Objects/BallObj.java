package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameSettings;
import com.mygdx.game.TimeManeger;


public class BallObj extends GameObj {
    TimeManeger timeManeger;
    private boolean isMoveUp = true;

    public BallObj(int x, int y) {
        super(x, y, GameSettings.BALL_HEIGHT, GameSettings.BALL_WIDTH, "pictures/Ellipse 7.png");
        timeManeger = new TimeManeger();
    }


    public void move(int speed) {
        if (isMoveUp) {
            y += speed;
        }
        if (!isMoveUp) {
            y -= speed;
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void dispose() {
        super.dispose();
    }


    public  boolean getisMoveup(){
        return isMoveUp;
    }



    public void toggleIsMoveup(boolean nextMove){
        this.isMoveUp = nextMove;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getYTop(){
        return y + GameSettings.BALL_HEIGHT;
    }
    public int getXRight(){
        return x + GameSettings.BALL_WIDTH;
    }
}

