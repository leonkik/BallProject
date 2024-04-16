package com.mygdx.game.Objects;

import com.mygdx.game.GameSettings;

public class BarrierObj extends GameObj {
    BallObj ballObj;
    boolean isOnUpDeck;

    public BarrierObj(int x, int y, int wight, int hight, boolean isOnUpDeck) {
        super(x, y, wight, hight, "Group 1.png");
        ballObj = new BallObj(0, 0);

    }

    public void SetPosX(int nextX) {
        this.x = nextX;
    }

    public void move(int speed) {
        if (x != 0 - width) {
            x -= speed;
        }
        if (x <= 0 - width) {
            SetPosX(GameSettings.SCREEN_WIDTH);
        }
    }

    public boolean isHit() {
        return ballObj.getX() == x & ballObj.getYTop() <= y & isOnUpDeck
                |
                ballObj.getX() == x & ballObj.getYTop() <= y & !isOnUpDeck  ;


    }



}
