package de.pschiessle.showcase.handler;

import com.google.gson.Gson;
import de.pschiessle.showcase.data.Entity;
import de.pschiessle.showcase.GameManager;
import de.pschiessle.showcase.Network;
import de.pschiessle.showcase.messages.req.MoveEntityReq;
import de.pschiessle.showcase.messages.resp.MoveEntityResp;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoveEntityHandler implements ActionHandler {

  private static Logger LOG = LoggerFactory.getLogger(MoveEntityHandler.class);

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
        .noneMatch(e -> e.getPos().equals(message.getPosition()))
        && gameManager.getEntitiesList()
        .stream()
        .anyMatch(e -> e.getId() == message.getEntityId());
  }

  @Override
  public void execute() {

    Optional<Entity> entity = gameManager.moveEntityTo(message.getEntityId(), message.getPosition());
    entity.ifPresent(e -> network.broadcast(gson.toJson(new MoveEntityResp(e, message.getRequestId()))));
  }
}
