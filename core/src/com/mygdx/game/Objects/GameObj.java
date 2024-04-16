package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameObj {
    int x;
    int y;
    int height;
    int width;
    Texture texture;
    String pathToTexture;

    public GameObj(int x, int y, int height, int width, String pathToTexture) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.pathToTexture = pathToTexture;
        texture = new Texture(pathToTexture);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }

    public void dispose() {
        texture.dispose();
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWight(){
        return width;
    }
    public int gethight(){
        return height;
    }
}
