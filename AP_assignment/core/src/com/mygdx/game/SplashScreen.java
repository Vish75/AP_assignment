package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SplashScreen extends ApplicationAdapter implements Screen {

    public Texture getSplash() {
        return splash;
    }

    public void setSplash(Texture splash) {
        this.splash = splash;
    }

    public Animation<TextureRegion> getLoadbar() {
        return loadbar;
    }

    public void setLoadbar(Animation<TextureRegion> loadbar) {
        this.loadbar = loadbar;
    }

    private Texture splash;
    private Animation<TextureRegion> loadbar;

    private Music theme_music;

    public SplashScreen(String s,String l,String m){
        splash=new Texture(s);
        loadbar=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(l).read());
//        theme_music = Gdx.audio.newMusic(Gdx.files.internal("data/sounds/music_menu.ogg"));

    }

//    public SplashScreen(String s,String l){
//        splash=new Texture(s);
//        loadbar=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(l).read());
//
//    }
    public SplashScreen(String s){
        splash=new Texture(s);
    }

    public void playMusic(){
        theme_music.setLooping(true);
        theme_music.play();
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void hide() {

    }
}
