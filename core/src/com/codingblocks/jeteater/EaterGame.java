package com.codingblocks.jeteater;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.codingblocks.jeteater.screen.PlayScreen;

public class EaterGame extends Game {
	public static SpriteBatch batch;
    //overlapping of all the images...tends to be very heavy so we use public static
	//we use Game extends so that we are able to make more screens like play,pause

    public static final int WIDTH=800;
    public static final int HEIGHT=400;

    @Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen());
    }

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
        batch.dispose();
	}
}
