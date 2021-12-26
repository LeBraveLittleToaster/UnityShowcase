package de.pschiessle.showcase;

import de.pschiessle.showcase.data.Entity;
import de.pschiessle.showcase.utils.Vector3Int;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class GameManager {

  private List<Entity> entitiesList;
  private AtomicInteger idCreator;

  public GameManager() {
    this.entitiesList = new LinkedList<>();
    this.idCreator = new AtomicInteger();
  }

  public Entity addEntity(String name, Vector3Int initPos ){
    Entity entity = new Entity(initPos,name, idCreator.incrementAndGet());
    entitiesList.add(entity);
    return entity;
  }

  public void removeEntity(int id){
    entitiesList.removeIf(e -> e.getId() == id);
  }

  public List<Entity> getEntitiesList() {
    return entitiesList;
  }

  public Optional<Entity> moveEntityTo(int entityId, Vector3Int position) {
    Optional<Entity> entity = entitiesList.stream().filter(e -> e.getId() == entityId).findFirst();
    entity.ifPresent(value -> value.setPos(position));
    return entity;
  }
}
