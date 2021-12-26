package de.pschiessle.showcase.handler;

import com.google.gson.Gson;
import de.pschiessle.showcase.GameManager;
import de.pschiessle.showcase.Network;
import de.pschiessle.showcase.messages.req.MoveEntityReq;
import de.pschiessle.showcase.messages.req.RemoveEntityReq;

public class RemoveEntityHandler implements ActionHandler{

  public final RemoveEntityReq message;
  public final GameManager gameManager;
  public final Network network;
  public final Gson gson;

  public RemoveEntityHandler(RemoveEntityReq message, GameManager gameManager,
      Network network, Gson gson) {
    this.message = message;
    this.gameManager = gameManager;
    this.network = network;
    this.gson = gson;
  }

  @Override
  public boolean validate() {
    return gameManager.getEntitiesList()
        .stream()
        .anyMatch(e -> e.getId() == message.entityId);
  }

  @Override
  public void execute() {
    gameManager.removeEntity(message.entityId);
  }
}
