using System.Collections.Generic;
using UnityEngine;
using UnityTemplateProjects;

public class GameManager : MonoBehaviour
{
    public GameObject prefabCharacter;

    private GameBoard _gameBoard;
    
    void Start()
    {
        this._gameBoard = new GameBoard();
        SpawnCharacter("H1", Vector3Int.zero, 1);
        SpawnCharacter("H2", Vector3Int.zero, 2);
        MoveCharacter(1, new Vector3Int(3, 0, 0));
        MoveCharacter(2, new Vector3Int(0, 0, 3));
    }

    public void SpawnCharacter(string name, Vector3Int pos, int id)
    {
        GameObject go = Instantiate(prefabCharacter, pos, Quaternion.identity) as GameObject;
        this._gameBoard.AddEntity(new Entity(go, name, pos, id));
    }

    public void MoveCharacter(int entityId, Vector3Int waypoint)
    {
        this._gameBoard.MoveEntity(entityId, waypoint);
        
    }

    // Update is called once per frame
    void Update()
    {
    }
}