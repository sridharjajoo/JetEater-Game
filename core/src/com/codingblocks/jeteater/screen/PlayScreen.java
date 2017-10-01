package com.codingblocks.jeteater.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.codingblocks.jeteater.EaterGame;
import com.codingblocks.jeteater.scene.HUD;
import com.codingblocks.jeteater.sprite.Bomb;
import com.codingblocks.jeteater.sprite.Coin;
import com.codingblocks.jeteater.sprite.Jet;

import java.util.LinkedList;

import sun.font.CreatedFontTracker;

import static com.codingblocks.jeteater.EaterGame.batch;

/**
 * Created by sridhar123 on 30/9/17.
 */

//screen is an interface so we are implementing it
public class PlayScreen implements Screen {

    private Jet jet;
    private HUD hud;
    private float time=0;


    //2 cameras perspective and orthogonal
    //orthogonal for 2d and perspective for 3d
    private OrthographicCamera gameCam;
    private StretchViewport viewPort1,viewPort2;

    private LinkedList<Coin> coins = new LinkedList<Coin>();
    private LinkedList<Bomb> bombs= new LinkedList<Bomb>();

    public PlayScreen() {
        jet = new Jet();
        hud = new HUD();
        gameCam = new OrthographicCamera(EaterGame.WIDTH,EaterGame.HEIGHT);
        viewPort1 = new StretchViewport(EaterGame.WIDTH,EaterGame.HEIGHT, gameCam);
        gameCam.translate(EaterGame.WIDTH/2,EaterGame.HEIGHT/2);
//        viewPort2 = new StretchViewport(hud.stage.getWidth(),hud.stage.getHeight() ,hud.stage.getCamera());

        for (int i=0;i<4;i++)
          coins.add(new Coin());

      for (int i=0;i<4;i++)
            bombs.add(new Bomb());

    }

    //for using screen we have to use constructor
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update();//first the thing gets updated then it is shown
        time= time+delta;
        if(time>=1){
            hud.timer();
            time=0;
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);//(R,G,B,ALPHA)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        EaterGame.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

        EaterGame.batch.setProjectionMatrix(gameCam.combined);

        EaterGame.batch.begin();//batach is like in memeory canvas
        for(Bomb bomb :bombs){
            bomb.draw(EaterGame.batch);
        }

        for(Coin coin :coins){
            coin.draw(EaterGame.batch);
        }

        //batch.draw(img, 0, 0);//batch is like a graph paper
        //earlier we gave info to batch how to draw...now info is given
        jet.draw(EaterGame.batch);

        batch.end();
    }

    private void update() {
        handleInput();
        handleEvent();
        gameCam.update();
    }

    private void handleEvent() {
        for(Bomb bomb :bombs){
            if(bomb.checkHit(jet)) {
                hud.kill();
                for(Bomb bomb1:bombs){
                    bomb1.relocate();
                }

            }
        }

        for(Coin coin :coins){
            if(coin.checkHit(jet)){
                hud.addScore(10);
                for(Coin coin1:coins){
                    coin1.relocate();
                }

            }
        }
    }

    private void handleInput() {
        Vector3 vector = new Vector3(Gdx.input.getX(),Gdx.input.getY(),0);
        gameCam.unproject(vector);
//camera sets coordinates with respect to screen density and lower coordinate wrt to lower coordinates
//        int x = (int) Gdx.input.getX();
//            int y = (int) (Gdx.graphics.getHeight()-Gdx.input.getY());
            jet.setGoal((int) vector.x,(int) vector.y);
    }


    @Override
    public void resize(int width, int height) {
        viewPort1.update(width,height);
//        viewPort2.update(width, height);

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
    //sprites are never disposed...only texture and images are disposed
    }
}
