package de.pschiessle.showcase;

import de.pschiessle.showcase.data.GameBoard;
import de.pschiessle.showcase.data.Player;
import de.pschiessle.showcase.data.Seed;
import de.pschiessle.showcase.data.SeedType;
import de.pschiessle.showcase.data.updates.TileUpdate;
import de.pschiessle.showcase.messages.general.TickMsg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {

  private Map<SeedType, Seed> seedConfig;
  private Player player;
  private GameBoard gameBoard;
  private long clock;
  private List<TileUpdate> tileUpdates;

  public GameManager() {

    this.player = new Player();
    this.gameBoard = new GameBoard(10,10);
    this.clock = 0;
  }

  public void tick(){
    this.clock += 1;
    gameBoard.tick(this.clock);
  }

  public void sendTickMsg(){
    TickMsg msg = new TickMsg(tileUpdates);

  }

  public void addTileUpdate(TileUpdate tileUpdate){
    tileUpdates.add(tileUpdate);
  }

  private Map<SeedType, Seed> createSeedConfigs(){
    Map<SeedType, Seed> seeds = new HashMap<>();
    seeds.put(SeedType.GRASS, new Seed(SeedType.GRASS, 1,0.1f,1,0));
    seeds.put(SeedType.WHEAT, new Seed(SeedType.WHEAT, 2,0.5f,2,0));
    seeds.put(SeedType.CORN, new Seed(SeedType.CORN, 4,0.1f,5,0));
    return seeds;
  }

  public Seed getSeedConfig(SeedType seedType){
    return seedConfig.get(seedType);
  }

  public Player getPlayer() {
    return player;
  }

  public GameBoard getGameBoard() {
    return gameBoard;
  }
}
