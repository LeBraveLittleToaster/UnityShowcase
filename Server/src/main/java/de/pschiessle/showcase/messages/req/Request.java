package de.pschiessle.showcase.messages.req;

import de.pschiessle.showcase.messages.req.RequestType;
import java.util.UUID;

public class Request {
  private RequestType messageType;
  private String requestId;

  public Request() {

  }

  public Request(RequestType messageType) {
    this.messageType = messageType;
    this.requestId = UUID.randomUUID().toString();
  }

  public RequestType getMessageType() {
    return messageType;
  }

  public String getRequestId() {
    return requestId;
  }

}
