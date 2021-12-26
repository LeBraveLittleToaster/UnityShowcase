using System;
using System.Collections.Generic;
using UnityEngine;

namespace UnityTemplateProjects
{

    public class MoveToScript : MonoBehaviour
    {
        public float speed = 0.1f;
        private List<Vector3> waypoints = new List<Vector3>();

        public void SetWaypoints(List<Vector3> waypoints)
        {
            this.waypoints = waypoints;
        }
        
        void Update()
        {
            if (waypoints.Count > 0)
            {
                Vector3 curTarget = waypoints[waypoints.Count - 1];
                float step =  speed * Time.deltaTime; // calculate distance to move
                transform.position = Vector3.MoveTowards(transform.position, curTarget, step);

                // Check if the position of the cube and sphere are approximately equal.
                if (Vector3.Distance(transform.position, curTarget) < 0.001f)
                {
                    waypoints.RemoveAt(waypoints.Count - 1);
                }
            }
        }
    }
}