package de.pschiessle.showcase.messages.resp;

public abstract class Response {
  public final ResponseType reqType;
  public final String requestId;

  protected Response(ResponseType reqType, String requestId) {
    this.reqType = reqType;
    this.requestId = requestId;
  }
}
