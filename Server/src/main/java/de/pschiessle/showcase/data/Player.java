package de.pschiessle.showcase.data;

import java.util.List;

public class Player {
  private float gold;
  private List<Seed> seeds;

  public Player() {
  }

  public Player(float gold, List<Seed> seeds) {
    this.gold = gold;
    this.seeds = seeds;
  }

  public float getGold() {
    return gold;
  }

  public void setGold(float gold) {
    this.gold = gold;
  }

  public List<Seed> getSeeds() {
    return seeds;
  }

  public void setSeeds(List<Seed> seeds) {
    this.seeds = seeds;
  }
}
