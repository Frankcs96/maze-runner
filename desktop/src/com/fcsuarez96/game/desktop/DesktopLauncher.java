package com.fcsuarez96.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.fcsuarez96.game.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = Game.SCREEN_HEIGHT;
		config.width = Game.SCREEN_WIDTH;
		new LwjglApplication(new Game(), config);
	}
}
