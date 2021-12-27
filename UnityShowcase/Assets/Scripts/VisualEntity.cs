using System.Collections.Generic;
using UnityEngine;

namespace UnityTemplateProjects
{
    public class Entity
    {
        private GameObject _gameObject;
        private string name;
        private Vector3Int pos;
        private int id;

        public Entity(GameObject gameObject, string name, Vector3Int pos, int id)
        {
            this._gameObject = gameObject;
            this.name = name;
            this.pos = pos;
            this.id = id;
        }

        public GameObject GameObject => _gameObject;

        public string Name
        {
            get => name;
            set => name = value;
        }

        public Vector3Int Pos
        {
            get => pos;
            set => pos = value;
        }

        public int ID
        {
            get => id;
            set => id = value;
        }
    }
}