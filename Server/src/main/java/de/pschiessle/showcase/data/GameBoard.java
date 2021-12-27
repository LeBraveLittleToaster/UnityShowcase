package de.pschiessle.showcase.data;

import de.pschiessle.showcase.utils.ArrayHelper;
import java.util.Arrays;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameBoard {

  private static final Logger LOG = LoggerFactory.getLogger(GameBoard.class);

  private Tile[][] tiles;

  public GameBoard(int sizeX, int sizeY) {
    createGameBoard(sizeX, sizeY);
  }

  public void createGameBoard(int sizeX, int sizeY){
    tiles = new Tile[sizeX][sizeY];
    Random random = new Random();
    for (int x = 0; x < sizeX; x++) {
      for (int y = 0; y < sizeY; y++) {
        tiles[x][y] = new Tile(random.nextBoolean() ? FloorType.STONE : FloorType.EARTH);
      }
    }
  }

  public boolean isFieldSeeded(int x, int y){
    if(ArrayHelper.is2DIndexInRange(tiles, x,y)){
      return tiles[x][y].getPlant() != null;
    }
    return true;
  }

  public void setPlant(int x, int y, Plant plant){
    if(ArrayHelper.is2DIndexInRange(tiles, x,y)){
      tiles[x][y].setPlant(plant);
    }else{
      LOG.error("Cannot place plant, " + x + "|" + y + " not in index range of tiles array");
    }
  }

  public void tick(float deltaTime) {
    Arrays.stream(tiles).flatMap(Arrays::stream).forEach(tile -> tile.getPlant().grow(deltaTime));
  }
}
