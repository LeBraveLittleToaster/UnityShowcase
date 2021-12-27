package de.pschiessle.showcase.handler;

import com.google.gson.Gson;
import de.pschiessle.showcase.data.Entity;
import de.pschiessle.showcase.GameManager;
import de.pschiessle.showcase.Network;
import de.pschiessle.showcase.messages.req.SpawnEntityReq;
import de.pschiessle.showcase.messages.resp.SpawnEntityResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpawnEntityHandler implements ActionHandler {

  private static Logger LOG = LoggerFactory.getLogger(SpawnEntityHandler.class);

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
    boolean isValid = gameManager
        .getEntitiesList()
        .stream()
        .noneMatch(e -> e.getName().equals(message.getName())
            && e.getPos().equals(message.getPosition()));
    LOG.debug("Spawning Entity allowed? [ " + isValid + " ]");
    return isValid;
  }

  @Override
  public void execute() {
    Entity entity = gameManager.addEntity(message.getName(), message.getPosition());
    LOG.debug("Spawning Entity=" + entity);
    String msg = gson.toJson(new SpawnEntityResp(entity, message.getRequestId()));
    LOG.debug("Broadcasting spawn Entity response=" + msg);
    network.broadcast(msg);
  }
}
