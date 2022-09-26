package com.fcsuarez96.game.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.fcsuarez96.game.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
    config.setForegroundFPS(60);
    config.setWindowedMode(Game.SCREEN_WIDTH, Game.SCREEN_WIDTH);
		new Lwjgl3Application(new Game(), config);
	}
}
