package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
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

    Buttons sound_game;

    boolean music_playing;
    float del=0;

    Music theme_music;
    SplashScreen splashScreen;
    boolean showsplash=true;

    private OrthographicCamera gamecam;
    private Viewport gameport;

    private SelectionScreen select;

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
        sound_game=new Buttons("sound.png",50,100);
        theme_music= Gdx.audio.newMusic(Gdx.files.internal("main_menu_theme.mp3"));

        music_playing=setTheme_music(true);
        select=new SelectionScreen("bkg_SelectionScreen.png","Step_Tank.gif","Select_Left.png","Select_Right.png","Select_P1.png");
        splashScreen=new SplashScreen("loadscreen.jpg","load-unscreen.gif","dufhs");



//        gamecam=new OrthographicCamera();
//        gameport=new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),gamecam);
//        gameport.apply();
//        gamecam.position.set(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,0);
//        gamecam.update();

    }

    public boolean setTheme_music(boolean t){
        if(t==true){
            theme_music.setLooping(true);
            theme_music.play();
            return true;
        }
        else{
            theme_music.stop();
            return false;
        }
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
//        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        //splashscreen
        if(showsplash){
            game.batch.draw(splashScreen.getSplash(),0,0,700,500);
            game.batch.draw(splashScreen.getLoadbar().getKeyFrame(del),180,45,300,300);
            if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) showsplash=false;
        }
        else {
            game.batch.draw(background, 0, 0, 700, 500);

            game.batch.draw(Tank_STARS_LOGO, 0, 0, 450, 80);

            game.batch.draw(menu_bar, 350, -50, 400, 550);
            game.batch.draw(menu_tanks.getKeyFrame(del), -200, 40, 800, 300);
            game.batch.draw(resume_button.getButton_look(), 410, 200, resume_button.getWidth(), resume_button.getHeight());
            game.batch.draw(exit_button.getButton_look(), 380, -20, exit_button.getWidth(), exit_button.getHeight());
            game.batch.draw(new_game.getButton_look(), 380, 70, new_game.getWidth(), new_game.getHeight());
            game.batch.draw(sound_game.getButton_look(), -20, 425, sound_game.getWidth(), sound_game.getHeight());
            game.batch.draw(sound_game.getButton_look(), Gdx.input.getX() - 30, 470 - Gdx.input.getY(), sound_game.getWidth(), sound_game.getHeight());
            int mousex = Gdx.input.getX() - 30;
            int mousey = 470 - Gdx.input.getY();
            if (mousex > -20 && mousex < -20 + sound_game.getWidth() && mousey < 425 + sound_game.getHeight() && mousey > 425) {
                if (Gdx.input.isTouched()) {
                    if (music_playing == true) music_playing = setTheme_music(false);
                    else music_playing = setTheme_music(true);

                }
            }
            int x = TankStars.WIDTH / 2 - (int) new_game.getWidth() / 2;
            if (Gdx.input.getX() < 380 + new_game.getWidth() && Gdx.input.getX() > 380 && Gdx.input.getY() < (70 + new_game.getHeight()) && TankStars.HEIGHT - Gdx.input.getY() > 70) {
                if (Gdx.input.isTouched()) {
                    this.dispose();
                    game.setScreen(new GameScreen(game));
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                Texture forced = new Texture("forced_white_bg.png");
                game.batch.draw(select.getBkg(), -30, 0, 700, 500);
                game.batch.draw(select.getTank().getKeyFrame(del), 50, 30, 500, 200);
                game.batch.draw(select.getLeft().getButton_look(), -15, 30, select.getLeft().getWidth(), select.getLeft().getHeight());
                game.batch.draw(select.getRight().getButton_look(), 500, 30, select.getRight().getWidth(), select.getRight().getHeight());
                game.batch.draw(forced, 180, 370, 280, 80);
                game.batch.draw(select.getPlayer().getButton_look(), 130, 300, select.getPlayer().getWidth(), select.getPlayer().getHeight());
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
//        gameport.update(width,height);

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
