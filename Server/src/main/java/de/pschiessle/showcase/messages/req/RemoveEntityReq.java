package de.pschiessle.showcase.messages.req;

public class RemoveEntityReq extends Request{

  public final int entityId;

  public RemoveEntityReq(int entityId) {
    super(RequestType.REMOVE_ENTITY);
    this.entityId = entityId;
  }
}
