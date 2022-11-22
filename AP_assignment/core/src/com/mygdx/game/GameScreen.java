package com.mygdx.game;



import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Bezier;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;




public class GameScreen extends ApplicationAdapter implements Screen  {
    private Bezier<Vector2> path1;
    private CatmullRomSpline<Vector2> path2;
    private ShapeRenderer sr;

    Texture health_bar;
    public static final float speed = 120 ;
    Texture foreground;
    Texture Frost_tank;
    Texture Abrams_tank;
    public static final int TankWidth = 51;
    public static final int TankHeight = 96;
    Animation[] rolls;
    int roll;
    float x;
    float y;
    TankStars game;
    Texture back_ground;
    Texture terrain;
    Animation<TextureRegion> rain;
    float del=0;
    Animation<TextureRegion> thunder;
    float delt=0;

    Texture PauseScreen;

    PauseMenu p;
    boolean xt=false;

    private Texture healthbarp1;
    private Texture healthbarp2;

    public GameScreen(TankStars game){
        this.game = game;
        y = 0;
        x = 0;
    }
    @Override
    public void create(){



    }

    @Override
    public void show() {
    foreground = new Texture("asd.jpg");
    Frost_tank = new Texture("Frost.png");
    Abrams_tank = new Texture("Abrams.jpg");
    health_bar = new Texture("health_bar.png");
    back_ground=new Texture("backg.png");
    terrain=new Texture("Heightmap.png");
    rain=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("rain.gif").read());
    thunder=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("thunder.gif").read());
//    PauseScreen=new Texture(("pause_menu.png"));
        p=new PauseMenu(game,"pause_menu.png","resume_pause_menu.png","exit_pause_menu.png","restart_pause_menu.png");

    }

    @Override
    public void render(float delta) {

        del+= Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed((Input.Keys.LEFT))){
            x = x - speed* Gdx.graphics.getDeltaTime();
            if(x<0){
                x=0;
            }
        }
        else if (Gdx.input.isKeyPressed((Input.Keys.RIGHT))) {
            x = x + speed* Gdx.graphics.getDeltaTime();
            if(x+TankWidth>Gdx.graphics.getWidth()){
                x = Gdx.graphics.getWidth() - TankWidth-40;
            }
        }
        ScreenUtils.clear(0, 0, 0, 1);
        game.batch.begin();

        game.batch.draw(back_ground,-10,100,800,300);
        game.batch.draw(rain.getKeyFrame(del), -10, 100,800,300);
//        game.batch.draw(PauseScreen,100,100,800,300);


        game.batch.draw(terrain,-10,100,800,380);
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) xt=xt==true?false:true;

        if(xt==true){
            game.batch.draw(p.getPauseScreen(), 80, 50, 500, 400);
            game.batch.draw(p.getResume(),180,200,300,200);
            game.batch.draw(p.getRestart(),180,150,300,200);
            game.batch.draw(p.getExit(),180,100,300,200);

        }




//        if(Gdx.input.isKeyPressed(Input.Keys.X)) {
//            this.dispose();
//            game.setScreen(new PauseMenu(game));
////            if(Gdx.input.isKeyPressed(Input.Keys.X)){
////                game.setScreen(new GameScreen(game));
////            }
//
//        }



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
//        game.batch.dispose();

    }
}
