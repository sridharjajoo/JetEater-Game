package com.codingblocks.jeteater.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.codingblocks.jeteater.EaterGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=EaterGame.WIDTH;
		config.height=EaterGame.HEIGHT;
		new LwjglApplication(new EaterGame(), config);
	}
}
