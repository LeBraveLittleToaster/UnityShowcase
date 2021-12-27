package de.pschiessle.showcase;

import com.google.gson.Gson;
import de.pschiessle.showcase.handler.ActionHandler;
import de.pschiessle.showcase.handler.HandleExecutor;
import de.pschiessle.showcase.handler.PlantSeedHandler;
import de.pschiessle.showcase.messages.req.MoveEntityReq;
import de.pschiessle.showcase.messages.req.Request;
import de.pschiessle.showcase.messages.req.PlantSeedReq;
import org.java_websocket.WebSocket;

public class App {

  private final Gson gson = new Gson();
  private final GameManager gameManager;
  private final Network network;


  public App() {
    this.gameManager = new GameManager();
    this.network = new Network(this, 1234);
  }

  public void handleMessage(WebSocket conn, String msg) {
    System.out.println("Handling message: " + msg);
    Request container = gson.fromJson(msg, Request.class);

    ActionHandler handler = null;
    switch (container.messageType) {
      default -> network.broadcast(msg);
    }
    if (handler != null) {
      HandleExecutor.executeHandler(handler);
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
