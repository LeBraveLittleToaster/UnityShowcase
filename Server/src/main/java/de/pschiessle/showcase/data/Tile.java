package de.pschiessle.showcase.data;

import java.util.Optional;

public class Tile {

  private FloorType floorType;
  private Plant plant;

  public Tile(FloorType floorType, Plant plant) {
    this.floorType = floorType;
    this.plant = plant;
  }

  public Tile(FloorType floorType) {
    this.floorType = floorType;
  }

  public FloorType getFloorType() {
    return floorType;
  }

  public void setFloorType(FloorType floorType) {
    this.floorType = floorType;
  }

  public Plant getPlant() {
    return plant;
  }

  public void setPlant(Plant plant) {
    this.plant = plant;
  }
}
