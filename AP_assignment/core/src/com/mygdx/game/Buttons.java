package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class Buttons {
    private float height;
    private float width;
    private TankStars game;
    private Texture button_look;

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        width = width;
    }

    public Buttons(String s,float height,float width){
        this.button_look=new Texture(s);
        this.height=height;
        this.width=width;
    }
    public void tap(){

    }



    public Texture getButton_look() {
        return button_look;
    }

    public void setButton_look(Texture button_look) {
        this.button_look = button_look;
    }
}
