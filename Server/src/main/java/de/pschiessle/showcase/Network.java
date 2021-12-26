package de.pschiessle.showcase;

import java.net.InetSocketAddress;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class Network extends WebSocketServer {

  public final App app;

  public Network(App app,int port) {
    super(new InetSocketAddress(port));
    this.app = app;
  }

  @Override
  public void onOpen(WebSocket conn, ClientHandshake handshake) {
    System.out.println("New connection opened");
  }

  @Override
  public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    System.out.println("Connection closed");
  }

  @Override
  public void onMessage(WebSocket conn, String message) {
    this.app.handleMessage(conn, message);
  }

  @Override
  public void onError(WebSocket conn, Exception ex) {

  }

  @Override
  public void onStart() {
    System.out.println("Server started!");
  }
}
