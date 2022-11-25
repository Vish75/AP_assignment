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
    Texture vslogo;
    public static final int TankWidth = 51;
    public static final int TankHeight = 96;
    Animation[] rolls;
    int roll;
    float x;
    float y;
    TankStars game;
    Texture back_ground;
    Texture terrain;

    Animation<TextureRegion> tank;
    Texture p1tank;
    Texture p2tank;

    Animation<TextureRegion> rain;
    float del=0;
    Animation<TextureRegion> thunder;
    float delt=0;

    Texture PauseScreen;

    PauseMenu p;
    GameOver go;
    boolean xt=false;
    boolean gt=false;

    private Texture healthbarp1;
    private Texture healthbarp2;

    Texture bomb1;
    Texture bomb2;
    Texture bomb3;

    Texture p1fuel;
    Texture p2fuel;


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
    tank=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP,Gdx.files.internal("p1_tank.gif").read());
    rain=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("rain.gif").read());
    thunder=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("thunder.gif").read());
    p1tank=new Texture("p1_tank.png");
    p2tank=new Texture("p2_tank.png");
    healthbarp1=new Texture("health_bar.png");
    healthbarp2=new Texture("health_bar.png");
    vslogo=new Texture("vslogo.png");
    bomb1=new Texture("Freeze_Bomb.png");
    bomb2=new Texture("fire_bomb.png");
    bomb3=new Texture("dash_bomb.png");
    p1fuel=new Texture("fuel.png");
    p2fuel=new Texture("fuel.png");

//    PauseScreen=new Texture(("pause_menu.png"));
        p=new PauseMenu(game,"pause_menu.png","resume_pause_menu.png","exit_pause_menu.png","restart_pause_menu.png");
        go=new GameOver(game,"Game_Over.png","pause_menu.png","exit_pause_menu.png","restart_pause_menu.png");

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
//        game.batch.draw(tank.getKeyFrame(del),20,200,200,100);
        game.batch.draw(p1tank,40,240,90,70);
        game.batch.draw(p2tank,400,240,90,70);
        game.batch.draw(vslogo,240,370,200,100);
        game.batch.draw(healthbarp1,100,415,200,30);
        game.batch.draw(healthbarp2,380,415,200,30);
        game.batch.draw(bomb1,10,40,40,40);
        game.batch.draw(bomb2,40,40,40,40);
        game.batch.draw(bomb3,70,40,40,40);

        game.batch.draw(bomb1,530,40,40,40);
        game.batch.draw(bomb2,560,40,40,40);
        game.batch.draw(bomb3,590,40,40,40);
        game.batch.draw(p1fuel,40,280,80,50);
        game.batch.draw(p2fuel,410,280,80,50);


        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) xt=xt==true?false:true;

        if(xt==true){
            game.batch.draw(p.getPauseScreen(), 80, 50, 500, 400);
            game.batch.draw(p.getResume(),180,200,300,200);
            game.batch.draw(p.getRestart(),180,150,300,200);
            game.batch.draw(p.getExit(),180,100,300,200);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.G)) gt=gt==true?false:true;

        if(gt==true){
            game.batch.draw(go.getBkg(),-300,-100,1500,700);
            game.batch.draw(go.getGameOverScreen(), 80, 100, 500, 400);
            game.batch.draw(go.getRestart(),50,0,300,200);
            game.batch.draw(go.getExit(),310,0,300,200);
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
