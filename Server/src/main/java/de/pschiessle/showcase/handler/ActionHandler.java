package de.pschiessle.showcase.handler;

public interface ActionHandler {
  boolean validate();
  void execute();
}
