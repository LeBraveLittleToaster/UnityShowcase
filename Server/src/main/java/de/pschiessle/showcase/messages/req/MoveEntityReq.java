package de.pschiessle.showcase.messages.req;

import de.pschiessle.showcase.utils.Vector3Int;

public class MoveEntityReq extends Request {

  public final int entityId;
  public final Vector3Int position;

  public MoveEntityReq(int entityId, Vector3Int position) {
    super(RequestType.MOVE_ENTITY);
    this.entityId = entityId;
    this.position = position;
  }
}
