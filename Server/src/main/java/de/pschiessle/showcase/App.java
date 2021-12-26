package de.pschiessle.showcase;

import com.google.gson.Gson;
import de.pschiessle.showcase.handler.MoveEntityHandler;
import de.pschiessle.showcase.handler.SpawnEntityHandler;
import de.pschiessle.showcase.messages.req.MoveEntityReq;
import de.pschiessle.showcase.messages.req.Request;
import de.pschiessle.showcase.messages.req.SpawnEntityReq;
import org.java_websocket.WebSocket;

public class App {

  private final Gson gson = new Gson();
  private final GameManager gameManager;
  private final Network network;


  public App() {
    this.gameManager = new GameManager();
    this.network = new Network(this,1234);
  }

  public void handleMessage(WebSocket conn, String msg) {
    System.out.println("Handling message: " + msg);
    Request container = gson.fromJson(msg, Request.class);
    switch (container.messageType) {
      case SPAWN_ENTITY -> new SpawnEntityHandler(gson.fromJson(msg, SpawnEntityReq.class),
          gameManager, network, gson).execute();
      case MOVE_ENTITY -> new MoveEntityHandler(gson.fromJson(msg, MoveEntityReq.class),
          gameManager, network, gson).execute();
      default -> network.broadcast(msg);
    }
  }

  public void start() {
    network.start();
  }

  public static void main(String[] args) {
    App app = new App();
    app.start();
  }
}
