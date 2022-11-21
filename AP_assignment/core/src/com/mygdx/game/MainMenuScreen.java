package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import sun.awt.image.GifImageDecoder;

public class MainMenuScreen extends ApplicationAdapter implements Screen {
    private static final int EXIT_BUTTON_WIDTH = 300;
    private static final int EXIT_BUTTON_HEIGHT = 120;
    private static final int PLAY_BUTTON_WIDTH = 300;
    private static final int PLAY_BUTTON_HEIGHT = 120;
    private static final int RESUME_BUTTON_WIDTH = 350;
    private static final int RESUME_BUTTON_HEIGHT = 120;
    private static final int EXIT_BUTTON_Y = 100;
    private static final int PLAY_BUTTON_Y = 230;
    private static final int RESUME_BUTTON_Y = 360;
    Texture playButtonActive;
    Texture playButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;
    Texture resumeButtonActive;
    Texture resumeButtonInactive;
    Texture Resume_button;
    TankStars game;

    public MainMenuScreen(TankStars game){
        this.game = game;
        playButtonActive = new Texture("New_active.jpg");
        playButtonInactive = new Texture("New_inactive.jpg");
        exitButtonActive = new Texture("Exit_active.jpg");
        exitButtonInactive = new Texture("Exit_inactive.jpg");
        resumeButtonActive = new Texture("Resume_active.jpg");
        resumeButtonInactive = new Texture("Resume_inactive.jpg");
        Resume_button = new Texture("Resume_new.png");
    }
    @Override
    public void create(){

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.30f, 1);

        game.batch.begin();
        int x = TankStars.WIDTH/2 - EXIT_BUTTON_WIDTH/2;
        if(Gdx.input.getX()< x + EXIT_BUTTON_WIDTH && Gdx.input.getX()>x && TankStars.HEIGHT -Gdx.input.getY() < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT && TankStars.HEIGHT-Gdx.input.getY()> EXIT_BUTTON_Y){
            game.batch.draw(exitButtonActive,TankStars.WIDTH/2 - EXIT_BUTTON_WIDTH/2,EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        }
        else {
            game.batch.draw(exitButtonInactive,TankStars.WIDTH/2 - EXIT_BUTTON_WIDTH/2,EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        }

        x = TankStars.WIDTH/2 - PLAY_BUTTON_WIDTH/2;
        if(Gdx.input.getX()< x + PLAY_BUTTON_WIDTH && Gdx.input.getX()>x && TankStars.HEIGHT -Gdx.input.getY() < (PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT) && TankStars.HEIGHT-Gdx.input.getY()> PLAY_BUTTON_Y){
            game.batch.draw(playButtonActive,TankStars.WIDTH/2 - PLAY_BUTTON_WIDTH/2,PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);

            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new GameScreen(game));
            }
        }
        else {
            game.batch.draw(playButtonInactive,TankStars.WIDTH/2 - PLAY_BUTTON_WIDTH/2,PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        }
        x = TankStars.WIDTH/2 - RESUME_BUTTON_WIDTH/2;
        if(Gdx.input.getX()< x + RESUME_BUTTON_WIDTH && Gdx.input.getX()>x && TankStars.HEIGHT -Gdx.input.getY() < (RESUME_BUTTON_Y + RESUME_BUTTON_HEIGHT) && TankStars.HEIGHT-Gdx.input.getY()> RESUME_BUTTON_Y){
            game.batch.draw(resumeButtonActive,TankStars.WIDTH/2 - RESUME_BUTTON_WIDTH/2,RESUME_BUTTON_Y, RESUME_BUTTON_WIDTH, RESUME_BUTTON_HEIGHT);
        }
        else {
            game.batch.draw(resumeButtonInactive,TankStars.WIDTH/2 - RESUME_BUTTON_WIDTH/2,RESUME_BUTTON_Y, RESUME_BUTTON_WIDTH, RESUME_BUTTON_HEIGHT);
        }
        //game.batch.draw(Resume_button,TankStars.WIDTH/2 - RESUME_BUTTON_WIDTH/2,RESUME_BUTTON_Y, RESUME_BUTTON_WIDTH, RESUME_BUTTON_HEIGHT);

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
