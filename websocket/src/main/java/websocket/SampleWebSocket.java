package websocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author kohei
 */
@ServerEndpoint(value = "/echows")
public class SampleWebSocket {
    
    private static Set<Session> ses = new CopyOnWriteArraySet<>();
    
    @OnOpen
    public void onOpen(Session session){
        System.out.println("Opening Session : " + session);
        ses.add(session);
    }
    
    @OnMessage
    public String echo(String message){
        System.out.println("Sent message : " + message);
        return message;
    }
    
    @OnClose
    public void onClose(Session session){
        System.out.println("Closing Session : " + session);
        ses.remove(session);
    }
    
    public static void sendMessage(String msg){
        ses.forEach(s -> {
            s.getAsyncRemote().sendText(msg);
        });
    }
}
