package de.pschiessle.showcase.data;

import de.pschiessle.showcase.utils.Vector3Int;

public class Entity {
  private Vector3Int pos;
  private String name;
  private int id;

  public Entity() {
  }

  public Entity(Vector3Int pos, String name, int id) {
    this.pos = pos;
    this.name = name;
    this.id = id;
  }

  public Vector3Int getPos() {
    return pos;
  }

  public void setPos(Vector3Int pos) {
    this.pos = pos;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Entity{" +
        "pos=" + pos +
        ", name='" + name + '\'' +
        ", id=" + id +
        '}';
  }
}
