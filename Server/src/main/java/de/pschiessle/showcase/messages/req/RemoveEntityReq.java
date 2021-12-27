package de.pschiessle.showcase.messages.req;

public class RemoveEntityReq extends Request{

  private int entityId;

  public RemoveEntityReq(int entityId) {
    super(RequestType.REMOVE_ENTITY);
    this.entityId = entityId;
  }

  public int getEntityId() {
    return entityId;
  }
}
