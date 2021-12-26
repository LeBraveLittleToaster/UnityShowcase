package de.pschiessle.showcase.messages.resp;

import de.pschiessle.showcase.data.Entity;

public class MoveEntityResp extends Response{

  private final Entity entity;

  public MoveEntityResp(Entity entity, String requestId) {
    super(ResponseType.MOVE_ENTITY, requestId);
    this.entity = entity;
  }
}
