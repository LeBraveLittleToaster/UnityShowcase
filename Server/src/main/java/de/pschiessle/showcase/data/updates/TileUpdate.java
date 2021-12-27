package de.pschiessle.showcase.data.updates;

public abstract class TileUpdate {
  public final int x;
  public final int y;


  protected TileUpdate(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
