package com.mygdx.game;



import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
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

    public GameScreen(TankStars game){
        this.game = game;
        y = 0;
        x = 0;
    }
    @Override
    public void create(){
        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();
        int points = 4;
        Vector2[] controlPoints = new Vector2[points];
        for(int i=0;i<points;i++){
            int x = (int) (Math.random() * width);
            int y = (int) (Math.random() * height);
            Vector2 point = new Vector2(x,y);
            controlPoints[i] = point;
        }

        path1 = new Bezier<Vector2>(controlPoints);
        path2 = new CatmullRomSpline<Vector2>(controlPoints,true);

        sr = new ShapeRenderer();
        sr.setAutoShapeType(true);
    }
    @Override
    public void render(){
        ScreenUtils.clear(0, 0, 0, 1);
        sr.begin();
        sr.setColor(Color.WHITE);

        for(int i=0;i<100;++i){
            float t = i/100f;
            Vector2 st = new Vector2();
            Vector2 end = new Vector2();

            path1.valueAt(st,t);
            path1.valueAt(end, t - 0.01f);
            sr.line(st.x,st.y,end.x,end.y);
        }

        sr.setColor(Color.RED);
        for(int i =0;i<100;++i){
            float t = i/100f;
            Vector2 st = new Vector2();
            Vector2 end = new Vector2();
            path2.valueAt(st,t);
            path2.valueAt(end,t-0.01f);
            sr.line(st.x,st.y,end.x,end.y);
        }
        sr.end();
    }
    @Override
    public void show() {
    foreground = new Texture("asd.jpg");
    Frost_tank = new Texture("Frost.png");
    Abrams_tank = new Texture("Abrams.jpg");
    health_bar = new Texture("health_bar.png");
    }

    @Override
    public void render(float delta) {
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
        game.batch.draw(foreground,0 ,0, TankStars.WIDTH,TankStars.HEIGHT);
        game.batch.draw(Abrams_tank,x,y,75,75);
        game.batch.draw(health_bar,0,100,100,50);
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
        game.batch.dispose();

    }
}
