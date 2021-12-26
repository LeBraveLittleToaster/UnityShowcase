package de.pschiessle.showcase.handler;

import com.google.gson.Gson;
import de.pschiessle.showcase.data.Entity;
import de.pschiessle.showcase.GameManager;
import de.pschiessle.showcase.Network;
import de.pschiessle.showcase.messages.req.MoveEntityReq;
import de.pschiessle.showcase.messages.resp.MoveEntityResp;
import java.util.Optional;

public class MoveEntityHandler implements ActionHandler {

  public final MoveEntityReq message;
  public final GameManager gameManager;
  public final Network network;
  public final Gson gson;

  public MoveEntityHandler(MoveEntityReq message, GameManager gameManager,
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
        .noneMatch(e -> e.getPos().equals(message.position))
        && gameManager.getEntitiesList()
        .stream()
        .anyMatch(e -> e.getId() == message.entityId);
  }

  @Override
  public void execute() {
    Optional<Entity> entity = gameManager.moveEntityTo(message.entityId, message.position);
    entity.ifPresent(e -> network.broadcast(gson.toJson(new MoveEntityResp(e, message.requestId))));
  }
}
