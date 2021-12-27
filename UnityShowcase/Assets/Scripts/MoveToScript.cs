using System;
using System.Collections.Generic;
using UnityEngine;

namespace UnityTemplateProjects
{

    public class MoveToScript : MonoBehaviour
    {
        public float speed = 0.1f;
        public float rotSpeed = 0.1f;
        public float rotDampening = 10;
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
                var mPosition = transform.position;
                
                float stepRotation =  rotSpeed * Time.deltaTime;
                var newDir = Vector3.RotateTowards(transform.forward, curTarget, stepRotation, 0.0f);
                Debug.DrawRay(transform.position, newDir, Color.red);
                
                
                var newRotation = Quaternion.LookRotation(newDir);
                var rotDiff = Quaternion.Angle(transform.rotation, newRotation);
                transform.rotation = newRotation;

                
                float stepMovement =  speed * Time.deltaTime * (rotDiff == 0 ? 1 : 1 / (1 + rotDiff * rotDampening));
                mPosition = Vector3.MoveTowards(mPosition, curTarget, stepMovement);
                transform.position = mPosition;

                
                if (Vector3.Distance(transform.position, curTarget) < 0.001f)
                {
                    waypoints.RemoveAt(waypoints.Count - 1);
                }
            }
        }
    }
}