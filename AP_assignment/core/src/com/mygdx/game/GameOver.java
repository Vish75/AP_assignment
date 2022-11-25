package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class GameOver extends ApplicationAdapter implements Screen {
    private Texture GameOverScreen;

    public Texture getBkg() {
        return bkg;
    }

    public void setBkg(Texture bkg) {
        this.bkg = bkg;
    }

    private Texture bkg;
//    private Texture p;
    private Texture resume;

    public Texture getRestart() {
        return restart;
    }

    public void setRestart(Texture restart) {
        this.restart = restart;
    }

    private Texture restart;

    public Texture getGameOverScreen() {
        return GameOverScreen;
    }

//    public void setPauseScreen(Texture pauseScreen,String p,String r,String e,String re) {
//        this.p = pauseScreen;

//    }

    public Texture getResume() {
        return resume;
    }

    public void setResume(Texture resume) {
        this.resume = resume;
    }

    public Texture getExit() {
        return exit;
    }

    public void setExit(Texture exit) {
        this.exit = exit;
    }

    private Texture exit;

    private TankStars game;

    public GameOver(TankStars game,String p,String r,String e,String re){
        this.game=game;
        GameOverScreen=new Texture(p);
//        resume=new Texture(r);
        bkg=new Texture(r);
        exit=new Texture(e);
        restart=new Texture(re);
    }

    @Override
    public void show() {
        GameOverScreen=new Texture("Game_Over.png");
//        resume=new Texture("resume_pause_menu.png");
        exit=new Texture("resume_pause_menu.png");
        restart=new Texture("restart_pause_menu.png");
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(this.GameOverScreen,100,100,800,300);
        game.batch.end();
    }

    @Override
    public void hide() {

    }


    public TankStars getGame() {
        return game;
    }
}
