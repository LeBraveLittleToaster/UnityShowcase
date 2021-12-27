package de.pschiessle.showcase.handler;

public class HandleExecutor {
  public static boolean executeHandler(ActionHandler handler){
    if(!handler.validate()) return false;
    handler.execute();
    return true;
  }
}
