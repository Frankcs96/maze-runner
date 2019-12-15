package com.fcsuarez96.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fcsuarez96.game.Enemy.GhostColor;
import java.util.ArrayList;
import java.util.List;

public class Game extends ApplicationAdapter {

  public static final int SCREEN_WIDTH = 800;
  public static final int SCREEN_HEIGHT = 800;
  SpriteBatch spriteBatch;
  Map map;
  List<Entity> entities = new ArrayList<>();

  @Override
  public void create() {
    spriteBatch = new SpriteBatch();
    map = new Map();
		entities.add(new Player(this));
    entities.add(new Enemy(this, GhostColor.RED));
    entities.add(new Enemy(this, GhostColor.BLUE));
    entities.add(new Enemy(this, GhostColor.ORANGE));
    entities.add(new Enemy(this, GhostColor.PINK));
  }

  @Override
  public void render() {
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    float delta = Gdx.graphics.getDeltaTime();
    spriteBatch.begin();
    map.draw(spriteBatch);

    for (Entity entity : entities) {
      entity.draw(spriteBatch);
    }

    spriteBatch.end();


    for (Entity entity : entities) {
      entity.update(delta);
    }
  }

  @Override
  public void dispose() {
    spriteBatch.dispose();

  }
}
