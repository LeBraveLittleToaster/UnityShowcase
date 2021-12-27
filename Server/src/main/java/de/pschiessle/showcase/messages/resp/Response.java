package de.pschiessle.showcase.messages.resp;

public class Response {
  private ResponseType reqType;
  private String requestId;

  public Response() {
  }

  protected Response(ResponseType reqType, String requestId) {
    this.reqType = reqType;
    this.requestId = requestId;
  }

  public ResponseType getReqType() {
    return reqType;
  }

  public String getRequestId() {
    return requestId;
  }
}
