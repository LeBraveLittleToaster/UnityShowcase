package de.pschiessle.showcase.messages.req;

import de.pschiessle.showcase.utils.Vector3Int;

public class SpawnEntityReq extends Request {

  public final String name;
  public final Vector3Int position;

  public SpawnEntityReq(String name, Vector3Int position) {
    super(RequestType.SPAWN_ENTITY);
    this.name = name;
    this.position = position;
  }
}
