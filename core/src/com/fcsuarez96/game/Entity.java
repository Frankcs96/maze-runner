package com.fcsuarez96.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Entity {

  public enum Direction {UP, DOWN, RIGHT, LEFT}



  public Game game;
  public Direction direction = Direction.RIGHT;

  public Sprite sprite;
  public int x;
  public int y;
  public float speed = 0.4f;

  public float tickSpeed;

  public Entity(Game game, String spritePath) {
    this.game = game;
    sprite = new Sprite(new Texture(spritePath));
  }


  public void draw(SpriteBatch spriteBatch) {
    sprite.setBounds(x * Map.TILE_SIZE + Map.OFFSET_X, y * Map.TILE_SIZE + Map.OFFSET_Y + 4,
        Map.TILE_SIZE, Map.TILE_SIZE);

    sprite.draw(spriteBatch);
  }

  public void update (float delta) {

  }
}
