package com.fcsuarez96.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {

  private enum Direction {UP, DOWN, RIGHT, LEFT}

  private static final float SPEED = 0.3f;

  private Game game;
  private Direction direction = Direction.RIGHT;
  private Sprite sprite;
  private int x = 10;
  private int y = 5;

  private float tickSpeed;


  public Player(Game game) {
    this.game = game;
    sprite = new Sprite(new Texture("slimeBlock.png"));
  }


  public void draw(SpriteBatch spriteBatch) {
    sprite.setBounds(x * Map.TILE_SIZE + Map.OFFSET_X, y * Map.TILE_SIZE + Map.OFFSET_Y + 4,
        Map.TILE_SIZE, Map.TILE_SIZE);

    sprite.draw(spriteBatch);
  }


  public void update(float delta) {
    playerInput();

    tickSpeed += delta;
    if (tickSpeed >= SPEED) {
      tickSpeed = 0;
      playerMovement();
    }
  }


  private void playerInput() {
    if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
      Gdx.app.exit();
    }

    if (Gdx.input.isKeyPressed(Keys.W)) {
      direction = Direction.UP;
    }

    if (Gdx.input.isKeyPressed(Keys.A)) {
      direction = Direction.LEFT;
    }

    if (Gdx.input.isKeyPressed(Keys.S)) {
      direction = Direction.DOWN;
    }

    if (Gdx.input.isKeyPressed(Keys.D)) {
      direction = Direction.RIGHT;
    }
  }

  private void playerMovement() {
    if (!isWall()) {
      switch (direction) {
        case UP:
          y++;
          break;

        case DOWN:
          y--;
          break;

        case RIGHT:
          x++;
          break;

        case LEFT:
          x--;
          break;
      }
    }

  }

  private boolean isWall() {
    int tile = 0;
    switch (direction) {
      case UP:
        tile = game.map.getTile(x, y + 1);
        break;

      case DOWN:
        tile = game.map.getTile(x, y - 1);
        break;

      case RIGHT:
        tile = game.map.getTile(x + 1, y);
        break;

      case LEFT:
        tile = game.map.getTile(x - 1, y);
        break;
    }
    return (tile == 1) || (tile == -1);
  }

}

