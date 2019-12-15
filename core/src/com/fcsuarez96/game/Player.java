package com.fcsuarez96.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends Entity {



  public Player(Game game) {
    super(game,"slimeBlock.png" );
    x = 10;
    y = 5;
  }


  public void update(float delta) {
    playerInput();

    tickSpeed += delta;
    if (tickSpeed >= speed) {
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

