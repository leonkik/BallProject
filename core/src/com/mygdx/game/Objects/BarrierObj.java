package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameSettings;

public class BarrierObj  {
    BallObj ballObj;
    boolean isOnUpDeck;
    int x;
    int y;
    int height;
    int width;
    Texture texture;
    String pathToTexture = "pictures/Group 1.png";
    DeckObj deck_upper;
    DeckObj deck_botom;
    public BarrierObj(int x, int wight, int hight, boolean isOnUpDeck) {
        deck_upper = new DeckObj(125, GameSettings.SCREEN_HEIGHT / 2 + 335,
                "Rectangle 94.png");
        deck_botom = new DeckObj(125, GameSettings.SCREEN_HEIGHT / 2 - 544,
                "Rectangle 94.png");
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.pathToTexture = pathToTexture;
        texture = new Texture(pathToTexture);
        ballObj = new BallObj(0, 0);
        if(isOnUpDeck){
            y += deck_upper.getY() ;
        }
        if(!isOnUpDeck){
            y += deck_botom.getY() + deck_botom.gethight() ;
        }
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
        return ballObj.getX() == x && ballObj.getYTop() <= y && isOnUpDeck
                ||  ballObj.getX() == x && ballObj.getYTop() <= y && !isOnUpDeck  ;


    }
    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }

    public void dispose() {
        texture.dispose();
    }



}
