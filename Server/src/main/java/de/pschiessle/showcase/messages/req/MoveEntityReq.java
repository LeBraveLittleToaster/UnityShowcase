package de.pschiessle.showcase.messages.req;

import de.pschiessle.showcase.utils.Vector3Int;

public class MoveEntityReq extends Request {

  private int entityId;
  private Vector3Int position;

  public MoveEntityReq() {
  }

  public MoveEntityReq(int entityId, Vector3Int position) {
    super(RequestType.MOVE_ENTITY);
    this.entityId = entityId;
    this.position = position;
  }

  public int getEntityId() {
    return entityId;
  }

  public Vector3Int getPosition() {
    return position;
  }
}
