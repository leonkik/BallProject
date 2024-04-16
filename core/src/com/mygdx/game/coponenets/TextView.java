package com.mygdx.game.coponenets;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Objects.GameObj;

public class TextView {

    int x;
    int y;
    int height;
    int width;

    BitmapFont bitmapFont;

    public TextView(int x, int y, BitmapFont bitmapFont) {
        this.x = x;
        this.y = y;
        this.bitmapFont = bitmapFont;
    }

    public void draw(SpriteBatch batch, String text) {
        if (bitmapFont == null) return;
        GlyphLayout gl = new GlyphLayout(bitmapFont, text);
        height = (int) gl.height;
        width = (int) gl.width;
        bitmapFont.draw(batch, text, x, y + height);
    }

    public void dispose() {
        if (bitmapFont != null) bitmapFont.dispose();
    }
}