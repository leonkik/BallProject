package com.mygdx.game.coponenets;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class ButtonView {

    TextView textView;
    com.mygdx.game.coponenets.ImageView imageView;

    String text;

    public ButtonView(int x, int y, int width, int height, String texturePath, BitmapFont bitmapFont, String text) {

        imageView = new ImageView(x, y, width, height, texturePath);
        textView = new TextView(0, 0, bitmapFont);

        this.text = text;
        GlyphLayout glyphLayout = new GlyphLayout(bitmapFont, text);
        textView.height = (int) glyphLayout.height;
        textView.width = (int) glyphLayout.width;

        textView.x = imageView.x + imageView.width / 2 - textView.width / 2;
        textView.y = imageView.y + imageView.height / 2 - textView.height / 2;
    }

    public ButtonView(int x, int y, int width, int height, String texturePath) {
        imageView = new ImageView(x, y, width, height, texturePath);
        textView = null;
    }

    public ButtonView(int x, int y, BitmapFont bitmapFont, String text) {
        this.text = text;
        textView = new TextView(x, y, bitmapFont);
        imageView = null;

    }

    public void setText(String text) {
        this.text = text;
    }

    public void draw(SpriteBatch batch) {
        if (imageView != null) imageView.draw(batch);
        if (textView != null) textView.draw(batch, text);
    }

    public void dispose() {
        imageView.dispose();
        textView.dispose();
    }

    public boolean isHit(float tx, float ty) {
        if (imageView != null) {
            return (tx > imageView.x && tx < imageView.x + imageView.width
                    && ty > imageView.y && ty < imageView.y + imageView.height);
        }

        if (textView != null) {
            return (tx > textView.x && tx < textView.x + textView.width
                    && ty > textView.y && ty < textView.y + textView.height);
        }

        return false;
    }

}