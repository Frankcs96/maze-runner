package com.fcsuarez96.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {

  public static final int TILE_SIZE = 30;
  public static final int OFFSET_X = 85;
  public static final int OFFSET_Y = 85;

  Texture mapWall;
  Texture diamondWall;
  Sprite mapSprite;
  Sprite mapDiamondSprite;
  private int[][] map = {
      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
      {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
      {0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0},
      {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
      {0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0},
      {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
      {0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0},
      {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
      {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1},
      {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
      {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1},
      {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
      {0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0},
      {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
      {0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0},
      {0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
      {0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0},
      {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
      {0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0},
      {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}

  };

  public Map() {
    mapWall = new Texture("stone.png");
    diamondWall = new Texture("stone_diamond_alt.png");
    mapSprite = new Sprite(mapWall);
    mapDiamondSprite = new Sprite(diamondWall);

  }

  public void draw(SpriteBatch spriteBatch) {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        int wall = getTile(i, j);
        if (wall == 1) {
          mapSprite
              .setBounds(i * TILE_SIZE + OFFSET_X, j * TILE_SIZE + OFFSET_Y, TILE_SIZE,
                  TILE_SIZE);
          mapSprite.draw(spriteBatch);

        }

        if (wall == -1) {
          mapDiamondSprite
              .setBounds(i * TILE_SIZE + OFFSET_X, j * TILE_SIZE + OFFSET_Y, TILE_SIZE,
                  TILE_SIZE);
          mapDiamondSprite.draw(spriteBatch);
        }

      }
    }
  }

  public int getTile(int x, int y) {  //We dont have to worry about map position.
    return map[map.length - y - 1][x];
  }

  public boolean isWall(Entity entity, Entity.Direction direction) {
    switch (direction) {
      case UP:
        if (getTile(entity.x, entity.y + 1) == 1) {
          return true;
        }

      case DOWN:
        if (getTile(entity.x, entity.y - 1) == 1) {
          return true;
        }

      case LEFT:
        if (getTile(entity.x - 1, entity.y) == 1) {
          return true;
        }

      case RIGHT:
        if (getTile(entity.x + 1, entity.y) == 1) {
          return true;
        }
    }
    return false;
  }
}
