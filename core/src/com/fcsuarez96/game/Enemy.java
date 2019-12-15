package com.fcsuarez96.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Enemy extends Entity {

  public enum GhostColor {RED, ORANGE, BLUE, PINK}

  public Enemy(Game game, GhostColor color) {
    super(game, "barnacle.png");

    switch (color) {
      case RED:
        sprite.setColor(Color.RED);
        x = 9;
        y = 11;
        break;
      case PINK:
        sprite.setColor(Color.PINK);
        x = 11;
        y = 11;
        break;
      case ORANGE:
        sprite.setColor(Color.ORANGE);
        x = 10;
        y = 12;
        break;
      case BLUE:
        sprite.setColor(Color.BLUE);
        x = 10;
        y = 11;
        break;
    }

  }

  public void update(float delta) {
    if (isIntersection()) {
      if (game.map.isWall(this,Direction.UP)) {
        //TODO
      }


    }
    switch (direction) {
      case UP:
        y++;
        break;
      case DOWN:
        y--;
        break;

      case LEFT:
        x--;
        break;

      case RIGHT:
        x++;
        break;
    }
  }

  private boolean isIntersection() {
    switch (direction) {
      case UP:
      case DOWN:
        if (!game.map.isWall(this,Direction.LEFT) ||!game.map.isWall(this,Direction.RIGHT)) {
          return true;
        }

      case LEFT:
      case RIGHT:
        if (!game.map.isWall(this,Direction.UP)|| !game.map.isWall(this,Direction.DOWN)) {
          return true;
        }
    }
    return false;
  }
}
