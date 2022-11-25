package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class SelectionScreen implements Screen {

    public Texture getBkg() {
        return bkg;
    }

    public void setBkg(Texture bkg) {
        this.bkg = bkg;
    }

    private Texture bkg;

    public ArrayList<Animation<TextureRegion>> getTank_list() {
        return tank_list;
    }

    private ArrayList<Animation<TextureRegion>> tank_list;

    public Animation<TextureRegion> getTank() {
        return tank;
    }

    public void setTank(Animation<TextureRegion> tank) {
        this.tank = tank;
    }

    private Animation<TextureRegion> tank;
    private Texture name;

    public Buttons getLeft() {
        return left;
    }

    public void setLeft(Buttons left) {
        this.left = left;
    }

    private Buttons left;

    public Buttons getRight() {
        return right;
    }

    public void setRight(Buttons right) {
        this.right = right;
    }

    private Buttons right;
    private Buttons siren;
    private  TankStars game;

    public Buttons getPlayer() {
        return player;
    }

    public void setPlayer(Buttons player) {
        this.player = player;
    }

    private Buttons player;

    public SelectionScreen(String bkg,String name,String left,String right,String player){
        this.bkg=new Texture(bkg);
        this.tank=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(name).read());
        this.left=new Buttons(left,450,150);
        this.right=new Buttons(right,450,150);
        this.player=new Buttons(player,200,400);
    }

    public void addTank(String s){
        Animation<TextureRegion> newTank=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(s).read());
        tank_list.add(newTank);
    }
    public Animation<TextureRegion> getTank(int x){
        return tank_list.get(x);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
//

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
