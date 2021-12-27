package de.pschiessle.showcase.messages.req;

import de.pschiessle.showcase.data.SeedType;
import de.pschiessle.showcase.utils.Vector3Int;

public class PlantSeedReq extends Request {

  private SeedType seedType;
  private int fieldX;
  private int fieldY;


  public PlantSeedReq(String requestId,
      SeedType seedType, int fieldX, int fieldY) {
    super(RequestType.PLANT_SEED, requestId);
    this.seedType = seedType;
    this.fieldX = fieldX;
    this.fieldY = fieldY;
  }

  public SeedType getSeedType() {
    return seedType;
  }

  public int getFieldX() {
    return fieldX;
  }

  public int getFieldY() {
    return fieldY;
  }
}
