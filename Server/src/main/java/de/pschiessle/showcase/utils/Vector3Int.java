package de.pschiessle.showcase.utils;

public class Vector3Int  {
  public final int x;
  public final int y;
  public final int z;

  private Vector3Int(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public static Vector3Int zero() {
    return new Vector3Int(0,0,0);
  }

  public static Vector3Int from(int x, int y, int z){
    return new Vector3Int(x,y,z);
  }
}
