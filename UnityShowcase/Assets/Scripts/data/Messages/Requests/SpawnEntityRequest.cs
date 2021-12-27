using UnityEngine;

public class SpawnEntityRequest
{
    public string messageType;
    public string name;
    public Vector3Int position;

    public SpawnEntityRequest(string name, Vector3Int position)
    {
        this.messageType = "SPAWN_ENTITY";
        this.name = name;
        this.position = position;
    }
}