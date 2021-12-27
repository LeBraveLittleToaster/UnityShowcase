package de.pschiessle.showcase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.pschiessle.showcase.utils.Vector3Int;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameManagerTest {

  private GameManager gameManager;

  @BeforeEach
  public void before(){
    this.gameManager = new GameManager();
  }

  @Test
  public void basicSpawn(){
    Entity entity1 = gameManager.addEntity("1", Vector3Int.zero());
    Entity entity2 = gameManager.addEntity("2", Vector3Int.from(1, 2, 3));

    assertEquals("1", entity1.getName());
    assertEquals("2", entity2.getName());
  }

  @Test
  public void basicMove(){
    Entity entity1 = gameManager.addEntity("1", Vector3Int.zero());
    Entity entity2 = gameManager.addEntity("2", Vector3Int.from(1, 2, 3));

    gameManager.moveEntityTo(entity1.getId(), Vector3Int.from(3,2,1));

    assertEquals(3, entity1.getPos().x);
    assertEquals(1, entity2.getPos().x);
  }
}
