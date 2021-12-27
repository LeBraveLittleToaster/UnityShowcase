package de.pschiessle.showcase.handler;

import com.google.gson.Gson;
import de.pschiessle.showcase.GameManager;
import de.pschiessle.showcase.Network;
import de.pschiessle.showcase.data.Plant;
import de.pschiessle.showcase.data.Seed;
import de.pschiessle.showcase.messages.req.PlantSeedReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlantSeedHandler implements ActionHandler {

  private static Logger LOG = LoggerFactory.getLogger(PlantSeedHandler.class);

  public final PlantSeedReq message;
  public final GameManager gameManager;
  public final Network network;
  public final Gson gson;

  private Seed seedToPlant;

  public PlantSeedHandler(PlantSeedReq message, GameManager gameManager,
      Network network, Gson gson) {
    this.message = message;
    this.gameManager = gameManager;
    this.network = network;
    this.gson = gson;
  }

  @Override
  public boolean validate() {
    this.seedToPlant = gameManager.getSeedConfig(message.getSeedType());
    if (seedToPlant == null) {
      LOG.debug("Seedconfig not available for seedType=" + message.getSeedType());
      return false;
    }
    if (gameManager.getPlayer().getGold() < seedToPlant.getCost()) {
      LOG.debug("Not enough gold for seeding");
      return false;
    }
    if (gameManager.getGameBoard().isFieldSeeded(message.getFieldX(), message.getFieldY())) {
      LOG.debug(
          "Field is already seeded, x=" + message.getFieldX() + " | y=" + message.getFieldY());
      return false;
    }
    return true;
  }

  @Override
  public void execute() {
    Plant plant = new Plant(seedToPlant);
    gameManager.getGameBoard().setPlant(message.getFieldX(), message.getFieldY(), plant);

  }
}
