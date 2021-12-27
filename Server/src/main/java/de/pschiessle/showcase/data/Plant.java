package de.pschiessle.showcase.data;

public class Plant {
  public static final float PROGRESS_MAX = 100f;

  private Seed seed;
  private float growPercent = 0;

  public Plant(Seed seed) {
    this.seed = seed;
    this.growPercent = 0;
  }

  public boolean grow(float deltaTime){
    growPercent += deltaTime * seed.getGrowSpeed();
    return growPercent >= PROGRESS_MAX;
  }

  public Seed getSeed() {
    return seed;
  }
}
