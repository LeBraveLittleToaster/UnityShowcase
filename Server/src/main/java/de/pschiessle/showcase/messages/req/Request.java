package de.pschiessle.showcase.messages.req;

import de.pschiessle.showcase.messages.req.RequestType;
import java.util.UUID;

public abstract class Request {
  public final RequestType messageType;
  public final String requestId;

  public Request(RequestType messageType) {
    this.messageType = messageType;
    this.requestId = UUID.randomUUID().toString();
  }
}
