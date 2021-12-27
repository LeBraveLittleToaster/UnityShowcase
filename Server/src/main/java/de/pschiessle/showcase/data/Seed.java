package de.pschiessle.showcase.data;

public class Seed {
  private SeedType seedType;
  private float cost;
  private float growSpeed;
  private float cropYield;
  private float failChance;

  public Seed() {
  }

  public Seed(SeedType seedType, float cost, float growSpeed, float cropYield, float failChance) {
    this.seedType = seedType;
    this.cost = cost;
    this.growSpeed = growSpeed;
    this.cropYield = cropYield;
    this.failChance = failChance;
  }

  public SeedType getSeedType() {
    return seedType;
  }

  public void setSeedType(SeedType seedType) {
    this.seedType = seedType;
  }

  public float getCost() {
    return cost;
  }

  public void setCost(float cost) {
    this.cost = cost;
  }

  public float getGrowSpeed() {
    return growSpeed;
  }

  public void setGrowSpeed(float growSpeed) {
    this.growSpeed = growSpeed;
  }

  public float getCropYield() {
    return cropYield;
  }

  public void setCropYield(float cropYield) {
    this.cropYield = cropYield;
  }

  public float getFailChance() {
    return failChance;
  }

  public void setFailChance(float failChance) {
    this.failChance = failChance;
  }
}
