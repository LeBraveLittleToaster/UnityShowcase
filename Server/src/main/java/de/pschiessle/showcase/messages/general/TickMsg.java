package de.pschiessle.showcase.messages.general;

import de.pschiessle.showcase.data.updates.TileUpdate;
import de.pschiessle.showcase.messages.resp.Response;
import de.pschiessle.showcase.messages.resp.ResponseType;
import java.util.List;

public class TickMsg extends Response {

  public final List<TileUpdate> tileUpdates;

  public TickMsg(List<TileUpdate> tileUpdates) {
    super(ResponseType.TICK, null);
    this.tileUpdates = tileUpdates;
  }

}
