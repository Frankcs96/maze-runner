package com.fcsuarez96.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	SpriteBatch spriteBatch;
	Map map;
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		map = new Map();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		map.draw(spriteBatch);
		spriteBatch.end();
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();

	}
}
