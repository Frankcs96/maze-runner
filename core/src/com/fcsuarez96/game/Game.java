package com.fcsuarez96.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fcsuarez96.game.Enemy.GhostColor;
import java.util.ArrayList;
import java.util.List;

public class Game extends ApplicationAdapter {

  public static final int SCREEN_WIDTH = 800;
  public static final int SCREEN_HEIGHT = 800;
  SpriteBatch spriteBatch;
  BitmapFont font;
  Map map;
  Player player;
  List<Entity> entities = new ArrayList<>();
  int chest = 5;
  String text;

  @Override
  public void create() {
    spriteBatch = new SpriteBatch();
    font = new BitmapFont();
    font.setColor(Color.RED);
    map = new Map();
		player = new Player(this);
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
    if (chest > 0) {
      font.draw(spriteBatch,"Chest remaining: " + chest,350,750);
    } else {
      player.win();
      font.draw(spriteBatch,"CONGRATULATIONS! THX FOR PLAYING",350,750);
    }

    map.draw(spriteBatch);
    player.draw(spriteBatch);
    for (Entity entity : entities) {
      entity.draw(spriteBatch);
    }

    spriteBatch.end();

    player.update(delta);
    for (Entity entity : entities) {
      entity.update(delta);
    }
  }

  @Override
  public void dispose() {
    spriteBatch.dispose();

  }
}
