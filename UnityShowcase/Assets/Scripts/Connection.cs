using System.Text;
using NativeWebSocket;
using UnityEngine;

public class Connection : MonoBehaviour
{
    WebSocket websocket;

    // Start is called before the first frame update
    async void Start()
    {
        websocket = new WebSocket("ws://localhost:1234");

        websocket.OnOpen += () => { Debug.Log("Connection open!"); };

        websocket.OnError += (e) => { Debug.Log("Error! " + e); };

        websocket.OnClose += (e) => { Debug.Log("Connection closed!"); };

        websocket.OnMessage += (bytes) =>
        {
           var message = Encoding.UTF8.GetString(bytes);
            Debug.Log("OnMessage! " + message);
        };
        
        Debug.Log("Trying to connect");
        
        await websocket.Connect();
    }

    void Update()
    {
        #if !UNITY_WEBGL || UNITY_EDITOR
                websocket.DispatchMessageQueue();
        #endif
    }

    public async void SendWebSocketMessage(string message)
    {
        if (websocket.State == WebSocketState.Open)
        {
            await websocket.SendText(message);
        }
    }

    private async void OnApplicationQuit()
    {
        await websocket.Close();
    }
}