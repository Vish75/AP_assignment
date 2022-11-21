package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import org.w3c.dom.Text;
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

    TankStars game;
    Texture background;
    Texture menu_bar;

    Texture Tank_STARS_LOGO;
    Animation<TextureRegion> menu_tanks;

    Buttons resume_button;
    Buttons exit_button;

    Buttons new_game;
    float del=0;

    public MainMenuScreen(TankStars game){
        this.game = game;
        //buttons
        resume_button=new Buttons("resume_button.png",190,220);
        exit_button=new Buttons("exit.png",250,290);
        new_game=new Buttons("new_game.png",250,290);

        menu_tanks = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("tankshoot.gif").read());
        background=new Texture("back_groundgarage.jpg");
        menu_bar=new Texture("menubar.png");
        Tank_STARS_LOGO=new Texture("TANK_STARS.jpg");

    }
    @Override
    public void create(){

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        del += Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(0, 0, 0, 0);
        game.batch.begin();

        game.batch.draw(background,0,0,700,500);

        game.batch.draw(Tank_STARS_LOGO,0,0,450,80);

        game.batch.draw(menu_bar,350,-50,400,550);
        game.batch.draw(menu_tanks.getKeyFrame(del), -200, 40,800,300);
        game.batch.draw(resume_button.getButton_look(),410,200,resume_button.getWidth(),resume_button.getHeight());
        game.batch.draw(exit_button.getButton_look(),380,-20,exit_button.getWidth(),exit_button.getHeight());
        game.batch.draw(new_game.getButton_look(),380,70,new_game.getWidth(),new_game.getHeight());
        int x = TankStars.WIDTH/2 - (int)new_game.getWidth()/2;
        if(Gdx.input.getX()< 380 + new_game.getWidth() && Gdx.input.getX()>380 && Gdx.input.getY() < (70 + new_game.getHeight()) && TankStars.HEIGHT-Gdx.input.getY()> 70){


            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new GameScreen(game));
            }
        }

//        int x = TankStars.WIDTH/2 - EXIT_BUTTON_WIDTH/2;
//        if(Gdx.input.getX()< x + EXIT_BUTTON_WIDTH && Gdx.input.getX()>x && TankStars.HEIGHT -Gdx.input.getY() < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT && TankStars.HEIGHT-Gdx.input.getY()> EXIT_BUTTON_Y){
//            game.batch.draw(exitButtonActive,TankStars.WIDTH/2 - EXIT_BUTTON_WIDTH/2,EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
//            if(Gdx.input.isTouched()){
//                Gdx.app.exit();
//            }
//        }
//        else {
//            game.batch.draw(exitButtonInactive,TankStars.WIDTH/2 - EXIT_BUTTON_WIDTH/2,EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
//        }
//
//        x = TankStars.WIDTH/2 - PLAY_BUTTON_WIDTH/2;
//        if(Gdx.input.getX()< x + PLAY_BUTTON_WIDTH && Gdx.input.getX()>x && TankStars.HEIGHT -Gdx.input.getY() < (PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT) && TankStars.HEIGHT-Gdx.input.getY()> PLAY_BUTTON_Y){
//            game.batch.draw(playButtonActive,TankStars.WIDTH/2 - PLAY_BUTTON_WIDTH/2,PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
//
//            if(Gdx.input.isTouched()){
//                this.dispose();
//                game.setScreen(new GameScreen(game));
//            }
//        }
//        else {
//            game.batch.draw(playButtonInactive,TankStars.WIDTH/2 - PLAY_BUTTON_WIDTH/2,PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
//        }
//        x = TankStars.WIDTH/2 - RESUME_BUTTON_WIDTH/2;
//        if(Gdx.input.getX()< x + RESUME_BUTTON_WIDTH && Gdx.input.getX()>x && TankStars.HEIGHT -Gdx.input.getY() < (RESUME_BUTTON_Y + RESUME_BUTTON_HEIGHT) && TankStars.HEIGHT-Gdx.input.getY()> RESUME_BUTTON_Y){
//            game.batch.draw(resumeButtonActive,TankStars.WIDTH/2 - RESUME_BUTTON_WIDTH/2,RESUME_BUTTON_Y, RESUME_BUTTON_WIDTH, RESUME_BUTTON_HEIGHT);
//        }
//        else {
//            game.batch.draw(resumeButtonInactive,TankStars.WIDTH/2 - RESUME_BUTTON_WIDTH/2,RESUME_BUTTON_Y, RESUME_BUTTON_WIDTH, RESUME_BUTTON_HEIGHT);
//        }
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
