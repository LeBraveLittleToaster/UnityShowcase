package de.pschiessle.showcase.messages.req;

import de.pschiessle.showcase.messages.req.RequestType;
import java.util.UUID;

public class Request {
  public final RequestType messageType;
  public final String requestId;

  public Request(RequestType messageType, String requestId) {
    this.messageType = messageType;
    this.requestId = requestId;
  }
}
