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
    String pathToTexture ;
    DeckObj deck_upper;
    DeckObj deck_botom;
    public BarrierObj( int wight, int height, boolean isOnUpDeck) {
        deck_upper = new DeckObj(125, GameSettings.SCREEN_HEIGHT / 2 + 335,
                "pictures/Deck.png");
        deck_botom = new DeckObj(125, GameSettings.SCREEN_HEIGHT / 2 - 544,
                "pictures/Deck.png");
        this.x = GameSettings.SCREEN_WIDTH;
        this.height = height;
        this.width = wight;


        ballObj = new BallObj(0, 0);
        if(isOnUpDeck){
            y = deck_upper.getY() ;
            this.pathToTexture = "pictures/TopBarrier.png";
        }
        if(!isOnUpDeck){
            y = deck_botom.getY() + deck_botom.gethight() ;
            this.pathToTexture = "pictures/BottomBarrier.png";
        }
        texture = new Texture(pathToTexture);
    }

    public void SetPosX(int nextX) {
        this.x = nextX;
    }

    public boolean move() {
        if (x != 0 - width) {
            x -= GameSettings.BARRIER_SPEED;
        }
        if (x <= 0 - width) {
            SetPosX(GameSettings.SCREEN_WIDTH);
            return true;
        }
        return false;
    }

    public boolean isHit() {
        return ballObj.getX() == x && ballObj.getYTop() <= y && isOnUpDeck
                ||  ballObj.getX() == x && ballObj.getYTop() <= y && !isOnUpDeck  ;


    }
    public void draw(SpriteBatch batch) {
        batch.draw(texture, GameSettings.SCREEN_WIDTH, y, width, height);
    }

    public void dispose() {
        texture.dispose();
    }

    public int getX(){
        return x ;
    }
    public int getY(){
        return y ;
    }
}
