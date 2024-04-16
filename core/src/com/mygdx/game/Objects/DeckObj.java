package com.mygdx.game.Objects;


import com.mygdx.game.GameSettings;

public class DeckObj extends GameObj {

    BallObj ballObj;

    public DeckObj(int x, int y, String pathToTexture) {
        super(x, y, 93, 497, "Rectangle 94.png");
        ballObj = new BallObj(0, 0);
    }

    public int getY() {
        return y;
    }

    public int getYTop() {
        return (int) (y + height);
    }
    public int getX(){
        return x;
    }
}


