using System.Collections.Generic;
using UnityEngine;
using UnityTemplateProjects;

public class GameBoard
{
    private List<Entity> entities = new List<Entity>();

    public void AddEntity(Entity entity)
    {
        this.entities.Add(entity);
    }

    public void MoveEntity(int entityId, Vector3Int pos)
    {
        if (entities.Exists(e => e.ID == entityId))
        {
            var entity = this.entities.Find(e => e.ID == entityId);
            entity.Pos = pos;
            List<Vector3> waypoints = new List<Vector3>();
            waypoints.Add(pos);
            entity.GameObject.GetComponent<MoveToScript>().SetWaypoints(waypoints);
        }    
    }
}
