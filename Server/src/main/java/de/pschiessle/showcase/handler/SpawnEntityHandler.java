package de.pschiessle.showcase.handler;

import com.google.gson.Gson;
import de.pschiessle.showcase.data.Entity;
import de.pschiessle.showcase.GameManager;
import de.pschiessle.showcase.Network;
import de.pschiessle.showcase.messages.req.SpawnEntityReq;
import de.pschiessle.showcase.messages.resp.SpawnEntityResp;

public class SpawnEntityHandler implements ActionHandler {

  public final SpawnEntityReq message;
  public final GameManager gameManager;
  public final Network network;
  public final Gson gson;

  public SpawnEntityHandler(SpawnEntityReq message, GameManager gameManager,
      Network network, Gson gson) {
    this.message = message;
    this.gameManager = gameManager;
    this.network = network;
    this.gson = gson;
  }

  @Override
  public boolean validate() {
    return gameManager
        .getEntitiesList()
        .stream()
        .noneMatch(e -> e.getName().equals(message.name)
            && e.getPos().equals(message.position));
  }

  @Override
  public void execute() {
    Entity entity = gameManager.addEntity(message.name, message.position);
    network.broadcast(gson.toJson(new SpawnEntityResp(entity, message.requestId)));
  }
}
