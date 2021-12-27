package de.pschiessle.showcase.data;

import java.util.LinkedList;
import java.util.List;

public class Warehouse {
  private List<Plant> plantList;

  public Warehouse() {
    this.plantList = new LinkedList<>();
  }

  public List<Plant> getPlantList() {
    return plantList;
  }

  public void addPlant(Plant plant){
    plantList.add(plant);
  }
}
