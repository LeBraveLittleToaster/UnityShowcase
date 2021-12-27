package de.pschiessle.showcase.messages.resp;

import de.pschiessle.showcase.data.Entity;

public class SpawnEntityResp extends Response{

  private Entity entity;

  public SpawnEntityResp() {
  }

  public SpawnEntityResp(Entity entity, String requestId) {
    super(ResponseType.SPAWN_ENTITY, requestId);
    this.entity = entity;
  }

  public Entity getEntity() {
    return entity;
  }
}
