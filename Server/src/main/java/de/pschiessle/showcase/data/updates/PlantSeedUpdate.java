package de.pschiessle.showcase.data.updates;

import de.pschiessle.showcase.data.SeedType;

public class PlantSeedUpdate extends TileUpdate{
  public final SeedType seedType;

  public PlantSeedUpdate(SeedType seedType, int x, int y) {
    super(x, y);
    this.seedType = seedType;
  }
}
